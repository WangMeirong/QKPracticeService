package com.qk.practice.dao;

import java.util.List;
import java.util.Map;

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
	 * Update PracticeInstance by practiceInstanceId.
	 * @param practiceInstance
	 * @return
	 * @throws Exception
	 */
	public int updatePracticeInstanceById(PracticeInstance practiceInstance) throws Exception;
	
	/**
	 * Get PracticeInstances.
	 * Condition in SQL can be: practiceInstanceId, userId, statusId, practiceId, title, code.
	 * @param practiceInstance
	 * @return
	 * @throws Exception
	 */
	public List<PracticeInstance> getPracticeInstance (PracticeInstance practiceInstance) throws Exception;
	
	/**
	 * Get the latest row PracticeInstance. 
	 * condition in SQL can be: practiceInstanceId, userId, statusId, practiceId, title, code.
	 * @param condition: <practiceInstance, PracticeInstance>, <row, int>
	 * @return
	 * @throws Exception
	 */
	public List<PracticeInstance> getLatestPracticeInstance (Map<String, Object> condition) throws Exception;
	
}
