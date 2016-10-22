package com.qk.practice.dao;

import java.util.List;

import com.qk.practice.model.Exam;
import com.qk.practice.model.ExamPractice;
import com.qk.practice.model.ExamTag;

public interface IExamDao {

	/**
	 * get Exam by examId.
	 * @param examId
	 * @return
	 * @throws Exception
	 */
	public Exam getExamById(String examId) throws Exception;
	
	/**
	 * get Exams
	 * @param exam
	 * @return
	 * @throws Exception
	 */
	public List<Exam> getExams(Exam exam) throws Exception;
	
	public List<Exam> getAllExams() throws Exception;
	
	public List<ExamTag> getExamTagsByExamId(String examId) throws Exception;
	
	public List<ExamPractice> getExamPracticeByExamId(String examId) throws Exception;
	
	public int deleteExamById(Exam exam) throws Exception;
	
	public int deleteExamsById(List<Exam> exams) throws Exception;
	
	public int deleteExamPracticesByExamId(ExamPractice examPractice) throws Exception;
	
	public int deleteExamPracticeByPracticeId(ExamPractice examPractice) throws Exception;
	
	public int deleteExamTagsByExamId(ExamTag examTag) throws Exception;
	
	public int updateExamById(Exam exam) throws Exception;
	
	public int updateExamPractices(List<ExamPractice> examPractices) throws Exception;
	
	public int updateExamTags(List<ExamTag> examTags) throws Exception;
	
	public int insertExam(Exam exam) throws Exception;
	
	public int insertExamPractice(ExamPractice examPractice) throws Exception;
	
	public int insertExamPractices(List<ExamPractice> epList) throws Exception;
	
	public int insertExamTag(ExamTag examTag) throws Exception;
	
	public int insertExamTags(List<ExamTag> examTags) throws Exception;
	
}
