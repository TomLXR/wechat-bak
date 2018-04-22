package com.gasq.bdp.logn.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
import com.gasq.bdp.logn.model.TLtnCustomerConsumptonAmount;
import com.gasq.bdp.logn.service.MergeScoreService;


/**  
* 类说明   
*  
* @author laody 
* @date 2018年2月5日
*/
@RestController
public class ConsumContrller {
	private final Logger logger = LoggerFactory.getLogger(getClass());
		@Autowired
		private MergeScoreService  mergeScoreService;
	
		@RequestMapping(value = "/consumAmount",method=RequestMethod.POST)
		public  JSONObject consumIntoDB(String phonenumb,String totalAmount){
			JSONObject json = new JSONObject();
			
			TLtnCustomerConsumptonAmount  customerAmountBean=new TLtnCustomerConsumptonAmount();
			customerAmountBean.setPhonenumb(phonenumb);
			customerAmountBean.setTotalAmount(new BigDecimal(totalAmount));
			 try {
				mergeScoreService.recordIntoDB(customerAmountBean);
				json.put("isok",0);
				json.put("mess", "好的");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				json.put("mess", e.getMessage());
				json.put("isok",1);
				logger.info(e.getMessage(),e);
			}
			
			return json;
			
		}
		
		
		
	    @Scheduled(cron = "0 0 0/2 * * ?") // 每天1点执行
	    public void doMergeScore() {

	    	
	    	try {
	    		mergeScoreService.mergeUserScore();
	    	} catch (Exception e) {

	    		e.printStackTrace();
	    	}
	    	
	    }
		
		
}
