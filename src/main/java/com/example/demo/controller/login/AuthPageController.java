package com.example.demo.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author kitahararyou
 *
 */
@Controller
public class AuthPageController {

	@GetMapping(value = "/login")
	public String login(
//			@RequestParam(required = false) String failure, Model model
			) {
//		if ("failure".equals(failure)) {
//			model.addAttribute("failureMessage", "ログインに失敗しました");
//		}
		return "login";
	}
}
