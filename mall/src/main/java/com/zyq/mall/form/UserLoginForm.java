package com.zyq.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created by zhangyiqi
 */
@Data
public class UserLoginForm {

	@NotBlank
	private String username;

	@NotBlank
	private String password;
}
