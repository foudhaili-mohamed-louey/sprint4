package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.Foudhaili.Camera.CameraApplication;
import com.Foudhaili.Camera.Models.Camera;
import com.Foudhaili.Camera.Models.Lens;
import com.Foudhaili.Camera.repos.CameraRepository;
import com.Foudhaili.Camera.service.CameraService;

@SpringBootTest(classes = CameraApplication.class)
class CameraApplicationTests {

	@Autowired
	private CameraRepository cameraRepository;
	@Autowired
	private CameraService cameraService;

	@Test
	public void testCreateCamera() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date expiryDate = sdf.parse("2025-12-31");

		Camera cam = new Camera("Nikon", "Z6", 77L, expiryDate);
		cameraRepository.save(cam);
	}

	@Test
	public void testFindCamera() {
		Camera c = cameraRepository.findById(1).get();
		System.out.println(c);
	}

	@Test
	public void testUpdateCamera() {
		Camera c = cameraRepository.findById(2).get();
		c.setName("z7");
		cameraRepository.save(c);
	}

	@Test
	public void testDeleteCamera() {
		cameraRepository.deleteById(2);

	}

	@Test
	public void testListerTousCameras() {
		List<Camera> cams = cameraRepository.findAll();
		for (Camera c : cams) {
			System.out.println(c);
		}
	}

	@Test
	public void testFindByNomCameraContains() {
		Page<Camera> prods = cameraService.getAllCamerasParPage(0, 2);
		System.out.println(prods.getSize());
		System.out.println(prods.getTotalElements());
		System.out.println(prods.getTotalPages());

		prods.getContent().forEach(p -> {
			System.out.println(p.toString());
		});
		/*
		 * ou bien for (Produit p : prods) { System.out.println(p); }
		 */
	}

	@Test
	public void testFindByNomProduit() {
		List<Camera> cams = cameraRepository.findByName("Nikon Coolpix P1000");
		for (Camera c : cams) {
			System.out.println(c);
		}

	}

	@Test
	public void testFindByNomProduitContains() {
		List<Camera> cams = cameraRepository.findByNameContains("GoPro");
		for (Camera c : cams) {
			System.out.println(c);
		}
	}

	@Test
	public void findByTypeAndResolution() {
		List<Camera> cams = cameraRepository.findByTypeAndResolution("Panasonic Lumix ZS200", 20000000L);
		for (Camera c : cams) {
			System.out.println(c);
		}
	}

	@Test
	public void testfindByLens() {
		Lens lens1 = new Lens();
		lens1.setIdLens(1);
		List<Camera> cams = cameraRepository.findByLens(lens1);
		for (Camera p : cams) {
			System.out.println(p);
		}
	}
	@Test
	public void testFindByLensId() {
	    List<Camera> cameras = cameraRepository.findByLens_IdLens(1);
	    for (Camera cam : cameras) {
	        System.out.println(cam);
	    }
	}
	@Test
	public void testFindByOrderByNameAsc() {
	    List<Camera> cameras = cameraRepository.findByOrderByNameAsc();
	    for (Camera cam : cameras) {
	        System.out.println(cam);
	    }
	}

}