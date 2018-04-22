package com.gasq.bdp.logn.controller;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gasq.bdp.logn.model.TFeature;
import com.gasq.bdp.logn.model.TFeatureExample;
import com.gasq.bdp.logn.model.TOrder;
import com.gasq.bdp.logn.model.TOrderExample;
import com.gasq.bdp.logn.model.TOrderProject;
import com.gasq.bdp.logn.model.TOrderProjectExample;
import com.gasq.bdp.logn.model.TProject;
import com.gasq.bdp.logn.model.TProjectExample;
import com.gasq.bdp.logn.model.TProjectExample.Criteria;
import com.gasq.bdp.logn.model.TUser;
import com.gasq.bdp.logn.model.TUserExample;
import com.gasq.bdp.logn.service.TFeatureService;
import com.gasq.bdp.logn.service.TOrderProjectService;
import com.gasq.bdp.logn.service.TOrderService;
import com.gasq.bdp.logn.service.TProjectService;
import com.gasq.bdp.logn.service.TUserService;
import com.gasq.bdp.logn.utils.ConfigUtil;
import com.gasq.bdp.logn.utils.WeixinUtil;


@Controller
public class IndexController extends BaseController{

	protected Logger logger = Logger.getLogger(this.getClass());
    //错误信息
	

	
	@Autowired
	private TProjectService tProjectService;
	
	@Autowired
	private TFeatureService  tFeatureService;
	
	@Autowired
	private TUserService  tUserService;
	
	@Autowired
	private TOrderService tOrderService;
	
	@Autowired
	private TOrderProjectService tOrderProjectService;
	
    Map<String,Object> paramMap = new HashMap<String,Object>();
    @ModelAttribute
    public void prepare(HttpServletRequest request,HttpServletResponse response, ModelMap mmap, RedirectAttributes attr,Model  mod){

		mod.addAttribute("basepath", request.getContextPath());
    }
    
    
    /**
     * 商城首页  门店入口
     * @return
     */
   @RequestMapping("/store")
   public String store(HttpServletRequest request,HttpServletResponse response,ModelMap model,Model  mod) {
	   jsGood (request,"store",mod);
	   return "store/stores/index";
   }
    
   @RequestMapping("/storeIndex")
   public String storeIndex(HttpServletRequest request,HttpServletResponse response,ModelMap model,Model  mod) {
	   jsGood (request,"storeIndex",mod);
	   HttpSession session = request.getSession();
	   if(session.getAttribute("user")!=null){
		   TUser user=(TUser) session.getAttribute("user");
		   mod.addAttribute("ct", tOrderService.getCarCt(user));
	   }
	   return "store/index";
   }
   

   @RequestMapping("/storeChild")
   public String storeChild(HttpServletRequest request,HttpServletResponse response,ModelMap model,Model  mod,String name) {
	   jsGood (request,"storeChild",mod);
	   return "store/stores/"+name;
   }
    

   @RequestMapping("/product")
   public String product(HttpServletRequest request,HttpServletResponse response,ModelMap model,Model  mod,String name) {
	   jsGood (request,"product",mod);
	   return "product/product";
   }
   
   
   @RequestMapping("/productIndex")
   public String productIndex(HttpServletRequest request,HttpServletResponse response,ModelMap model,Model  mod,String name) {
	   jsGood (request,"productIndex",mod);
	   HttpSession session = request.getSession();
	   if(session.getAttribute("user")!=null){
		   TUser user=(TUser) session.getAttribute("user");
		   mod.addAttribute("ct", tOrderService.getCarCt(user));
	   }
	   return "product/index";
   }
    
   
   
   /**
    * 商城首页  项目入口
    * @return
    */
  @RequestMapping("/project")
  public String project(HttpServletRequest request,HttpServletResponse response,ModelMap model,Model  mod) {
	   jsGood (request,"project",mod);
	   return "project/index";
  }
   
  
  /**
   * 商城首页  订单入口
   * @return
   */
 @RequestMapping("/order")
 public String order(HttpServletRequest request,HttpServletResponse response,ModelMap model,Model  mod) {
	   jsGood (request,"order",mod);
	   /*HttpSession session =request.getSession();*/
	   return "order/index";
 }
    
