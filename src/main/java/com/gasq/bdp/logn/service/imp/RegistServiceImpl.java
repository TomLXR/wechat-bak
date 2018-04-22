package com.gasq.bdp.logn.service.imp;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.gasq.bdp.logn.model.TUser;
import com.gasq.bdp.logn.model.TUserExample;
import com.gasq.bdp.logn.model.TUserShareRecord;
import com.gasq.bdp.logn.model.TUserExample.Criteria;
import com.gasq.bdp.logn.service.RegistService;
import com.gasq.bdp.logn.service.TUserService;
import com.gasq.bdp.logn.service.TUserShareRecordService;
import com.gasq.bdp.logn.utils.WeixinUtil;

/**  
* 类说明   
*  
* @author laody 
* @date 2018年2月10日
*/
@Service
public class RegistServiceImpl  implements RegistService{
	
	
	@Autowired
	private TUserService  tUserService;
	@Autowired
	private TUserShareRecordService  tUserShareRecordService;
	  @Transactional(TxType.REQUIRED)
	  public Map<String, Object> doRegist(HttpSession session,String username,String password,String recommond){
			Map<String, Object> rs=new HashMap<>();
			JSONObject userinfo=WeixinUtil.getUserinfo(session);
			System.out.println(userinfo.toString());
			TUser u=new  TUser();
			TUser sup=null;
			TUserShareRecord rd=new TUserShareRecord();
			if(recommond!=null && !recommond.equals("")){
				sup=tUserService.selectUserByCommo(recommond);
				rd.setRegisterTime(new Date());
				rd.setUserId(sup.getUserId());
			}
			if(sup!=null){
				u.setReferrerUserId(sup.getUserId());
			}
			String com=tUserService.createCommo();
			u.setRecomCode(com);
			u.setRegisterTime(new Date());
			System.out.println("----------- nickname ----------"+userinfo.get("nickname"));
			if(userinfo.get("nickname")!=null){
				u.setNickName(userinfo.get("nickname").toString());	
			}
			u.setUserName(username);
			u.setMobilePhone(username);
			u.setPassword(password);
			u.setSex(userinfo.get("sex").toString());
			u.setStatus((byte) 1); 
			u.setUserImgUrl(userinfo.get("headimgurl").toString());
			u.setWxPubOpenId(WeixinUtil.getOpenId(session)); //openid
			try {
				tUserService.regist(u);
				rs.put("rc", tUserService.selectRecomByOpenId(WeixinUtil.getOpenId(session)));
				
			} catch (Exception e) {

				rs.put("ms", e.getMessage());
			}
			TUserExample uexample=new TUserExample();
			Criteria ucriteria = uexample.createCriteria();
			ucriteria.andWxPubOpenIdEqualTo(WeixinUtil.getOpenId(session));
			List<TUser> user = tUserService.selectByExample(uexample);
			if(sup!=null&&user.size()>0&&user.get(0)!=null){
				rd.setRegisterUserId(user.get(0).getUserId());
				tUserShareRecordService.insertSelect(rd);
			}
			session.setAttribute("user",user.get(0));
			rs.put("ms", "ok");
		  return rs;
	  }

}
