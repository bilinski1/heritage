package com.heritage.repository;

import java.util.List;
import java.util.Optional;

import com.heritage.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.heritage.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	Optional<UserEntity> findByEmail(String email);
	UserEntity findByRole(Role role);
	boolean existsByEmail(String email);


	//UserEntity findByEmail(String email);
	//User save(Optional<User> user);
	
	/*
	@Override
	default List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
		*/
	


}