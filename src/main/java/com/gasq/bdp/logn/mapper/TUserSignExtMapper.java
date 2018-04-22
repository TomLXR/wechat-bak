package com.gasq.bdp.logn.mapper;

import com.gasq.bdp.logn.model.TUserSignExt;
import com.gasq.bdp.logn.model.TUserSignExtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TUserSignExtMapper {
    long countByExample(TUserSignExtExample example);

    int deleteByExample(TUserSignExtExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TUserSignExt record);

    int insertSelective(TUserSignExt record);

    List<TUserSignExt> selectByExampleWithRowbounds(TUserSignExtExample example, RowBounds rowBounds);

    List<TUserSignExt> selectByExample(TUserSignExtExample example);

    TUserSignExt selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TUserSignExt record, @Param("example") TUserSignExtExample example);

    int updateByExample(@Param("record") TUserSignExt record, @Param("example") TUserSignExtExample example);

    int updateByPrimaryKeySelective(TUserSignExt record);

    int updateByPrimaryKey(TUserSignExt record);
}