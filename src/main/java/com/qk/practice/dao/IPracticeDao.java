package com.qk.practice.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.qk.practice.model.Practice;
import com.qk.practice.model.PracticeTag;

public interface IPracticeDao {
	
	/**
	 * Get Practices.
	 * @param practice
	 * @return
	 * @throws Exception
	 */
	public List<Practice> getPractices(@Param("practice")Practice practice) throws Exception;

	/**
	 * Get all Practices.
	 * @return
	 * @throws Exception
	 */
	public List<Practice> getAllPractices() throws Exception;
	
	/**
	 * Get Practice by practiceId.
	 * @param practiceId
	 * @return
	 */
	public Practice getPracticeById(String practiceId) throws Exception;
	
	/**
	 * Get PracticeTag by practiceId.
	 * @param practiceId
	 * @return
	 */
	public List<PracticeTag> getPracticeTagsById(String practiceId) throws Exception;
	
	/**
	 * Delete Practice by practiceId.
	 * @param practice
	 * @return
	 */
	public int deletePracticeById(Practice practice) throws Exception;
	
	/**
	 * Delete Practices by practiceId.
	 * @param ps
	 * @return
	 * @throws Exception
	 */
	public int deletePracticesById(List<Practice> ps) throws Exception;
	
	/**
	 * Delete PracticeTag by practiceId.
	 * @param practiceTag
	 * @return
	 */
	public int deletePracticeTagById(PracticeTag practiceTag) throws Exception;
	
	/**
	 * Update Practice by practiceId.
	 * @param practice
	 * @return
	 */
	public int updatePracticeById(@Param("practice")Practice practice) throws Exception;
	
	/**
	 * Update PracticeTag by practiceId and tagId, mainly update is_delete.
	 * @param practiceTags
	 * @return
	 */
	public int updatePracticeTags(List<PracticeTag> practiceTags) throws Exception;

	/**
	 * Insert Practice.
	 * @param practice
	 * @return
	 */
	public int insertPractice(Practice practice) throws Exception;
	
	/**
	 * Insert PracticeTag.
	 * @param practiceTag
	 * @return
	 */
	public int insertPracticeTag(PracticeTag practiceTag) throws Exception;
	
	/**
	 * Batch insert PracticeTag.
	 * @param practiceTags
	 * @return
	 */
	public int insertPracticeTags(List<PracticeTag> practiceTags) throws Exception;
}
