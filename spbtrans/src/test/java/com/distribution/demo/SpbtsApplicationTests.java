package com.distribution.demo;

import com.distribution.demo.utils.CustomerServiceUtil;
import com.distribution.demo.utils.ProducerUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.JMSException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpbtsApplicationTests {

    @Autowired
    ProducerUtil producerUtil;

    @Autowired
    CustomerServiceUtil customerServiceUtil;

    @Test
    public void contextLoads() throws JMSException {
       /*producerUtil.send();
       customerServiceUtil.receive();*/
    }

}
