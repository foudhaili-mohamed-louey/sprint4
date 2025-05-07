package com.Foudhaili.Camera.service;

import com.Foudhaili.Camera.Models.Role;
import com.Foudhaili.Camera.Models.User;

public interface UserService {
	void deleteAllusers();

	void deleteAllRoles();

	User saveUser(User user);

	User findUserByUsername(String username);

	Role addRole(Role role);

	User addRoleToUser(String username, String rolename);

}
