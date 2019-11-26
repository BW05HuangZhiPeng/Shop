package com.huangzhipeng.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.dubbo.config.annotation.Service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huangzhipeng.shop.dao.SpuMapper;
import com.huangzhipeng.shop.entity.Spu;
import com.huangzhipeng.shop.service.SpuService;

@Service
public class SpuServiceImpl implements SpuService {

	@Resource
	private SpuMapper spuMapper;
	
	@Override
	public PageInfo<Spu> spuList(Spu spu, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Spu> list = spuMapper.selectSpuList(spu);
		PageInfo<Spu> pageInfo = new PageInfo<Spu>(list);
		return pageInfo;
	}

	@Override
	public Integer saveOrUpdateSpu(Spu spu) {
		if (spu.getId() == null) {
			spu.setIsMarketable("0");
			return spuMapper.insertSpu(spu);
		} else {
			return spuMapper.updateSpu(spu);
		}
	}

	public Spu getSpuById(Integer id) {
		return spuMapper.selectSpuById(id);
	}

	@Override
	public Integer deleteSpuByIds(Integer[] ids) {
		return spuMapper.deleteSpuByIds(ids);
	}

	@Override
	public List<Spu> spus() {
		return spuMapper.selectSpus();
	}


}
