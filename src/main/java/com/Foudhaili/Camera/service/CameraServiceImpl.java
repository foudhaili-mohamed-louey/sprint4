package com.Foudhaili.Camera.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.Foudhaili.Camera.Models.Camera;
import com.Foudhaili.Camera.Models.Lens;
import com.Foudhaili.Camera.dto.CameraDTO;
import com.Foudhaili.Camera.repos.CameraRepository;
import com.Foudhaili.Camera.repos.LensRepository;

@Service
public class CameraServiceImpl implements CameraService {

    @Autowired
    private CameraRepository cameraRepository;
    
    @Autowired
    private LensRepository lensRepository;
    
    @Autowired 
    ModelMapper modelMapper; 

    @Override
    public CameraDTO saveCamera(CameraDTO c) {
        return convertEntityToDto(cameraRepository.save(convertDtoToEntity(c)));
    }

    @Override
    public CameraDTO updateCamera(CameraDTO c) {
        return  convertEntityToDto(cameraRepository.save(convertDtoToEntity(c)));
    }

    @Override
    public void deleteCamera(Camera c) {
        cameraRepository.delete(c);
    }

    @Override
    public void deleteCameraById(int id) {
        cameraRepository.deleteById(id);
    }

    @Override
    public CameraDTO getCamera(int id) {
        
    	return convertEntityToDto(cameraRepository.findById(id).get());
    }

    @Override
    public List<CameraDTO> getAllCameras() {
    	return cameraRepository.findAll().stream() 
    		    .map(this::convertEntityToDto) 
    		    .collect(Collectors.toList()); 
    		   
    		  //OU BIEN 
    		  /*List<Camera> camss =  cameraRepository.findAll(); 
    		  List<CameraDTO> listcamsDto = new ArrayList<>(cams.size()); 
    		  for (Camera c : cams) 
    		   listcamsDto.add(convertEntityToDto(c)); 
    		  return listcams Dto;*/ 
    }

    @Override 
    public Page<Camera> getAllCamerasParPage(int page, int size) { 
        return cameraRepository.findAll(PageRequest.of(page, size)); 
    }

    @Override
    public List<Camera> findByName(String name) {
        return cameraRepository.findByName(name);
    }

    @Override
    public List<Camera> findByNameContains(String name) {
        return cameraRepository.findByNameContains(name);
    }

    @Override
    public List<Camera> findByTypeAndResolution(String type, Long resolution) {
        return cameraRepository.findByTypeAndResolution(type, resolution);
    }

    @Override
    public List<Camera> findByLens(Lens lens) {
        return cameraRepository.findByLens(lens);
    }

    @Override
    public List<Camera> findByLens_IdLens(int idLens) {
        return cameraRepository.findByLens_IdLens(idLens);
    }

    @Override
    public List<Camera> findByOrderByNameAsc() {
        return cameraRepository.findByOrderByNameAsc();
    }

	@Override
	public List<Lens> getAllLens() {
		
		return lensRepository.findAll();
	}
	@Override 
	public CameraDTO convertEntityToDto(Camera camera) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
	CameraDTO cameraDTO = modelMapper.map(camera, CameraDTO.class); 
	return cameraDTO;  
	} 

	@Override
	public Camera convertDtoToEntity(CameraDTO cameraDTO) {
	    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
	    return modelMapper.map(cameraDTO, Camera.class);
	}



}
