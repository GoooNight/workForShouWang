package com.distribution.demo.utils;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @author:awei
 * @date:2019/8/17
 * @ver:1.0
 **/
@Component
public class ProducerUtil {
    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier("activeMQ02")
    ActiveMQQueue activeMQQueue02;

    @Autowired
    @Qualifier("activeMQ02")
    ActiveMQQueue activeMQQueue03;

    public void send(){
        jmsTemplate.convertAndSend("你好啊");
        jmsTemplate.convertAndSend(activeMQQueue02,"哈哈哈02");
        jmsTemplate.convertAndSend(activeMQQueue02,"哈哈哈03");
    }
}
