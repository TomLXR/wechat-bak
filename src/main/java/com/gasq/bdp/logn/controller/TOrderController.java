package com.gasq.bdp.logn.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gasq.bdp.logn.model.TOrder;
import com.gasq.bdp.logn.model.TOrderExample;
import com.gasq.bdp.logn.model.TOrderProject;
import com.gasq.bdp.logn.model.TOrderProjectExample;
import com.gasq.bdp.logn.model.TProjectExample;
import com.gasq.bdp.logn.model.TOrderProjectExample.Criteria;
import com.gasq.bdp.logn.model.TProject;
import com.gasq.bdp.logn.model.TUser;
import com.gasq.bdp.logn.model.TUserExample;
import com.gasq.bdp.logn.service.TOrderProjectService;
import com.gasq.bdp.logn.service.TOrderService;
import com.gasq.bdp.logn.service.TProjectService;
import com.gasq.bdp.logn.service.TUserService;

/**  
* 类说明   
*  
* @author laody 
* @date 2018年3月19日
*/

@Controller
@RequestMapping("order")
public class TOrderController {
	
	@Autowired
	private TOrderService tOrderService;
	
	@Autowired
	private TOrderProjectService tOrderProjectService;
	
	@Autowired
	private TProjectService tProjectService; 
	
	@Autowired
	private TUserService  tUserService;
	
    @ModelAttribute
    public void prepare(HttpServletRequest request,HttpServletResponse response, ModelMap mmap, RedirectAttributes attr,Model  mod){

		mod.addAttribute("basepath", request.getContextPath());
    }
	
	@RequestMapping("shopDetail")
	public String detail(){
		return "shop/orderDetail";
	}
	
	@RequestMapping("shopModify")
	public String modify(){
		return "shop/shopModify";
	}
	
	
	
	
	
/*	public boolean checkIsEoungh(TUser user,Long id){
		List<TOrderProject> pList =new ArrayList<>();
		boolean flag=true;
		Long total=0L;
		Long validIntegral= user.getValidIntegral();
		
		
		TOrderExample orderExample=new TOrderExample();
		com.gasq.bdp.logn.model.TOrderExample.Criteria orderCriteria = orderExample.createCriteria();
		orderCriteria.andUsernameEqualTo(user.getUserName());
		orderCriteria.andStatusNotEqualTo("0");
		List<TOrder> orderList = tOrderService.selectByExample(orderExample);
		
		
		//产品信息
		TProjectExample projectExample=new  TProjectExample();
		List<TProject> projectList = tProjectService.selectByExample(projectExample);

		TOrderExample orderExample=new TOrderExample();
		com.gasq.bdp.logn.model.TOrderExample.Criteria orderCriteria = orderExample.createCriteria();
		orderCriteria.andUsernameEqualTo(user.getUserName());
		orderCriteria.andStatusEqualTo("2");
		List<TOrder> orderList = tOrderService.selectByExample(orderExample);
		if(orderList.size()>0){
			TOrder order = orderList.get(0);
			Long orderId = order.getId();
			TOrderProjectExample pexample=new TOrderProjectExample();
			Criteria pCriteria = pexample.createCriteria();
			pCriteria.andOrderIdEqualTo(orderId);
			//需要合算的订单
			pList = tOrderProjectService.selectByExample(pexample);
		}
		// 当前添加商品
		for(TProject project:projectList){
			if(project.getId()==id){
				int i=0;
				for(TOrderProject p:pList){
					if(p.getProjectId()==id){
						i++;
						project.setAmount(p.getNumber().intValue()+1);
						total+=project.getMoney().multiply(project.getDiscount()).longValue()*project.getAmount();
						break;
					}
				}
				if(i==0){
					project.setAmount(1);
					total+=project.getMoney().multiply(project.getDiscount()).longValue()*project.getAmount();
				}
				break;
			}
		}
		// 已添加商品
		for(TProject project:projectList){
			for(TOrderProject p:pList){
				if((p.getProjectId()==project.getId())&& (project.getId()!=id) ){
					project.setAmount(p.getNumber().intValue());
					total+=project.getMoney().multiply(project.getDiscount()).longValue()*project.getAmount().intValue();
					break;
				}
				
			}
			
		}
		

		
		if(total>validIntegral){
			flag=false;
		}
		if(pList.size()>0){
			for(TOrderProject p:pList){
				if(p.getProjectId()==id){
					(p.getNumber().intValue()+1)*p.get
				}
			}
		}else{
			
		}

		if(pList.size()>0){
			TProject project = pList.get(0);
			BigDecimal money = project.getMoney();
			BigDecimal discount = project.getDiscount();
			int per = money.multiply(discount).intValue();
		}
		return flag;
	}

*/	
	
