/**
 * 
 * @Title:         AdminController.java
 * @Package        com.huangzhipeng.shop.controller
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月15日 上午9:18:46
 * @version:       V1.0
 */
package com.huangzhipeng.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**   
 * @ClassName:     AdminController   
 * @Description:   TODO
 * @author:        HuangZhiPeng
 * @date:          2019年11月15日 上午9:18:46     
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	  @RequestMapping("/index")
	  public String toIndex() {
		  
		  return "/Admin/index";
	  }
	  @RequestMapping("/towelcome")
	  public String towelcome() {
		  return "/Admin/welcome";
	  }

}
