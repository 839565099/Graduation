package com.zyq.mall.service;

import com.github.pagehelper.PageInfo;
import com.zyq.mall.vo.ProductDetailVo;
import com.zyq.mall.vo.ResponseVo;

/**
 * Created by zhangyiqi
 */
public interface IProductService {

	ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);

	ResponseVo<ProductDetailVo> detail(Integer productId);
}
