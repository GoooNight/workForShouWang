package com.distribution.demo.utils;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @Description
 * @author:awei
 * @date:2019/8/17
 * @ver:1.0
 **/
@Component
public class CustomerServiceUtil {

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier("activeMQ02")
    ActiveMQQueue activeMQQueue02;

    @Autowired
    @Qualifier("activeMQ02")
    ActiveMQQueue activeMQQueue03;

    public void receive() throws JMSException {
        Destination destination = jmsTemplate.getDefaultDestination();
        TextMessage message = (TextMessage)jmsTemplate.receive(destination);
        TextMessage message02 = (TextMessage)jmsTemplate.receive(activeMQQueue02);
        TextMessage message03 = (TextMessage)jmsTemplate.receive(activeMQQueue03);
        System.out.println(message.getText());
        System.out.println(message02.getText());
        System.out.println(message03.getText());
    }

}
