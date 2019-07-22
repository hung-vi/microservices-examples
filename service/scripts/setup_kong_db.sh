#!/bin/bash

set -eu

KONG_VERSION=${KONG_VERSION:=1.0.3}

echo -e "\n -------------------- \nInitialize kong database \n --------------------"
echo `docker run --rm -e "KONG_DATABASE=postgres" -e "KONG_PG_HOST=postgresql" -e "KONG_PG_PORT=5432" -e "KONG_PG_USER=kong" -e "KONG_PG_DATABASE=kong" --network mstest kong:$KONG_VERSION kong migrations bootstrap`
