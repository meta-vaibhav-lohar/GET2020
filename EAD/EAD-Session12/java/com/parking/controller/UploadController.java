package com.parking.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.parking.model.Image;
import com.parking.service.EmployeeService;

/**
 * The Class UploadController.
 */
@Controller
public class UploadController {

	/** The upload directory. */
	public static String uploadDirectory = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\images";
	
	/** The employee service. */
	@Autowired
	EmployeeService employeeService;

	/**
	 * Upload.
	 *
	 * @param model the model
	 * @param img the img
	 * @param session the session
	 * @return the string
	 */
	@PostMapping("/upload")
	public String upload(Model model, @RequestParam("file") MultipartFile img, HttpSession session) {

		Path fileNameAndPath = Paths.get(uploadDirectory, img.getOriginalFilename());

		model.addAttribute("imgName", img.getOriginalFilename());
		try {
			Files.write(fileNameAndPath, img.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Image image = new Image();
		image.setEmailId((String) session.getAttribute("email"));
		image.setImageName(img.getOriginalFilename());
		employeeService.setEmployeeImage(image);
		return "redirect:/profile/" + session.getAttribute("email");
	}

}