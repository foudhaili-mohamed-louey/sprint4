package com.Foudhaili.Camera.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Foudhaili.Camera.Models.Role; 
 
public interface RoleRepository extends JpaRepository<Role, Long> { 
	Role findByRole(String role); 
}
