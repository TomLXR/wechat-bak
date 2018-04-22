package com.gasq.bdp.logn.service.imp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gasq.bdp.logn.mapper.TIntegralGetRecordMapper;
import com.gasq.bdp.logn.mapper.TIntegralGetRuleMapper;
import com.gasq.bdp.logn.mapper.TProjectConsumeRecordMapper;
import com.gasq.bdp.logn.mapper.TUserMapper;
import com.gasq.bdp.logn.mapper.TUserShareRecordMapper;
import com.gasq.bdp.logn.mapper.TUserShareRuleMapper;
import com.gasq.bdp.logn.model.LtnCustomerAmountBean;
import com.gasq.bdp.logn.model.ScoreDescribe;
import com.gasq.bdp.logn.model.TIntegralGetRecord;
import com.gasq.bdp.logn.model.TIntegralGetRecordExample;
import com.gasq.bdp.logn.model.TLtnCustomer;
import com.gasq.bdp.logn.model.TLtnCustomerConsumptonAmount;
import com.gasq.bdp.logn.model.TProjectConsumeRecord;
import com.gasq.bdp.logn.model.TProjectConsumeRecordExample;
import com.gasq.bdp.logn.model.TUserExample;
import com.gasq.bdp.logn.model.TUserShareRecord;
import com.gasq.bdp.logn.model.TUserShareRecordExample;
import com.gasq.bdp.logn.model.TUserShareRule;
import com.gasq.bdp.logn.model.TProjectConsumeRecordExample.Criteria;
import com.gasq.bdp.logn.model.TUser;
import com.gasq.bdp.logn.model.TUserShareRuleExample;
import com.gasq.bdp.logn.service.MergeScoreService;
import com.gasq.bdp.logn.utils.ConfigUtil;

/**  
* 类说明   根据订单同步积分实现
*  
* @author laody 
* @date 2017年12月5日
*/
@Service
public class MergeScoreServiceImpl implements MergeScoreService {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private TProjectConsumeRecordMapper  tProjectConsumeRecordMapper;
	@Autowired
	private TUserShareRuleMapper  tUserShareRuleMapper;
	@Autowired
	private TUserMapper  tUserMapper;
		
	@Autowired
	private TIntegralGetRecordMapper  tIntegralGetRecordMapper;
	
	@Autowired
	private TIntegralGetRuleMapper  tIntegralGetRuleMapper;
	
	@Autowired
	private TUserShareRecordMapper tUserShareRecordMapper;
	
	
	
