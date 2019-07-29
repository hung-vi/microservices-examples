package com.vnext.projekt.photoservice.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PhotoId
{
    @NonNull
    private Long id;


    public static PhotoId of(@NonNull String _id)
    {
        return PhotoId.of(Long.parseLong(_id));
    }

    public static PhotoId of(@NonNull Long _id)
    {
        if (_id <= 0L)
        {
            throw new IllegalArgumentException(String.format("Param 'photoId' is not valid; Got %s", _id));
        }
        return new PhotoId(_id);
    }

    @Override
    public String toString() {
        return id.toString();
    }

    public Long toLong()
    {
        return id;
    }
}
