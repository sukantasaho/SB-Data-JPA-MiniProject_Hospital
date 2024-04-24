package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.Patient;

public interface IPatientRepository extends JpaRepository<Patient, Integer> 
{
     
}
