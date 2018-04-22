package com.gasq.bdp.logn.service.imp;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.gasq.bdp.logn.mapper.TBuyRecordMapper;
import com.gasq.bdp.logn.mapper.TOrderMapper;
import com.gasq.bdp.logn.mapper.TOrderProjectMapper;
import com.gasq.bdp.logn.model.TBuyRecord;
import com.gasq.bdp.logn.model.TOrder;
import com.gasq.bdp.logn.model.TOrderExample;
import com.gasq.bdp.logn.model.TOrderProject;
import com.gasq.bdp.logn.model.TOrderProjectExample;
import com.gasq.bdp.logn.model.TProject;
import com.gasq.bdp.logn.model.TUser;
import com.gasq.bdp.logn.service.ExchangeService;
import com.gasq.bdp.logn.service.TUserService;
@Service
public class ExchangeServiceImpl implements ExchangeService{
	@Autowired
	TOrderMapper orderMapper;
	@Autowired
	TOrderProjectMapper orderProMapper;
	@Autowired
	TUserService userService;
	@Autowired
	TBuyRecordMapper buyrecordMapper;
	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public boolean exchange(TProject project, TUser user)throws Exception{
		try {
			Long orderid = orderMapper.getNextId();
			TOrderExample orderExample = new TOrderExample();
			orderExample.createCriteria().andUsernameEqualTo(user.getUserName());
			List<TOrder> orders = orderMapper.selectByExample(orderExample);
			if(orders.size()>0) {
				TOrder order = orders.get(0);
				TOrderProjectExample example = new TOrderProjectExample();
				example.createCriteria().andOrderIdEqualTo(order.getId()).andProjectIdEqualTo(project.getId());
				List<TOrderProject> orderProjects = orderProMapper.selectByExample(example);
				if(orderProjects.size()>0) {
					TOrderProject op = orderProjects.get(0);
					op.setNumber(op.getNumber().add(new BigDecimal(1)));
					orderProMapper.updateByPrimaryKey(op);
				}else {
					TOrderProject orderProject = new TOrderProject();
					orderProject.setNumber(new BigDecimal(1));
					orderProject.setOrderId(orderid);
					orderProject.setProjectId(project.getId());
					orderProMapper.insert(orderProject);
				}
			}else {
				TOrder order = new TOrder();
				order.setUsername(user.getUserName());
				order.setStatus("1");
				order.setBugCode(userService.createCommo());
				order.setId(orderid);
				orderMapper.insert(order);
				TOrderProject orderProject = new TOrderProject();
				orderProject.setNumber(new BigDecimal(1));
				orderProject.setOrderId(orderid);
				orderProject.setProjectId(project.getId());
				orderProMapper.insert(orderProject);
			}
			TBuyRecord buyrecord = new TBuyRecord();
			buyrecord.setProjectId(project.getId());
			buyrecord.setScore(project.getDiscount().multiply(project.getMoney()).doubleValue());
			buyrecord.setUsername(user.getUserName());
			buyrecordMapper.insert(buyrecord);
			user.setValidIntegral(user.getValidIntegral()-(project.getDiscount().multiply(project.getMoney()).longValue()));
			userService.updateByPrimaryKey(user);
			return true;
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return false;
	}

}
