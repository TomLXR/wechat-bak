package com.gasq.bdp.logn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**  
* 类说明   签到
*  
* @author laody 
* @date 2018年3月9日
*/
@Controller
@RequestMapping("instr")
public class InstructionController {
	
	
	/*
	 * 积分说明
	 * 
	 */
	@RequestMapping("index")
	public String instr(HttpServletRequest request,HttpServletResponse response,ModelMap model,Model mod){
		   HttpSession session = request.getSession();
/*		   if(session.getAttribute("user")==null){
			   return "redirect:gotoregist";
		   }*/
		return "instruction/instruction";
	}
}
