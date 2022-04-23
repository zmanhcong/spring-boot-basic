package edu.poly.hello.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//	@ModelAttribute("genders")
//	public Map<Boolean, String> getGenders(){
//		Map<Boolean, String> genders = new HashMap<>();
//		genders.put(true,"Male");
//		genders.put(false, "Female");
//		return genders;
//	}
	
	@ModelAttribute("genders")
	public Map<Boolean, String> getGenders(){
		Map<Boolean,String> genders = new HashMap<>();
		genders.put(true, "Malse");
		genders.put(false, "Female");
		return genders;
	}
	@ModelAttribute("hobbies")
	public Map<String, String> getHobbies(){
		Map<String, String> hobbies = new HashMap<>();
		
		hobbies.put("M", "Mucsic");
		hobbies.put("S", "Sport");
		return hobbies;
	}
	
	@ModelAttribute("faculties")
	public List<String> getFaculty(){
		
		return Arrays.asList("IT", "Web design", "BA");
	}
	
	
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
	