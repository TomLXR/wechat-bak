package com.gasq.bdp.logn.mapper;

import com.gasq.bdp.logn.model.TIntegralGetRecord;
import com.gasq.bdp.logn.model.TIntegralGetRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TIntegralGetRecordMapper {
    int countByExample(TIntegralGetRecordExample example);

    int deleteByExample(TIntegralGetRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TIntegralGetRecord record);

    int insertSelective(TIntegralGetRecord record);

    List<TIntegralGetRecord> selectByExampleWithRowbounds(TIntegralGetRecordExample example, RowBounds rowBounds);

    List<TIntegralGetRecord> selectByExample(TIntegralGetRecordExample example);

    TIntegralGetRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TIntegralGetRecord record, @Param("example") TIntegralGetRecordExample example);

    int updateByExample(@Param("record") TIntegralGetRecord record, @Param("example") TIntegralGetRecordExample example);

    int updateByPrimaryKeySelective(TIntegralGetRecord record);

    int updateByPrimaryKey(TIntegralGetRecord record);
}