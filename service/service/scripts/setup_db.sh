#!/bin/bash

set -eu

# cd `dirname $0`


## main
echo -e "\n -------------------- \nCreate databases \n --------------------"
echo `docker-compose run --rm postgresql psql -U hungvi -h postgresql -f - << EOS
CREATE USER kong;

CREATE DATABASE kong OWNER kong;
EOS`