package com.example.demo.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.common.ViewName;

import lombok.extern.slf4j.Slf4j;

/**
 * @author kitahararyou
 */
@Controller
@Slf4j
public class AuthPageController {

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
	
	@RequestMapping
	public String afterLogin() {
		return ViewName.MAIN;
	}
}
