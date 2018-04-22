package com.gasq.bdp.logn.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gasq.bdp.logn.mapper.TUserShareRecordMapper;
import com.gasq.bdp.logn.model.TUserShareRecord;
import com.gasq.bdp.logn.service.TUserShareRecordService;
@Service
public class TUserShareRecordServiceImpl implements TUserShareRecordService {
	@Autowired TUserShareRecordMapper  tUserShareRecordMapper;
	private TUserShareRecord rd;

	@Override
	public int insertSelect(TUserShareRecord rd) {
		tUserShareRecordMapper.insertSelective(rd);
		return 0;
	}
	

}
