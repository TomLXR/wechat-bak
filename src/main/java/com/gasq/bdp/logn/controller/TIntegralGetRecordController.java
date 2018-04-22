package com.gasq.bdp.logn.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gasq.bdp.logn.model.TIntegralGetRecord;
import com.gasq.bdp.logn.model.TIntegralGetRecordExample;
import com.gasq.bdp.logn.model.TIntegralGetRecordExample.Criteria;
import com.gasq.bdp.logn.model.TUser;
import com.gasq.bdp.logn.model.TUserExample;
import com.gasq.bdp.logn.service.TIntegralGetRecordService;
import com.gasq.bdp.logn.service.TUserService;
import com.gasq.bdp.logn.utils.ConfigUtil;

@Controller
@RequestMapping("getRecord")
public class TIntegralGetRecordController {
	public static final SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private TIntegralGetRecordService  tIntegralGetRecordService;
	
	@Autowired
	private TUserService tUserService;
	
	@RequestMapping("listPage")
	public String listPage(HttpSession session,HttpServletRequest request,Model  mod){

		
		return "tab/getList";
	}
	
	
	@RequestMapping("listDetail")
	public String listDetail(HttpSession session,HttpServletRequest request,Model  mod,String isfirst,Integer nc){
		TUser u=null;
/*		TUser u=new TUser();
		u.setUserId(38L);
		u.setNickName("老大爷");
		u.setUserImgUrl("http://thirdwx.qlogo.cn/mmopen/aUZWklsY4pU5eQTsusxO1cmibiaVlM1bsSuicmsntCJIxL5PThxuAK5P8pGfoibZNs5giaeotKt8I1wZOQecNibBuqEwROxEnnnAam/132");
		u.setValidMoney(new BigDecimal(100));
		u.setValidIntegral(100L);
		session.setAttribute("user", u);
		*/
		Integer pageSize=Integer.valueOf(ConfigUtil.get("pageSize").toString());
		if(isfirst==null){
			isfirst="y";
			nc=0;
		}else if(isfirst.equals("y")){
			isfirst="n";
		}

		List<Map<String, Object>> nl=new ArrayList<>();
		Map<String, Object> map=new HashMap<>();
		 List<TIntegralGetRecord> lsn=null;
			
		TUser 	user=(TUser) session.getAttribute("user");
		TIntegralGetRecordExample example=new TIntegralGetRecordExample();
		Criteria criteria = example.createCriteria();
		Date today=new Date();
		Long userId = user.getUserId();

			 criteria.andAvaDateTimeGreaterThanOrEqualTo(today);
			 //criteria.andUserIdEqualTo(userId);
			 criteria.andSupUserIdEqualTo(userId);
			 example.setOrderByClause(" get_date_time desc");
			 example.setStart(nc);
			 example.setEnd(nc+pageSize);
			 nc+=pageSize;
			 lsn = tIntegralGetRecordService.selectByExample(example);
			 TUserExample uexample=new TUserExample();
			 com.gasq.bdp.logn.model.TUserExample.Criteria uCriteria = uexample.createCriteria();
			 
		 for(TIntegralGetRecord record:lsn){
			 map=new HashMap<>();
			 map.put("notUsedIntegral",record.getNotUsedIntegral() );
			 map.put("avaDateTime",format.format(record.getAvaDateTime() ));
			 //map.put("getDateTime",format.format(record.getGetDateTime() ));
			 uexample.clear();
			 uCriteria = uexample.createCriteria();
			 uCriteria.andUserIdEqualTo(record.getUserId());
			 List<TUser> ulist = tUserService.selectByExample(uexample);
			 if(ulist.size()>0){
				 map.put("userName",ulist.get(0).getUserName());	 
			 }else{
				 map.put("userName","无");
			 }
			 
			 nl.add(map);
		 }
		 criteria.andAvaDateTimeGreaterThanOrEqualTo(today);
		 criteria.andUserIdEqualTo(userId);
		 example.setOrderByClause(" get_date_time desc");
		 example.setStart(null);
		 example.setEnd(null);
		 lsn = tIntegralGetRecordService.selectByExample(example);
		 int count=lsn.size();
		 if(nc>=count){
			 mod.addAttribute("ismore","n");	 
		 }else{
			 mod.addAttribute("ismore","y");
		 }
		 mod.addAttribute("nl", nl);
		 mod.addAttribute("isfirst",isfirst);
		 mod.addAttribute("nc",nc);
		return "tab/getList";
	}
}
