package com.cropdeal.dealerservice.resource;

import java.util.Arrays;
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
import org.springframework.web.client.RestTemplate;

import com.cropdeal.dealerservice.models.Crop;
import com.cropdeal.dealerservice.models.Dealer;
import com.cropdeal.dealerservice.repository.DealerRepository;
import com.cropdeal.dealerservice.service.DealerService;

@RestController
@RequestMapping("/dealer")
public class DealerResource {
	@Autowired
	private DealerRepository DealerRepo;

	@Autowired
	DealerService dealerService;
	
	@Autowired
	private RestTemplate restTemp;

	@PostMapping("/adddealer")
	public Dealer adddealer(@RequestBody Dealer dealer) {
		return dealerService.addDealer(dealer);
	}
	
	@PutMapping("/updatedealer")
	public Dealer updatedealer(@RequestBody Dealer dealer) {
		return dealerService.updateDealer(dealer );
	}

	@GetMapping("/finddealer")
	public List<Dealer> getdealer() {
		return dealerService.findAll();
	}

	@GetMapping("/getdealer/{id}")
	public Optional<Dealer> getdealer(@PathVariable String id) {
		return dealerService.getdealerById(id);
	}
	
	@DeleteMapping("/deletedealer/{id}")
	public String deleteDealer(@PathVariable String id) {
		return dealerService.deleteById(id);
	}

	
	// Dealer access to crop
	@GetMapping("/getcrop")
	public List<Crop> getCropatFarmer() {
		Crop[] crop = restTemp.getForObject("http://cropservice/crop/findcrops", Crop[].class);
		return Arrays.asList(crop);
	}
}
