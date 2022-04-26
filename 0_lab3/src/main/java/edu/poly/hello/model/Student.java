package edu.poly.hello.model;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Đây là các anotation của lambok để giúp sinh ra các contructor và getter và setter
@Data
@AllArgsConstructor //khởi tạo cho các trường id, name..vv
@NoArgsConstructor  //khởi tạo cho các contructor mà không cso tham số truyền vào
public class Student {
	@NotEmpty
	private String studentId;
	@NotEmpty(message = "Name is not empty")
//	@Min(value = 4)
	private String name;
	@Email(message = "Email type is not true")
	@NotEmpty(message = "Email is not empty")
	private String email;
	@Min(value = 0)
	@Max(value = 10)
	private Double mark;
	private String faculty;
	
	private Boolean gender;
	private List<String> hobbies;
	private MultipartFile imageFile;
	private String imageUrl;
}
