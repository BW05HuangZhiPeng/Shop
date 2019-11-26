package com.huangzhipeng.shop.controller;

import java.util.List;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.huangzhipeng.shop.entity.Spec;
import com.huangzhipeng.shop.service.SpecService;

@Controller
@RequestMapping("/Spec")
public class SpecController {

	@Reference
	private SpecService specService;
	
	@RequestMapping("/specList")
	public String specList(Model model, Spec spec, @RequestParam(defaultValue="1")Integer pageNum, @RequestParam(defaultValue="3")Integer pageSize) {
		//1.获取数据
		PageInfo<Spec> pageInfo = specService.specList(spec, pageNum, pageSize);
		//2.填充数据
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("spec", spec);
		return "/spec/spec_list";
	}
	/**
	 * 添加sku页面获取规格列表
	 * @return
	 */
	@RequestMapping("/specs")
	@ResponseBody
	public List<Spec> specs() {
		return specService.specs();
	}
	
	@RequestMapping("/specAdd")
	@ResponseBody
	public boolean specAdd(Spec spec) {
		return specService.saveOrUpdateSpec(spec) > 0;
	}
	
	@RequestMapping("/getSpecById")
	@ResponseBody
	public Spec getSpecById(Integer id) {
		return specService.getSpecById(id);
	}
	
	@RequestMapping("/specDelete")
	@ResponseBody
	public boolean specDelete(Integer[] ids) {
		return specService.deleteSpecByIds(ids) > 0;
	}
	
	@RequestMapping("/specOptionDelete")
	@ResponseBody
	public boolean specOptionDelete(Integer id) {
		return specService.deleteSpecOptionById(id) > 0;
	}
	
	
}
