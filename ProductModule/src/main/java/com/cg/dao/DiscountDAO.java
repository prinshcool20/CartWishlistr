package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.bean.Discount;
import com.cg.bean.Product;


@Repository
public interface DiscountDAO extends JpaRepository<Discount, Integer>{
	
	@Query("select d.discount from Discount d where d.product=?1")
	public Integer checkDiscountOnProductById(Product product);

}