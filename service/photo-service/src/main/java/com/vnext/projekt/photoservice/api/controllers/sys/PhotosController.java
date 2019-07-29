package com.vnext.projekt.photoservice.api.controllers.sys;

import com.vnext.projekt.common.api.responses.CreatedResponse;
import com.vnext.projekt.photoservice.api.forms.sys.PhotoProcessCreateForm;
import com.vnext.projekt.photoservice.api.views.PhotoProcessView;
import com.vnext.projekt.photoservice.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.net.URISyntaxException;

@Controller
@RequestMapping("/sys/photos")
public class PhotosController
{
    @Autowired
    private PhotoService service;

    @PostMapping
    public CreatedResponse<PhotoProcessView> create(@RequestBody @Valid PhotoProcessCreateForm _form)
            throws URISyntaxException
    {
        service.create(_form);
        return new CreatedResponse<>(new PhotoProcessView(_form));
    }
}
