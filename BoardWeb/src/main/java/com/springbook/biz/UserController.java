package com.springbook.biz;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@Autowired
	//UserDAO userDAO;
	UserDAOSpring userDAO;

	@RequestMapping("/getUserList")
	public String getUserList(Model model) {
		List<Map<String, Object>> list = userDAO.getUserList();
		model.addAttribute("list", list);
		return "/user/getUserList";
	}

}
