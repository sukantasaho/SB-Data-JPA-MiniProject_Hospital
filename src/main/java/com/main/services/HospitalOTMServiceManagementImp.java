package com.main.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.hibernate.type.descriptor.java.LocalDateJavaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.Doctor;
import com.main.entity.Patient;
import com.main.entity.Test;
import com.main.repository.IDoctorRepository;
import com.main.repository.IPatientRepository;
import com.main.repository.ITestRepository;

@Service("hospitalService")
public class HospitalOTMServiceManagementImp implements IHospitalOTMServiceManagement 
{

	@Autowired
	private IDoctorRepository dRepo;
	@Autowired
	private IPatientRepository pRepo;
	@Autowired
	private ITestRepository tRepo;
	
	@Override
	public void saveDataByUsingDoctor()
	{
		 Doctor d1 = new Doctor("Dr. SK Burma","Nurology");
		
		 LocalDate admittedDate = LocalDate.now();
		 LocalDate checkedDate = LocalDate.now();
		 
		 Patient p1 = new Patient("Rajendra Sahoo",23,"D4","Premium",admittedDate.now(),checkedDate.now().of(2023, 12, 17));
		
		 Test t1 = new Test("MRI",LocalDate.now(),LocalTime.now(),"Test Is Normal");
		 Test t2 = new Test("Androscopy",LocalDate.now(),LocalTime.now(),"Test Is Normal");
		 t1.setDoctorInfo(d1);
		 t1.setPatientInfo(p1);
		 t2.setDoctorInfo(d1);
		 t2.setPatientInfo(p1);
		 
		  
		 p1.setTestInfo(List.of(t1, t2));
		 p1.setDoctorDss(d1);
		
		 Patient p2 = new Patient("Amrita Sahoo",29,"D3","Super Premium",admittedDate.now(),checkedDate.now().of(2023, 12, 22));
		 
		 Test t3 = new Test("CT Scan",LocalDate.now(),LocalTime.now(),"Test Is Ab-Normal");
		 Test t4 = new Test("Androscopy",LocalDate.now(),LocalTime.now(),"Test Is Sevior");
		 t3.setDoctorInfo(d1);
		 t3.setPatientInfo(p2);
		 t4.setDoctorInfo(d1);
		 t4.setPatientInfo(p2);
		 p2.setTestInfo(List.of(t3, t4));
		 p2.setDoctorDss(d1);
		 
		 d1.setPatientInfo(List.of(p1, p2));
		 d1.setTestInfo(List.of(t1, t2,t3,t4));
		 
		 
		 dRepo.save(d1);
		 System.out.println("Doctor record and related associated Patient and Test object saved(Parent to child)");

	}

}
