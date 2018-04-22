package com.gasq.bdp.logn.mapper;

import com.gasq.bdp.logn.model.TOrderProject;
import com.gasq.bdp.logn.model.TOrderProjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TOrderProjectMapper {
    long countByExample(TOrderProjectExample example);

    int deleteByExample(TOrderProjectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TOrderProject record);

    int insertSelective(TOrderProject record);

    List<TOrderProject> selectByExampleWithRowbounds(TOrderProjectExample example, RowBounds rowBounds);

    List<TOrderProject> selectByExample(TOrderProjectExample example);

    TOrderProject selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TOrderProject record, @Param("example") TOrderProjectExample example);

    int updateByExample(@Param("record") TOrderProject record, @Param("example") TOrderProjectExample example);

    int updateByPrimaryKeySelective(TOrderProject record);

    int updateByPrimaryKey(TOrderProject record);
}