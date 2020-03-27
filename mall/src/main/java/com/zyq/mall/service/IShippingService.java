package com.zyq.mall.service;

import com.github.pagehelper.PageInfo;
import com.zyq.mall.form.ShippingForm;
import com.zyq.mall.vo.ResponseVo;

import java.util.Map;

/**
 * Created by zhangyiqi
 */
public interface IShippingService {

	ResponseVo<Map<String, Integer>> add(Integer uid, ShippingForm form);

	ResponseVo delete(Integer uid, Integer shippingId);

	ResponseVo update(Integer uid, Integer shippingId, ShippingForm form);

	ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize);
}
