package com.heritage.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.heritage.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	UserEntity findByEmail(String email);
	UserEntity findById(String id);
	//UserEntity findByEmail(String email);
	

	//User save(Optional<User> user);
	
	/*
	@Override
	default List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
		*/
	


}