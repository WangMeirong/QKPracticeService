package com.qk.practice.controller;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qk.practice.common.AllCaches;
import com.qk.practice.common.StatusEnum;
import com.qk.practice.model.Practice;
import com.qk.practice.model.PracticeInstance;
import com.qk.practice.model.Response;
import com.qk.practice.service.IPracticeService;

@RestController
@RequestMapping("/practice")
public class PracticeContoller {
	
	@Resource
	private IPracticeService practiceService;
    
    @RequestMapping(value = { "/doPractice" }, method = RequestMethod.GET)
    @ResponseBody
    public Response doPractice(@RequestBody Practice practice) {
    	// create practiceInstance
    	PracticeInstance pi = new PracticeInstance();
    	// TODO
    	//pi.setLastModifiedBy(userId);
    	pi.setPracticeId(practice.getPracticeId());
    	//pi.setUserId(userId);
    	pi.setStatusId(AllCaches.CACHE_STATUS.get(StatusEnum.PROCESSING));
    	try {
			practiceService.insertPracticeInstance(pi);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(HttpStatus.SERVICE_UNAVAILABLE, "Can't start the Practice.", "");
		}
        return new Response(HttpStatus.OK,"Updated sucessfully", "");
    }

    @RequestMapping(value = { "/completePractice" }, method = RequestMethod.GET)
    @ResponseBody
    public Response completePractice(@RequestBody Practice practice) {
    	
    	return new Response(HttpStatus.OK,"Updated sucessfully", "");
    }
}
