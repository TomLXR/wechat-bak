package com.gasq.bdp.logn.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.gasq.bdp.logn.model.TOrder;
import com.gasq.bdp.logn.model.TOrderExample;
import com.gasq.bdp.logn.model.TUser;
import com.gasq.bdp.logn.model.TUserExample;
import com.gasq.bdp.logn.model.TUserExample.Criteria;
import com.gasq.bdp.logn.service.TOrderService;
import com.gasq.bdp.logn.service.TUserService;

@RestController
public class SettlementController {
	@Autowired
	private TUserService tUserService;
	@Autowired
	private TOrderService tOrderService;

	
	@RequestMapping(value="/settlement",method=RequestMethod.POST)
	public JSONObject dosettle(String username,String buycode){

		JSONObject result=new JSONObject();
		if(StringUtils.isBlank(username)){
			result.put("rs", "用户名称(手机号)不能为空");
			return result;
		}
/*		TUserExample uexample=new TUserExample();
		Criteria uCriteria = uexample.createCriteria();
		uCriteria.andUserNameEqualTo(username);
		List<TUser> selectByExample = tUserService.selectByExample(uexample);
		*/
		if(StringUtils.isBlank(buycode)){
			result.put("rs", "购物码不能为空");
			return result;
		}
		TUserExample uexample=new TUserExample();
		Criteria uCriteria = uexample.createCriteria();
		uCriteria.andUserNameEqualTo(username);
		List<TUser> ulist = tUserService.selectByExample(uexample);
		if(ulist.size()==0){
			result.put("rs", "非平台用户请先注册");
		}else{
			TUser user = ulist.get(0);
			result.put("user", user);
			TOrderExample oexample=new TOrderExample();
			com.gasq.bdp.logn.model.TOrderExample.Criteria oCriteria = oexample.createCriteria();
			oCriteria.andBugCodeEqualTo(buycode);
			List<TOrder> olist = tOrderService.selectByExample(oexample);
			if(olist.size()==0){
				result.put("rs", "无对应订单");
			}else{
				TOrder order = olist.get(0);
				String status = order.getStatus();
				if(!status.equals("1")){
					result.put("rs", "订单状态错误");
				}else{
					result.put("order", order);
					try {
						tOrderService.settle(user,order);	
						result.put("rs", "ok");	
					} catch (Exception e) {
						result.put("rs", "积分不足");
					}					
				}

			}
		}
		return result;
	}
	
/**
 * 测试get使用
 */
	@RequestMapping(value="/settlementTest",method=RequestMethod.GET)
	public JSONObject doTest(String username,String buycode){

		JSONObject result=new JSONObject();
		if(StringUtils.isBlank(username)){
			result.put("rs", "用户名称(手机号)不能为空");
			return result;
		}
/*		TUserExample uexample=new TUserExample();
		Criteria uCriteria = uexample.createCriteria();
		uCriteria.andUserNameEqualTo(username);
		List<TUser> selectByExample = tUserService.selectByExample(uexample);
		*/
		if(StringUtils.isBlank(buycode)){
			result.put("rs", "购物码不能为空");
			return result;
		}
		TUserExample uexample=new TUserExample();
		Criteria uCriteria = uexample.createCriteria();
		uCriteria.andUserNameEqualTo(username);
		List<TUser> ulist = tUserService.selectByExample(uexample);
		if(ulist.size()==0){
			result.put("rs", "非平台用户请先注册");
		}else{
			TUser user = ulist.get(0);
			result.put("user", user);
			TOrderExample oexample=new TOrderExample();
			com.gasq.bdp.logn.model.TOrderExample.Criteria oCriteria = oexample.createCriteria();
			oCriteria.andBugCodeEqualTo(buycode);
			List<TOrder> olist = tOrderService.selectByExample(oexample);
			if(olist.size()==0){
				result.put("rs", "无对应订单");
			}else{
				TOrder order = olist.get(0);
				String status = order.getStatus();
				if(!status.equals("1")){
					result.put("rs", "订单状态错误");
				}else{
					result.put("order", order);
					try {
						tOrderService.settle(user,order);	
						result.put("rs", "ok");	
					} catch (Exception e) {
						result.put("rs", "积分不足");
					}					
				}

			}
		}
		return result;
	}

	
	
	@RequestMapping(value="/queryUserInfo",method=RequestMethod.POST)
	public JSONObject queryUserInfo(String phonenumb){
		JSONObject result=new JSONObject();
		if(StringUtils.isBlank(phonenumb)){
			result.put("rs", "用户名称(手机号)不能为空");
			return result;
		}
		TUserExample uexample=new TUserExample();
		Criteria uCriteria = uexample.createCriteria();
		uCriteria.andUserNameEqualTo(phonenumb);
		List<TUser> ulist = tUserService.selectByExample(uexample);
		if(ulist.size()==0){
			result.put("rs", "非平台用户请先注册");
		}else{
			TUser user = ulist.get(0);
			result.put("user", user);
			result.put("rs", "ok");
		}
		return result;
	}
}
