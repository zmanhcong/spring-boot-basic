package edu.poly.hello.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
	private int productId;
	private String name;
	private int quantity;
	private double price;
}
