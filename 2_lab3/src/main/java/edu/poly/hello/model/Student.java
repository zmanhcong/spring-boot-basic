package edu.poly.hello.model;

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
}