	/*	    private Long userId;

    private Long projectId;

    private BigDecimal money;

    private BigDecimal paymentMoney;

    private String paymentType;

    private Byte isBack;*/
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void recordIntoDB(TLtnCustomerConsumptonAmount CustomerAmountBean) throws Exception{
		// 1  ok  2 用户不存在   0  服务端错误
	
		TUser user;
		
		BigDecimal totalAmount = CustomerAmountBean.getTotalAmount();
		
		String phonenumb = CustomerAmountBean.getPhonenumb();

		
		TUserExample example  =new TUserExample();
		com.gasq.bdp.logn.model.TUserExample.Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(phonenumb);
		List<TUser> users = tUserMapper.selectByExample(example);
		if(users.size()>0&&users.get(0)!=null){
			user=users.get(0);
			TProjectConsumeRecord record=new  TProjectConsumeRecord();
			record.setUserId(user.getUserId());
			record.setPaymentMoney(totalAmount);
			record.setMoney(totalAmount);
/*			record.setProjectId();*/
			record.setPaymentType("1");
			record.setIsBack((byte)1);
			//tProjectConsumeRecordMapper.insertSelective(record);
			 ScoreDescribe sd=null;
			 int i=1;
			int level=this.getLevel();
			 List<TUserShareRule> levels=getLevelList();
			 try {
				 if(level>0){
					 logger.info("------------------"+i+"批次同步开始-----------------------------");
						 //根据查询得到层级来找到对应的所有上级用户
						 sd=new ScoreDescribe();
						 getScoreDescribe(record,null,level,sd,levels,0);
						 mergeScore(sd,record);
					 logger.info("------------------"+i+"批次同步结束-----------------------------");
					 i++;
					 level--;
					 
				 }
				 
			} catch (Exception e) {
				throw new Exception(e);
			}
		}

		

	}
	
	
	@Override
	public int merge() {
		 int i=1;
		 List<TProjectConsumeRecord> clist=null;
		 Integer level=this.getLevel();
		 ScoreDescribe sd=null;
		 List<TUserShareRule> levels=getLevelList();
		 try {
			 while(level>0){
				 logger.info("------------------"+i+"批次同步开始-----------------------------");
				 for(TProjectConsumeRecord rd:getConsumeRecord()){
					 
					 //根据查询得到层级来找到对应的所有上级用户
					 sd=new ScoreDescribe();
					 getScoreDescribe(rd,null,level,sd,levels,0);
					 mergeScore(sd,rd);
					 
				 }
				 logger.info("------------------"+i+"批次同步结束-----------------------------");
				 i++;
				 level--;
				 
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("------------------"+i+"批次有问题-----------------------------");
		}
		return i;
	}

	@Override
	public int getLevel() {
		TUserShareRuleExample example=new  TUserShareRuleExample();
		com.gasq.bdp.logn.model.TUserShareRuleExample.Criteria c = example.createCriteria();
		c.andStatusEqualTo((byte)1);
		return tUserShareRuleMapper.countByExample(example);
	}

	@Override
	public List<TUserShareRule> getLevelList() {
		TUserShareRuleExample example=new  TUserShareRuleExample();
		com.gasq.bdp.logn.model.TUserShareRuleExample.Criteria c = example.createCriteria();
		c.andStatusEqualTo((byte)1);
		return tUserShareRuleMapper.selectByExample(example);
	}

	

	public List<TProjectConsumeRecord> getConsumeRecord() {
		TProjectConsumeRecordExample  example=new TProjectConsumeRecordExample();
		Criteria c= example.createCriteria();
		c.andIsBackEqualTo((byte)0);
		example.setStart(Integer.valueOf(ConfigUtil.get("start")));
		example.setEnd(Integer.valueOf(ConfigUtil.get("end")));
		return tProjectConsumeRecordMapper.selectByExample(example);
	}
	
	public void  getScoreDescribe(TProjectConsumeRecord rd,TUser user,Integer level,final ScoreDescribe sd,final List<TUserShareRule> levels,int index){
		BigDecimal pay=null;
		Long userId=null;
		if(rd!=null){
			pay=rd.getPaymentMoney();
			userId=rd.getUserId();
			sd.setMoney(pay);
			sd.setUserId(userId);
		}else{
			userId=user.getUserId();
		}
		TUserShareRecordExample rexample=new TUserShareRecordExample();
		com.gasq.bdp.logn.model.TUserShareRecordExample.Criteria rc = rexample.createCriteria();
		rc.andRegisterUserIdEqualTo(userId);
		List<TUserShareRecord> rlist = tUserShareRecordMapper.selectByExample( rexample);
		try {
			if(rlist.size()>0&&level>0){
				
				TUserExample example=new TUserExample();
				com.gasq.bdp.logn.model.TUserExample.Criteria c = example.createCriteria();
				c.andUserIdEqualTo(rlist.get(0).getUserId());
				List<TUser> selectByExample = tUserMapper.selectByExample(example);
				
				sd.addScoreUsers(selectByExample.get(0));
				sd.addScoreLevels(levels.get(index));
				getScoreDescribe(null,selectByExample.get(0),(--level),sd,levels,(++index));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Transactional(propagation=Propagation.REQUIRED)
	public  void  mergeScore(ScoreDescribe sd,TProjectConsumeRecord rd){
		List<TUserShareRule> scoreLevels = sd.getScoreLevels();
		List<TUser> scoreUsers = sd.getScoreUsers();
		if(scoreUsers!=null&&scoreLevels!=null){
			for(int i=0;i<scoreUsers.size();i++){
				doScore(scoreUsers.get(i),scoreLevels.get(i),rd);
			}			
		}

		
	}
	
	
	/**
	 * @param user  最终更新积分数据
	 * @param level
	 */
	@Transactional(propagation=Propagation.NESTED)
	public  void  doScore(TUser user,TUserShareRule level,TProjectConsumeRecord rd){
		
		// 修改当前 的记录  已经返还
/*		TProjectConsumeRecordExample example=new TProjectConsumeRecordExample();
		Criteria c = example.createCriteria();
		c.andRecordIdEqualTo(rd.getRecordId());
		TProjectConsumeRecord rc=new TProjectConsumeRecord();
		rc.setIsBack((byte)1);
		tProjectConsumeRecordMapper.updateByExampleSelective(rc,example);*/
		// 修改用户积分获取记录  
		//tIntegralGetRecordMapper.updateByExample(record, example)
		TIntegralGetRecordExample texample = new TIntegralGetRecordExample();
		com.gasq.bdp.logn.model.TIntegralGetRecordExample.Criteria cg = texample.createCriteria();
		TIntegralGetRecord grecord=new TIntegralGetRecord();
		Date today=new Date();
		Calendar c= Calendar.getInstance();
		c.setTime(today);
		c.add(Calendar.DATE, 7);
		grecord.setGetDateTime(today);
		grecord.setAvaDateTime(c.getTime());

		grecord.setHasUsedIntegral(0L);
		grecord.setIntegral(rd.getMoney().longValue());
		grecord.setNotUsedIntegral((level.getDiscount().divide(new BigDecimal(100)).multiply(rd.getMoney())).longValue());
		grecord.setUserId(rd.getUserId());
		grecord.setRecordId(rd.getRecordId());
		grecord.setSupUserId(user.getUserId());
		grecord.setRuleId(Long.valueOf(level.getShareType()));
		grecord.setDiscount(level.getDiscount());
		tIntegralGetRecordMapper.insertSelective(grecord);
		//  跟新用户信息表 有效积分
/*		TUser urecord=new TUser();
		urecord.setValidIntegral(user.getValidIntegral()+((level.getDiscount().divide(new BigDecimal(100)).multiply(rd.getMoney())).longValue()));
		TUserExample uexample=new TUserExample();
		com.gasq.bdp.logn.model.TUserExample.Criteria uc = uexample.createCriteria();
		uc.andUserIdEqualTo(user.getUserId());
		tUserMapper.updateByExampleSelective(urecord, uexample);*/
		
	}
	
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void mergeUserScore() throws Exception{
		
		
		TIntegralGetRecordExample texample = new TIntegralGetRecordExample();
		com.gasq.bdp.logn.model.TIntegralGetRecordExample.Criteria cg = texample.createCriteria();
		cg.andAvaDateTimeLessThan(new Date());
		List<TIntegralGetRecord> avarecord = tIntegralGetRecordMapper.selectByExample(texample);
		for(TIntegralGetRecord record:avarecord){
			Long score = record.getNotUsedIntegral();
			Long userId = record.getUserId();
			TUser tUser = null;
			TUserExample uexample=new TUserExample();
			com.gasq.bdp.logn.model.TUserExample.Criteria uc = uexample.createCriteria();
			uc.andUserIdEqualTo(userId);
			List<TUser> userlist = tUserMapper.selectByExample(uexample);
			if(userlist.size()>0){
				tUser = userlist.get(0);
			}
			if(tUser!=null){
				uexample.clear();
				uc = uexample.createCriteria();
				uc.andUserIdEqualTo(tUser.getUserId());
				TUser urecord=new TUser();
				urecord.setValidIntegral(tUser.getValidIntegral()+score);
				tUserMapper.updateByExampleSelective(urecord, uexample);
			}
			
			
		}
		
	}
}
