package com.gasq.bdp.logn.mapper;

import com.gasq.bdp.logn.model.TUser;
import com.gasq.bdp.logn.model.TUserExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TUserMapper {
    long countByExample(TUserExample example);

    int deleteByExample(TUserExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(TUser record);

    int insertSelective(TUser record);

    List<TUser> selectByExampleWithRowbounds(TUserExample example, RowBounds rowBounds);

    List<TUser> selectByExample(TUserExample example);

    TUser selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByExample(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
    
    TUser selectUserByCommo(String code);
    long selectNextUserId();
    int selectUserCount(String username);
    int  checkCommo(String rc);
    int selectUserCountByOpenId(String openId) ;
    String selectRecomByOpenId(String openId);
    Map<String , Object> selectUserByOpenId(String openId);
}