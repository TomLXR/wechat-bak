package com.gasq.bdp.logn.service.imp;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.ActuatorMetricWriter;
import org.springframework.stereotype.Service;

import com.gasq.bdp.logn.mapper.TOrderProjectMapper;
import com.gasq.bdp.logn.mapper.TProjectMapper;
import com.gasq.bdp.logn.model.TOrderProject;
import com.gasq.bdp.logn.model.TOrderProjectExample;
import com.gasq.bdp.logn.model.TProject;
import com.gasq.bdp.logn.model.TProjectExample;
import com.gasq.bdp.logn.model.TProjectExample.Criteria;
import com.gasq.bdp.logn.service.TOrderProjectService;

/**  
* 类说明   
*  
* @author laody 
* @date 2018年3月19日
*/
@Service
public class TOrderProjectServiceImpl implements TOrderProjectService {
	@Autowired
	private TOrderProjectMapper  tOrderProjectMapper;
	
	@Autowired
	private TProjectMapper tProjectMapper;

	@Override
	public long countByExample(TOrderProjectExample example) {

		return tOrderProjectMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TOrderProjectExample example) {
		tOrderProjectMapper.deleteByExample(example);
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		tOrderProjectMapper.deleteByPrimaryKey(id);
		return 0;
	}

	@Override
	public int insert(TOrderProject record) {
		tOrderProjectMapper.insert(record);
		return 0;
	}

	@Override
	public int insertSelective(TOrderProject record) {
		tOrderProjectMapper.insertSelective(record);
		return 0;
	}

	@Override
	public List<TOrderProject> selectByExample(TOrderProjectExample example) {
		
		return tOrderProjectMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(TOrderProject record, TOrderProjectExample example) {
		tOrderProjectMapper.updateByExampleSelective(record, example);
		return 0;
	}
	
	
    public Integer getPay(List<TOrderProject> orderPList,Integer amount,Long id){
    	Integer total=0;
    	for(TOrderProject order:orderPList){
    		Long projectId = order.getProjectId();
    		
    		TProjectExample pexample=new TProjectExample();
    		Criteria pCriteria = pexample.createCriteria();
    		pCriteria.andIdEqualTo(projectId);
    		
    		List<TProject> projectList = tProjectMapper.selectByExample(pexample);
    		if(projectList.size()>0){
    			TProject project = projectList.get(0);
    			BigDecimal money = project.getMoney();
    			BigDecimal discount = project.getDiscount();
    			Integer amount2 = order.getNumber().intValue();
    			if(project.getId()==id){
    				total+=money.multiply(discount).intValue()*amount;	
    			}else{
    				total+=money.multiply(discount).intValue()*amount2;
    			}
    			
    		}
    	}
    	return total;
    }
}
