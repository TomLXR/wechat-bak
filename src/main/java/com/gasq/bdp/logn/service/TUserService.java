package com.gasq.bdp.logn.service;

import java.util.List;
import java.util.Map;
import com.gasq.bdp.logn.model.TUser;
import com.gasq.bdp.logn.model.TUserExample;

public interface TUserService {
	int regist(TUser record);
	TUser selectUserByCommo(String code);
    long selectNextUserId();
    int selectUserCount(String username);
    int selectUserCountByOpenId(String openId);
    String selectRecomByOpenId(String openId);
     String  createCommo();
     Map<String, Object> selectUserByOpenId(String opendId);
     
     
     
 	long countByExample(TUserExample example);

 	int deleteByExample(TUserExample example);

 	int deleteByPrimaryKey(Long id);

 	int insert(TUser record);

 	int insertSelective(TUser record);

 	List<TUser> selectByExample(TUserExample example);

 	TUser selectByPrimaryKey(Long id);

 	int updateByExampleSelective(TUser record,TUserExample example);

 	int updateByExample(TUser record,TUserExample example);

 	int updateByPrimaryKeySelective(TUser record);

 	int updateByPrimaryKey(TUser record);
 	
 	
     
}