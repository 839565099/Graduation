package com.zyq.mall.service;

import com.zyq.mall.pojo.User;
import com.zyq.mall.vo.ResponseVo;

/**
 * Created by zhangyiqi
 */
public interface IUserService {

	/**
	 * 注册
	 */
	ResponseVo<User> register(User user);

	/**
	 * 登录
	 */
	ResponseVo<User> login(String username, String password);
}
