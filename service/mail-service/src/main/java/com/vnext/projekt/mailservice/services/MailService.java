package com.vnext.projekt.mailservice.services;

import com.vnext.projekt.mailservice.api.forms.sys.MailCreateForm;
import com.vnext.projekt.mailservice.models.EmailId;

public interface MailService
{
    void create(MailCreateForm _form);

    void send(EmailId _emailId);

}
