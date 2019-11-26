package com.huangzhipeng.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.dubbo.config.annotation.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huangzhipeng.shop.dao.SpecMapper;
import com.huangzhipeng.shop.entity.Spec;
import com.huangzhipeng.shop.entity.SpecOption;
import com.huangzhipeng.shop.service.SpecService;

@Service
public class SpecServiceImpl implements SpecService {

	@Resource
	private SpecMapper specMapper;
	
	@Override
	public PageInfo<Spec> specList(Spec spec, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Spec> list = specMapper.selectSpecList(spec);
		PageInfo<Spec> pageInfo = new PageInfo<Spec>(list);
		return pageInfo;
	}

	@Override
	public Integer saveOrUpdateSpec(Spec spec) {
		Integer count = 0;
		//①新增
		if (spec.getId() == null) {
			//1.添加spec
			count = specMapper.insertSpec(spec);
		} else {
			//Ⅱ修改
			count = specMapper.updateSpec(spec);
		}
		if (count > 0) {
			List<SpecOption> options = spec.getOptions();
			for (SpecOption specOption : options) {
				specOption.setSpecId(spec.getId());
				if (specOption.getId() == null) {
					specMapper.insertSpecOption(specOption);
				} else {
					specMapper.updateSpecOption(specOption);
				}
			}
		}
		return count;
	}

	@Override
	public Spec getSpecById(Integer id) {
		return specMapper.selectSpecById(id);
	}

	@Override
	public Integer deleteSpecByIds(Integer[] ids) {
		Integer count = specMapper.deleteSpecByIds(ids);
		if (count > 0) {
			specMapper.deleteSpecOptionBySpecIds(ids);
		}
		return count;
	}

	@Override
	public Integer deleteSpecOptionById(Integer id) {
		return specMapper.deleteSpecOptionById(id);
	}

	@Override
	public List<Spec> specs() {
		return specMapper.selectSpecs();
	}

}
