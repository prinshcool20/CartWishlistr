package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cg.bean.Cart;
import com.cg.bean.Product;
import com.cg.bean.User1;
import com.cg.bean.Wishlist;
import com.cg.dao.CartRepo;

import com.cg.dao.IProductRepo;
import com.cg.dao.User1Repo;
import com.cg.dao.WishlistRepo;
import com.cg.exception.ApplicationException;
import com.cg.exception.InvalidInputException;
import com.cg.exception.ProductUnavailableException;

@Service
@Transactional
public class IProductServiceImpl implements IProductService{

	User1 user;
//	Review review;
	Product product;
	
	Cart cart;

	@Autowired
	private User1Repo customerRepo;

	@Autowired
	private CartRepo cartRepo;
	
	

//	@Autowired
//	private AddressRepo addressRepo;

	@Autowired
	private WishlistRepo wishlistRepo;

	
	
	
	
	@Autowired IProductRepo productRepo;
	
	@Transactional(readOnly=true)
	public List<Product> getall() {
		if(productRepo.findAll().isEmpty()) {
			throw new ApplicationException("No Products Exist");
		}
		return productRepo.findAll();
	}
	@Transactional
	public String addProduct(Product p) {
		if(productRepo.existsById(p.getProductID())) {
			throw new ApplicationException("Product Already Exists");
		}
		else {
			productRepo.save(p);
			return "Product Added";
			}
	}

	@Override
	public Product getProduct(int productID) {

	 return productRepo.getProduct(productID);

	}

		@Transactional(readOnly=true)
	public Product getById(int id) {
		Optional<Product> product=productRepo.findById(id);
		if(product.isPresent()) {
			return product.get();
		}
		else {
			throw new ApplicationException("No Product Exists");
		}
	}
	@Transactional
	public String update(Product p) {
		this.delete(p.getProductID());
		this.addProduct(p);
		return "Product Updated";
	}
	@Transactional
	public String delete(int id) {
		productRepo.delete(this.getById(id));
		 return "Product Deleted";
	}
	
	
	@Override
	public Wishlist addProductToWishlist(int userId, int productId) throws InvalidInputException {

		 product = productRepo.getOne(productId);
		  user =customerRepo.getOne(userId);

		 Wishlist wishlist1= wishlistRepo.findByuser(user);
		 
		  if(wishlist1==null)
		  {
			  Wishlist wishlist = new Wishlist();
			  System.out.println("Inside if");
		  List<Product> products = new ArrayList<Product>();
		  products.add(product);
		wishlist.setUser(user);
		 wishlist.setProducts(products);
		System.out.println(wishlist.getProducts());
		  wishlist.setName("My Wishlist");;
		  return wishlistRepo.save(wishlist);
		  }
		  else
		  {
		  List<Product> productList = new ArrayList<Product>();
		  productList=wishlist1.getProducts();
		  productList.add(product); 
		  wishlist1.setProducts(productList); 
		  System.out.println(wishlist1.getProducts());
		  return wishlistRepo.save(wishlist1);
		  }
		  
	}
	
	@Override
	public boolean removeProductFromWishlist(int userId, int productId) throws InvalidInputException {
		product = productRepo.getOne(productId);
		user = customerRepo.findByuserId(userId);
		Wishlist wishlist = wishlistRepo.findByuser(user);
		List<Product> productsList = wishlist.getProducts();
		productsList.remove(product);
		wishlist.setProducts(productsList);
		//Wishlist w=new Wishlist();
		//product.setWishlist(null);
		wishlistRepo.save(wishlist);
		return true;
	}
	
	@Override
	public List<Product> getWishlist(int userId) throws InvalidInputException {
		Wishlist wishlist = new Wishlist();
		try {
			user = customerRepo.findByuserId(userId);
			wishlist = wishlistRepo.findByuser(user);
		} catch (Exception e) {
			e.getMessage();
		}
		return wishlist.getProducts();
	}


	@Override
	public Cart addProductToNewCart(int userId, int productId)
			throws ProductUnavailableException {

		 product = productRepo.getOne(productId);
		  user =customerRepo.getOne(userId);

		 Cart cart1= cartRepo.findByuser(user);
		 
		  if(cart1==null)
		  {
			  Cart cart = new Cart();
			  System.out.println("Inside if");
		  List<Product> products = new ArrayList<Product>();
		  products.add(product);
		  System.out.println(products);
		  cart.setUser(user);
		  System.out.println("hhh");
		 cart.setProducts(products);
		 System.out.println("hello");
		  cart.setAmount(product.getPrice());
		  return cartRepo.save(cart);
		  }
		  else
		  {
			 
			  System.out.println("hello");
		  List<Product> productList = new ArrayList<Product>();
		  productList=cart1.getProducts();
		  productList.add(product);
		  System.out.println("hello2");
		  System.out.println(productList);
		  
		  cart1.setProducts(productList);
		 
		  cart1.setAmount(cart1.getAmount()+product.getPrice());
		
		  return cartRepo.save(cart1);
		  }
		  
		  

	}
	@Override
	public List<Product> getAllProductsFromCart(int userId) throws InvalidInputException {
		Cart cart;

		user = customerRepo.getOne(userId);
		cart = cartRepo.findByuser(user);
		
		return cart.getProducts();
		
	}
	@Override
	public boolean removeProductFromCart(int userId, int productId)  throws InvalidInputException {
		Product product = productRepo.getOne(productId);
		user = customerRepo.getOne(userId);
		Cart cart = cartRepo.findByuser(user);
		List<Product> productlist = cart.getProducts();
		productlist.remove(product);
		cart.setAmount(cart.getAmount()-product.getPrice());
		cart.setProducts(productlist);
		 cartRepo.save(cart);
		 return true;
		}
	
	
	}
