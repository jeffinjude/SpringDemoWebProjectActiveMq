package com.springdemo.jmsconfig;

import java.util.Arrays;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

@Configuration
public class MessagingConfiguration {
private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";
    
    private static final String QUEUE = "TestQueue";
    
    
    @Bean
    public ActiveMQConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
        connectionFactory.setTrustedPackages(Arrays.asList("com.springdemo.models")); //set the package where the object to be sent as message is present. That pojo should be serializable
        return connectionFactory;
    }
    
    @Bean
   	public ActiveMQQueue getQueue(){
   		ActiveMQQueue queue = new ActiveMQQueue();
   		queue.setPhysicalName(QUEUE);
   		return queue;
   	}
    
    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setDefaultDestinationName(QUEUE);
        return template;
    }
    
    @Bean
    MessageConverter converter(){
        return new SimpleMessageConverter();
    }
}
