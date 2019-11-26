package com.huangzhipeng.shop.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext-service.xml",
		"classpath:applicationContext-dao.xml"})
public class TestBase  {
	
	
	
}
