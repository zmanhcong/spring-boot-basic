package edu.poly.hello.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.hello.model.Student;

@Controller
@RequestMapping("students")
public class StudentController {
	@ModelAttribute("students")
	public List<Student> getStudents(){
		List<Student> list = new ArrayList<>();
		
		list.add(new Student("S01","Minh"));
		list.add(new Student("S01","Hung"));
		return list;
	}
	
	
	@GetMapping("new")
	public String newForm() {
		return "students/new";   //hiển thị form new
	}
	
	@PostMapping("saveOrUpdate") //thêm sửa xóa thì dùng post
	public String saveOrUpdate(
			@RequestParam(value = "studentId", required = false) String studentId,
			@RequestParam("name") String name,
			Model model) {
		//phía server có thể nhìn được
		System.out.println("student ID: " + studentId);
		System.out.println("name: "+ name);
		
		//Hiển thị sang views
		model.addAttribute("studentId",studentId);
		model.addAttribute("name",name);
		return "students/viewDetail";
	}
	@PostMapping("update")
	public String update( Student student,Model model ) 
	{
		System.out.println("Update method");
		//Hiển thị sang views ( chi tiết user)
		model.addAttribute("studentId",student.getStudentId());
		model.addAttribute("name",student.getName());
		return "students/viewDetail";
	}
	
	@GetMapping("edit/{studentId}")
	public String edit(@PathVariable("studentId") String studentId, Model model) {
		System.out.println("Edit student ID: "+ studentId);
		
		Student student = new Student();
		
		student.setStudentId(studentId);
		student.setName("Minh");
		
		model.addAttribute("student", student);
		return "students/edit";
	}
	
	@RequestMapping("list")      //request data thì dùng request
	public String list() {
		return "students/list";
	}
	
	@RequestMapping("search")     //request data thì dùng request
	public String search() {
		return "students/search";
	}
	
}
