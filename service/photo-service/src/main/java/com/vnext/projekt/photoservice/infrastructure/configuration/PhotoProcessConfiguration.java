package com.vnext.projekt.photoservice.infrastructure.configuration;


import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.vnext.projekt.photoservice.infrastructure.activemq.messages.PhotoProcessRequest;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;


@Configuration
public class PhotoProcessConfiguration
{

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    @Value("${activemq.max-redelivery}")
    private int ACTIVEMQ_MAX_DELIVERIES;

    @Value("${activemq.initial-redelivery-delay}")
    private int ACTIVEMQ_INITIAL_REDELIVERY_DELAY;

    @Value("${activemq.redelivery-delay}")
    private int ACTIVEMQ_REDELIVERY_DELAY;

    @Bean
    public ConnectionFactory connectionFactory()
    {
        ActiveMQConnectionFactory amqConnectionFactory = new ActiveMQConnectionFactory(brokerUrl);
        RedeliveryPolicy redeliveryPolicy = new RedeliveryPolicy();
        redeliveryPolicy.setInitialRedeliveryDelay(ACTIVEMQ_INITIAL_REDELIVERY_DELAY);
        redeliveryPolicy.setMaximumRedeliveries(ACTIVEMQ_MAX_DELIVERIES);
        redeliveryPolicy.setRedeliveryDelay(ACTIVEMQ_REDELIVERY_DELAY);
        amqConnectionFactory.setRedeliveryPolicy(redeliveryPolicy);
        return amqConnectionFactory;
    }
//
//    @Bean("photoProcessListenerConnectionFactory")
//    public DefaultJmsListenerContainerFactory photoProcessListenerConnectionFactory(ActiveMQConnectionFactory _connectionFactory)
//    {
//        DefaultJmsListenerContainerFactory jmsListenerConnectionFactory = new DefaultJmsListenerContainerFactory();
//        jmsListenerConnectionFactory.setConnectionFactory(_connectionFactory);
//        jmsListenerConnectionFactory.setMessageConverter(photoProcessMessageConverter());
//        jmsListenerConnectionFactory.setSessionTransacted(true);
//        return  jmsListenerConnectionFactory;
//    }
//
//    @Bean
//    public MessageConverter photoProcessMessageConverter()
//    {
//        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter()
//        {
//            @Override
//            protected JavaType getJavaTypeForMessage(Message message) throws JMSException {
//                return TypeFactory.defaultInstance().constructType(PhotoProcessRequest.class);
//            }
//        };
//        converter.setTargetType(MessageType.TEXT);
//        return converter;
//    }

}
