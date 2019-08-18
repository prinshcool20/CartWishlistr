package com.cg.service;

import java.util.List;

import com.cg.bean.Cart;
import com.cg.bean.Product;
import com.cg.bean.Wishlist;
import com.cg.exception.InvalidInputException;
import com.cg.exception.ProductUnavailableException;

public interface IProductService {
	public List<Product> getall();
	public String addProduct(Product p);
	public Product getById(int id);
	public Product getProduct(int productId);
	public String update(Product p);
	public String delete(int id);
	
	public Wishlist addProductToWishlist(int userId,int productId) throws InvalidInputException;

	public boolean removeProductFromWishlist(int userId,int productId) throws InvalidInputException;

	public List<Product> getWishlist(int userId) throws InvalidInputException;


	Cart addProductToNewCart(int userId,int productId) throws ProductUnavailableException;
	
	List<Product> getAllProductsFromCart(int userId) throws InvalidInputException;
	
	public boolean removeProductFromCart(int userId,int productId)  throws InvalidInputException;
	
	
}
