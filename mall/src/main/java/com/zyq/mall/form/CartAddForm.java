package com.zyq.mall.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 添加商品
 * Created by zhangyiqi
 */
@Data
public class CartAddForm {

	@NotNull
	private Integer productId;

	private Boolean selected = true;
}
