package com.springdemo.jmsmessaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.springdemo.models.UserDetails;

@Component
public class MessageSender {
	@Autowired
    JmsTemplate jmsTemplate;
 
    public void sendMessage(final UserDetails userdetails) {
        jmsTemplate.send(new MessageCreator(){
                @Override
                public Message createMessage(Session session) throws JMSException{
                    ObjectMessage objectMessage = session.createObjectMessage(userdetails);
                    return objectMessage;
                }
            });
    }
}
