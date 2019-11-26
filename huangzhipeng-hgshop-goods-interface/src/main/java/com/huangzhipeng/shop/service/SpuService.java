package com.huangzhipeng.shop.service;


import java.util.List;

import com.github.pagehelper.PageInfo;
import com.huangzhipeng.shop.entity.Spu;

public interface SpuService {

	PageInfo<Spu> spuList(Spu spu, Integer pageNum, Integer pageSize);

	Integer saveOrUpdateSpu(Spu spu);

	Spu getSpuById(Integer id);

	Integer deleteSpuByIds(Integer[] ids);

	List<Spu> spus();
}
