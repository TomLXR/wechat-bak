//package com.gasq.bdp.logn;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.gasq.bdp.logn.job.InterfaceType;
//import com.gasq.bdp.logn.model.TSysTimerJobconfig;
//import com.gasq.bdp.logn.model.TSysTimerJobconfigExample;
//import com.gasq.bdp.logn.model.TSysTimerScheduleWorkflow;
//import com.gasq.bdp.logn.model.TSysTimerScheduleWorkflowExample;
//import com.gasq.bdp.logn.model.TSysTimerScheduleconfig;
//import com.gasq.bdp.logn.model.TSysTimerScheduleconfigExample;
//import com.gasq.bdp.logn.model.TSysTimerWorkflow;
//import com.gasq.bdp.logn.model.TSysTimerWorkflowExample;
//import com.gasq.bdp.logn.service.TSysTimerJobHiveService;
//import com.gasq.bdp.logn.service.TSysTimerJobconfigService;
//import com.gasq.bdp.logn.service.TSysTimerScheduleWorkflowService;
//import com.gasq.bdp.logn.service.TSysTimerScheduleconfigService;
//import com.gasq.bdp.logn.service.TSysTimerWorkflowService;
//import com.gasq.bdp.logn.state.WorkFlowState;
//import com.gasq.bdp.logn.utils.SpringApplicationUtils;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class HadoopWorkFlowApplicationTests {
//	@Autowired TSysTimerScheduleconfigService timerScheduleconfigService;
//	@Autowired TSysTimerWorkflowService TSysTimerWorkflow;
//	@Autowired TSysTimerJobconfigService timerJobconfigService;
//	@Test
//	public void readES() {
//		String name = "";
//		String group = "";
//		try {
//			TSysTimerScheduleconfigExample scheduleconfigExample = new TSysTimerScheduleconfigExample();
//			scheduleconfigExample.createCriteria().andGroupnameEqualTo(group).andNameEqualTo(name).andStatusEqualTo(true);
//			List<TSysTimerScheduleconfig> listschedule = SpringApplicationUtils.getBean(TSysTimerScheduleconfigService.class).selectByExample(scheduleconfigExample);
//			if(listschedule.size()>0) {
//				TSysTimerScheduleconfig scheduleconfig = listschedule.get(0);
//				TSysTimerScheduleWorkflowExample scheduleWorkflowExample = new TSysTimerScheduleWorkflowExample();
//				scheduleWorkflowExample.createCriteria().andScheduleIdEqualTo(scheduleconfig.getId().intValue()).andStatusEqualTo(true);
//				scheduleWorkflowExample.setOrderByClause("sort asc");
//				List<TSysTimerScheduleWorkflow> listwfs = SpringApplicationUtils.getBean(TSysTimerScheduleWorkflowService.class).selectByExample(scheduleWorkflowExample);
//				if (listwfs.size() > 0) {
//					for (TSysTimerScheduleWorkflow scheduleWorkflow : listwfs) {
//						int id = scheduleWorkflow.getWorkflowId().intValue();
//						TSysTimerJobconfigExample jobexample = new TSysTimerJobconfigExample();
//						jobexample.createCriteria().andWorkflowIdEqualTo(id).andStatusEqualTo(true);
//						jobexample.setOrderByClause("sort asc");
//						List<TSysTimerJobconfig> joblist = SpringApplicationUtils.getBean(TSysTimerJobconfigService.class).selectByExample(jobexample);
//						for (TSysTimerJobconfig tSysTimerJobconfig : joblist) {
//							int type = tSysTimerJobconfig.getType();
//							int excute_id = tSysTimerJobconfig.getExcuteId();
//							WorkFlowState jobwfs = InterfaceType.valueOf(type).getIntfaceService();
//							jobwfs.run(jobwfs.getJob(), excute_id);
//						}
//					}
//				}
//			}
//		} catch (Exception e) {
//			return; // 任务失败不再往下进行
//		}
//	}
//}
