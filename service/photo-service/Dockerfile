FROM adoptopenjdk/openjdk8:jdk8u192-b12-slim

# add user
RUN groupadd vnext
RUN useradd vnext -g vnext -m -s /bin/bash
RUN echo "vnext:secret" | chpasswd

# setup
ADD ./files/etc/profile /etc/profile
ENV TZ Asia/Jakarta
ENV LANG C.UTF-8

# see https://spring.io/guides/gs/spring-boot-docker/
VOLUME /tmp
ADD ./build/libs/photo-service-0.0.1-SNAPSHOT.war app.war
RUN sh -c 'touch /app.war'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.war" ]
