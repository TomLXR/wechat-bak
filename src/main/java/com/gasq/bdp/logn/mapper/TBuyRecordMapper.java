package com.gasq.bdp.logn.mapper;

import com.gasq.bdp.logn.model.TBuyRecord;
import com.gasq.bdp.logn.model.TBuyRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TBuyRecordMapper {
    long countByExample(TBuyRecordExample example);

    int deleteByExample(TBuyRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TBuyRecord record);

    int insertSelective(TBuyRecord record);

    List<TBuyRecord> selectByExampleWithRowbounds(TBuyRecordExample example, RowBounds rowBounds);

    List<TBuyRecord> selectByExample(TBuyRecordExample example);

    TBuyRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TBuyRecord record, @Param("example") TBuyRecordExample example);

    int updateByExample(@Param("record") TBuyRecord record, @Param("example") TBuyRecordExample example);

    int updateByPrimaryKeySelective(TBuyRecord record);

    int updateByPrimaryKey(TBuyRecord record);
}