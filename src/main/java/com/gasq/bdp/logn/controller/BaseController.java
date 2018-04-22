package com.gasq.bdp.logn.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import com.gasq.bdp.logn.utils.ConfigUtil;
import com.gasq.bdp.logn.utils.WeixinUtil;

/**  
* 类说明  包装微信的javascript 验证   
*  
* @author laody 
* @date 2018年1月1日
*/
public class BaseController {	
	/**js 微信验证的方法
	 * @param request
	 * @param path
	 * @param mod
	 */
	public void jsGood (HttpServletRequest request, String path,Model  mod) {

		String[] arr=WeixinUtil.getSignature("http://"+ConfigUtil.get("localname")+request.getContextPath()+"/"+path);
		mod.addAttribute("appId",ConfigUtil.get("appId"));
		mod.addAttribute("timestamp",arr[2] );
		mod.addAttribute("nonceStr",arr[1]);
		mod.addAttribute("signature",arr[0]);
	}

}
