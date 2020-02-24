package com.parking.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.parking.model.Employee;
import com.parking.service.EmployeeService;
@Controller
public class EmployeeControler {
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("employee", new Employee());
		return "signup";

	}


	@PostMapping("/signup")

	public String addEmployee(@Valid @ModelAttribute("employee") Employee employee, HttpSession session,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {

			return "redirect:/signup";
		}
		int userId =  employeeService.addEmployee(employee);
		session.setAttribute("userId", userId);
		session.setAttribute("emailId", employee.getEmailId());
		return "redirect:/vehicle";
	}

}