	@RequestMapping("shopList")
	@ResponseBody
	public Map<String,Object> list(HttpSession session,HttpServletRequest request,String id){
		Map<String, Object> result=new HashMap<String, Object>();

		if(id==null){
			result.put("rs", "获取商品信息失败");
		}
		if(session.getAttribute("user")!=null){
			TUser user = (TUser)session.getAttribute("user");
			user=tUserService.selectByPrimaryKey(user.getUserId());
				
			if(tOrderService.checkOrderProjectEnoughAndPersistent(user,Long.valueOf(id))){
				Long ct = tOrderService.getUnSettleOrderCt(user);
				result.put("rs", "ok");
				result.put("ct", ct);
			}
			else{
				result.put("rs", "用户积分不足");
			}

		}else{
			result.put("rs", "请先在平台注册");
		}
		return result;
	}
	
	
	@RequestMapping("orderList")
	
	public String orderList(HttpSession session,HttpServletRequest request,Model  mod){
		List<TProject> plist=new ArrayList<>();
/*		TUser u=new TUser();
		u.setUserId(28L);
		u.setUserName("13691024892");
		u.setNickName("老大爷");
		u.setUserImgUrl("http://thirdwx.qlogo.cn/mmopen/aUZWklsY4pU5eQTsusxO1cmibiaVlM1bsSuicmsntCJIxL5PThxuAK5P8pGfoibZNs5giaeotKt8I1wZOQecNibBuqEwROxEnnnAam/132");
		u.setValidMoney(new BigDecimal(100));
		u.setValidIntegral(100L);
		session.setAttribute("user", u);*/

		Long ct=0L;
		if(session.getAttribute("user")!=null){
			TUser user=(TUser)session.getAttribute("user");
			TOrderExample orderExample=new TOrderExample();
			com.gasq.bdp.logn.model.TOrderExample.Criteria orderCriteria = orderExample.createCriteria();
			orderCriteria.andUsernameEqualTo(user.getUserName());
			orderCriteria.andStatusEqualTo("2");
			List<TOrder> orderList = tOrderService.selectByExample(orderExample);
			if(orderList.size()>0){
				TOrder order = orderList.get(0);
				Long orderId = order.getId();
				TOrderProjectExample torderExample=new TOrderProjectExample();
				Criteria torderCriteria = torderExample.createCriteria();
				torderCriteria.andOrderIdEqualTo(orderId);
				torderExample.setOrderByClause(" project_id  ");
				List<TOrderProject> tOrderList = tOrderProjectService.selectByExample(torderExample);
				for(TOrderProject torder:tOrderList){
					Long projectId = torder.getProjectId();
					TProjectExample pExample=new TProjectExample();
					com.gasq.bdp.logn.model.TProjectExample.Criteria pCriteria = pExample.createCriteria();
					pCriteria.andIdEqualTo(projectId);
					List<TProject> list = tProjectService.selectByExample(pExample);
					if(list.size()>0){
						TProject p = list.get(0);
						p.setAmount(torder.getNumber());
						ct+=p.getMoney().multiply(p.getDiscount()).multiply(p.getAmount()).longValue();
						plist.add(p);
					}
				}
				//plist
				mod.addAttribute("projects", plist);
				mod.addAttribute("ct", ct);
			}
			
		}else{
			   return "redirect:gotoregist";
		}
		
		return  "shop/orderDetail";
	}
	
	
	
	
	
	
	@RequestMapping("orderSubmit")
	@ResponseBody
	public Map<String, Object> submit(HttpSession session,HttpServletRequest request,Model  mod,Long id){
		Map<String, Object> result=new HashMap<String, Object>();

		if(id==null){
			result.put("rs", "获取商品信息失败");
		}
		if(session.getAttribute("user")!=null){
			TUser user = (TUser)session.getAttribute("user");
			user=tUserService.selectByPrimaryKey(user.getUserId());
				
			if(tOrderService.checkOrderProjectEnoughAndPersistent(user,Long.valueOf(id))){

				result.put("rs", "ok");

			}
			else{
				result.put("rs", "用户积分不足");
			}

		}else{
			result.put("rs", "请先在平台注册");
		}
		return result;

	}

	
	@RequestMapping("orderSubmitdel")
	@ResponseBody
	public Map<String, Object> submitdel(HttpSession session,HttpServletRequest request,Model  mod,Long id,String all){
		Map<String, Object> result=new HashMap<String, Object>();

		if(id==null){
			result.put("rs", "获取商品信息失败");
		}
		if(session.getAttribute("user")!=null){
			TUser user = (TUser)session.getAttribute("user");
			user=tUserService.selectByPrimaryKey(user.getUserId());
			tOrderService.cartSubDel(user,id,all);
			result.put("rs", "ok");


		}else{
			result.put("rs", "请先在平台注册");
		}
		return result;

	}

	
	
	
	@RequestMapping("clear")
	@ResponseBody
	public Map<String, Object> clear(HttpSession session,HttpServletRequest request,Model  mod){
		Map<String, Object> result=new HashMap<>();
		


		if(session.getAttribute("user")!=null){
			TUser user = (TUser)session.getAttribute("user");
			String userName = user.getUserName();
			TOrderExample torderExample=new TOrderExample();
			com.gasq.bdp.logn.model.TOrderExample.Criteria orderCriteria = torderExample.createCriteria();
			orderCriteria.andUsernameEqualTo(userName);
			orderCriteria.andStatusEqualTo("2");
			List<TOrder> orderList = tOrderService.selectByExample(torderExample);
			if(orderList.size()>0){
				TOrder order = orderList.get(0);
				Long id = order.getId();
				TOrderProjectExample pexample=new TOrderProjectExample();
				Criteria pCriteria = pexample.createCriteria();
				pCriteria.andOrderIdEqualTo(id);
				tOrderService.deleteByPrimaryKey(id);
				tOrderProjectService.deleteByExample(pexample);
				result.put("rs", "清空成功");
			}else{
				result.put("rs", "无清空产品");
			}
		}else{
			result.put("rs", "登录未注册");
			
		}
		return result;
	}
	

	
	
	
	
	
	@RequestMapping("orderSettle")
	@ResponseBody
	public Map<String, Object> settle(HttpSession session,HttpServletRequest request,Model  mod){
		Map<String, Object> result=new HashMap<>();
		if(session.getAttribute("user")!=null){
			TUser user = (TUser)session.getAttribute("user");
			String userName = user.getUserName();
			TOrderExample torderExample=new TOrderExample();
			com.gasq.bdp.logn.model.TOrderExample.Criteria orderCriteria = torderExample.createCriteria();
			orderCriteria.andUsernameEqualTo(userName);
			orderCriteria.andStatusEqualTo("2");
			List<TOrder> orderList = tOrderService.selectByExample(torderExample);
			if(orderList.size()>0){
				TOrder order = orderList.get(0);
				String bugCode = order.getBugCode();
				Long id = order.getId();
				torderExample.clear();
				orderCriteria = torderExample.createCriteria();
				orderCriteria.andIdEqualTo(id);
				order=new TOrder();
				order.setCreateTime(new Date());
				order.setStatus("1");
				tOrderService.updateByExampleSelective(order,torderExample);

				result.put("rs", "订单结算成功");
				//session.setAttribute("user", tUserService.selectByPrimaryKey(user.getUserId()));
				result.put("code",bugCode );
			}else{
				result.put("rs", "无结算订单");
			}
		}else{
			result.put("rs", "未在平台注册");
		}
		return result;
	}
	
