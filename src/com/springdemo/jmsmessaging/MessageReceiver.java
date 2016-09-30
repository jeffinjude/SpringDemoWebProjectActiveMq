package com.springdemo.jmsmessaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.springdemo.models.UserDetails;

@Component
public class MessageReceiver implements MessageListener {
	static final Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);
    
    @Autowired
    MessageConverter messageConverter;
     
    @Override
    public void onMessage(Message message) {
        try {
        	LOG.info("-----------------------------------------------------");
            UserDetails userDetails = (UserDetails) messageConverter.fromMessage(message);
        	System.out.println(("USERNAME RETRIEVED FROM DEQUEUED OBJECT  : " + userDetails.getUserName()));
            LOG.info("Message : ",userDetails); 
            LOG.info("-----------------------------------------------------");
		} catch (JMSException e) {
			e.printStackTrace();
		}
    }
}
