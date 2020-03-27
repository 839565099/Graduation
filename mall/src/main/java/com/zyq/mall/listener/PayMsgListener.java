package com.zyq.mall.listener;

import com.google.gson.Gson;
import com.zyq.mall.pojo.PayInfo;
import com.zyq.mall.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * 关于PayInfo，正确姿势：pay项目提供client.jar, mall项目引入jar包
 * 《SpringCloud微服务实战》
 * Created by zhangyiqi
 */
@Component
//@RabbitListener(queues = "payNotify")

@Slf4j
public class PayMsgListener {
    @Autowired
    private IOrderService orderService;

    @JmsListener(destination = "${myqueue}")
    public void receive(TextMessage textMessage) throws JMSException {
        log.info("消费者收到消息：" + textMessage.getText());
        String msg = textMessage.getText();
        PayInfo payInfo = new Gson().fromJson(msg, PayInfo.class);
        if (payInfo.getPlatformStatus().equals("SUCCESS")) {
            //修改订单里的状态
            orderService.paid(payInfo.getOrderNo());
        }
    }


//
//	@RabbitHandler
//	public void process(String msg) {
//		log.info("【接收到消息】=> {}", msg);
//
//		PayInfo payInfo = new Gson().fromJson(msg, PayInfo.class);
//		if (payInfo.getPlatformStatus().equals("SUCCESS")) {
//			//修改订单里的状态
//			orderService.paid(payInfo.getOrderNo());
//		}
//	}
}
