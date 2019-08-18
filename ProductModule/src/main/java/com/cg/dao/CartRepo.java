package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bean.Cart;
import com.cg.bean.User1;





public interface CartRepo extends JpaRepository<Cart, Integer>{
	public Cart findByuser(User1 user);
}
