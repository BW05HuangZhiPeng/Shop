package com.huangzhipeng.shop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.huangzhipeng.shop.entity.Spec;

public interface SpecService {
	/**
	 * 获取规格参数列表
	 * @param spec
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageInfo<Spec> specList(Spec spec, Integer pageNum, Integer pageSize);

	/**
	 * 添加或修改规格参数
	 * @param spec
	 * @return
	 */
	Integer saveOrUpdateSpec(Spec spec);

	/**
	 * 获取规格参数详情
	 * @param id
	 * @return
	 */
	Spec getSpecById(Integer id);

	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	Integer deleteSpecByIds(Integer[] ids);

	/**
	 * 删除指定id的规格参数选项
	 * @param id
	 * @return
	 */
	Integer deleteSpecOptionById(Integer id);
	
	List<Spec> specs();

}
