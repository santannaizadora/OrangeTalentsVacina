package com.orangetalents.controller;


import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.orangetalents.entity.Vaccination;
import com.orangetalents.service.VaccinationService;

@RestController
@RequestMapping("/vaccinations")
public class VaccinationController {
	
	@Autowired
	private VaccinationService vaccinationService;

	@PostMapping
	public ResponseEntity<Void> save(@RequestBody Vaccination dto) {
		
		Vaccination vaccination = this.vaccinationService.save(	dto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vaccination.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

}
