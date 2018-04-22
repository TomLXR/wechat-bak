package com.gasq.bdp.logn.service.imp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gasq.bdp.logn.mapper.TOrderMapper;
import com.gasq.bdp.logn.mapper.TOrderProjectMapper;
import com.gasq.bdp.logn.mapper.TProjectMapper;
import com.gasq.bdp.logn.mapper.TUserMapper;
import com.gasq.bdp.logn.model.TOrder;
import com.gasq.bdp.logn.model.TOrderExample;
import com.gasq.bdp.logn.model.TOrderProject;
import com.gasq.bdp.logn.model.TOrderProjectExample;
import com.gasq.bdp.logn.model.TProject;
import com.gasq.bdp.logn.model.TProjectExample;
import com.gasq.bdp.logn.model.TOrderExample.Criteria;
import com.gasq.bdp.logn.model.TUser;
import com.gasq.bdp.logn.model.TUserExample;
import com.gasq.bdp.logn.service.TOrderService;
import com.gasq.bdp.logn.utils.RcommondUtil;


/**  
* 类说明   
*  
* @author laody 
* @date 2018年3月15日
*/
@Service
public class TOrderServiceImpl implements TOrderService {
	@Autowired
	private TOrderMapper tOrderMapper;
	
	@Autowired
	private TProjectMapper tProjectMapper;
	
	@Autowired
	private TOrderProjectMapper tOrderProjectMapper;
	
	@Autowired
	private TUserMapper tUserMapper;
	
	public int deleteByPrimaryKey(Long id){
		tOrderMapper.deleteByPrimaryKey(id);
		return 0;
	}
	
    public List<TOrder> selectByExample(TOrderExample example){
    	return tOrderMapper.selectByExample(example);
    }

    public long countByExample(TOrderExample example){
    	return tOrderMapper.countByExample(example);
    }
    
    public  int insertSelective(TOrder record){
    	
    	return tOrderMapper.insertSelective(record);
    }

    
    public String getPayCode(){
		String rc=RcommondUtil.randomString();
		if(checkCode(rc)>0){
			
			rc=getPayCode();
		}
		return rc;
 
    }
    
    public long checkCode(String rc){
    	TOrderExample example=new TOrderExample();
    	Criteria orderCriteria = example.createCriteria();
    	orderCriteria.andBugCodeEqualTo(rc);
    	return tOrderMapper.countByExample(example);
    }
    
    public int updateByExampleSelective(TOrder record,TOrderExample example){
    	tOrderMapper.updateByExampleSelective(record,example);
    	return 0;
    }
    @Transactional(propagation=Propagation.REQUIRED)
    public void settle(TUser user,TOrder order) throws Exception{
    	Long validIntegral = user.getValidIntegral();
    	Long userId=user.getUserId();
    	Long payPrice = order.getPayPrice().longValue();
    	

    	user=new TUser();
    	user.setValidIntegral(validIntegral-payPrice);
    	TUserExample uexample=new TUserExample();
    	com.gasq.bdp.logn.model.TUserExample.Criteria uCriteria = uexample.createCriteria();
    	uCriteria.andUserIdEqualTo(userId);
    	tUserMapper.updateByExampleSelective(user,uexample );
    	TOrderExample oexample =new TOrderExample();
    	Criteria oCriteria = oexample.createCriteria();
    	oCriteria.andIdEqualTo(order.getId());
    	order=new TOrder();
    	order.setStatus("0");
    	tOrderMapper.updateByExampleSelective(order, oexample);
    }
    
    
    
    public  Map<Long,TProject> getOrderProjectToProjectTable(Map<Long,TProject> ptable,List<TOrderProject> list){
    	Map<Long,TProject> table=new HashMap<>(list.size());
    	for(TOrderProject p:list){
    		Long projectId = p.getProjectId();
    		if(ptable.containsKey(projectId)){
    			TProject tProject = ptable.get(projectId);
    			tProject.setAmount(p.getNumber());
    			table.put(projectId, tProject);
    		}
    	}
    	return table;
    }
    
