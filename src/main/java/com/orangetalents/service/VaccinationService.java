package com.orangetalents.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangetalents.entity.User;
import com.orangetalents.entity.Vaccination;
import com.orangetalents.repository.UserRepository;
import com.orangetalents.repository.VaccinationRepository;
import com.orangetalents.service.exception.NotFoundException;

@Service
public class VaccinationService {
 
		@Autowired
		private VaccinationRepository vaccinationRepository;
		
		@Autowired
		private UserRepository userRepository;
	
		public Vaccination save(Vaccination dto) {
			Optional<User> user = this.userRepository.findByEmail(dto.getUserEmail());
			if(user.isEmpty()) 
				throw new NotFoundException("User with email " + dto.getUserEmail() + " not found");

			dto.setId(null);
			Vaccination vaccinationToSave = this.fromDto(dto);
	
			return this.vaccinationRepository.save(vaccinationToSave);
					
		}

		public Vaccination fromDto(Vaccination vaccination) {
			return new Vaccination(vaccination.getId(), vaccination.getVaccineName(), vaccination.getUserEmail(), vaccination.getVaccinationDate());
		}
	
}