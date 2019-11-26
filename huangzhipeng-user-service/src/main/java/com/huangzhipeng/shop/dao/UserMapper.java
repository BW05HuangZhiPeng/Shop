/**
 * 
 * @Title:         UserMapper.java
 * @Package        com.huangzhipeng.shop.dao
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月21日 下午3:59:07
 * @version:       V1.0
 */
package com.huangzhipeng.shop.dao;

import org.apache.ibatis.annotations.Param;

import com.huangzhipeng.shop.entity.User;

/**   
 * @ClassName:     UserMapper   
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月21日 下午3:59:07     
 */
public interface UserMapper {

	int check(@Param("param")String param, @Param("type")Integer type);

	int register(User user);

	User getUserBySearch(String name);

}