    /**
     * 获取产品表
     * @param projectList
     * @return
     */
    public Map<Long,TProject> getProjectTable(List<TProject> projectList){
    	Map<Long,TProject> table=new HashMap<>(projectList.size());
    	for(TProject p:projectList){
    		table.put(p.getId(), p);
    	}
    	return table;
    }
    
    @Transactional(propagation=Propagation.REQUIRED)
    public void persisterOrderAndScore(TUser user,List<TOrder> list,TProject project,Map<Long,TProject> ptable,Long payPrice){
    	if(list.size()==0){
			String code=getPayCode();
			TOrder order=new TOrder();
			order.setStatus("2");
			order.setBugCode(code);
			order.setCreateTime(new Date());
			order.setPayPrice(new BigDecimal(payPrice));
			order.setUsername(user.getUserName());
			tOrderMapper.insertSelective(order);
			TOrderExample oexample=new TOrderExample();
			Criteria oCriteria = oexample.createCriteria();
			oCriteria.andBugCodeEqualTo(code);
			List<TOrder> olist = tOrderMapper.selectByExample(oexample);
			if(olist.size()>0){
				TOrder tOrder = olist.get(0);
				Long orid = tOrder.getId();
				TOrderProject tp=new TOrderProject();
				tp.setOrderId(orid);
				tp.setNumber(new BigDecimal("1"));
				tp.setProjectId(project.getId());
				tOrderProjectMapper.insertSelective(tp);
			}
			
    	}else{
			TOrder order = list.get(0);
			Long orderId = order.getId();
    		TOrderProjectExample pexample=new TOrderProjectExample();
    		com.gasq.bdp.logn.model.TOrderProjectExample.Criteria pCriteria = pexample.createCriteria();
            pCriteria.andOrderIdEqualTo(orderId);
    		List<TOrderProject> pList = tOrderProjectMapper.selectByExample(pexample);
    		Map<Long, TProject> table = getOrderProjectToProjectTable(ptable,pList);
    		if(table.containsKey(project.getId())){
    			TOrderProjectExample exg=new TOrderProjectExample();
    			com.gasq.bdp.logn.model.TOrderProjectExample.Criteria exgCriteria = exg.createCriteria();
    			exgCriteria.andOrderIdEqualTo(orderId);
    			exgCriteria.andProjectIdEqualTo(project.getId());
    			TOrderProject tp=new TOrderProject();
    			tp.setNumber(table.get(project.getId()).getAmount().add(new BigDecimal("1")));
    			tOrderProjectMapper.updateByExampleSelective(tp, exg);
    		}else{
    			TOrderProject tp=new TOrderProject();
				tp.setOrderId(orderId);
				tp.setNumber(new BigDecimal("1"));
				tp.setProjectId(project.getId());
				tOrderProjectMapper.insertSelective(tp);
    		}

    	}
    	TOrder o=new TOrder();
    	o.setPayPrice(new BigDecimal(payPrice));
		TOrderExample oexample=new TOrderExample();
		Criteria oCriteria = oexample.createCriteria();
		oCriteria.andStatusEqualTo("2");
		oCriteria.andUsernameEqualTo(user.getUserName());
		
		tOrderMapper.updateByExampleSelective(o,oexample );
    }

    
    /**
     * 计算订单的消耗积分
     * @param list
     * @param ptable
     * @param projectId
     * @return
     */
    public Long calOrderScore(List<TOrder> list,Map<Long,TProject> ptable,Long projectId){
    	Long payPrice=0L;
		TOrderProjectExample pexample=new TOrderProjectExample();
		com.gasq.bdp.logn.model.TOrderProjectExample.Criteria pCriteria = pexample.createCriteria();
    	// 未提交订单
    	if(projectId!=null){
    		TProject currentPro=tProjectMapper.selectByPrimaryKey(projectId);
    		if(list.size()>0){
    			TOrder order = list.get(0);
    			Long orderId = order.getId();
    			pCriteria.andOrderIdEqualTo(orderId);
    			//未提交订单的产品对应关系
    			 List<TOrderProject> pList = tOrderProjectMapper.selectByExample(pexample);
    			 Map<Long, TProject> optable = getOrderProjectToProjectTable(ptable,pList);
    			 if(optable.containsKey(projectId)){
    				 TProject tProject = optable.get(projectId);
    				 tProject.setAmount(tProject.getAmount().add(new BigDecimal("1")));
    			 }else{
    				 
    				 currentPro.setAmount(new BigDecimal("1"));
    				 optable.put(currentPro.getId(), currentPro);
    			 }
    			 if(optable.size()>0){
    				 Iterator<Entry<Long, TProject>> opiter = optable.entrySet().iterator();
    				 while(opiter.hasNext()){
    					  TProject pro = opiter.next().getValue();
    					 payPrice+=pro.getMoney().multiply(pro.getDiscount()).multiply(pro.getAmount()).longValue();
    				 }
    			 }
    		}else{
    			currentPro.setAmount(new BigDecimal("1"));
    			payPrice+=currentPro.getMoney().multiply(currentPro.getDiscount()).longValue();

    		}
    		
    	}else{
    		for(TOrder t:list){
    			payPrice+=t.getPayPrice().longValue();
    			/*Long id = t.getId();
    			pCriteria.andOrderIdEqualTo(id);
    			List<TOrderProject> pList = tOrderProjectMapper.selectByExample(pexample);
    			for(TOrderProject p:pList){
    				TProject pro=ptable.get(p.getProjectId());
    				payPrice+=pro.getMoney().multiply(pro.getDiscount()).multiply(p.getNumber()).longValue();
    			}*/
    		}
    	}
    	return payPrice;
    }
    
