package com.parking.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.parking.dao.EmployeeDao;
import com.parking.model.Employee;
import com.parking.model.Vehicle;
import com.parking.service.EmployeeService;
import com.parking.service.VehicleService;

/**
 * The Class ProfileController.
 */
@Controller
public class ProfileController {

	/** The employee service. */
	@Autowired
	private EmployeeService employeeService;

	/** The vehicle service. */
	@Autowired
	private VehicleService vehicleService;

	/** The employee dao. */


	/**
	 * Profile.
	 *
	 * @param model the model
	 * @param session the session
	 * @param email the email
	 * @return the string
	 */
	@GetMapping("/profile/{email}")
	public String profile(Model model, HttpSession session, @PathVariable String email) {

		if (session.getAttribute("emailId") == null) {
			return "redirect:/";
		}
		
		
		Integer userId= employeeService.getUserId(email);
		session.setAttribute("userId", userId );
		session.setAttribute("email", email);
		
		Employee emp = employeeService.getEmployee(email);
		Integer vehicleId =  emp.getVId(); 
		
		Employee employee = employeeService.getEmployee(email);
		Vehicle vehicle = vehicleService.getVehicle(vehicleId);
		ArrayList<Employee> friendsList = (ArrayList<Employee>) employeeService.getFirends(employee.getOrganization(),employee.getEmailId());
		
		System.out.println(friendsList);
		model.addAttribute("employee", employee);
		model.addAttribute("vehicle", vehicle);
		model.addAttribute("friends", friendsList);
		String imageName = employeeService.getEmployeeImage(email);
		model.addAttribute("imageName", imageName);

		return "profile";

	}

}
