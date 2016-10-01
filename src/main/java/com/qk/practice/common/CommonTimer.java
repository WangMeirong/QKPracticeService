package com.qk.practice.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.qk.practice.model.Status;
import com.qk.practice.service.ICommonService;

@Component
public class CommonTimer {
	
	@Resource
	private ICommonService commonService;
	private static Logger logger = Logger.getLogger(CommonTimer.class);
	
	public static Map<String, Status> CACHE_STATUS = new HashMap<String, Status>();

	@Scheduled(cron="0 0 1 * * ?") // run at 1AM everyday
//	@Scheduled(cron="0/5 * *  * * ? ") 
	public void loadStatusCache() {
		List<Status> statusList = commonService.getAllStatus();
		
      for (Status status : statusList) {
      	CACHE_STATUS.put(status.getStatusId(), status);
      }
      logger.info("===Completed Status Cache Loading!");
	}

}
