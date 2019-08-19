package com.distribution.demo.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

/**
 * @Description
 * @author:awei
 * @date:2019/8/17
 * @ver:1.0
 **/
@Configuration
public class JmsConfig {

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactoryCreat(){
        return new ActiveMQConnectionFactory("tcp://localhost:61616");
    }

    @Bean
    public ActiveMQQueue activeMQQueueCreat(){
        return new ActiveMQQueue("队列1");
    }
    @Bean(name = "activeMQ02")
    public ActiveMQQueue activeMQQueueCreat02(){
        return new ActiveMQQueue("队列2");
    }
    @Bean(name = "activeMQ03")
    public ActiveMQQueue activeMQQueueCreat03(){
        return new ActiveMQQueue("队列3");
    }
    @Bean(name = "activeMQ04")
    public ActiveMQQueue activeMQQueueCreat04(){
        return new ActiveMQQueue("队列4");
    }

    @Bean
    public JmsTemplate jmsTemplateCreat(){
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setDefaultDestination(activeMQQueueCreat());
        jmsTemplate.setConnectionFactory(activeMQConnectionFactoryCreat());
        jmsTemplate.setReceiveTimeout(20000);
        return jmsTemplate;
    }
}
