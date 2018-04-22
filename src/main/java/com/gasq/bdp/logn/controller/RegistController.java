package com.gasq.bdp.logn.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gasq.bdp.logn.model.TUser;
import com.gasq.bdp.logn.model.TUserExample;
import com.gasq.bdp.logn.model.TUserExample.Criteria;
import com.gasq.bdp.logn.service.RegistService;
import com.gasq.bdp.logn.service.TUserService;
/*import com.gasq.bdp.logn.service.TUserShareRecordService;*/
import com.gasq.bdp.logn.utils.ConfigUtil;

/**  
* 类说明   
*  
* @author laody 
* @date 2018年1月26日
*/

@Controller
public class RegistController extends BaseController{
	private Logger _logger = Logger.getLogger(RegistController.class);
	@Autowired
	private TUserService  tUserService;
/*	@Autowired
	private TUserShareRecordService  tUserShareRecordService;*/
	
	@Autowired
	private RegistService registService;


	@RequestMapping(value = "/gotoregist")

	public String regist(HttpServletRequest request,HttpSession session, ModelMap mmap, RedirectAttributes attr,Model  mod) {
		jsGood (request, "gotoregist",mod);
		TUser user;
		_logger.info("openId///////////////////#######################");
		String openId=null;

		if(session.getAttribute("user")!=null){
			user=(TUser)session.getAttribute("user");
			openId=user.getWxPubOpenId();
		}else{
			if(session.getAttribute("openId")==null){
				mod.addAttribute("err", "微信获取用户信息失败");
				return "err";				
			}else{
				openId=(String)session.getAttribute("openId");	
			}
			

		}
		TUserExample example=new TUserExample(); 
		Criteria createCriteria = example.createCriteria();
		createCriteria.andWxPubOpenIdEqualTo(openId);
		List<TUser> selectByExample = tUserService.selectByExample(example);
		if(selectByExample.size()==0){
			session.setAttribute("user", null);
		}else{
			session.setAttribute("user", selectByExample.get(0));
		}

		if(session.getAttribute("user")==null){
			Object rc=session.getAttribute(ConfigUtil.get("recommond"));
			mod.addAttribute("isreg", "0");
			mod.addAttribute("recode", "no");
			if(rc!=null){
				mod.addAttribute("recode",rc.toString());
				session.setAttribute(ConfigUtil.get("recommond"), null);
			}
			
		}else{
			user=(TUser) session.getAttribute("user");
			mod.addAttribute("isreg", "1");
			mod.addAttribute("recode", user.getRecomCode());
		}
		return "regist";
	}
/*	@RequestMapping(value = "/gotoregist")
	public String regist(HttpServletRequest request,HttpSession session, ModelMap mmap, RedirectAttributes attr,Model  mod,String state) {
		jsGood (request,"gotoregist",mod);
		String openId;
		if(session.getAttribute("openid")==null){
			openId=WeixinUtil.accessOpenid(request, session);
		}else{
			openId= (String) session.getAttribute("openid");
		}
		
		//openId="oDpzjwe_ZBcLhMCuEZt5-JRAww6s";  测试使用
		if(openId!=null&&tUserService.selectUserCountByOpenId(openId.toString())==0){
			mod.addAttribute("isreg", "0");
			mod.addAttribute("recode", "no");
			if(state!=null&&!state.equals("123")){
				mod.addAttribute("recode",state);
			}
		}else{
			mod.addAttribute("isreg", "1");
			mod.addAttribute("recode", tUserService.selectRecomByOpenId(openId.toString()));
		}
		return "regist";
	}*/

	
	@RequestMapping(value = "/regist",produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map<String, Object> handle(HttpSession session,String username,String password,String recommond){

		return	registService.doRegist(session,username,password,recommond);
		
	 
	}
	
	@RequestMapping(value = "/checkUsername",produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map<String, Object> checkUsername(String username){
		Map<String, Object> rs=new HashMap<>();

		if(tUserService.selectUserCount(username)>0){
				rs.put("ms","用户已经存在" );
			
		}else{
			rs.put("ms", "");
		}
		
		return rs;
	}


}