	/**
	 * 检查是否积分足够 并修改订单产品对应关系
	 * @param user
	 * @param id
	 * @return
	 */

    @Transactional(propagation=Propagation.REQUIRED)
    public boolean checkOrderProjectEnoughAndPersistent(TUser user,Long id){
    	// 应付价格
    	Long payPrice=0L;
    	Long total=0L;
    	// 有效积分值
		Long validIntegral= user.getValidIntegral();

		//产品信息
		TProjectExample projectExample=new  TProjectExample();
		List<TProject> projectList = tProjectMapper.selectByExample(projectExample);
		TProject currentPro=tProjectMapper.selectByPrimaryKey(id);
		//获取产品表
		Map<Long,TProject> ptable=getProjectTable(projectList);
		TOrderExample orderExample=new TOrderExample();
		com.gasq.bdp.logn.model.TOrderExample.Criteria orderCriteria = orderExample.createCriteria();
		orderCriteria.andUsernameEqualTo(user.getUserName());
		orderCriteria.andStatusEqualTo("2");
		//查看未提交的订单		
		List<TOrder> uList = tOrderMapper.selectByExample(orderExample);
		System.out.println(uList.size());

		orderExample.clear();
		orderCriteria = orderExample.createCriteria();
		orderCriteria.andUsernameEqualTo(user.getUserName());
		orderCriteria.andStatusEqualTo("1");
		// 进行中订单
		List<TOrder> jList = tOrderMapper.selectByExample(orderExample);
		
		// 未提交的订单积分计算
		
		total+=calOrderScore(uList,ptable,id);
		payPrice+=total;
		// 进行中订单的积分计算
		total+=calOrderScore(jList,ptable,null);

		
		if(total>validIntegral){
			return false;
		}
		//持久化订单数据
		persisterOrderAndScore(user,uList,currentPro,ptable,payPrice);
		return true;

    }
    
