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

import com.parking.model.Vehicle;
import com.parking.service.VehicleService;
@Controller
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;

	@GetMapping("/vehicle")
	public String vehicle(Model model) {
		model.addAttribute("vehicle", new Vehicle());
		return "vehicle";

	}

	@PostMapping("/vehicle")

	public String vehicle(@Valid @ModelAttribute("vehicle") Vehicle vehicle, HttpSession session,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {

			return "vehicle";
		}
		Integer userId = (Integer) session.getAttribute("userId");
		String emailId = (String) session.getAttribute("emailId");
		Integer vehicleId = vehicleService.addVehicle(vehicle,userId, emailId);
		session.setAttribute("vehicleId", vehicleId);
		return "redirect:/profile/"+emailId;
	}
}
