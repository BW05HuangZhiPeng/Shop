package com.huangzhipeng.shop.test;

import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;

import com.huangzhipeng.shop.entity.Brand;
import com.huangzhipeng.shop.service.BrandService;

public class TestBrand  extends TestBase{
	
	
	@Reference
	BrandService brandService;
	
	@Test
	public void testAdd() {
		
		Brand brand =  new Brand();
		brand.setFirstChar("B");
		brand.setName("����");
		
		brandService.add(brand);
		
		
	}
}
