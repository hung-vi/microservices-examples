package com.vnext.projekt.mailservice.api.views;

import com.vnext.projekt.mailservice.api.forms.sys.MailCreateForm;
import lombok.NonNull;
import lombok.Value;

@Value
public class MailView
{
    private String to;

    private String body;

    public MailView(@NonNull MailCreateForm _form)
    {
        this.to = _form.getTo();
        this.body = _form.getBody();
    }
}
