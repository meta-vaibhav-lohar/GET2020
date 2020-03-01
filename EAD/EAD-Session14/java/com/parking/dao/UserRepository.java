package com.parking.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByUsername(String userName);
}
