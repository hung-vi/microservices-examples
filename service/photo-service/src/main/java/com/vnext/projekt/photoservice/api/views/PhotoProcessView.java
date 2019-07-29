package com.vnext.projekt.photoservice.api.views;

import com.vnext.projekt.photoservice.api.forms.sys.PhotoProcessCreateForm;
import lombok.NonNull;
import lombok.Value;

@Value
public class PhotoProcessView
{
    private String photoId;

    public PhotoProcessView(@NonNull PhotoProcessCreateForm _form)
    {
        this.photoId = _form.getPhotoId();
    }
}
