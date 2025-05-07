package com.Foudhaili.Camera;

import java.text.SimpleDateFormat;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.Foudhaili.Camera.Models.Camera;
import com.Foudhaili.Camera.Models.Role;
import com.Foudhaili.Camera.Models.User;
import com.Foudhaili.Camera.service.CameraService;
import com.Foudhaili.Camera.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class CameraApplication implements CommandLineRunner {
	
	@Lazy
	@Autowired
	private CameraService cameraService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserService userService;
	
	@Bean 
	public ModelMapper modelMapper() 
	{ 
	return new ModelMapper(); 
	} 
	
	
	
	
	/* @PostConstruct 
	 void init_users() { 
	  //ajouter les rôles 
	  userService.addRole(new Role(null,"ADMIN")); 
	  userService.addRole(new Role(null,"AGENT")); 
	  userService.addRole(new Role(null,"USER")); 
	   
	  //ajouter les users 
	  userService.saveUser(new User(null,"admin","123",true,null)); 
	  userService.saveUser(new User(null,"nadhem","123",true,null)); 
	  userService.saveUser(new User(null,"user1","123",true,null)); 
	   
	  //ajouter les rôles aux users 
	  userService.addRoleToUser("admin", "ADMIN"); 
	   
	  userService.addRoleToUser("nadhem", "USER"); 
	  userService.addRoleToUser("nadhem", "AGENT"); 
	   
	  userService.addRoleToUser("user1", "USER");   
	 }*/
	
	@Autowired 
	private RepositoryRestConfiguration repositoryRestConfiguration; 
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) {
		SpringApplication.run(CameraApplication.class, args);
	}
	@Override 
	public void run(String... args) throws Exception { 
		/*cameraService.saveCamera(new Camera("Bridge", "Nikon Coolpix P1000", 16000000L, sdf.parse("2025-12-31")));  
		cameraService.saveCamera(new Camera("Compact", "Panasonic Lumix ZS200", 20000000L, sdf.parse("2026-06-15")));  
		cameraService.saveCamera(new Camera("Cinema", "Blackmagic Pocket 6K", 61400000L, sdf.parse("2027-03-10")));  
		 */
		//  System.out.println("Password Encoded BCRYPT :******************** "); 
	     //  System.out.println(passwordEncoder.encode("123"));
		repositoryRestConfiguration.exposeIdsFor(Camera.class);
	}

}
