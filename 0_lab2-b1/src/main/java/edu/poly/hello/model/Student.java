package edu.poly.hello.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Đây là các anotation của lambok để giúp sinh ra các contructor và getter và setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	private String studentId;
	private String name;
}
