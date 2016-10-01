package com.qk.practice.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.qk.practice.dao.ICommonDao;
import com.qk.practice.model.Status;
import com.qk.practice.service.ICommonService;

@Service("commonService")
public class CommonService implements ICommonService{
	
	private static Logger logger = Logger.getLogger(CommonService.class);
	@Resource
	private ICommonDao commonDao;

	@Override
	public List<Status> getAllStatus() {
		return commonDao.getAllStatus();
	}
	

}
