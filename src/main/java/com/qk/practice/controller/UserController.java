package com.qk.practice.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qk.practice.model.Response;
import com.qk.practice.model.User;
import com.qk.practice.service.IUserService;


@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request,Model model){
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}
	
	
	
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    @ResponseBody
    public Response listQuestion() {

		User user = this.userService.getUserById(1);
		List<User> users = new ArrayList<User>();
		users.add(user);
        if (null == user) {
            System.out.println("Question with id " + 1 + " not found");
            return new Response(HttpStatus.NO_CONTENT, "Question with id " + 1 + " not found", "");
        }
        System.out.println("=============================");
        return new Response(HttpStatus.OK, "", users);
    }
    

}
