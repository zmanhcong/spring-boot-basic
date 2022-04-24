package edu.poly.hello.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.poly.hello.model.Product;
import edu.poly.hello.service.ProductService;

@Service //cần thiết khai báo annotation này để implements interface
public class ProductServiceImpl implements ProductService{
	private static List<Product> list= new ArrayList<>();
	
	static {
		list.add(new Product(1, "Hat", 20, 200));
		list.add(new Product(2, "Shoes", 20, 200));
		list.add(new Product(3, "Jeans", 20, 200));
		list.add(new Product(4, "T-shirts", 20, 200));
		list.add(new Product(5, "Skirt", 20, 200));
		list.add(new Product(6, "Coat", 20, 200));
	}
	
	@Override //implements của interface thì cần thiết phải overide, public void phía dưới ngầm hiểu là pulic abstruct void
	public void add(Product product) { 
		list.add(product);
	}
	
	@Override
	public void remove(int productId) {
		list.removeIf(item->item.getProductId() == productId);
	}
	
	@Override
	public List<Product> findAll(){
		return list;
	}
	@Override
	public void update(Product product) {
		for(int i = 0; i < list.size(); i++)
		{
			Product item = list.get(i);
			if (item.getProductId() == product.getProductId()) {
				list.set(i, product); //tiến hành update thông tin product
				break;
			}
		}
	}
}
