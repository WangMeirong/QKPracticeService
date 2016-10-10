package com.qk.practice.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qk.practice.common.Constant;
import com.qk.practice.model.Practice;
import com.qk.practice.model.Response;
import com.qk.practice.service.IPracticeService;

@RestController
@RequestMapping("/practiceManager")
public class PracticeManagerController {
	
	private static Logger logger = Logger.getLogger(PracticeManagerController.class);
	@Resource
	IPracticeService practiceService;

    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    @ResponseBody
    public Response listPractice(@RequestBody Practice practice) {

		List<Practice> practices = null;
		try {
			practices = practiceService.getPractices(practice);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(HttpStatus.SERVICE_UNAVAILABLE, "Practice is not found.", "");
		}
        if (null == practices || practices.isEmpty()) {
            logger.debug("Practice is not found.");
            return new Response(HttpStatus.NOT_FOUND, "Practice is not found.", "");
        }
        return new Response(HttpStatus.OK, "", practices);
    }
    
    @RequestMapping(value = { "/update" }, method = RequestMethod.GET)
    @ResponseBody
    public Response updatePractice(@RequestBody Practice practice) {

    	String flag = null;
		try {
			// TODO
			//practice.setLastModifiedBy(userId);
			flag = practiceService.updatePractice(practice);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(HttpStatus.SERVICE_UNAVAILABLE, "Practice is not updated.", "");
		}
        if (Constant.FAILURE.equals(flag)) {
            logger.debug("Practice is not updated.");
            return new Response(HttpStatus.NOT_MODIFIED, "Practice is not updated.", "");
        }
        return new Response(HttpStatus.OK,"Updated sucessfully", "");
    }
    
    @RequestMapping(value = { "/add" }, method = RequestMethod.GET)
    @ResponseBody
    public Response addPractice(@RequestBody Practice practice) {

    	String flag = null;
    	// TODO
    	//practice.setLastModifiedBy(userId);
		try {
			flag = practiceService.insertPractice(practice);
		} catch (Exception e) {
			e.printStackTrace();
            return new Response(HttpStatus.SERVICE_UNAVAILABLE, "Add failed.", "");
		}
        if (Constant.FAILURE.equals(flag)) {
            logger.debug("Practice is not inserted.");
            return new Response(HttpStatus.NOT_MODIFIED, "Practice is not inserted.", "");
        }
        return new Response(HttpStatus.OK,"Added sucessfully", null);
    }
}
