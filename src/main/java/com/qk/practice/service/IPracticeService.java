package com.qk.practice.service;

import java.util.List;

import com.qk.practice.model.Practice;


public interface IPracticeService {
	
	public List<Practice> getPractices(Practice practice);
	public Practice getPracticeById(String practiceId);
	public int insertPractice(Practice practice);
	public int deletePracticeById(String practiceId);
	public int updatePracticeById(Practice pratice);

}
