package com.example.module12.service;

import com.example.module12.entity.Company;
import com.example.module12.entity.Department;
import com.example.module12.payload.ApiResponse;
import com.example.module12.payload.DepartmentDto;
import com.example.module12.repositories.CompanyRepository;
import com.example.module12.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    public ResponseEntity<String> addDepartment(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setName(departmentDto.getName());
        Optional<Company> byId = companyRepository.findById(department.getId());
        if (!byId.isPresent()) return ResponseEntity.status(HttpStatus.CONFLICT).body("company not found");

        department.setCompany(byId.get());
        departmentRepository.save(department);
        return ResponseEntity.status(HttpStatus.CREATED).body("saved");
    }
}
