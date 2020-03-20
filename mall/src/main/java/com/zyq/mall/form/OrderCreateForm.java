package com.zyq.mall.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by zhangyiqi
 */
@Data
public class OrderCreateForm {

	@NotNull
	private Integer shippingId;
}
