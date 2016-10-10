package com.qk.practice.dao;

import java.util.List;

import com.qk.practice.model.ExamTag;
import com.qk.practice.model.PracticeTag;
import com.qk.practice.model.Tag;

public interface ITagDao {
	
	public List<Tag> getAllTags();
	
	public Tag getTagByPracticeId(String practiceId);
	
	public Tag getTagByExamId(String examId);
	
	public List<Tag> getAllTags(Tag tag);
	
	public int deletePracticeTag(PracticeTag practiceTag);
	
	public int deleteExamTag(ExamTag examTag);

}
