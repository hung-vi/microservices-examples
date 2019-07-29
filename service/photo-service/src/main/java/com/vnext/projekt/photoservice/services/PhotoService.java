package com.vnext.projekt.photoservice.services;

import com.vnext.projekt.photoservice.api.forms.sys.PhotoProcessCreateForm;

public interface PhotoService
{
    void create(PhotoProcessCreateForm _form);

    void process() throws Exception;
}
