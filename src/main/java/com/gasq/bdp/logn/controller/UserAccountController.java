package com.gasq.bdp.logn.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gasq.bdp.logn.model.TUser;
import com.gasq.bdp.logn.model.TUserExample;
import com.gasq.bdp.logn.model.TUserExample.Criteria;
import com.gasq.bdp.logn.service.TUserService;
import com.gasq.bdp.logn.utils.WeixinUtil;

/**  
* 类说明   用户账户信息的控制器类
*  
* @author laody 
* @date 2017年12月28日
*/
@Controller
@RequestMapping("userAccount")
public class UserAccountController extends BaseController{
	@Autowired
	private TUserService  tUserService;
	
		@RequestMapping("init")
		public String init(HttpServletRequest request,HttpSession session, ModelMap mmap, RedirectAttributes attr,Model  mod,String code){
			//String openid="oDpzjwbQOt71nmU6jLnczPp2VmTc";
			//String openid="oDpzjwbQOt71nmU6jLnczPp2VmT";
			TUser user=	(TUser)	session.getAttribute("user");
			mod.addAttribute("nick_name", user.getNickName());
			mod.addAttribute("user_img_url",user.getUserImgUrl());
			mod.addAttribute("money", user.getValidMoney());
			mod.addAttribute("valid_integral", (user.getValidIntegral()!=null)?user.getValidIntegral():0);
			jsGood(request, "userAccount/init", mod);

			return "userAccount";
		}

/*
		@RequestMapping("initAccount")
		public String initAccount(HttpServletRequest request,HttpSession session, ModelMap mmap, RedirectAttributes attr,Model  mod){
			TUser user=	(TUser)	session.getAttribute("user");
			mod.addAttribute("nick_name", user.getNickName());
			mod.addAttribute("user_img_url",user.getUserImgUrl());
			mod.addAttribute("money", user.getValidMoney());
			mod.addAttribute("valid_integral", (user.getValidIntegral()!=null)?user.getValidIntegral():0);
			jsGood(request, "userAccount/init", mod);
			return "userAccount";
		}*/
		
		@RequestMapping("registpage")
		public String regist(){
			return "regist";
		}
		
		@RequestMapping("setting")
		public String setting(){
			return "setting/setting";
		}
		

		@RequestMapping("cart")
		public String cart(){
			return "cart/cart";
		}
		

		
		
}
