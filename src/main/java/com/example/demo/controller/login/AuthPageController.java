package com.example.demo.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.common.ViewName;
import com.example.demo.service.SampleService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author kitahararyou
 */
@Controller
@Slf4j
public class AuthPageController {

	@Autowired
	private SampleService sampleService;
	
	@GetMapping(value = "/login")
	public String login() {
		return ViewName.LOGIN;
	}

	@GetMapping(value = "/login", params = "failure")
	public String loginFailed(Model model) {
		model.addAttribute("failureMessage", "ログインに失敗しました。");
		return ViewName.LOGIN;
	}

	@RequestMapping(value = "/access-denied")
	public String accessDenied() {
		return ViewName.ACCESS_DENIED;
	}
	
	@RequestMapping(value = "/main")
	public String afterLogin() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		log.debug(auth.toString());
		log.debug(auth.getName());
		
		log.debug(this.sampleService.hello());
		
		return ViewName.MAIN;
	}
}
