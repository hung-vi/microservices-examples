package com.vnext.projekt.mailservice.infrastructure.messaging.kafka.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vnext.projekt.mailservice.models.EmailId;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;

@ToString
public class EmailDeliveryInboundMessage
{
    @JsonProperty(value = "emailId")
    @Setter
    private EmailId emailId;

    public Optional<EmailId> getEmailId()
    {
        return Optional.ofNullable(this.emailId);
    }
}
