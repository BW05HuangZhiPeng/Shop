package com.huangzhipeng.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.huangzhipeng.shop.entity.Brand;

/**
 * 
 * @author huangzhipeng
 *
 */
public interface BrandMapper {

	/**
	 * 
	 * @param brand
	 * @return
	 * id
	 */
	@Insert("INSERT INTO hg_brand(name,first_char) "
			+ " VALUES(#{name},#{firstChar})")
	int add(Brand brand);

	/**
	 * 
	 * @param brandId
	 * @return
	 */
	int delete(int [] brandId);

	/**
	 * 
	 * @param where
	 * @return
	 */
	List<Brand> list(Brand brand);

	/**
	 * 
	 * @param brand
	 * @return
	 */
	int update(Brand brand);

	/**
	 * 
	 * @param brandId
	 * @return
	 */
	Brand get(Integer brandId);

	/**   
	 * @Title:         QYBrand   
	 * @Description:   TODO
	 * @param:         @param brandid
	 * @param:         @return      
	 * @return:        int     
	 * @date:          2019年11月14日 下午4:01:48   
	 * @throws   
	 */
	int QYBrand(int[] brandid);
	
	List<Brand> selectAllBrands();

}
