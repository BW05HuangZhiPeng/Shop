package com.huangzhipeng.shop.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.dubbo.config.annotation.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huangzhipeng.shop.dao.SkuMapper;
import com.huangzhipeng.shop.dao.SpecMapper;
import com.huangzhipeng.shop.entity.Brand;
import com.huangzhipeng.shop.entity.Category;
import com.huangzhipeng.shop.entity.Sku;
import com.huangzhipeng.shop.entity.SkuSpec;
import com.huangzhipeng.shop.entity.Spec;
import com.huangzhipeng.shop.service.SkuService;

@Service
public class SkuServiceImpl implements SkuService {

	@Resource
	private SkuMapper skuMapper;
	
	@Resource
	private SpecMapper specMapper;
	
	@Override
	public PageInfo<Sku> skuList(Sku sku, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Sku> list = skuMapper.selectSkuList(sku);
		PageInfo<Sku> pageInfo = new PageInfo<Sku>(list);
		return pageInfo;
	}

	@Override
	public Integer saveOrUpdateSku(Sku sku) {
		Integer count = 0;
		int id=0;
		//①新增
		if (sku.getId() == null) {
			sku.setStatus("0");
			sku.setCreateTime(new Date());
			sku.setUpdateTime(new Date());
			count = skuMapper.insertSku(sku);
			id=sku.getId();
		} else {
			//Ⅱ修改
			sku.setUpdateTime(new Date());
			count = skuMapper.updateSku(sku);
			skuMapper.deleteSkuSpecBySkuIds(new Integer[]{sku.getId()});
			id=sku.getId();
		}
		if (count > 0) {
			
			List<SkuSpec> skuSpecs = sku.getSkuSpec();
			if (skuSpecs != null) {
				for (SkuSpec skuSpec : skuSpecs) {
					skuSpec.setSkuId(id);
					 skuMapper.insertSkuSpec(skuSpec); 
				}
			}
		}
		return count;
	}

	@Override
	public Map<String, Object> getSkuById(Integer id) {
		Map<String, Object> map = new HashMap<>();
		//1.获取sku详情
		Sku sku = skuMapper.selectSkuById(id);
		//2.将中间表对象列表映射成规格参数id列表
		List<Integer> specIds = sku.getSkuSpec().stream().map(ks -> ks.getSpecId()).collect(Collectors.toList());
//		List<Map<String, String>> specList = specMapper.selectSpecAndSpecOptionBySpecIds(specIds);
		//3.根据规格参数id列表获取规格参数及规格参数选项信息
		List<Spec> specList = specMapper.selectSpecByIds(specIds);
		map.put("sku", sku);
		map.put("specs", specList);
		return map;
	}

	@Override
	public Integer deleteSkuByIds(Integer[] ids) {
		//1.删除sku表
		Integer count = skuMapper.deleteSkuByIds(ids);
		if (count > 0) {
			//2.删除sku_spec表
			skuMapper.deleteSkuSpecBySkuIds(ids);
		}
		return count;
	}

	/**
	 * 搜索列表页展示
	 */
	public Map<String, Object> getSkuList(Sku sku, Integer pageNum, Integer pageSize) {
		Map<String, Object> map = new HashMap<>();
		
		//①查询skuId列表
		List<Integer> skuIds = skuMapper.selectSkuIdsBySearch(sku);
		System.out.println(skuIds);
		if (skuIds.size() == 0) return map;
		//②分页查询sku列表
		PageHelper.startPage(pageNum, pageSize);
		List<Sku> list = skuMapper.selectSkuByIds(skuIds);
		PageInfo<Sku> pageInfo = new PageInfo<>(list);
		map.put("pageInfo", pageInfo);
	
		//③查询分类列表
		List<Category> categoryList = skuMapper.selectCategoryBySkuIds(skuIds);
		//④查询品牌列表
		List<Brand> brandList = skuMapper.selectBrandBySkuIds(skuIds);
		//⑤查询规格参数列表
		List<Spec> specList = specMapper.selectSpecBySkuIds(skuIds);
	
		map.put("categoryList", categoryList);
		map.put("brandList", brandList);
		map.put("specList", specList);
		
		return map;
	}
	
	
	@Override
	public List<Sku> selectNews(int num) {
		return skuMapper.selectNews(num);
	}
	/**
	 * 详情页展示
	 */
	@Override
	public Map<String, Object> getSkuById1(Integer id) {
		Map<String, Object> map = new HashMap<>();
		//1.获取sku详情
		Sku sku = skuMapper.selectSkuById1(id);
		//2.根据spu id获取规格参数及规格参数选项信息(查询该商品中有哪些规格参数)
		List<Integer> skuIds = skuMapper.selectSkuIdsBySpuId(sku.getSpuId());
		List<Spec> specList = specMapper.selectSpecBySkuIds(skuIds);
		map.put("sku", sku);
		map.put("specs", specList);
		System.err.println(specList);
		return map;
	}

