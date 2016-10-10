package com.qk.practice.common;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.qk.practice.model.Status;
import com.qk.practice.model.Subject;
import com.qk.practice.service.ICommonService;
import com.qk.practice.service.ISubjectService;

@Component
public class CommonTimer {
	
	@Resource
	private ICommonService commonService;
	@Resource 
	private ISubjectService subjectService;
	private static Logger logger = Logger.getLogger(CommonTimer.class);
	
	@Scheduled(cron="0 0 1 * * ?") // run at 1AM everyday
//	@Scheduled(cron="0/5 * *  * * ? ") 
	public void loadCache() {
		List<Status> statusList = commonService.getAllStatus();
		for (Status status : statusList) {
			AllCaches.CACHE_STATUS.put(status.getCode(), status.getStatusId());
	    }
		logger.info("===Completed Status Cache Loading!");
		
		List<Subject> subjectList = subjectService.getAllSubjects();
		for (Subject subject : subjectList) {
			AllCaches.CACHE_SUBJECT.put(subject.getName(), subject.getSubjectId());
	    }
        logger.info("===Completed Subject Cache Loading!");
	}

}
