package com.qk.practice.controller;


import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
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
	@Autowired
	IPracticeService practiceService;
	

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
    public Response getPracticeById(@PathVariable("id") String id) {

		Practice p = null;
		try {
			p = practiceService.getPracticeById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

        if (null == p) {
           // System.out.println("Question with id " + id + " not found");
            return new Response(HttpStatus.NO_CONTENT, "Question with id " + id + " not found", "");
        }

        return new Response(HttpStatus.OK, "", p);
    }
	
    @RequestMapping(value = { "/" }, method = RequestMethod.POST)
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
    
    @RequestMapping(value = { "/update" }, method = RequestMethod.POST)
    @ResponseBody
    public Response updatePractice(@RequestBody Practice practice) {

    	String flag = null;
		try {
			// TODO
			practice.setLastModifiedBy("1");
			flag = practiceService.updatePractice(practice);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(HttpStatus.SERVICE_UNAVAILABLE, e.getMessage(), "");
		}
        if (Constant.FAILURE.equals(flag)) {
            logger.debug("Practice is not updated.");
            return new Response(HttpStatus.NOT_MODIFIED, "Practice is not updated.", "");
        }
        return new Response(HttpStatus.OK,"Updated sucessfully", "");
    }
    
    @RequestMapping(value = { "/add" }, method = RequestMethod.POST)
    @ResponseBody
    public Response addPractice(@RequestBody Practice practice) {

    	String flag = null;
    	// TODO
    	practice.setLastModifiedBy("1");
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
    
    @RequestMapping(value = { "/delete" }, method = RequestMethod.POST)
    @ResponseBody
    public Response deletePractices(@RequestBody Map<String,String> map) {

    	String flag = null;
    	// TODO
    	String lastModifiedBy = "1";
		try {
			flag = practiceService.deletePractices(map.get("ids"), lastModifiedBy);
		} catch (Exception e) {
			e.printStackTrace();
            return new Response(HttpStatus.SERVICE_UNAVAILABLE, "Delete failed.", "");
		}
        if (Constant.FAILURE.equals(flag)) {
            logger.debug("Practice is not deleted.");
            return new Response(HttpStatus.NOT_MODIFIED, "Practices are not deleted.", "");
        }
        return new Response(HttpStatus.OK,"Deleted sucessfully", null);
    }
}
