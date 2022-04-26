package edu.poly.hello.controller;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poly.hello.model.Student;

@Controller
@RequestMapping("students")
public class StudentController {
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
	
	@Autowired
	ServletContext application; //sử dụng autowired để tiêm servletcontext cho biến application, dùng application để xử lý phần dứ liệu upload lên server
	
	@GetMapping("new")
	public String newForm(Model model) {
		model.addAttribute("student", new Student());
		return "students/addOrEdit";
	}
	
	@PostMapping("saveOrUpdate")
	public String saveOrUpdate(
			@Validated @ModelAttribute("student") Student student,
			BindingResult result) {
		if (result.hasErrors()) {
			return "students/addOrEdit";
		}
		
		if(!student.getImageFile().isEmpty()){
			String path = application.getRealPath("/");
			System.out.println("path: " + path);
			
			try {
				student.setImageUrl(student.getImageFile().getOriginalFilename()); // lấy file của người dùng, import vào student.imageUrl
				String filePath = path + "/images/" + student.getImageUrl();    //cho file vào thư mục "images"
				student.getImageFile().transferTo(Path.of(filePath)); // xử lý nội dung của file được upload
				student.setImageFile(null);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Student ID: " + student.getStudentId());
		System.out.println("Name: " + student.getName());
		
		return "students/detail";
	}
}
	