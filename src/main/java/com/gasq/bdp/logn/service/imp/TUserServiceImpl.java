package com.gasq.bdp.logn.service.imp;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gasq.bdp.logn.mapper.TUserMapper;
import com.gasq.bdp.logn.mapper.TUserSignExtMapper;
import com.gasq.bdp.logn.model.TUser;
import com.gasq.bdp.logn.model.TUserExample;
import com.gasq.bdp.logn.model.TUserExample.Criteria;
import com.gasq.bdp.logn.model.TUserSignExt;
import com.gasq.bdp.logn.service.TUserService;
import com.gasq.bdp.logn.utils.RcommondUtil;

@Service
public class TUserServiceImpl implements TUserService {
	
	@Resource
	private TUserMapper tUserMapper;
	
	@Autowired
	private TUserSignExtMapper  tUserSignExtMapper;

	@Transactional(value=TxType.REQUIRED)
	public int regist(TUser record) {
		String username=record.getUserName();
		tUserMapper.insertSelective(record);
		TUserExample example=new TUserExample();
		Criteria c = example.createCriteria();
		c.andUserNameEqualTo(username);
		List<TUser> userlist = tUserMapper.selectByExample(example);
		if(userlist.size()>0){
			TUser u = userlist.get(0);
			Long userId = u.getUserId();
			TUserSignExt sign=new TUserSignExt();
			sign.setUserId(userId);
			tUserSignExtMapper.insertSelective(sign);
		}
		
		return 0;
	}

	@Override
	public TUser selectUserByCommo(String code) {
		
		return tUserMapper.selectUserByCommo(code);
	}

	@Override
	public long selectNextUserId() {
		
		return tUserMapper.selectNextUserId();
	}
	public int selectUserCount(String username){
		return tUserMapper.selectUserCount(username);
	}
	public    String  createCommo(){
		String rc=RcommondUtil.randomString();
		if(checkCommo(rc)>0){
			
			rc=createCommo();
		}
		return rc;
	}
	
	public  int  checkCommo(String rc){
		
		return tUserMapper.checkCommo(rc);
	}

	@Override
	public int selectUserCountByOpenId(String openId) {

		return tUserMapper.selectUserCountByOpenId(openId);
	}

	@Override
	public String selectRecomByOpenId(String openId) {

		return tUserMapper.selectRecomByOpenId(openId);
	}
	

	public Map<String, Object> selectUserByOpenId(String opendId){
		
		return tUserMapper.selectUserByOpenId(opendId);
	}
	
	
	
 	public long countByExample(TUserExample example){
 		return tUserMapper.countByExample(example);
 	}

 	public int deleteByExample(TUserExample example){
 		return tUserMapper.deleteByExample(example);
 	}

 	public int deleteByPrimaryKey(Long id){
 		return tUserMapper.deleteByPrimaryKey(id);
 	}

 	public int insert(TUser record){
 		return tUserMapper.insert(record);
 	}

 	public int insertSelective(TUser record){
 		return tUserMapper.insertSelective(record);
 		
 	}

 	public List<TUser> selectByExample(TUserExample example){
 		return tUserMapper.selectByExample(example);
 	}

 	public TUser selectByPrimaryKey(Long id){
 		return tUserMapper.selectByPrimaryKey(id);
 	}

 	public int updateByExampleSelective(TUser record,TUserExample example){
 		return tUserMapper.updateByExampleSelective(record,example);
 	}

 	public int updateByExample(TUser record,TUserExample example){
 		return tUserMapper.updateByExample(record,example);
 		
 	}

 	public int updateByPrimaryKeySelective(TUser record){
 		return tUserMapper.updateByPrimaryKeySelective(record);
 	}



	@Override
	public int updateByPrimaryKey(TUser record) {
		// TODO Auto-generated method stub
		return tUserMapper.updateByPrimaryKey(record);
	}
}