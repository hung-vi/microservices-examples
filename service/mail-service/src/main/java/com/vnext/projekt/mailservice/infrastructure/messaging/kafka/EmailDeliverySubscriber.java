package com.vnext.projekt.mailservice.infrastructure.messaging.kafka;

import com.vnext.projekt.mailservice.infrastructure.messaging.kafka.message.EmailDeliveryInboundMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@Slf4j
@EnableBinding(EmailDeliveryInbound.class)
public class EmailDeliverySubscriber
{

    @StreamListener(EmailDeliveryInbound.INPUT)
    public void receive(EmailDeliveryInboundMessage _message)
    {
        if (_message.getEmailId().isPresent()) {
            log.info("---------------");
            log.info("Receiving " +  _message.toString());
            log.info("---------------");
        } else {
            log.info("---------------");
            log.info("Receiving an invalid message");
            log.info("---------------");
        }
    }
}
