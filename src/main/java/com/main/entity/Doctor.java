package com.main.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="ER_JPA_DOCTOR")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Doctor implements Serializable
{
	@SequenceGenerator(name = "doc_gen1", sequenceName = "DOC_SEQ1", initialValue = 100000, allocationSize = 1)
	@GeneratedValue(generator = "doc_gen1", strategy = GenerationType.SEQUENCE)
	@Id
    private Integer dss;
	
	@NonNull
    private String name;
	@NonNull
    private String specialization;
    
    @OneToMany(targetEntity = Patient.class, cascade = CascadeType.ALL, mappedBy = "doctorDss")
    private List<Patient> patientInfo;
    
    @OneToMany(targetEntity = Test.class, cascade = CascadeType.ALL, mappedBy = "doctorInfo")
    private List<Test> testInfo;
}
