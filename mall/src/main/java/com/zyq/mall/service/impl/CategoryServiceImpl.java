package com.zyq.mall.service.impl;

import com.zyq.mall.dao.CategoryMapper;
import com.zyq.mall.pojo.Category;
import com.zyq.mall.service.ICategoryService;
import com.zyq.mall.vo.CategoryVo;
import com.zyq.mall.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.zyq.mall.consts.MallConst.ROOT_PARENT_ID;

/**
 * Created by 廖师兄
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

	@Resource
	private CategoryMapper categoryMapper;

	/**
	 * 耗时：http(请求微信api) > 磁盘 > 内存
	 * mysql(内网+磁盘)
	 * @return
	 */
	@Override
	public ResponseVo<List<CategoryVo>> selectAll() {
		//查询出劝募类目
		List<Category> categories = categoryMapper.selectAll();

		//查出parent_id=0
//		for (Category category : categories) {
//			if (category.getParentId().equals(ROOT_PARENT_ID)) {
//				CategoryVo categoryVo = new CategoryVo();
//				BeanUtils.copyProperties(category, categoryVo);
//				categoryVoList.add(categoryVo);
//			}
//		}


		//lambda + stream
		/**
         * 查出父节点为0的放入list中categoryVoList，作为根节点
		 */
		List<CategoryVo> categoryVoList = categories.stream()
				.filter(e -> e.getParentId().equals(ROOT_PARENT_ID))
				.map(this::category2CategoryVo)
				.sorted(Comparator.comparing(CategoryVo::getSortOrder).reversed())
				.collect(Collectors.toList());

		//查询子目录
		findSubCategory(categoryVoList, categories);

		return ResponseVo.success(categoryVoList);
	}

	@Override
	public void findSubCategoryId(Integer id, Set<Integer> resultSet) {
		List<Category> categories = categoryMapper.selectAll();
		findSubCategoryId(id, resultSet, categories);
	}

	private void findSubCategoryId(Integer id, Set<Integer> resultSet, List<Category> categories) {
		for (Category category : categories) {
			if (category.getParentId().equals(id)) {
				resultSet.add(category.getId());
				findSubCategoryId(category.getId(), resultSet, categories);
			}
		}
	}


	/**
     * 查询子目录，思路将全部数据和跟节点传进去，查到以根节点为父类的，把它
	 * 再作为一个list，subCategoryVoList，就可以查出子目录，之后递归
	 * @param categoryVoList
     * @param categories
	 */
	private void findSubCategory(List<CategoryVo> categoryVoList, List<Category> categories) {
		for (CategoryVo categoryVo : categoryVoList) {
			List<CategoryVo> subCategoryVoList = new ArrayList<>();

			for (Category category : categories) {
				//如果查到内容，设置subCategory, 继续往下查
				if (categoryVo.getId().equals(category.getParentId())) {
					CategoryVo subCategoryVo = category2CategoryVo(category);
					subCategoryVoList.add(subCategoryVo);
				}

				subCategoryVoList.sort(Comparator.comparing(CategoryVo::getSortOrder).reversed());
				categoryVo.setSubCategories(subCategoryVoList);

				//递归
				findSubCategory(subCategoryVoList, categories);
			}
		}
	}

	/**
	 * 将Category转化为CategoryVo
	 * @param category
	 * @return
	 */
	private CategoryVo category2CategoryVo(Category category) {
		CategoryVo categoryVo = new CategoryVo();
		BeanUtils.copyProperties(category, categoryVo);
		return categoryVo;
	}
}
