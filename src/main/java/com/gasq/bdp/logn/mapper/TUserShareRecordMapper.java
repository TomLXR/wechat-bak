package com.gasq.bdp.logn.mapper;

import com.gasq.bdp.logn.model.TUserShareRecord;
import com.gasq.bdp.logn.model.TUserShareRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TUserShareRecordMapper {
    long countByExample(TUserShareRecordExample example);

    int deleteByExample(TUserShareRecordExample example);


    int insert(TUserShareRecord record);

    int insertSelective(TUserShareRecord record);

    List<TUserShareRecord> selectByExampleWithRowbounds(TUserShareRecordExample example, RowBounds rowBounds);

    List<TUserShareRecord> selectByExample(TUserShareRecordExample example);


    int updateByExampleSelective(@Param("record") TUserShareRecord record, @Param("example") TUserShareRecordExample example);

    int updateByExample(@Param("record") TUserShareRecord record, @Param("example") TUserShareRecordExample example);

    int updateByPrimaryKeySelective(TUserShareRecord record);

    int updateByPrimaryKey(TUserShareRecord record);
}