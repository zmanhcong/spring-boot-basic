package edu.poly.hello.controller;

import com.example.demo.domain.Student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("home")
	public String index() {
		return "index";
	}
	
//	public String display() {
//		Student stud = new Student("ST01", "Anhnn");
//		stud.getStudentId();
//	}
}
