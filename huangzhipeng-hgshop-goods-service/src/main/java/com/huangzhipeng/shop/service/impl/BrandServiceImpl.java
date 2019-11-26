package com.huangzhipeng.shop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huangzhipeng.shop.dao.BrandMapper;
import com.huangzhipeng.shop.entity.Brand;
import com.huangzhipeng.shop.service.BrandService;

@Service(interfaceClass=BrandService.class)
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	BrandMapper brandMapper;

	@Override
	public int add(Brand brand) {
		// TODO Auto-generated method stub
		return brandMapper.add(brand);
	}

	@Override
	public int delete(int [] brandId) {
		// TODO Auto-generated method stub
		return brandMapper.delete(brandId);
	}

	@Override
	public Brand get(Integer brandId) {
		// TODO Auto-generated method stub
		return brandMapper.get(brandId);
	}

	@Override
	public PageInfo<Brand> list(int page, int pageSize,Brand brand) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, pageSize);
		return new PageInfo<Brand>(brandMapper.list(brand));
	}

	@Override
	public int update(Brand brand) {
		// TODO Auto-generated method stub
		return brandMapper.update(brand);
	}

	/**   
	 * @Title:         QYBrand
	 * @Description:   TODO
	 * @date:          2019年11月14日 下午4:01:21  
	 * @param brandid
	 * @return   
	 * @see com.huangzhipeng.shop.service.BrandService#QYBrand(int[])   
	 */
	@Override
	public int QYBrand(int[] brandid) {
		
		return brandMapper.QYBrand(brandid);
	}
	
	@Override
	public List<Brand> getAllBrands() {
		return brandMapper.selectAllBrands();
	}


}
