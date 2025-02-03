package com.heritage.repository;

import java.util.Optional;
import java.util.UUID;

import com.heritage.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.heritage.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
	User findByRole(Role role);
	User findByPublicId(String publicId);
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