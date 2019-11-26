/**
 * 
 */
package com.huangzhipeng.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huangzhipeng.shop.entity.Brand;
import com.huangzhipeng.shop.entity.Category;
import com.huangzhipeng.shop.entity.Sku;
import com.huangzhipeng.shop.entity.SkuSpec;


/**
 * @author coolface
 *
 */
public interface SkuMapper {

	List<Sku> selectSkuList(Sku sku);

	Integer insertSku(Sku sku);

	Integer updateSku(Sku sku);

	void insertSkuSpec(SkuSpec skuSpec);

	void updateSkuSpec(SkuSpec skuSpec);

	Sku selectSkuById(Integer id);

	Integer deleteSkuByIds(Integer[] ids);

	void deleteSkuSpecBySkuIds(Integer[] ids);

	/***********************************前台搜索页*************************/
	
	/**
	 * 根据过滤条件查询skuId列表
	 * @param sku
	 * @return
	 */
	List<Integer> selectSkuIdsBySearch(Sku sku);

	/**
	 * 根据sku id列表查询sku列表
	 * @param skuIds
	 * @return
	 */
	List<Sku> selectSkuByIds(List<Integer> skuIds);

	/**
	 * 根据sku id列表查询分类列表
	 * @param skuIds
	 * @return
	 */
	List<Category> selectCategoryBySkuIds(List<Integer> skuIds);
	
	/**
	 * 根据sku id列表查询品牌列表
	 * @param skuIds
	 * @return
	 */
	List<Brand> selectBrandBySkuIds(List<Integer> skuIds);

	/********************************前台首页************************/
	/**
	 * 查询最新商品
	 * @param num
	 * @return
	 */
	List<Sku> selectNews(int num);

	Sku selectSkuById1(Integer id);

	Sku selectSkuBySpecOptionIds(Integer[] optionIds);

	List<Integer> selectSkuIdsBySpuId(Integer spuId);

	List<SkuSpec> selectSkuSpecBySkuId(Integer skuId);

	Sku selectSkuById2(Integer skuid);

	/**   
	 * @Title:         reduceStock   
	 * @Description:   TODO
	 * @param:         @param skuId
	 * @param:         @param num      
	 * @return:        void     
	 * @date:          2019年11月25日 下午2:25:12   
	 * @throws   
	 */
	void reduceStock(@Param("skuId")Integer skuId, @Param("num")Integer num);
}
