package com.gasq.bdp.logn.service;
import java.util.Map;

import javax.servlet.http.HttpSession;

/**  
* 类说明   
*  
* @author laody 
* @date 2018年2月10日
*/
public interface RegistService {
	

	
  public Map<String, Object> doRegist(HttpSession session,String username,String password,String recommond);
}
