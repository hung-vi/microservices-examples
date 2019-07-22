package com.vnext.projekt.mailservice.infrastructure.messaging.kafka;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EmailDeliveryOutbound
{
    public final String OUTPUT = "emailDeliveryOutbound";

    @Output(EmailDeliveryOutbound.OUTPUT)
    MessageChannel output();
}
