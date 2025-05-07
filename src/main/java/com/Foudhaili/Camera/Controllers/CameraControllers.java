package com.Foudhaili.Camera.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.Foudhaili.Camera.Models.Camera;
import com.Foudhaili.Camera.Models.Lens;
import com.Foudhaili.Camera.dto.CameraDTO;
import com.Foudhaili.Camera.service.CameraService;

import jakarta.validation.Valid;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class CameraControllers {

    @Autowired
    private CameraService cameraService;

    @RequestMapping("/ListeCamera")
    public String listeCameras(ModelMap modelMap,
                               @RequestParam(name = "page", defaultValue = "0") int page,
                               @RequestParam(name = "size", defaultValue = "2") int size) {
        Page<Camera> cams = cameraService.getAllCamerasParPage(page, size);
        modelMap.addAttribute("cameras", cams);
        modelMap.addAttribute("pages", new int[cams.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size); 
        return "listeCameras";
    }

    @RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap) {
    	List<Lens> lens = cameraService.getAllLens();
    	modelMap.addAttribute("camera",new Camera());
    	modelMap.addAttribute("mode","new");
    	modelMap.addAttribute("lenses",lens);
        return "formCamera";
    }

    @RequestMapping("/saveCamera")
    public String saveProduit(@Valid Camera camera,
                              BindingResult bindingResult,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              @RequestParam(name = "size", defaultValue = "2") int size) {
        boolean isNew = (camera.getId() == 0);

        if (bindingResult.hasErrors()) return "formCamera";

        cameraService.saveCamera(camera);

        int redirectPage;
        if (isNew) {
            Page<Camera> cams = cameraService.getAllCamerasParPage(0, size);
            int totalElements = (int) cams.getTotalElements() + 1;
            redirectPage = (totalElements - 1) / size;
        } else {
            redirectPage = page;
        }

        return "redirect:/ListeCamera?page=" + redirectPage + "&size=" + size;
    }
    	
 

    @RequestMapping("/supprimerCamera")
    public String supprimerCamera(@RequestParam("id") int id,
                                   @RequestParam(name = "page", defaultValue = "0") int page,
                                   @RequestParam(name = "size", defaultValue = "2") int size,
                                   ModelMap modelMap) {
        cameraService.deleteCameraById(id);
        Page<Camera> cams = cameraService.getAllCamerasParPage(page, size);
        modelMap.addAttribute("cameras", cams);
        modelMap.addAttribute("pages", new int[cams.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeCameras";
    }

    @RequestMapping("/modifierCamera")
    public String editerCamera(@RequestParam("id") int id, ModelMap modelMap ) {
        CameraDTO c = cameraService.getCamera(id);
        List<Lens> lens = cameraService.getAllLens();
        modelMap.addAttribute("camera", c);
        modelMap.addAttribute("lenses",lens);
        modelMap.addAttribute("mode","edit");
        return "formCamera";
    }

    @RequestMapping("/updateCamera")
    public String updateProduit(@Valid @ModelAttribute("camera") Camera camera,
                                BindingResult bindingResult,
                                @RequestParam(name = "page", defaultValue = "0") int page,
                                @RequestParam(name = "size", defaultValue = "2") int size,
                                ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            List<Lens> lens = cameraService.getAllLens();
            modelMap.addAttribute("lenses", lens);
            modelMap.addAttribute("mode", "edit");
            return "formCamera";
        }

        cameraService.updateCamera(camera);
        List<CameraDTO> allCams = cameraService.getAllCameras();
        int index = -1;
        for (int i = 0; i < allCams.size(); i++) {
            if (allCams.get(i).getId() == camera.getId()) {
                index = i;
                break;
            }
        }
        int redirectPage = (index != -1) ? (index / size) : page;

        return "redirect:/ListeCamera?page=" + redirectPage + "&size=" + size;
    }
    @GetMapping(value = "/") 
    public String welcome() { 
    	return "index"; 
    } 
    

}
