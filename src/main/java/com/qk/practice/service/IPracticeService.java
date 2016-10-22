package com.qk.practice.service;

import java.util.List;

import com.qk.practice.model.Practice;
import com.qk.practice.model.PracticeInstance;


public interface IPracticeService {
	
	/**
	 * Get Practice.
	 * @param practice
	 * @return
	 * @throws Exception
	 */
	public List<Practice> getPractices(Practice practice) throws Exception;
	
	/**
	 * Get Practice by practiceId
	 * @param practiceId
	 * @return
	 * @throws Exception
	 */
	public Practice getPracticeById(String practiceId) throws Exception;
	
	/**
	 * Insert Practice(contain PracticeTag, Answer).
	 * @param practice
	 * @return
	 * @throws Exception
	 */
	public String insertPractice(Practice practice) throws Exception;
	
	/**
	 * Delete Practice(contain PracticeTag, Answer).
	 * @param practice
	 * @return
	 * @throws Exception
	 */
	public String deletePractice(Practice practice) throws Exception;
	
	/**
	 * Delete Practice by practiceId.
	 * @param practiceIds
	 * @param lastModifiedBy
	 * @return
	 * @throws Exception
	 */
	public String deletePractices(String practiceIds, String lastModifiedBy) throws Exception;
	
	/**
	 * Update Practice(contain PracticeTag, Answer).
	 * @param pratice
	 * @return
	 * @throws Exception
	 */
	public String updatePractice(Practice pratice) throws Exception;
	
	/**
	 * Insert PracticeInstance.
	 * @param practiceInstance
	 * @return
	 * @throws Exception
	 */
	public String insertPracticeInstance(PracticeInstance practiceInstance) throws Exception;
	
	/**
	 * Update PracticeInstance.
	 * @param practiceInstance
	 * @return
	 * @throws Exception
	 */
	public String updatePracticeInstance(PracticeInstance practiceInstance) throws Exception;

}
