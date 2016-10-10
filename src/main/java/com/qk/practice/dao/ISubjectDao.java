package com.qk.practice.dao;

import java.util.List;

import com.qk.practice.model.Subject;

public interface ISubjectDao {

	public Subject getSubjectById(String subjectId);
	
	public Subject getSubjectByName(String name);
	
	public List<Subject> getAllSubjects();
}
