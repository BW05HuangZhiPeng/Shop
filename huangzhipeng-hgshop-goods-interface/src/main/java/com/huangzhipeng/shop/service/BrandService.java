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
	 * ���Ʒ��
	 * @param spu
	 * @return
	 */
	int add(Brand spu);
	
	/**
	 * ɾ��Ʒ��
	 * @param branId
	 * @return
	 */
	int delete(int [] brandId);
	
	/**
	 * ��ȡ��Ʒ����
	 * @param spuId
	 * @return
	 */
	Brand get(Integer spuId);
	
	/**
	 * ģ����ѯ  
	 * @param page
	 * @param pageSize
	 * @param where  ��ѯ������
	 * @return
	 */
	PageInfo<Brand> list(int page,int pageSize,Brand brand);
	
	/**
	 * �޸�Ʒ��
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
	 * @date:          2019��11��14�� ����4:01:11   
	 * @throws   
	 */
	int QYBrand(int[] brandid);
	
	List<Brand> getAllBrands();

}
