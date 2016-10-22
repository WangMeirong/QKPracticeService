package com.qk.practice.common;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.qk.practice.model.Status;
import com.qk.practice.model.Subject;
import com.qk.practice.model.Tag;
import com.qk.practice.service.ICommonService;
import com.qk.practice.service.ISubjectService;
import com.qk.practice.service.ITagService;
import com.qk.practice.util.Utils;

@Component("commonTimer")
public class CommonTimer {

	private static Logger logger = Logger.getLogger(CommonTimer.class);

	@Resource
	private ICommonService commonService;
	@Resource
	private ISubjectService subjectService;
	@Resource
	private ITagService tagService;

	@Scheduled(cron = "0 0 1 * * ?")
	// run at 1AM everyday
	public void loadCache() {
		CacheProcessor.CACHE_STATUS.clear();
		CacheProcessor.CACHE_SUBJECT.clear();
		CacheProcessor.CACHE_TAG.clear();

		List<Status> statusList = null;
		try {
			statusList = commonService.getAllStatus();
		} catch (Exception e2) {
			e2.printStackTrace();
			logger.error("===Can't get Status.", e2);
		}
		if (!Utils.isEmpty(statusList)) {
			for (Status status : statusList) {
				CacheProcessor.CACHE_STATUS.put(status.getCode(),
						status.getStatusId());
			}
			logger.info("===Completed Status Cache Loading!");
		}

		List<Subject> subjectList = null;
		try {
			subjectList = subjectService.getAllSubjects();
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error("===Can't get Subject.", e1);
		}
		if (!Utils.isEmpty(subjectList)) {
			for (Subject subject : subjectList) {
				CacheProcessor.CACHE_SUBJECT.put(subject.getName(),
						subject.getSubjectId());
			}
			logger.info("===Completed Subject Cache Loading!");
		}

		List<Tag> tags = null;
		try {
			tags = tagService.getAllTags();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("===Can't get Tags.", e);
		}
		if (!Utils.isEmpty(tags)) {
			for (Tag tag : tags) {
				CacheProcessor.CACHE_TAG.put(tag.getTag(), tag.getTagId());
			}
			logger.info("===Completed Tag Cache Loading!");
		}
	}

}
