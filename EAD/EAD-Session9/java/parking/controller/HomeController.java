package com.parking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.parking.model.LoginDetails;

import com.parking.service.LoginService;

/**
 * The Class HomeController.
 */
@Controller
public class HomeController {

	@Autowired
	LoginService loginService;

	@GetMapping({"/","/home" } )
	public String home(Model model,HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("emailId");
		if( email == null ) {
			LoginDetails login = new LoginDetails();
			model.addAttribute("login", login);

			return "login";
		}
		
		return "redirect:/profile/"+email;
		
	}

	

	@PostMapping("/login")

	public String login(@Valid @ModelAttribute("login") LoginDetails login , HttpSession session, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {

			return "login";
		}
		
		if(loginService.login(login)) {
			
			session.setAttribute("emailId", login.getEmailId());
			return "redirect:/profile/"+login.getEmailId();
			
		}
		
		return "login";
		
	}

	@PostMapping("/logout")

	public String logout(HttpSession session,HttpServletResponse res) {
		res.setHeader("Cahce-Control","no-cache, no-store, must-revalidate");
		session.removeAttribute("emailId");
		return "redirect:/home";
		
	}



}
