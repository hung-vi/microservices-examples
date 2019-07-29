package com.vnext.projekt.photoservice.messaging;


import com.vnext.projekt.photoservice.infrastructure.activemq.messages.PhotoProcessRequest;
import com.vnext.projekt.photoservice.models.PhotoId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.listener.adapter.JmsResponse;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
@Slf4j
public class PhotoProcessListener
{
//
//    @JmsListener(destination = "${projekt.photoService.jms.consumer.destination}",
//            containerFactory = "photoProcessListenerConnectionFactory",
//            concurrency = "1-3"
//    )
//    public JmsResponse<Object> receive(PhotoProcessRequest _payload, Message _message)
//    {
//        PhotoId photoId = _payload.getPhotoId();
//        log.info(String.format("Receive message with photoId = %", _payload));
//        return null;
//    }
}
