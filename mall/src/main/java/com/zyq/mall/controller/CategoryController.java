package com.zyq.mall.controller;

import com.zyq.mall.service.ICategoryService;
import com.zyq.mall.vo.CategoryVo;
import com.zyq.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhangyiqi
 */
@RestController
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;

	@GetMapping("/categories")
	public ResponseVo<List<CategoryVo>> selectAll() {
		return categoryService.selectAll();
	}
}
