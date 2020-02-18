package com.student.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.student.dao.StudentDao;
import com.student.model.Student;
import com.student.service.StudentService;

/**
 * The Class HomeController.
 */
@Controller
public class HomeController {

	/** The student service. */
	@Autowired
	private StudentService studentService;

	/** The message. */
	@Value("${home.message}")
	private String message;

	/**
	 * Home.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping({ "/", "/home" })
	public String home(Model model) {
		model.addAttribute("msg", message);

		return "home";
	}

	/**
	 * Adds the student.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/addStudent")
	public String addStudent(Model model) {
		model.addAttribute("student", new Student());
		return "addStudent";
	}

	/**
	 * Adds the.
	 *
	 * @param student the student
	 * @param bindingResult the binding result
	 * @param model the model
	 * @return the string
	 */
	@PostMapping("/add")
	public String add(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model) {
		System.out.println("add");

		if (bindingResult.hasErrors()) {

			return "addStudent";
		} else {
			int id = studentService.addStudent(student);
			System.out.println(id);
			if (id != 0) {
				model.addAttribute("alert", "already registered");
				System.out.println("al");
				return "addStudent";
			}
		}
		System.out.println("new");
		return "redirect:home";

	}

	/**
	 * All student.
	 *
	 * @param model the model
	 * @return the model and view
	 */
	@GetMapping("/allStudent")
	public ModelAndView allStudent(Model model) {
		List<Student> student = studentService.getAllStudents();
		return new ModelAndView("allStudent", "student1", student);
	}

}