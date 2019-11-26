package com.huangzhipeng.shop.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.huangzhipeng.shop.entity.Sku;

public interface SkuService {

	PageInfo<Sku> skuList(Sku sku, Integer pageNum, Integer pageSize);

	Integer saveOrUpdateSku(Sku sku);

	Map<String, Object> getSkuById(Integer id);

	Integer deleteSkuByIds(Integer[] ids);

	List<Sku> selectNews(int num);

	
	Map<String, Object> getSkuList(Sku sku, Integer pageNum, Integer pageSize);

	Map<String, Object> getSkuById1(Integer id);

	Map<String, Object> getSkuBySpecOptionIds(Integer[] optionIds);

	Sku getSkuById2(Integer skuid);

	/**   
	 * @Title:         reduceStock   
	 * @Description:   TODO
	 * @param:         @param skuId
	 * @param:         @param num      
	 * @return:        void     
	 * @date:          2019年11月25日 下午2:23:59   
	 * @throws   
	 */
	void reduceStock(Integer skuId, Integer num);
}
