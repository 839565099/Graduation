package com.imooc.pay.service.impl;

import com.imooc.pay.PayApplicationTests;
import com.imooc.pay.config.CofigBean;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.annotation.Resource;
import javax.jms.Queue;
import java.math.BigDecimal;

/**
 * Created by zhangyiqi
 */
public class PayServiceTest extends PayApplicationTests {

    @Autowired
    private PayServiceImpl payService;

//    @Autowired
//    private AmqpTemplate amqpTemplate;

    @Resource
    private Queue queue;
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Resource
    private CofigBean cofigBean;

    @Test
    public void create() {
        //BigDecimal.valueOf(0.01)
        //new BigDecimal("0.01")  千万不要用 new BigDecimal(0.01)
        payService.create("12134521342334", BigDecimal.valueOf(0.01), BestPayTypeEnum.WXPAY_NATIVE);
    }

//    @Test
//    public void produceMSG() {
//        jmsMessagingTemplate.convertAndSend(queue, "mall啦啦啦啦");
//        System.out.println(cofigBean.MQname);
//    }


//	@Test
//	public void sendMQMsg() {
//		amqpTemplate.convertAndSend("payNotify", "lalala");
//	}
}