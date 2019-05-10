#!/bin/bash

set -eu

cd `dirname $0`

./setup_db.sh
./setup_kong_db.sh
