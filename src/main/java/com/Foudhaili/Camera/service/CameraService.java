package com.Foudhaili.Camera.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.Foudhaili.Camera.Models.Camera;
import com.Foudhaili.Camera.Models.Lens;

public interface CameraService {

	  
		  Camera saveCamera(Camera c); 
		  Camera updateCamera(Camera c); 
		  void deleteCamera(Camera c); 
		  void deleteCameraById(int id); 
		  Camera getCamera(int id); 
		  List<Camera> getAllCameras(); 
		  Page<Camera> getAllCamerasParPage(int page, int size); 
		  List<Camera> findByName(String name);
	  	List<Camera> findByNameContains(String name);
		List<Camera> findByTypeAndResolution(@Param("type") String type,@Param("resolution") Long resolution);
		List<Camera> findByLens(Lens lens);
		List<Camera> findByLens_IdLens(int idLens);
		List<Camera> findByOrderByNameAsc();
		
		
		List<Lens> getAllLens();

}

