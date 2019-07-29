package com.vnext.projekt.photoservice.infrastructure.activemq.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vnext.projekt.photoservice.models.PhotoId;
import lombok.Getter;
import lombok.NonNull;

public class PhotoProcessRequest
{
    @NonNull
    @Getter
    private PhotoId photoId;

    @JsonCreator
    public PhotoProcessRequest(@JsonProperty("photoId") String _photoId)
    {
        this.photoId = PhotoId.of(_photoId);
    }

    @JsonGetter("photoId")
    public Long toLong()
    {
        return  photoId.toLong();
    }
}
