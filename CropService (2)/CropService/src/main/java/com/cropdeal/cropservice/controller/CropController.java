package com.cropdeal.cropservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cropdeal.cropservice.model.Crop;
import com.cropdeal.cropservice.resourse.CropServiceImpl;

@RestController
@RequestMapping("/crop")
public class CropController {

	@Autowired
	CropServiceImpl cropserviceimpl; 
	
	@GetMapping("/findcrops")
	public List<Crop> getcrop() {
    return cropserviceimpl.findAll();
	}
	  	 
	  @GetMapping("/getCropById/{id}")
	  public Optional<Crop> getcropById(@PathVariable int id){
	  return cropserviceimpl.getCropById(id);
	 }
	  
	  @PostMapping("/addcrop")
		public Crop addcrop(@RequestBody Crop crop) {
			return 	cropserviceimpl.addCrop(crop);
		}
	  
	  @PutMapping("/updatecrop")
	  public Crop updateCrop(@RequestBody Crop crop) {
		  return cropserviceimpl.updateCrop(crop);
	  }
	  
	  @DeleteMapping("/deletecrop/{id}")
		public String deletecrop(@PathVariable int id) {
		 cropserviceimpl.deleteById(id);
	    return "crop deleted having id " + id;
		}
}
