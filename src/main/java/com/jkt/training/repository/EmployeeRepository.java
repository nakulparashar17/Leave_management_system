package com.jkt.training.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jkt.training.entity.Employees;

public interface EmployeeRepository extends JpaRepository<Employees, Integer> {

}
