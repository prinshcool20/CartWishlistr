package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.cg.bean.User1;
import com.cg.bean.Wishlist;



public interface WishlistRepo extends JpaRepository<Wishlist, Integer>,CrudRepository<Wishlist, Integer>{

	public Wishlist findByuser(User1 user);
}
