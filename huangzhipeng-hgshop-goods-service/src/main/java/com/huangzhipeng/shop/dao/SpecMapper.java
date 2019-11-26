package com.huangzhipeng.shop.dao;

import java.util.List;
import java.util.Map;

import com.huangzhipeng.shop.entity.Spec;
import com.huangzhipeng.shop.entity.SpecOption;


public interface SpecMapper {

	List<Spec> selectSpecList(Spec spec);

	Integer insertSpec(Spec spec);

	void insertSpecOption(SpecOption option);

	Integer updateSpec(Spec spec);

	void updateSpecOption(SpecOption option);
	
	Spec selectSpecById(Integer id);

	void deleteSpecOptionBySpecIds(Integer[] ids);

	Integer deleteSpecByIds(Integer[] ids);

	Integer deleteSpecOptionById(Integer id);

	List<Spec> selectSpecs();
	
	/********************前台搜索列表***********************/
	/***
	 * 根据规格参数id列表获取规格参数和规格参数选项列表
	 * @param specIds
	 * @return
	 */

	List<Map<String, String>> selectSpecAndSpecOptionBySpecIds(List<Integer> specIds);

	List<Spec> selectSpecByIds(List<Integer> specIds);

	List<Spec> selectSpecBySkuIds(List<Integer> skuIds);

}