    /**
     * 商城首页  入口
     * @return
     */
   @RequestMapping("/index")
   public String homepage(HttpServletRequest request,HttpServletResponse response,ModelMap model,Model  mod) {
   	HttpSession session = request.getSession();
	   jsGood (request,"index",mod);	   
/*        TUser user=new TUser();
        		user.setUserId(44L);
		user.setUserName("13691024892");
		user.setNickName("风吹头发飞");
		user.setRecomCode("BZtprY");
		user.setWxPubOpenId("oDpzjwbQOt71nmU6jLnczPp2VmTc");
		user.setUserImgUrl("http://thirdwx.qlogo.cn/mmopen/aUZWklsY4pU5eQTsusxO1cmibiaVlM1bsSuicmsntCJIxL5PThxuAK5P8pGfoibZNs5giaeotKt8I1wZOQecNibBuqEwROxEnnnAam/132");
		//user.setValidMoney(new BigDecimal(2000));
		user.setValidIntegral(10000L);
		session.setAttribute("user", user);*/
	   if(session.getAttribute("user")==null){   
		   return "redirect:gotoregist";
	   }
	   TUser user=(TUser) session.getAttribute("user");
	   int end=Integer.valueOf(ConfigUtil.get("pageSize").toString());
	   boolean isMoreEnable=tProjectService.isMoreEnable(end);
	   session.setAttribute("end", end);
	   mod.addAttribute("isMoreEnable", isMoreEnable);
	   setProjectsInfo(mod,end,user.getUserId(),false,null);

	   mod.addAttribute("ct", tOrderService.getCarCt(user));
	   
	   return "index";
   }

   
   /**
    * 商城首页  点击更多
    * @return
    */
  @RequestMapping("/indexmore")
  public String homepagemore(HttpServletRequest request,HttpServletResponse response,ModelMap model,Model  mod) {
	   jsGood (request,"indexmore",mod);
	   int ct=0;
	   int end=Integer.valueOf(ConfigUtil.get("pageSize").toString());
	   HttpSession session =request.getSession();
	   TUser u=null;
	   if(session.getAttribute("user")!=null){
		   u=(TUser) session.getAttribute("user");
	   }
	   if(session.getAttribute("end")!=null){
		   end=Integer.valueOf(session.getAttribute("end").toString())+end;
	   }
	   TUser user=(TUser) session.getAttribute("user");
	   boolean isMoreEnable=tProjectService.isMoreEnable(end);
	   mod.addAttribute("isMoreEnable", isMoreEnable);
	   session.setAttribute("end", end);
	   setProjectsInfo(mod,end,u.getUserId(),false,null);
	   //计算现有的委托提交结算订单的商品数量
	   TOrderExample  orderexample=new TOrderExample();
	   com.gasq.bdp.logn.model.TOrderExample.Criteria orderCriteria = orderexample.createCriteria();
	   orderCriteria.andUsernameEqualTo(user.getUserName());
	   //未结算订单
	   orderCriteria.andStatusEqualTo("2");
	   List<TOrder> orderList = tOrderService.selectByExample(orderexample);

	   if(orderList.size()==0){
		   //如果没有未提交订单的记录 ct为0
		   mod.addAttribute("ct", 0);   
	   }else{
		   //如果有未提交订单的记录计算此订单ct数量
		   TOrder tOrder = orderList.get(0);
		   Long orderId = tOrder.getId();
		   TOrderProjectExample tProjectexample=new TOrderProjectExample();
		   com.gasq.bdp.logn.model.TOrderProjectExample.Criteria tprojectCriteria = tProjectexample.createCriteria();
		   tprojectCriteria.andOrderIdEqualTo(orderId);
		   List<TOrderProject> tprojectList = tOrderProjectService.selectByExample(tProjectexample);
		   for(TOrderProject tproject:tprojectList){
			   ct+=tproject.getNumber().intValue();
			   
		   }
		   mod.addAttribute("ct", ct);
	   }
	   return "index";
  }

  @RequestMapping("/shopIndex")
  public String shopIndex(HttpServletRequest request,HttpServletResponse response,ModelMap model,Model  mod) {
	   jsGood (request,"shopIndex",mod);
	   HttpSession session = request.getSession();
	   if(session.getAttribute("user")!=null){
		   TUser user=(TUser) session.getAttribute("user");
		   mod.addAttribute("ct", tOrderService.getCarCt(user));
	   }
	   return "shop/index";
  }
  
  
  @RequestMapping("/projectIndex")
  public String projectIndex(HttpServletRequest request,HttpServletResponse response,ModelMap model,Model  mod) {
	   jsGood (request,"projectIndex",mod);
	   HttpSession session = request.getSession();
	   if(session.getAttribute("user")!=null){
		   TUser user=(TUser) session.getAttribute("user");
		   mod.addAttribute("ct", tOrderService.getCarCt(user));
	   }
	   return "project/index";
  }
   
