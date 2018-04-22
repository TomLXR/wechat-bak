package com.gasq.bdp.logn.mapper;

import com.gasq.bdp.logn.model.TFeature;
import com.gasq.bdp.logn.model.TFeatureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TFeatureMapper {
    long countByExample(TFeatureExample example);

    int deleteByExample(TFeatureExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TFeature record);

    int insertSelective(TFeature record);

    List<TFeature> selectByExampleWithRowbounds(TFeatureExample example, RowBounds rowBounds);

    List<TFeature> selectByExample(TFeatureExample example);

    TFeature selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TFeature record, @Param("example") TFeatureExample example);

    int updateByExample(@Param("record") TFeature record, @Param("example") TFeatureExample example);

    int updateByPrimaryKeySelective(TFeature record);

    int updateByPrimaryKey(TFeature record);
}