	/**
	 * 根据选项id列表查询sku信息
	 */
	@Override
	public Map<String, Object> getSkuBySpecOptionIds(Integer[] optionIds) {
		Map<String, Object> map = new HashMap<>();
		//1.获取sku详情
		Sku sku = skuMapper.selectSkuBySpecOptionIds(optionIds);
		//一般正常情况下sku不为空,即使没有该规格参数的组合,后台录入时,也会添加一份库存和价格为0的记录
		//这样处理是为了详情页展示图片及其他相关信息
		//库存为空，需在页面将规格选项置为禁用状态
		if (sku == null || sku.getStockCount() ==null) {
			
		}
		List<SkuSpec> skuSpecList = skuMapper.selectSkuSpecBySkuId(sku.getId());
		sku.setSkuSpec(skuSpecList);
		//2.根据spu id获取规格参数及规格参数选项信息(查询该商品中有哪些规格参数)
		List<Integer> skuIds = skuMapper.selectSkuIdsBySpuId(sku.getSpuId());
		List<Spec> specList = specMapper.selectSpecBySkuIds(skuIds);
		map.put("sku", sku);
		map.put("specs", specList);
		System.err.println(specList);
		return map;
	}

	@Override
	public Sku getSkuById2(Integer skuid) {
		return skuMapper.selectSkuById2(skuid);
	}

	/**   
	 * @Title:         reduceStock
	 * @Description:   TODO
	 * @date:          2019年11月25日 下午2:24:15  
	 * @param skuId
	 * @param num   
	 * @see com.huangzhipeng.shop.service.SkuService#reduceStock(java.lang.Integer, java.lang.Integer)   
	 */
	@Override
	public void reduceStock(Integer skuId, Integer num) {
		skuMapper.reduceStock(skuId, num);
		
	}

	/*@Override
	public Map<String, Object> getSkuList(Sku sku, Integer pageNum, Integer pageSize) {
		Map<String, Object> map = new HashMap<>();
		
		PageHelper.startPage(pageNum, pageSize);
		List<Sku> list = skuMapper.selectSkus(sku);
		PageInfo<Sku> pageInfo = new PageInfo<>(list);
		map.put("pageInfo", pageInfo);
		
		Map<String, String> selectCategorysAndBrands = skuMapper.selectCategorysAndBrands(sku);
		if (selectCategorysAndBrands != null) {
			String brands = selectCategorysAndBrands.get("bb");
			String categorys = selectCategorysAndBrands.get("cc");
			List<String> brandList = Arrays.asList(brands.split(","));
			List<String> categoryList = Arrays.asList(categorys.split(","));
			map.put("brandList", brandList);
			map.put("categoryList", categoryList);
		}
		
		List<Map<String, Object>> specOptionList = new ArrayList<>();
		List<String> selectSpecOptions = skuMapper.selectSpecOptions(sku);
		for(String str : selectSpecOptions) {
			Map<String, Object> optionMap = new HashMap<>();
			String specName = str.substring(0, str.indexOf(":"));
			List<String> optionList = Arrays.asList(str.substring(str.indexOf(":")+1).split(","));
			optionMap.put("specName", specName);
			optionMap.put("optionList", optionList);
			specOptionList.add(optionMap);
		}
		map.put("specOptionList", specOptionList);
		
		return map;
	}*/
}
