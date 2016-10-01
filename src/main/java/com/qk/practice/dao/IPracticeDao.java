package com.qk.practice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qk.practice.model.Practice;

public interface IPracticeDao {
	
	public List<Practice> getPractices(@Param("practice")Practice practice);
	
	public Practice getPracticeById(String practiceId);
	
	public int insertPractice(Practice practice);
	
	public int deletePracticeById(String practiceId);
	
	public int updatePracticeById(@Param("practice")Practice pratice);
	
	

}
