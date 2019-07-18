package com.vnext.projekt.mailservice.infrastructure.messaging.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface EmailDeliveryInbound
{
    public final String INPUT = "emailDeliveryInbound";

    @Input(EmailDeliveryInbound.INPUT)
    SubscribableChannel input();
}
