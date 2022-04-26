package edu.poly.hello.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.domain.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	HttpServletRequest request;
	//request để đọc các thông tin, và thông tin do người dùng gửi tới ( code dòng 30 trở đi)
	
	@Autowired
	HttpServletRequest response;
	
	@GetMapping("create")
	public String create() {
		return "createStudent";
	}
	@PostMapping("create")
	public String createPost() {
		String studentId = request.getParameter("studentId");
		String name = request.getParameter("name");
		
		Student stud = new Student(studentId,name);
		request.setAttribute("student", stud);
		//setAttribute để thiết lập thuộc tính student với nội dung là đối tượng student được tạo ra
		// và chia sẻ dữ liêu cho views->detailStudent
		return "detailStudent";
	}
	

}
