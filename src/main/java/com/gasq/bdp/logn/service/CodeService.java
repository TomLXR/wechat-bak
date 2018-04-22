package com.gasq.bdp.logn.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**  
* 类说明   
*  
* @author laody 
* @date 2018年1月26日
*/
public interface CodeService {
	
	 void generateCode(HttpServletRequest request,HttpServletResponse response,String rc);

}
