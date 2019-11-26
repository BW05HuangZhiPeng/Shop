package com.huangzhipeng.shop.dao;

import java.util.List;


import com.huangzhipeng.shop.entity.Spu;


public interface SpuMapper {

	List<Spu> selectSpuList(Spu spu);

	Integer insertSpu(Spu spu);

	Integer updateSpu(Spu spu);

	Spu selectSpuById(Integer id);

	Integer deleteSpuByIds(Integer[] ids);

	List<Spu> selectSpus();

}
