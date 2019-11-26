package com.huangzhipeng.shop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.huangzhipeng.shop.entity.Brand;

/**
 * 
 * @author zhuzg
 *
 */
public interface BrandService {
	
	/**
	 * 添加品牌
	 * @param spu
	 * @return
	 */
	int add(Brand spu);
	
	/**
	 * 删除品牌
	 * @param branId
	 * @return
	 */
	int delete(int [] brandId);
	
	/**
	 * 获取商品详情
	 * @param spuId
	 * @return
	 */
	Brand get(Integer spuId);
	
	/**
	 * 模糊查询  
	 * @param page
	 * @param pageSize
	 * @param where  查询的内容
	 * @return
	 */
	PageInfo<Brand> list(int page,int pageSize,Brand brand);
	
	/**
	 * 修改品牌
	 * @param brand
	 * @return
	 */
	int update(Brand brand);

	/**   
	 * @Title:         QYBrand   
	 * @Description:   TODO
	 * @param:         @param brandid
	 * @param:         @return      
	 * @return:        int     
	 * @date:          2019年11月14日 下午4:01:11   
	 * @throws   
	 */
	int QYBrand(int[] brandid);
	
	List<Brand> getAllBrands();

}
