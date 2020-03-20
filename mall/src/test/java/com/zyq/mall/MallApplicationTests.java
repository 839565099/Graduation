package com.zyq.mall;

import com.zyq.mall.dao.CategoryMapper;
import com.zyq.mall.dao.OrderMapper;
import com.zyq.mall.pojo.Category;
import com.zyq.mall.pojo.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class MallApplicationTests {

    @Resource
    OrderMapper orderMapper;
    @Resource
    CategoryMapper categoryMapper;
    @Test
    void contextLoads() {
        Order order = orderMapper.selectByPrimaryKey(2);
        System.out.println(order);
    }
    @Test
    void Category() {
        Category category = categoryMapper.selectByPrimaryKey(100007);
        System.out.println(category);
    }

}
