package com.vnext.projekt.photoservice.services.internal;

import com.vnext.projekt.photoservice.api.forms.sys.PhotoProcessCreateForm;
import com.vnext.projekt.photoservice.infrastructure.activemq.producer.PhotoProcessProducer;
import com.vnext.projekt.photoservice.models.PhotoId;
import com.vnext.projekt.photoservice.services.PhotoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DefaultPhotoService implements PhotoService
{
    @Autowired
    private PhotoProcessProducer photoProcessProducer;

    @Override
    public void create(PhotoProcessCreateForm _form)
    {
        PhotoId photoId = PhotoId.of(_form.getPhotoId());
        try {
            photoProcessProducer.send(photoId);
        } catch (Exception e) {
            log.error("Photo process request creating failed");
            log.error(e.getMessage());
        }
    }

    @Override
    public void process() throws Exception
    {
        throw new Exception("Photo processing failed");
    }
}
