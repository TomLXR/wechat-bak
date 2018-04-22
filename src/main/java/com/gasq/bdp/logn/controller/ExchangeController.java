package com.gasq.bdp.logn.controller;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.gasq.bdp.logn.model.TProject;
import com.gasq.bdp.logn.model.TUser;
import com.gasq.bdp.logn.service.ExchangeService;
import com.gasq.bdp.logn.service.TProjectService;
import com.gasq.bdp.logn.service.TUserService;

@RestController
@RequestMapping(value = "exchange")
public class ExchangeController {

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	TProjectService projectService;
	@Autowired
	TUserService userService;
	@Autowired
	ExchangeService exchageService;
	
	@RequestMapping(value = "/scoreExchange",method=RequestMethod.POST)
	public Map<String,Object> userManager(HttpServletRequest request,HttpServletResponse response,Integer id) {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
		    HttpSession session = request.getSession();
		    TUser user = (TUser) session.getAttribute("user");
		    TProject project = projectService.selectByPrimaryKey((long)id);
		    user = userService.selectByPrimaryKey(user.getUserId());
		    Long vi = user.getValidIntegral();
		    if(project.getMoney().longValue()>vi) {
		    	result.put("status", false);
		    	result.put("mess", "积分不够，不能兑换！");
		    }else {
				exchageService.exchange(project, user);
		    	result.put("status", true);
		    	result.put("mess", "兑换成功！");
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return result;
  	}

}
