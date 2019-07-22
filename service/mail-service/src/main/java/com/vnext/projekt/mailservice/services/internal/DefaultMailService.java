package com.vnext.projekt.mailservice.services.internal;

import com.vnext.projekt.mailservice.api.forms.sys.MailCreateForm;
import com.vnext.projekt.mailservice.infrastructure.messaging.kafka.EmailDeliveryPublisher;
import com.vnext.projekt.mailservice.models.EmailId;
import com.vnext.projekt.mailservice.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DefaultMailService implements MailService
{
    @Autowired
    EmailDeliveryPublisher publisher;

    @Override
    public void create(MailCreateForm _form)
    {
        UUID uuid = UUID.randomUUID();
        publisher.send(uuid.toString());
    }

    @Override
    public void send(EmailId _emailId)
    {
        System.out.println(String.format("Email [%s] was sent.", _emailId.toString()));
    }

}
