package com.vnext.projekt.mailservice.api.controllers.sys;

import com.vnext.projekt.common.api.responses.CreatedResponse;
import com.vnext.projekt.mailservice.api.forms.sys.MailCreateForm;
import com.vnext.projekt.mailservice.api.views.MailView;
import com.vnext.projekt.mailservice.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.net.URISyntaxException;

@Controller
@RequestMapping("/sys/mails")
public class MailsController
{
    @Autowired
    MailService service;

    @PostMapping
    public CreatedResponse<MailView> create(@RequestBody @Valid MailCreateForm _form) throws URISyntaxException
    {
        service.create(_form);
        return new CreatedResponse<>(new MailView(_form));
    }
}