    public Long getUnSettleOrderCt(TUser user){
    	Long ct=0L;
    	TOrderExample oexample=new TOrderExample();
    	Criteria oCriteria = oexample.createCriteria();
    	oCriteria.andUsernameEqualTo(user.getUserName());
    	oCriteria.andStatusEqualTo("2");
    	List<TOrder> olist = tOrderMapper.selectByExample(oexample);
    	if(olist.size()>0){
    		TOrder order = olist.get(0);
    		TOrderProjectExample opexample=new TOrderProjectExample();
    		com.gasq.bdp.logn.model.TOrderProjectExample.Criteria opCriteria = opexample.createCriteria();
    		opCriteria.andOrderIdEqualTo(order.getId());
    		List<TOrderProject> oplist = tOrderProjectMapper.selectByExample(opexample);
    		for(TOrderProject t:oplist){
    			ct+=t.getNumber().longValue();
    		}
    	}
    	return ct;
    }

	
	public Long getpay(TOrder order){
		Long money=0L;
		TProjectExample projectExample=new  TProjectExample();
		List<TProject> projectList = tProjectMapper.selectByExample(projectExample);

		Long orderId = order.getId();
		TOrderProjectExample pexample=new TOrderProjectExample();
		com.gasq.bdp.logn.model.TOrderProjectExample.Criteria pCriteria = pexample.createCriteria();
		pCriteria.andOrderIdEqualTo(orderId);
		List<TOrderProject> oplist = tOrderProjectMapper.selectByExample(pexample);


		for(TProject project:projectList){
			for(TOrderProject p:oplist){
				if((project.getId()==p.getProjectId())){

					money+=project.getMoney().multiply(project.getDiscount()).multiply(p.getNumber()).longValue();
					break;
				}
				
			}
			
		}
		
		
		return money;
	}
	

	
	public void cartSubDel(TUser user,Long id,String all){
		
		TOrderExample oexample=new TOrderExample();
		com.gasq.bdp.logn.model.TOrderExample.Criteria oCriteria = oexample.createCriteria();
		oCriteria.andUsernameEqualTo(user.getUserName());
		oCriteria.andStatusEqualTo("2");
		List<TOrder> olist = tOrderMapper.selectByExample(oexample);
		TProject pro = tProjectMapper.selectByPrimaryKey(id);
		if(olist.size()>0){
			TOrder order = olist.get(0);
			Long orderId = order.getId();
			TOrderProjectExample opexample=new TOrderProjectExample();
			com.gasq.bdp.logn.model.TOrderProjectExample.Criteria opCriteria = opexample.createCriteria();
			opCriteria.andOrderIdEqualTo(orderId);
			List<TOrderProject> alllist = tOrderProjectMapper.selectByExample(opexample);
			opCriteria.andProjectIdEqualTo(id);
			List<TOrderProject> oplist = tOrderProjectMapper.selectByExample(opexample);
			if(alllist.size()>0){
				if(oplist.size()>0){
					TOrderProject record = oplist.get(0);
					if(all!=null&&all.equals("y")){
						tOrderProjectMapper.deleteByPrimaryKey(record.getId());

						TOrder o=new TOrder();
						BigDecimal pay=pro.getMoney().multiply(pro.getDiscount()).multiply(record.getNumber());
						o.setPayPrice(order.getPayPrice().subtract(pay));
						tOrderMapper.updateByExampleSelective(o, oexample);
					}else{
						if(record.getNumber().intValue()>1){
							record.setNumber(record.getNumber().subtract(new BigDecimal("1")));	
						}
						tOrderProjectMapper.updateByExampleSelective(record, opexample);

						TOrder o=new TOrder();
						BigDecimal pay=order.getPayPrice().subtract(pro.getMoney().multiply(pro.getDiscount()));
						o.setPayPrice(pay);
						tOrderMapper.updateByExampleSelective(o, oexample);
					}
				}				
			}else{
				TOrder o=new TOrder();
				o.setId(orderId);
				o.setPayPrice(new BigDecimal("0"));
				tOrderMapper.updateByPrimaryKeySelective(o);				
				
			}

			
		}

	}
	
	
	public int getCarCt(TUser user){
		
			int ct=0;
		   TOrderExample  orderexample=new TOrderExample();
		   com.gasq.bdp.logn.model.TOrderExample.Criteria orderCriteria = orderexample.createCriteria();
		   orderCriteria.andUsernameEqualTo(user.getUserName());
		   //未结算订单
		   orderCriteria.andStatusEqualTo("2");
		   List<TOrder> orderList = tOrderMapper.selectByExample(orderexample);

		   if(orderList.size()>0){
			   //如果有未提交订单的记录计算此订单ct数量
			   TOrder tOrder = orderList.get(0);
			   Long orderId = tOrder.getId();
			   TOrderProjectExample tProjectexample=new TOrderProjectExample();
			   com.gasq.bdp.logn.model.TOrderProjectExample.Criteria tprojectCriteria = tProjectexample.createCriteria();
			   tprojectCriteria.andOrderIdEqualTo(orderId);
			   List<TOrderProject> tprojectList = tOrderProjectMapper.selectByExample(tProjectexample);
			   for(TOrderProject tproject:tprojectList){
				   ct+=tproject.getNumber().intValue();
				   
			   }
			   
		   }
		   return ct;
		
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public int fixorderStatus(TUser user,TProject project,Boolean isChecked){
		
		
		 TOrderExample oexample=new TOrderExample();
		 com.gasq.bdp.logn.model.TOrderExample.Criteria oCriteria = oexample.createCriteria();
		 oCriteria.andUsernameEqualTo(user.getUserName());
		 oCriteria.andStatusEqualTo("2");
		 List<TOrder> olist = tOrderMapper.selectByExample(oexample);
		 if(olist.size()>0){
			 TOrder tOrder = olist.get(0);
			 Long orderId = tOrder.getId();
			 TOrderProjectExample opexample=new TOrderProjectExample();
			 com.gasq.bdp.logn.model.TOrderProjectExample.Criteria opCriteria = opexample.createCriteria();
			 opCriteria.andOrderIdEqualTo(orderId);
			 opCriteria.andProjectIdEqualTo(project.getId());
			 List<TOrderProject> plist = tOrderProjectMapper.selectByExample(opexample);
			 if(isChecked){
				 if(plist.size()==0){
					 TOrderProject record=new TOrderProject();
					 record.setNumber(project.getAmount());
					 record.setOrderId(orderId);
					 record.setProjectId(project.getId());
					 tOrderProjectMapper.insert(record);
					 
					 TOrder order=new TOrder();
					 order.setPayPrice(tOrder.getPayPrice().add(project.getMoney().multiply(project.getDiscount().multiply(project.getAmount()))));
					 tOrderMapper.updateByExampleSelective(order, oexample);
				 }else{
					 TOrderProject record=new TOrderProject();
					 record.setNumber(project.getAmount());
					 tOrderProjectMapper.updateByExampleSelective(record,opexample );
					 TOrder order=new TOrder();
					 order.setPayPrice(tOrder.getPayPrice().add(project.getMoney().multiply(project.getDiscount().multiply(project.getAmount()))));
					 tOrderMapper.updateByExampleSelective(order, oexample);
				 }
			 }else{
				 if(plist.size()==0){
					 TOrder order=new TOrder();
					 order.setPayPrice(tOrder.getPayPrice().subtract(project.getMoney().multiply(project.getDiscount().multiply(project.getAmount()))));
					 tOrderMapper.updateByExampleSelective(order, oexample);
				 }else{
					 tOrderProjectMapper.deleteByExample(opexample);
					 TOrder order=new TOrder();
					 order.setPayPrice(tOrder.getPayPrice().subtract(project.getMoney().multiply(project.getDiscount().multiply(project.getAmount()))));
					 tOrderMapper.updateByExampleSelective(order, oexample);
				 }
			 }

			 return 0;
		 }
			 return 1;	 
		 
		 		
		
		
	}
}
