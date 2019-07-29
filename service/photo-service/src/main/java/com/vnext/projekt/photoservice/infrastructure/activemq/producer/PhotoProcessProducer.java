package com.vnext.projekt.photoservice.infrastructure.activemq.producer;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vnext.projekt.photoservice.models.PhotoId;
import lombok.NonNull;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.util.HashMap;
import java.util.Map;

@Component
public class PhotoProcessProducer
{
    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${projekt.photoService.jms.producer.destination}")
    private String queueName;

    public void send(@NonNull PhotoId _photoId)
    {
        TextMessage message = new ActiveMQTextMessage();
        Map params = new HashMap<String, String>() {{
            put("photoId", _photoId.toString());
        }};
        try {
            message.setText(new ObjectMapper().writeValueAsString(params));
        } catch (JMSException | JsonProcessingException e) {
            e.printStackTrace();
        }

        jmsTemplate.setSessionTransacted(true);
        jmsTemplate.convertAndSend(queueName, message);
    }
}
