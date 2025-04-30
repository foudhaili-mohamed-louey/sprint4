package com.Foudhaili.Cameras.security;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.GetMapping; 

public class SecurityController {
	@GetMapping("/accessDenied") 
	public String error() 
	{ 
	return "accessDenied"; 
	} 

}
