package com.cg.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bean.Cart;
import com.cg.bean.Product;
import com.cg.bean.User2;
import com.cg.bean.User3;

import com.cg.bean.Wishlist;
import com.cg.exception.InvalidInputException;
import com.cg.service.IProductService;

//Product Controller
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/products")
public class ProductController {
	
	
	
	//Creating object of IProductService
	@Autowired 
	IProductService service;
	
	//Display all Product, Generate a GET request on localhost:5000/products
	@GetMapping("/get")
	public List<Product> getall() {
		return service.getall();
	}
	
	
	//Add Product, Generate a Post request with body on localhost:5000/products/addProduct
	@PostMapping(value="/addProduct",consumes={"application/json"})
	public String addProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}
	
	//Display a particular Product, Generate a Get request with id as parameter on localhost:5000/products/"productId"
	@GetMapping(value="/{id}",produces= {"application/json"})
	public Product getById(@PathVariable int id) {
		System.out.println("springtest");
		return service.getProduct(id);
	}
	
	//Update a product information, Generate a Put request with body on localhost:5000/products/update
	@PutMapping(value="/update",consumes= {"application/json"})
	public String update(@RequestBody Product product) {
		service.update(product);
		return "Product Updated!";
	}
	//Delete a product, Generate a Delete request with id as parameter on localhost:5000/products/delete/"productId"
	@DeleteMapping(value="/delete/{id}")
	public String delete(@PathVariable int id) {
		service.delete(id);
		return "Product Deleted!";
	}
	
	@PostMapping(value= "/getWishlist",consumes= {"application/json"})
	public List<Product> getWishlist(@RequestBody User2 user2) {
		System.out.println("helo");
		 List<Product> wishList=null;
		try {
			wishList = service.getWishlist(user2.getUserId());
		} catch (InvalidInputException e) {
			return wishList;
		}
		
		return wishList;
	}
	@PostMapping(value= "/newwishlist",consumes= {"application/json"})
	public Wishlist addProductToWishlist(@RequestBody User3 user3) {
		System.out.println("wishlist");
		Wishlist val=null;
		try {
			 val=service.addProductToWishlist(user3.getUserId(),user3.getProductId());
		} catch (InvalidInputException e) {
			return val;
		}
		
		return val;
	}
	
	@PostMapping(value= "/remove",consumes= {"application/json"})
	public boolean removeProductFromWishlist(@RequestBody User3 user3) {
		boolean val;
		try {
			val=service.removeProductFromWishlist(user3.getUserId(),user3.getProductId());
		} catch (InvalidInputException e) {
			return false;
		}
		
		return val;
	}
	
	@PostMapping(value= "/NewCart", consumes= {"application/json"})
	 public Cart addProductToNewCart(@RequestBody User3 user3) {
		System.out.println("hello");
	 Cart cart=null;
	 try {
		 System.out.println("test");
	  cart= service.addProductToNewCart(user3.getUserId(),user3.getProductId());
	 }
	 catch (Exception e) {
	  return cart;
	 }
	 return cart;
	 }
	
	@PostMapping(value="/getCart",consumes= {"application/json"})
	public List<Product> getCart(@RequestBody User2 user2) {
		List<Product> cartList = null;
		try {
			cartList = service.getAllProductsFromCart(user2.getUserId());
		} catch (InvalidInputException e) {
			return cartList;
		}
		
		return cartList;
	}
	@PostMapping(value= "/removeCart",consumes= {"application/json"})
	public boolean removeProductFromCart(@RequestBody User3 user3) {
		boolean val;
		try {
			val=service.removeProductFromCart(user3.getUserId(),user3.getProductId());
		} catch (InvalidInputException e) {
			return false;
		}
		
		return val;
	}
	

	

}
