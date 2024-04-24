package com.main.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="ER_JPA_TEST")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Test implements Serializable
{
	
	@SequenceGenerator(name = "test_gen1", sequenceName = "TEST_SEQ1", initialValue = 3000, allocationSize = 1)
	@GeneratedValue(generator = "test_gen1", strategy = GenerationType.SEQUENCE)
	@Id
    private Integer id;
	
	  @NonNull
      private String name;
      
    
      @NonNull
      private LocalDate testDate;
      
     
      @NonNull
      private LocalTime testTime;
      
      @NonNull
      private String result;
      
      @ManyToOne(targetEntity = Doctor.class, cascade = CascadeType.ALL)
      @JoinColumn(name="doctorDss", referencedColumnName = "dss")
      private Doctor doctorInfo;
      
      
      @ManyToOne(targetEntity = Patient.class, cascade = CascadeType.ALL)
      @JoinColumn(name="patientSS", referencedColumnName = "ss")
      private Patient patientInfo;
      
}
