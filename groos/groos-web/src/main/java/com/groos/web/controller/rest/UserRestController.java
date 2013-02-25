package com.groos.web.controller.rest;
 
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.groos.domain.model.User;

@Controller
@RequestMapping("rest")
public class UserRestController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value="users", method=RequestMethod.GET)
	@ResponseBody
	public List<User> findAll(Model model) {
		logger.info("public List<User> findAll(Model model)");
		
		List<User> userList = new ArrayList<User>();   
		
		return userList; 
	}
	
	@RequestMapping(value="users/{id}", method=RequestMethod.GET)
	@ResponseBody
	public User find(Model model, @PathVariable String id) {
		logger.info("public User find(Model model, @PathVariable String id)");
		
		User user = new User();  
		
		return user; 
	}
	
	@RequestMapping(value="users", method=RequestMethod.POST)
	@ResponseBody
	public String create(Model model, @RequestBody User user) { 
		logger.info("public String create(Model model, @RequestBody User user )");
		
		return "1"; 
	}
	
	@RequestMapping(value="users", method=RequestMethod.PUT)
	@ResponseBody
	public void modify(Model model, @RequestBody User user) {  
		logger.info("public void modify(Model model, @RequestBody User user)");
		
	}
	
	@RequestMapping(value="users/{id}", method=RequestMethod.DELETE)
	@ResponseBody
	public void remove(Model model, @PathVariable String id) { 
		logger.info("public void remove(Model model, @PathVariable String id)");
		
	}
	
}
