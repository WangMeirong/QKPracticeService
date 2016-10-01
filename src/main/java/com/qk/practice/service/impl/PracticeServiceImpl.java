package com.qk.practice.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qk.practice.dao.IPracticeDao;
import com.qk.practice.model.Practice;
import com.qk.practice.service.IPracticeService;

@Service("practiceService")
public class PracticeServiceImpl implements IPracticeService{

	@Resource
	private IPracticeDao practiceDao;

	@Override
	public Practice getPracticeById(String practiceId) {
		Practice practice = practiceDao.getPracticeById(practiceId);
		return practice;
	}

	@Override
	public List<Practice> getPractices(Practice practice) {
		return practiceDao.getPractices(practice);
	}

	@Override
	public int insertPractice(Practice practice) {
		return practiceDao.insertPractice(practice);
	}

	@Override
	public int deletePracticeById(String practiceId) {
		return practiceDao.deletePracticeById(practiceId);
	}

	@Override
	public int updatePracticeById(Practice pratice) {
		return practiceDao.updatePracticeById(pratice);
	}

}
