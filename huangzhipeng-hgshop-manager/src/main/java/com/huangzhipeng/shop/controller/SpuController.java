package com.huangzhipeng.shop.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
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
import com.huangzhipeng.shop.entity.Spu;
import com.huangzhipeng.shop.service.SpuService;

@Controller
@RequestMapping("/Spu")
public class SpuController {
	
	@Reference
	private SpuService spuService;
	
	@RequestMapping("/showCategoryTree")
	public String showCategoryTree() {
		return "/spu/spu_list";
	}
	@RequestMapping("/spuList")
	public String spuList(Model model,Spu spu, @RequestParam(defaultValue="1")Integer pageNum, @RequestParam(defaultValue="2")Integer pageSize) {
		PageInfo<Spu> pageInfo = spuService.spuList(spu, pageNum, pageSize);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("spu", spu);
		return "/spu/spu_list1";
	}
	/**
	 * sku���ҳ������ʾspu�б�
	 * @return
	 */
	@RequestMapping("/spus")
	@ResponseBody
	public List<Spu> spus() {
		return spuService.spus();
	}
	
	/**
	 * ���ϴ��ļ���spu��ӻ�༭
	 * @param spu
	 * @param file
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping("/spuAdd")
	@ResponseBody
	public boolean spuAdd(Spu spu, MultipartFile file) throws IllegalStateException, IOException {
		//1.��ȡ�ļ�ԭʼ����
		String originalFilename = file.getOriginalFilename();
		if (StringUtils.isNotBlank(originalFilename)) {
			String fileName = UUID.randomUUID() + "_" + originalFilename;
			File destFile = new File("d://pic/", fileName);
			//2.���fileName�ϼ�����Ŀ¼�����ڣ���Ҫ����
			if (!destFile.getParentFile().exists()) {
				destFile.getParentFile().mkdirs();
			}
			//3.�����ļ�����
			file.transferTo(destFile);
			//4.��ȡ֮ǰ��ͼƬ������ɾ��
			String oldPath = spu.getSmallPic();
			if (StringUtils.isNotBlank(oldPath)) {
				/* FileUtils.forceDeleteOnExit(new File("d://pic/" + oldPath)); */
				 boolean delete = new File("d://pic/" + oldPath).delete(); 
				 if (delete) {
					System.out.println("ɾ���ɹ�");
				}
			}
			
			//5.��ֵ���ļ�·��
			spu.setSmallPic(fileName);
		}
		return spuService.saveOrUpdateSpu(spu) > 0;
	}
	
	@RequestMapping("/getSpuById")
	@ResponseBody
	public Spu getSpuById(Integer id) {
		return spuService.getSpuById(id);
	}
	
	@RequestMapping("/spuDelete")
	@ResponseBody
	public boolean spuDelete(Integer[] ids) {
		return spuService.deleteSpuByIds(ids) > 0;
	}
}
