package com.orangetalents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orangetalents.entity.Vaccination;

@Repository
public interface VaccinationRepository extends JpaRepository<Vaccination, Integer> {
 
}

