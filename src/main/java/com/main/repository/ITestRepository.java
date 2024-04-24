package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

 
import com.main.entity.Test;

public interface ITestRepository extends JpaRepository<Test, Integer> 
{

}
