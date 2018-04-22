package com.gasq.bdp.logn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gasq.bdp.logn.utils.WXUtil;



@Controller
public class WeChatController {

	private Logger _logger = Logger.getLogger(WeChatController.class);
	
	@RequestMapping(value = "/weChat",produces = "application/json; charset=utf-8",method = RequestMethod.GET)
	@ResponseBody
	public String sign(HttpServletRequest request){
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		_logger.info("sign");
		if (WXUtil.checkSignature(signature, timestamp, nonce)) {
			return echostr;
		}
		return "";
	}
	
	@RequestMapping(value = "/weChat",produces = "application/json; charset=utf-8",method = RequestMethod.POST)
	@ResponseBody
	public String handle(@RequestBody String xmlObject,HttpServletRequest request,HttpServletResponse response){
		_logger.info(xmlObject);
		return "";
	}
	
	
}
