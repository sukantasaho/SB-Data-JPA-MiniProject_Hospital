package com.main.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NonNull;

@Entity
@Table(name="ER_JPA_PATIENT")
@Data
public class Patient implements Serializable
{
	@SequenceGenerator(name = "patient_gen1", sequenceName = "PATIENT_SEQ1", initialValue = 50000, allocationSize = 1)
	@GeneratedValue(generator = "patient_gen1", strategy = GenerationType.SEQUENCE)
	@Id
    private Integer ss;
	
	@NonNull
    private String name;
	
	@NonNull
    private Integer age;
	@NonNull
    private String wardno;
	@NonNull
    private String insurance;
    
    @NonNull
    private LocalDate dateAdmitted;
    
    @NonNull
    private LocalDate dateCheckedOut;
    
    @ManyToOne(targetEntity = Doctor.class, cascade = CascadeType.ALL)
    @JoinColumn(name="doctorDss", referencedColumnName = "dss")
    private Doctor doctorDss;
    
    @OneToMany(targetEntity = Test.class, cascade = CascadeType.ALL, mappedBy = "patientInfo")
    private List<Test> testInfo;
}
