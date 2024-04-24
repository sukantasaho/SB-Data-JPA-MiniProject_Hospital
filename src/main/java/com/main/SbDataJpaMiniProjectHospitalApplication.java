package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.main.services.IHospitalOTMServiceManagement;

@SpringBootApplication
public class SbDataJpaMiniProjectHospitalApplication 
{

	public static void main(String[] args) 
	{
		  ApplicationContext ctx = SpringApplication.run(SbDataJpaMiniProjectHospitalApplication.class, args);
		  IHospitalOTMServiceManagement service = ctx.getBean("hospitalService", IHospitalOTMServiceManagement.class);
		  service.saveDataByUsingDoctor();
		  
		  ((ConfigurableApplicationContext) ctx).close();
	}

}
