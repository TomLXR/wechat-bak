package com.gasq.bdp.logn.controller;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gasq.bdp.logn.model.TOrder;
import com.gasq.bdp.logn.model.TOrderExample;
import com.gasq.bdp.logn.model.TOrderExample.Criteria;
import com.gasq.bdp.logn.model.TOrderProject;
import com.gasq.bdp.logn.model.TOrderProjectExample;
import com.gasq.bdp.logn.model.TProject;
import com.gasq.bdp.logn.model.TProjectExample;
import com.gasq.bdp.logn.model.TUser;
import com.gasq.bdp.logn.service.TOrderProjectService;
import com.gasq.bdp.logn.service.TOrderService;
import com.gasq.bdp.logn.service.TProjectService;
import com.gasq.bdp.logn.utils.ConfigUtil;

@Controller
@RequestMapping("project")
public class TProjectController extends BaseController{

	protected Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private TOrderService tOrderService;
	
	@Autowired
	private TOrderProjectService tOrderProjectService;
	
	@Autowired
	private TProjectService  tProjectService;
	
	  /**
	    * 商城首页
	    * @return
	    */
	   @RequestMapping("/projectDetail")
	   public String userManager(HttpServletRequest request,HttpServletResponse response,ModelMap model,Model mod,Boolean first,Integer end1,Integer end2,Integer tabIndex,Boolean more) {
		   HttpSession session = request.getSession();
		   
		   Integer pageSize=Integer.valueOf(ConfigUtil.get("pageSize").toString());
		   jsGood (request,"projectDetail",mod);
		   TOrderExample tOrderExample=new TOrderExample();
		   Criteria oCriteria = tOrderExample.createCriteria();
		   
		   if(session.getAttribute("user")==null){
			   return "redirect:gotoregist";
		   }
		   TUser user=(TUser)session.getAttribute("user");
		   oCriteria.andUsernameEqualTo(user.getUserName());

		   if(first!=null){

				   end1=pageSize;
				   end2=pageSize;
				   tabIndex=0;
				   oCriteria.andStatusEqualTo("1");
				   
				   boolean all=true;
			  	   Long count = tOrderService.countByExample(tOrderExample);

			  	   if(count.intValue()>end1){
			  		   all=false;
			  	   }
				   mod.addAttribute("isMoreEnable", all);
		   }else{
			   	  if(tabIndex==null){
			   		  tabIndex=0;
			   		  end1=pageSize;
			   		  end2=pageSize;
			   	  }
				  if(tabIndex==0){
					      oCriteria.andStatusEqualTo("1");
					  if(more!=null){
					    	  end1=end1+pageSize;  
				      }

					   boolean all=true;
				  	   Long count = tOrderService.countByExample(tOrderExample);

				  	   if(count.intValue()>end1){
				  		   all=false;
				  	   }
					  mod.addAttribute("isMoreEnable", all);    
					  tOrderExample.setEnd(end1);
					  
				  }else if(tabIndex==1){
					      oCriteria.andStatusEqualTo("0");
					  if(more!=null){
					    	  end2=end2+pageSize;  
					  }
					   boolean all=true;
				  	   Long count = tOrderService.countByExample(tOrderExample);

				  	   if(count.intValue()>end1){
				  		   all=false;
				  	   }
					   mod.addAttribute("isMoreEnable", all);					      
					  tOrderExample.setEnd(end2);
				  }				   
			   
		   }
		   
		   tOrderExample.setOrderByClause(" create_time desc ");
		   setOrderList(tOrderExample,mod);
		   mod.addAttribute("end1", end1);
		   mod.addAttribute("end2", end2);
		   mod.addAttribute("tabIndex", tabIndex);
		   
		   
		   return "projectms/complete";
	  	}
	   
	   public void setOrderList(TOrderExample example,Model mod){
		   List<TOrder> orderList = tOrderService.selectByExample(example);
		   if(orderList.size()>0){
			   for(TOrder order:orderList){
				   Long orderId = order.getId();
				   TOrderProjectExample tOrderProjectExample=new TOrderProjectExample();
				   com.gasq.bdp.logn.model.TOrderProjectExample.Criteria opCriteria = tOrderProjectExample.createCriteria();
				   opCriteria.andOrderIdEqualTo(orderId);
				   List<TOrderProject> opList = tOrderProjectService.selectByExample(tOrderProjectExample);
				   int amount=0;
				   int tmoney=0;
				   for(TOrderProject op:opList){
					Long projectId = op.getProjectId();
					BigDecimal number = op.getNumber();
					TProjectExample tProjectExample=new TProjectExample();
					com.gasq.bdp.logn.model.TProjectExample.Criteria proCriteria = tProjectExample.createCriteria();
					proCriteria.andIdEqualTo(projectId);
					List<TProject> prolist = tProjectService.selectByExample(tProjectExample);
					if(prolist.size()>0){
						TProject p = prolist.get(0);
						p.setAmount(number);
						amount+=number.intValue();
						tmoney+=p.getMoney().multiply(p.getDiscount()).multiply(number).intValue();
						order.getPlist().add(p);
						
					}
				   }
				   order.setAmount(amount);

				   order.setTotal(tmoney);

			   }
		   }
		   mod.addAttribute("orderList", orderList);
		   mod.addAttribute("ct", orderList.size());
	   }
	   
}
