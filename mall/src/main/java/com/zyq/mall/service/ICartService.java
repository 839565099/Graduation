package com.zyq.mall.service;

import com.zyq.mall.form.CartAddForm;
import com.zyq.mall.form.CartUpdateForm;
import com.zyq.mall.pojo.Cart;
import com.zyq.mall.vo.CartVo;
import com.zyq.mall.vo.ResponseVo;

import java.util.List;

/**
 * Created by 廖师兄
 */

public interface ICartService {

	ResponseVo<CartVo> add(Integer uid, CartAddForm form);

	ResponseVo<CartVo> list(Integer uid);

	ResponseVo<CartVo> update(Integer uid, Integer productId, CartUpdateForm form);

	ResponseVo<CartVo> delete(Integer uid, Integer productId);

	ResponseVo<CartVo> selectAll(Integer uid);

	ResponseVo<CartVo> unSelectAll(Integer uid);

	ResponseVo<Integer> sum(Integer uid);

	List<Cart> listForCart(Integer uid);
}