  @RequestMapping("/projectList")
  public String projectList(HttpServletRequest request,HttpServletResponse response,Model  mod,Boolean first,String keyword){
	  Integer pageSize=Integer.valueOf(ConfigUtil.get("pageSize").toString());
	  Integer end;
	   	HttpSession session = request.getSession();
		   jsGood (request,"projectList",mod);	
		   //先判断是否已经注册
		   if(session.getAttribute("user")==null){
			   return "redirect:gotoregist";
		   }
		   //计算当前需要显示的记录数
		   if(first!=null||session.getAttribute("end1")==null){
			   end=pageSize;
			   
		   }else{
			   end=Integer.valueOf(session.getAttribute("end1").toString())+pageSize;
		   }
		   session.setAttribute("end1",end);
		   TUser user=(TUser) session.getAttribute("user");
		   //计算否是有更多可以显示
		   boolean isMoreEnable=tProjectService.isMoreAllEnable(end);
		   mod.addAttribute("isMoreEnable", isMoreEnable);
		   //keywork 前台暂时无逻辑
		   setProjectsInfo(mod,end,user.getUserId(),true,keyword);
		   //计算当前未提交订单的ct值
		   if(first==null||first!=true){
			int ct=tOrderService.getCarCt(user); 
			   mod.addAttribute("ct", ct);
		   }
		  
	  return "project/projectList";
  }
  
/**
 * 
 * 设置 产品的 信息  共首页展示
 * @param mod
 * @param end
 */
public void setProjectsInfo(Model  mod,int end,Long userId,Boolean all,String keyword){

	   TUserExample userExample=new TUserExample();
	   com.gasq.bdp.logn.model.TUserExample.Criteria userCriteria = userExample.createCriteria();
	   userCriteria.andUserIdEqualTo(userId);
	   List<TUser> users = tUserService.selectByExample(userExample);
	   List<TProject> projects=null;
	   //获取用户和可消费积分值
	   Long validIntegral=null;
	   if(users.size()>0){
		   TUser user = users.get(0);
		   validIntegral=user.getValidIntegral();
		   TOrderExample o =new TOrderExample();
		   com.gasq.bdp.logn.model.TOrderExample.Criteria oCriteria = o.createCriteria();
		   oCriteria.andUsernameEqualTo(user.getUserName());
		   oCriteria.andStatusNotEqualTo("0");
		   List<TOrder> olist = tOrderService.selectByExample(o);
		   for(TOrder t:olist){
			   validIntegral-= t.getPayPrice().longValue();
		   }
		   
	   }
	   if(validIntegral!=null){
		   TProjectExample projectExample=new TProjectExample();
		   Criteria projectCriteria = projectExample.createCriteria();
		   projectCriteria.andStatusEqualTo((byte)1);
		   //all false 为打折商品
		   if(!all){
			   projectCriteria.andDiscountLessThan(new BigDecimal(1));			   
		   }
		   if(!StringUtils.isEmpty(keyword)){
			   projectCriteria.andProjectNameLike("%"+keyword+"%");
		   }
		   projectExample.setEnd(end);
		   projects = tProjectService.selectByExample(projectExample);
		   for(TProject project:projects){
			   TFeatureExample featureExample=new TFeatureExample();
			   com.gasq.bdp.logn.model.TFeatureExample.Criteria featureCriteria = featureExample.createCriteria();
			   featureCriteria.andProjectIdEqualTo(project.getId());
			   featureExample.setOrderByClause("`index`");
			   
			   List<TFeature> featureList = tFeatureService.selectByExample(featureExample);
			   if(project.getMoney().multiply(project.getDiscount()).longValue()>validIntegral){
				   project.setIsenough(false);
			   }
			   project.setListFeature(featureList);
		   }   
	   }
	   mod.addAttribute("projects", projects);
   }
   
