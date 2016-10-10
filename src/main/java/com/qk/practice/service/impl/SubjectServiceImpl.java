package com.qk.practice.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qk.practice.dao.ISubjectDao;
import com.qk.practice.model.Subject;
import com.qk.practice.service.ISubjectService;

@Service("subjectService")
public class SubjectServiceImpl implements ISubjectService{
	
	@Resource
	private ISubjectDao subjectDao;

	@Override
	public List<Subject> getAllSubjects() {
		return subjectDao.getAllSubjects();
	}

}
