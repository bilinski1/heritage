package com.heritage.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.heritage.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	List<UserEntity> findByEmail(String email);
	Optional<UserEntity> findById(String id);

	//User save(Optional<User> user);
	
	/*
	@Override
	default List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
		*/
	


}