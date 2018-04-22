package com.gasq.bdp.logn.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gasq.bdp.logn.model.TUser;
import com.gasq.bdp.logn.model.TUserSignExt;
import com.gasq.bdp.logn.model.TUserSignExtExample;
import com.gasq.bdp.logn.model.TUserSignExtExample.Criteria;
import com.gasq.bdp.logn.service.TUserSignExtService;
import com.gasq.bdp.logn.utils.DateUtil;

/**  
* 类说明   
*  
* @author laody 
* @date 2018年3月9日
*/
@Controller
@RequestMapping("point")
public class PointController {
	
	@Autowired
	private TUserSignExtService tUserSignExtService;
	@RequestMapping("")
	public String index(HttpSession session,HttpServletRequest request,Model  mod){
		Date today=new  Date();
		if(session.getAttribute("user")==null){
			   return "redirect:gotoregist";
		}
		TUser user=(TUser) session.getAttribute("user");
		int sign=0;
		int wd = DateUtil.getWeekOfDay(today);
		TUserSignExtExample example=new TUserSignExtExample(); 
		Criteria c = example.createCriteria();
		c.andUserIdEqualTo(user.getUserId());
		List<TUserSignExt> signlist = tUserSignExtService.selectByExample(example);
		if(signlist.size()>0){
			TUserSignExt ts = signlist.get(0);
			switch (wd) {
			case 1:
				sign=ts.getW1();
				break;
			case 2:
				sign=ts.getW2();				
				break;
			case 3:
				sign=ts.getW3();				
				break;
			case 4:
				sign=ts.getW4();				
				break;
			case 5:
				sign=ts.getW5();				
				break;
			case 6:
				sign=ts.getW6();				
				break;
			case 7:
				sign=ts.getW7();				
				break;
			default:
				break;
			}
			
				
				Long score=getScore(ts);
				mod.addAttribute("score", score);
			
			
		}
		mod.addAttribute("sign", sign);
		mod.addAttribute("username", user.getUserName());
		return "point/point";
	}
	
	
	
	
	
	
	
	
	@RequestMapping("sign")
	public String sign(HttpSession session,HttpServletRequest request,Model  mod){
		Date today=new  Date();

		TUser user=(TUser) session.getAttribute("user");

		int wd = DateUtil.getWeekOfDay(today);


			TUserSignExt record=new TUserSignExt();
			switch (wd) {
			case 1:
				record.setW1(1);
				break;
			case 2:
				record.setW2(1);
				break;
			case 3:
				record.setW3(1);
				break;
			case 4:
				record.setW4(1);
				break;
			case 5:
				record.setW5(1);
				break;
			case 6:
				record.setW6(1);
				break;
			case 7:
				record.setW7(1);
				break;
			default:
				break;
			}
			
			TUserSignExtExample example=new TUserSignExtExample(); 
			Criteria c = example.createCriteria();
			c.andUserIdEqualTo(user.getUserId());
			tUserSignExtService.updateByExampleSelective(record,example);
			List<TUserSignExt> singlist = tUserSignExtService.selectByExample(example);
			if(singlist.size()>0){
				TUserSignExt signext = singlist.get(0);
				Long score=getScore(signext);
				record.setSignScore(score);
				mod.addAttribute("score", score);
			}
		mod.addAttribute("sign", 1);
		mod.addAttribute("username", user.getUserName());
		return "point/point";
	}
	
	public Long getScore(TUserSignExt signext){
		int[] arr=new int[7];
		arr[0]=signext.getW1();
		arr[1]=signext.getW2();
		arr[2]=signext.getW3();
		arr[3]=signext.getW4();
		arr[4]=signext.getW5();
		arr[5]=signext.getW6();
		arr[6]=signext.getW7();
		int a=0;
		int rs=0;
		for(int i=0;i<7;i++){
			if(arr[i]==1){
				a++;
			}else{
				a=0;
			}
			rs+=a;
		}

		return Long.valueOf(rs);
	}
}
