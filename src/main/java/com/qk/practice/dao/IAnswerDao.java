package com.qk.practice.dao;

import com.qk.practice.model.Answer;

public interface IAnswerDao {

	/**
	 * Get Answer by answerId.
	 * @param answerId
	 * @return
	 */
	public Answer getAnswerById(String answerId) throws Exception;
	
	/**
	 * Insert Answer.
	 * @param answer
	 * @return
	 */
	public int insertAnswer(Answer answer) throws Exception;
	
	/**
	 * Delete Answer by answerId.
	 * @param answer
	 * @return
	 */
	public int deleteAnswerById(Answer answer) throws Exception;
	
	/**
	 * Update Answer by answerId.
	 * @param answer
	 * @return
	 */
	public int updateAnswerById(Answer answer) throws Exception;
}
