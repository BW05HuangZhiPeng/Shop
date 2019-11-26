/**
 * 
 * @Title:         BrandController.java
 * @Package        com.huangzhipeng.shop.controller
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019��11��13�� ����7:12:02
 * @version:       V1.0
 */
package com.huangzhipeng.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.huangzhipeng.shop.entity.Brand;
import com.huangzhipeng.shop.service.BrandService;
import com.huangzhipeng.shop.util.PageUtil;

/**   
 * @ClassName:     BrandController   
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019��11��13�� ����7:12:02     
 */
@Controller
@RequestMapping("Brand")
public class BrandController {
	@Reference
	BrandService BrandService;
	
	//Ʒ�ƹ���
	@RequestMapping("tobrand_list")
	public String tobrand_list(HttpServletRequest request,Model model,@RequestParam(defaultValue="1") int page,
			@RequestParam(defaultValue="5")  int pageSize,Brand brand) {
		//�б�
		PageInfo<Brand> brandlist=BrandService.list(page,pageSize,brand);
		model.addAttribute("brandlist", brandlist.getList());
		model.addAttribute("brand",brand);
		//�ж���������url
		String url="/Brand/tobrand_list";
		if (brand.getName()!=null&&!"".equals(brand.getName().trim())) {
			url=url+"?name="+brand.getName();
		}
		if (brand.getFirstChar()!=null&&!"".equals(brand.getFirstChar().trim())) {
			if (brand.getName()==null||"".equals(brand.getName().trim())) {
				url=url+"?FirstChar="+brand.getFirstChar();
			}else {
				url=url+"&FirstChar="+brand.getFirstChar();
			}
			
		}
		String page2 = PageUtil.page(brandlist.getPageNum(),brandlist.getPages(),url,brandlist.getPageSize());
		model.addAttribute("page",page2);
		return "brand/brand_list";
		
	}
	@RequestMapping("/getAllBrands")
	@ResponseBody
	public List<Brand> getAllBrands() {
		return BrandService.getAllBrands();
	}
	
	//���
	@RequestMapping("Addbrand")
	@ResponseBody
	public int Addbrand(HttpServletRequest request,Brand brand,Model model) {
		int add = BrandService.add(brand);
		return add;
		
	}
	//�޸�
	@RequestMapping("UpdBrand")
	@ResponseBody
	public int UpdBrand(HttpServletRequest request,Brand brand,Model model){
		int add = BrandService.update(brand);
		return add;
	}
	
	//ɾ��
	@RequestMapping("DelAll")
	@ResponseBody
	public int DelAll(HttpServletRequest request,int [] brandid,Model model) {
		int delete = BrandService.delete(brandid);
		return delete;
		
	}
	//����
	@RequestMapping("QYBrand")
	@ResponseBody
	public int QYBrand(HttpServletRequest request,int [] brandid,Model model) {
		int delete = BrandService.QYBrand(brandid);
		return delete;
		
	}
	//����
	@RequestMapping("Parti")
	@ResponseBody
	public Brand Parti(HttpServletRequest request,int id) {
		Brand Partibrand = BrandService.get(id);
		return Partibrand;
	}
	

}
