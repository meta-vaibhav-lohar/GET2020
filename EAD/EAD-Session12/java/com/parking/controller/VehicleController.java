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
import com.parking.service.VehicleService;

/**
 * The Class VehicleController.
 */
@Controller
public class VehicleController {

	/** The vehicle service. */
	@Autowired
	private VehicleService vehicleService;

	/**
	 * Vehicle.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/vehicle")
	public String vehicle(Model model) {
		model.addAttribute("vehicle", new Vehicle());
		return "vehicle";

	}

	/**
	 * Vehicle.
	 *
	 * @param vehicle the vehicle
	 * @param session the session
	 * @param bindingResult the binding result
	 * @param model the model
	 * @return the string
	 */
	@PostMapping("/vehicle")

	public String vehicle(@Valid @ModelAttribute("vehicle") Vehicle vehicle, HttpSession session,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {

			return "vehicle";
		}
		
		Integer userId = (Integer) session.getAttribute("userId");
		String emailId = (String) session.getAttribute("emailId");
		Employee emp = (Employee) session.getAttribute("emp");
		Integer vehicleId = vehicleService.addVehicle(vehicle, userId, emailId,emp);
		session.setAttribute("vehicleId", vehicleId);
		
		return "redirect:/profile/" + emailId;
	}
}
