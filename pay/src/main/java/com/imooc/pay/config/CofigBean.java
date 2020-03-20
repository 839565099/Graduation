package com.imooc.pay.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

/**
 * 作者：张翼麒
 * Date:2020-2-26
 */
@EnableJms
@Configuration
public class CofigBean {
    @Value("${myqueue}")
    public String MQname;
    @Bean
    public Queue queue(){
        return new ActiveMQQueue(MQname);
    }


}
