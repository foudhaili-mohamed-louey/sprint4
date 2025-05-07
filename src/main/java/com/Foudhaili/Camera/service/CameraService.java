package com.Foudhaili.Camera.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.Foudhaili.Camera.Models.Camera;
import com.Foudhaili.Camera.Models.Lens;
import com.Foudhaili.Camera.dto.CameraDTO;

public interface CameraService {

	  
		  CameraDTO saveCamera(CameraDTO c); 
		  CameraDTO getCamera(int id); 
		  List<CameraDTO> getAllCameras(); 
		  
			
		  
		  
		  
		  CameraDTO updateCamera(CameraDTO c);
		  
		  
		  void deleteCamera(Camera c); 
		  void deleteCameraById(int id); 
		   
		  Page<Camera> getAllCamerasParPage(int page, int size); 
		  List<Camera> findByName(String name);
	  	List<Camera> findByNameContains(String name);
		List<Camera> findByTypeAndResolution(@Param("type") String type,@Param("resolution") Long resolution);
		List<Camera> findByLens(Lens lens);
		List<Camera> findByLens_IdLens(int idLens);
		List<Camera> findByOrderByNameAsc();
		
		
		List<Lens> getAllLens();
		CameraDTO convertEntityToDto (Camera camera);
		Camera convertDtoToEntity(CameraDTO produitDto); 
		
	

}

