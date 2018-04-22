package com.gasq.bdp.logn.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.gasq.bdp.logn.model.TOrderProject;
import com.gasq.bdp.logn.model.TOrderProjectExample;

/**  
* 类说明   
*  
* @author laody 
* @date 2018年3月19日
*/
public interface TOrderProjectService {
	
	
	public long countByExample(TOrderProjectExample example);

    public int deleteByExample(TOrderProjectExample example);

    public int deleteByPrimaryKey(Long id);

    public int insert(TOrderProject record);

    public int insertSelective(TOrderProject record);



    public List<TOrderProject> selectByExample(TOrderProjectExample example);



    public int updateByExampleSelective(TOrderProject record, TOrderProjectExample example);



    public Integer getPay(List<TOrderProject> orderPList,Integer amount,Long id);



}
