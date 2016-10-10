package com.qk.practice.dao;

import java.util.List;

import com.qk.practice.model.Exam;
import com.qk.practice.model.ExamPractice;

public interface IExamDao {

	public Exam getExamById(String examId);
	
	public List<Exam> getExams(Exam exam);
	
	public int deleteExamPracitcesByExamId(String examId);
	
	public int updateExamById(String examId);
	
	public int insertExam(Exam exam);
	
	public int insertExamPractice(ExamPractice examPractice);
	
	public int insertExamPractices(List<ExamPractice> epList);
}
