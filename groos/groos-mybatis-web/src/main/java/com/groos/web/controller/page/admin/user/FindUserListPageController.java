package com.groos.web.controller.page.admin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.groos.domain.model.User;
import com.groos.service.admin.UserService;

@Controller
@RequestMapping("page/admin/user")
public class FindUserListPageController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="findUserList.do", method=RequestMethod.GET)
	public void showForm(Model model) { 
		
		List<User> allUserList = this.userService.findAllUserList();
		
		List<User> userList = this.userService.findUserListByUserName("");
		
		model.addAttribute("allUserList", allUserList);
		model.addAttribute("userList", userList);
		
	}

}
