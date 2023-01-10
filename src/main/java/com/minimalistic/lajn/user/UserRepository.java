package com.minimalistic.lajn.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Override
	default List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}