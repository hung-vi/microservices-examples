package com.vnext.projekt.mailservice.infrastructure.messaging.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageHandlingException;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@EnableBinding(EmailDeliveryOutbound.class)
public class EmailDeliveryPublisher
{
    @Autowired
    EmailDeliveryOutbound outbound;

    public void send(String _emailId)
    {
        Map<String, String> message = new HashMap<String, String>() {{
            put("emailId", _emailId);
        }};
        try {
            outbound.output().send(MessageBuilder
                    .withPayload(message)
                    .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                    .build());
        } catch (MessageHandlingException e) {
            log.error("message publish failed: {}", e.getMessage());
        }
    }
}