	@RequestMapping("fixorderStatus")
	@ResponseBody
	public Map<String,Object>   fixorderStatus(HttpServletRequest request,Long id,Boolean isChecked,Integer number){
		 Map<String,Object> result=new HashMap<>(1);
		 HttpSession session = request.getSession();
		 if(session.getAttribute("user")!=null){
			 TUser user=(TUser)session.getAttribute("user");
			 TUserExample uexample=new TUserExample();
			 com.gasq.bdp.logn.model.TUserExample.Criteria uCriteria = uexample.createCriteria();
			 uCriteria.andUserIdEqualTo(user.getUserId());
			 List<TUser> ulist = tUserService.selectByExample(uexample);
			 if(ulist.size()>0){
				 user=ulist.get(0);
				 TProjectExample pexample=new TProjectExample();
				 com.gasq.bdp.logn.model.TProjectExample.Criteria pCriteria = pexample.createCriteria();
				 pCriteria.andIdEqualTo(id);
				 List<TProject> prolist = tProjectService.selectByExample(pexample);
				 if(prolist.size()>0){
					 TProject project = prolist.get(0);
					 project.setAmount(new BigDecimal(number));
					 int status=tOrderService.fixorderStatus( user,project,isChecked);
					 if(status==0){
						 result.put("rs", "ok");	 
					 }else{
						 result.put("rs", "无可提交订单");
					 }
					 
				 }else{
					 result.put("rs", "产品不存在");
				 }
				 
				 
				 
			 }else{
				 result.put("rs", "未注册用户");
			 }
			 

		 }
		 return result;
	}
		
	
	
	
}
