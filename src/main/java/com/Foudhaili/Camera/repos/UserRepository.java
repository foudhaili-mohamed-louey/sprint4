package com.Foudhaili.Camera.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Foudhaili.Camera.Models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}