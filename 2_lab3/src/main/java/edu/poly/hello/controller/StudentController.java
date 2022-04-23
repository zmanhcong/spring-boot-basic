package edu.poly.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poly.hello.model.Student;

@Controller
@RequestMapping("students")
public class StudentController {
	@GetMapping("new")
	public String newForm(Model model) {
		model.addAttribute("student", new Student());
		return "students/addOrEdit";
	}
	
	@PostMapping("saveOrUpdate")
	public String saveOrUpdate(@ModelAttribute("student") Student student) {
		System.out.println("Student ID: " + student.getStudentId());
		System.out.println("Name: " + student.getName());
		 
		return "students/detail";
	}
}
	