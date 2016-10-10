package com.qk.practice.dao;

import com.qk.practice.model.PracticeInstance;

public interface IPracticeInstanceDao {

	/**
	 * Insert PracticeInstance.
	 * @param practiceInstance
	 * @return
	 * @throws Exception
	 */
	public int insertPracticeInstance(PracticeInstance practiceInstance) throws Exception;
	
	/**
	 * Update PracticeInstance.
	 * @param practiceInstance
	 * @return
	 * @throws Exception
	 */
	public int updatePracticeInstanceById(PracticeInstance practiceInstance) throws Exception;
}
