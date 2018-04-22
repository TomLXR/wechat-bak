package com.gasq.bdp.logn.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gasq.bdp.logn.mapper.TUserSignExtMapper;
import com.gasq.bdp.logn.model.TUserSignExt;
import com.gasq.bdp.logn.model.TUserSignExtExample;
import com.gasq.bdp.logn.service.TUserSignExtService;

/**  
* 类说明   
*  
* @author laody 
* @date 2018年3月9日
*/
@Service
public class TUserSignExtServiceImpl implements TUserSignExtService {
	@Autowired
	private TUserSignExtMapper  tUserSignExtMapper;
	
    public int insert(TUserSignExt record){
    	tUserSignExtMapper.insert(record);
    	return 0;
    }

    public int insertSelective(TUserSignExt record){
    	tUserSignExtMapper.insertSelective(record);
    	return 0;    	
    }
    
    public int deleteByPrimaryKey(Long id){
    	tUserSignExtMapper.deleteByPrimaryKey(id);
    	return 0;
    }
    
    public List<TUserSignExt> selectByExample(TUserSignExtExample example){
    	return tUserSignExtMapper.selectByExample(example);
    }
    
    
    public int updateByExampleSelective( TUserSignExt record,  TUserSignExtExample example){
    	tUserSignExtMapper.updateByExampleSelective(record,example);
    	return 0;
    }
	
}
