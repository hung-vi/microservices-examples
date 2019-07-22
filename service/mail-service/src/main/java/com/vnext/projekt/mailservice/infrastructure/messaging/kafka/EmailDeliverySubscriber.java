package com.vnext.projekt.mailservice.infrastructure.messaging.kafka;

import com.vnext.projekt.mailservice.infrastructure.messaging.kafka.message.EmailDeliveryInboundMessage;
import com.vnext.projekt.mailservice.models.EmailId;
import com.vnext.projekt.mailservice.services.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableBinding(EmailDeliveryInbound.class)
public class EmailDeliverySubscriber
{
    @Autowired
    MailService mailService;

    @StreamListener(EmailDeliveryInbound.INPUT)
    public void receive(@Payload EmailDeliveryInboundMessage _message)
    {
        if (_message.getEmailId().isPresent()) {
            log.info("Receiving " +  _message.toString());
            mailService.send(_message.getEmailId().get());
        } else {
            log.info("Receiving an invalid message");
        }
    }
}
