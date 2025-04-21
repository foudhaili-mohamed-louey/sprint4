package com.Foudhaili.Camera.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.Foudhaili.Camera.Models.Camera;
import com.Foudhaili.Camera.Models.Lens;
import com.Foudhaili.Camera.repos.CameraRepository;
import com.Foudhaili.Camera.repos.LensRepository;

@Service
public class CameraServiceImpl implements CameraService {

    @Autowired
    private CameraRepository cameraRepository;
    
    @Autowired
    private LensRepository lensRepository;

    @Override
    public Camera saveCamera(Camera c) {
        return cameraRepository.save(c);
    }

    @Override
    public Camera updateCamera(Camera c) {
        return cameraRepository.save(c);
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
    public Camera getCamera(int id) {
        Optional<Camera> camera = cameraRepository.findById(id);
        return camera.orElse(null);
    }

    @Override
    public List<Camera> getAllCameras() {
        return cameraRepository.findAll();
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
}
