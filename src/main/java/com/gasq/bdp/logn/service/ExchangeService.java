package com.gasq.bdp.logn.service;

import com.gasq.bdp.logn.model.TProject;
import com.gasq.bdp.logn.model.TUser;

public interface ExchangeService {
	
	public boolean exchange(TProject project,TUser user) throws Exception;
}
