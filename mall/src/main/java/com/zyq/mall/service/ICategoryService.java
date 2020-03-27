package com.zyq.mall.service;

import com.zyq.mall.vo.CategoryVo;
import com.zyq.mall.vo.ResponseVo;

import java.util.List;
import java.util.Set;

/**
 * Created by zhangyiqi
 */
public interface ICategoryService {

	ResponseVo<List<CategoryVo>> selectAll();

	void findSubCategoryId(Integer id, Set<Integer> resultSet);
}
