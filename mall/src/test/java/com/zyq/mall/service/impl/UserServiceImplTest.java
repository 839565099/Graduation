package com.zyq.mall.service.impl;

import com.zyq.mall.MallApplicationTests;
import com.zyq.mall.enums.RoleEnum;
import com.zyq.mall.pojo.User;
import com.zyq.mall.service.IUserService;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * 作者：张翼麒
 * Date:2020-2-21
 */

public class UserServiceImplTest extends MallApplicationTests {
    @Resource
    IUserService userService;
    @Test
    public void T(){
        userService.register(new User("jj","123456","yiqi0711@foxmail.com", RoleEnum.CUSTOMER.getCode()));
    }

}
