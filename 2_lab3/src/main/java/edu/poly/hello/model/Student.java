package edu.poly.hello.model;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Đây là các anotation của lambok để giúp sinh ra các contructor và getter và setter
@Data
@AllArgsConstructor //khởi tạo cho các trường id, name..vv
@NoArgsConstructor  //khởi tạo cho các contructor mà không cso tham số truyền vào
public class Student {
	private String studentId;
	private String name;
	private String email;
	private Double mark;
	private String faculty;
	
	private Boolean gender;
	private List<String> hobbies;
	private MultipartFile imageFile;
	private String imageUrl;
}
