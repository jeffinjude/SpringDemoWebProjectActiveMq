package com.springdemo.jmsconfig;

import javax.jms.ConnectionFactory;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import com.springdemo.jmsmessaging.MessageReceiver;

@Configuration
@EnableJms
public class MessagingListnerConfiguration {

	@Autowired
	ConnectionFactory connectionFactory;
	
	@Autowired
	ActiveMQQueue queue;
	
	@Bean
	public DefaultMessageListenerContainer jmsListenerContainerFactory() {
		DefaultMessageListenerContainer factory = new DefaultMessageListenerContainer();
		factory.setConcurrentConsumers(1);
		factory.setConnectionFactory(connectionFactory);
		factory.setDestination(queue);
		factory.setMessageListener(getMessageListener());
		return factory;
	}
	@Bean
	public MessageReceiver getMessageListener(){
		return new MessageReceiver();
	}
}
