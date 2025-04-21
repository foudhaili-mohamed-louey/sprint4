package com.Foudhaili.Camera;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.Foudhaili.Camera.Models.Camera;
import com.Foudhaili.Camera.service.CameraService;

@SpringBootApplication
public class CameraApplication implements CommandLineRunner {
	@Autowired
	private CameraService cameraService;
	
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
		repositoryRestConfiguration.exposeIdsFor(Camera.class);
	}

}
