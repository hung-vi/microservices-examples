package com.vnext.projekt.mailservice.infrastructure.messaging.kafka.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;

@ToString
public class EmailDeliveryInboundMessage
{
    @JsonProperty(value = "emailId")
    @Setter
    private String emailId;

    public Optional<String> getEmailId()
    {
        return Optional.ofNullable(this.emailId);
    }
}
