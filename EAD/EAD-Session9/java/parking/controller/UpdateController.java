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
import com.parking.model.Vehicle;
import com.parking.service.EmployeeService;
import com.parking.service.VehicleService;
@Controller
public class UpdateController {
	
	@Autowired
	EmployeeService employeeService;
	@Autowired
	VehicleService vehicleService;
	
	@GetMapping("/edit")
	public String edit(Model model){
		System.out.println("aaya");
		model.addAttribute("employee", new Employee());
		return "updateSignup";

	}


	@PostMapping("/edit")

	public String updateEmployee(@Valid @ModelAttribute("employee") Employee employee, HttpSession session,
			BindingResult bindingResult, Model model) {
		System.out.println("Edit");
		if (bindingResult.hasErrors()) {
			return "redirect:/edit";
		}
		System.out.println("Aaya");
		Integer vehicleId = employeeService.updateEmployee(employee,(String) session.getAttribute("emailId"));
		System.out.println("bbb:" + vehicleId);
		session.setAttribute("vehicleId", vehicleId);
		return "redirect:/editVehicle";
	}
	@GetMapping("/editVehicle")
	public String vehicle(Model model) {
		model.addAttribute("vehicle", new Vehicle());
		return "updateVehicle";

	}

	@PostMapping("/editVehicle")

	public String vehicle(@Valid @ModelAttribute("vehicle") Vehicle vehicle, HttpSession session,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {

			return "updatevehicle";
		}
		
		String emailId = (String) session.getAttribute("emailId");
		Integer vehicleId = (Integer) session.getAttribute("vehicleId");
		
		vehicleService.updateVehicle(vehicle,vehicleId );
		return "redirect:/profile/"+emailId;
	}
}
