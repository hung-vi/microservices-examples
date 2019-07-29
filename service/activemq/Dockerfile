FROM adoptopenjdk/openjdk8:jdk8u192-b12-slim
ENV TZ Asia/Tokyo
ENV LANG C.UTF-8
ENV ACTIVEMQ_VERSION 5.15.4
ENV ACTIVEMQ apache-activemq-$ACTIVEMQ_VERSION
ENV ACTIVEMQ_TCP=61616 ACTIVEMQ_AMQP=5672 ACTIVEMQ_STOMP=61613 ACTIVEMQ_MQTT=1883 ACTIVEMQ_WS=61614 ACTIVEMQ_UI=8161
ENV SHA512_VAL=26d8154fcfe17ab90508b3b9d46b40815404fa3886cfdc4eae4b06086332203bd2455475b9309ccabd76d0c9b65f523f9d3911d315c17bf4b48bd22395ea8ead

ENV ACTIVEMQ_HOME /opt/activemq

RUN curl "https://archive.apache.org/dist/activemq/$ACTIVEMQ_VERSION/$ACTIVEMQ-bin.tar.gz" -o $ACTIVEMQ-bin.tar.gz

RUN if [ "$SHA512_VAL" != "$(sha512sum $ACTIVEMQ-bin.tar.gz | awk '{print($1)}')" ];\
    then \
        echo "sha512 values doesn't match! exiting."  && \
        exit 1; \
    fi;

RUN tar xzf $ACTIVEMQ-bin.tar.gz -C  /opt && \
    ln -s /opt/$ACTIVEMQ $ACTIVEMQ_HOME && \
    useradd -r -M -d $ACTIVEMQ_HOME activemq && \
    chown -R activemq:activemq /opt/$ACTIVEMQ && \
    chown -h activemq:activemq $ACTIVEMQ_HOME

COPY ./startup.sh /opt/$ACTIVEMQ/conf
RUN chmod +x /opt/$ACTIVEMQ/conf/startup.sh

USER activemq
WORKDIR $ACTIVEMQ_HOME
EXPOSE $ACTIVEMQ_TCP $ACTIVEMQ_AMQP $ACTIVEMQ_STOMP $ACTIVEMQ_MQTT $ACTIVEMQ_WS $ACTIVEMQ_UI
ENV SCHEDULER_SUPPORT true

CMD ["/bin/sh", "-c", "conf/startup.sh"]