   /**
    * 商城首页
    * @return
    */
   @RequestMapping("/userManager")
   public String userManager(HttpServletRequest request,HttpServletResponse response,ModelMap model,Model mod) {
	   HttpSession session = request.getSession();

	   if(session.getAttribute("user")==null){
		   return "redirect:gotoregist";
	   }
	  // 开发测试 
	/*   String openId="oDpzjwe_ZBcLhMCuEZt5-JRAww6s";*/
/*	   TUserExample exmaple=new TUserExample();
	   com.gasq.bdp.logn.model.TUserExample.Criteria criteria = exmaple.createCriteria();
	   criteria.andWxPubOpenIdEqualTo(openId);
	   List<TUser> users = tUserService.selectByExample(exmaple);
	   if(users.size()>0){
		   
		   session.setAttribute("user", users.get(0));
	   }*/
	   
/*	   if(session.getAttribute("user")!=null){
		   mod.addAttribute("user", session.getAttribute("user"));
	   }else{
		   // 跳转到登陆界面
	   }*/
	   mod.addAttribute("user", session.getAttribute("user"));

	   return "userManager/index";
  	}

   @RequestMapping("/user_account_news")
   public String userAccountNewsPage(HttpServletRequest request,HttpServletResponse response,ModelMap model) {
	   return "user_account_news";
   }
   
	/**
	 * 登录页面
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	public String index(HttpServletRequest request, RedirectAttributes model) {
		return "login";
	}

	
	

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/dologin", method = RequestMethod.POST)
	public String login(RedirectAttributes attr, HttpServletRequest request, RedirectAttributes model) {
		return "redirect:index";
	}

	/**
	 * 用户登出
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpServletResponse response, HttpServletRequest request) {
		return "redirect:login";
	}



	
	
	/**
	 * 后去微信平台的code的入口
	 * @param request
	 * @param session
	 * @param mod
	 * @param code
	 * @param state
	 * @return
	 */
	@RequestMapping(value = "/accessopenId")
	public String accessopenId(HttpServletRequest request,HttpSession session,Model  mod,String code,String state) {
		String recommond;
		String redirectUrl;
		if(!StringUtils.isEmpty(code)&&!StringUtils.isEmpty(state)){
			String openId=WeixinUtil.acheOpenId(code,session);
			if(logger.isDebugEnabled()){
				logger.info(" ------- "+openId+" 用户进入 ---------- ");
				logger.info(" ------- "+code+" 用户进入 ---------- ");
				logger.info(" ------- "+state+" 用户进入 ---------- ");
				
			}
			//  用户openid 的  
			if(state.equals("openid")){
				mod.addAttribute("openid", openId);
				return "openId";
				
			}else{
				TUserExample example=new TUserExample(); 
				com.gasq.bdp.logn.model.TUserExample.Criteria criteria = example.createCriteria();
				criteria.andWxPubOpenIdEqualTo(openId);
				List<TUser> list = tUserService.selectByExample(example);
				logger.info(" ------- "+list.size()+" size ---------- ");
				if(list.size()>0&&list.get(0)!=null){
					session.setAttribute("user", list.get(0));	
				}
				// 二维码推荐的url 逻辑
				System.out.println("----------state---------"+state);
				if(state.indexOf("$$")!=-1){
					redirectUrl=state.substring(0,state.indexOf("$$"));
					recommond=state.substring(state.indexOf("$$")+2,state.length());
					System.out.println("----------recommond---------"+recommond);
					System.out.println("----------redirectUrl---------"+redirectUrl);
					session.setAttribute(ConfigUtil.get("recommond"),recommond);
				}else{
					redirectUrl=state;
				}
				
				System.out.println("----------redirectUrl---------"+redirectUrl);
				
			}

			return "redirect:"+redirectUrl;	
		}
		return "redirect:"+"error";
		
	}

	/*
	@RequestMapping(value = "/accessopenId")

	public String accessopenId(HttpServletRequest request,HttpSession session, ModelMap mmap, RedirectAttributes attr,Model  mod,@RequestParam Map<String,Object> map) {
		
		String code =(String) map.get("code");
		String rc ="";
		try {
			rc =(String) map.get("state");
		} catch (Exception e) {

		}

		if(rc.equals("123")){
			
		}else{
			WeixinUtil.acherc(rc,session);
		}
		String openid=WeixinUtil.acheOpenId(code,session);
		return "redirect:gotoregist";
	}*/


	
	
	
	@RequestMapping(value = "/ewtj")
	public String ewtj(HttpServletResponse response, HttpServletRequest request,Model mod){
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null){
			return "redirect:gotoregist";
		}
		TUser user=(TUser) session.getAttribute("user");
		mod.addAttribute("code", user.getRecomCode());
		return "ewtj";
	}
	

	
	

	
}
