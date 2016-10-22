package com.qk.practice.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.qk.practice.dao.ISubjectDao;
import com.qk.practice.model.Subject;
import com.qk.practice.service.ISubjectService;

@Service("subjectService")
public class SubjectServiceImpl implements ISubjectService{
	
	private static Logger logger = Logger.getLogger(SubjectServiceImpl.class); 
	
	@Resource
	private ISubjectDao subjectDao;

	@Override
	public List<Subject> getAllSubjects() {
		logger.debug("===Get all Subjects.");
		return subjectDao.getAllSubjects();
	}

}
