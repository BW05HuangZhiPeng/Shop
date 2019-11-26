package com.huangzhipeng.shop.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.huangzhipeng.shop.entity.Sku;
import com.huangzhipeng.shop.service.SkuService;
import com.huangzhipeng.shop.util.PageUtil;

@Controller
@RequestMapping("/Sku")
public class SkuController {
	
	@Reference
	private SkuService skuService;
	
	@RequestMapping("/skuList")
	public String skuList(Model model, Sku sku, @RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="2")Integer pageSize) {
		PageInfo<Sku> pageInfo = skuService.skuList(sku, page, pageSize);
		String url="/Sku/skuList";
		if (sku.getTitle()!=null && !"".equals(sku.getTitle().trim())) {
			url=url+"?title="+sku.getTitle();
		}else if (sku.getSellPoint()!=null && !"".equals(sku.getSellPoint().trim())){
			if (sku.getTitle()==null ||"".equals(sku.getTitle().trim())) {
				url=url+"?sellPoint="+sku.getSellPoint();
			}else {
				url=url+"&sellPoint="+sku.getSellPoint();
			}
		}
		
		String Page = PageUtil.page(pageInfo.getPageNum(),pageInfo.getPages(),url,pageInfo.getPageSize());
		model.addAttribute("Page",Page);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("sku", sku);
		return "/sku/sku_list";
	}
	
	@RequestMapping("/skuAdd")
	@ResponseBody
	public boolean skuAdd(Sku sku, MultipartFile file) throws IllegalStateException, IOException {
		String originalFilename = file.getOriginalFilename();
		if (StringUtils.isNotBlank(originalFilename)) {
			String fileName = UUID.randomUUID() + "_" + originalFilename;
			File destFile = new File("d://pic/", fileName);
			if (!destFile.getParentFile().exists()) {
				destFile.getParentFile().mkdirs();
			}
			file.transferTo(destFile);
			
			String oldPath = sku.getImage();
			if (StringUtils.isNotBlank(oldPath)) {
				/* FileUtils.forceDelete(new File("d://pic/" + oldPath)); */
				new File("d://pic/" + oldPath).delete();
			}
			sku.setImage(fileName);
		}
		return skuService.saveOrUpdateSku(sku) > 0;
	}
	
	@RequestMapping("/getSkuById")
	@ResponseBody
	public Map<String, Object> getSkuById(Integer id) {
		return skuService.getSkuById(id);
	}
	
	@RequestMapping("/skuDelete")
	@ResponseBody
	public boolean skuDelete(Integer[] ids) {
		return skuService.deleteSkuByIds(ids) > 0;
	}
}
