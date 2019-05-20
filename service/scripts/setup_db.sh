#!/bin/bash

set -eu

cd `dirname $0`
SQLS_DIR=$(cd $(dirname $0) && cd ./sqls && pwd)

echo $SQLS_DIR

function initialize_db {
    local databaseName=$1
    local sqlArray=$2
    eval local sqlFiles=\"\${$sqlArray[@]}\"
    echo -e "\n -------- \nInitialize ${databaseName} database \n --------"
    echo -e "\n -------- \n ${sqlFiles} \n --------"
    for sqlFile in ${sqlFiles[@]}; do
        echo -e "** run sql $sqlFile **"
        echo `docker-compose run --rm -v $SQLS_DIR:/tmp/sqls postgresql psql -U vnext "$databaseName" -h postgresql -f /tmp/sqls/$sqlFile`
    done
}

## main
echo -e "\n -------------------- \nCreate databases \n --------------------"
echo `docker-compose run --rm postgresql psql -U vnext -h postgresql -f - << EOS
CREATE USER kong;

CREATE DATABASE kong OWNER kong;
CREATE DATABASE "user";
EOS`

user_sqls=(
    "user-database.sql"
)

initialize_db user user_sqls
