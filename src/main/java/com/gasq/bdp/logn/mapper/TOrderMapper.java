package com.gasq.bdp.logn.mapper;

import com.gasq.bdp.logn.model.TOrder;
import com.gasq.bdp.logn.model.TOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TOrderMapper {
    long countByExample(TOrderExample example);

    int deleteByExample(TOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TOrder record);

    int insertSelective(TOrder record);

    List<TOrder> selectByExampleWithRowbounds(TOrderExample example, RowBounds rowBounds);

    List<TOrder> selectByExample(TOrderExample example);

    TOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TOrder record, @Param("example") TOrderExample example);

    int updateByExample(@Param("record") TOrder record, @Param("example") TOrderExample example);

    int updateByPrimaryKeySelective(TOrder record);

    int updateByPrimaryKey(TOrder record);
    
    Long getNextId();
}