FROM kong:1.0.3

COPY ./files/usr/local/kong/ /usr/local/kong/
ADD ./files/docker-entrypoint.sh /
ENV TZ=Asia/Tokyo \
 KONG_SSL=off \
 KONG_DATABASE=postgres \
 KONG_PG_HOST=api-gateway-database \
 KONG_PG_PORT=5432 \
 KONG_PG_USER=kong \
 KONG_PG_DATABASE=kong