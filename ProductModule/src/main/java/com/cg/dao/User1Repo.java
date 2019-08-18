package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bean.User1;





public interface User1Repo extends JpaRepository<User1, Integer>{

	public User1 findByuserId(int userId);

}
