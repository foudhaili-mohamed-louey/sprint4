package com.Foudhaili.Camera.restcontrollers;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.CrossOrigin; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RestController;

import com.Foudhaili.Camera.Models.Camera;
import com.Foudhaili.Camera.service.CameraService; 

@RestController 
@RequestMapping("/api") 
@CrossOrigin 
public class CameraRESTController {
	@Autowired
	private CameraService cameraService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Camera> getAllCameras()
	{
		return cameraService.getAllCameras();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET) 
	public Camera getCameraById(@PathVariable("id") int id) {  
	return cameraService.getCamera(id); 
	}
	@RequestMapping(method = RequestMethod.POST) 
	public Camera createCamera(@RequestBody Camera cam) { 
	return cameraService.saveCamera(cam); 
	}
	@RequestMapping(method = RequestMethod.PUT) 
		public Camera updateCamera(@RequestBody Camera cam) { 
		return cameraService.updateCamera(cam); 
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE) 
	public void deleteCamera(@PathVariable("id") int id) 
	{ 
		cameraService.deleteCameraById(id); 
	} 
	@RequestMapping(value="/camslens/{idLens}",method = RequestMethod.GET) 
		public List<Camera> getProduitsByCatId(@PathVariable("idLens") int idLens) { 
		return cameraService.findByLens_IdLens(idLens); 
	}

}
