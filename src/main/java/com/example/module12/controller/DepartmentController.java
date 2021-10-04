package com.example.module12.controller;

import com.example.module12.payload.DepartmentDto;
import com.example.module12.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @PostMapping
    public ResponseEntity<String> addDepartment(@RequestBody DepartmentDto departmentDto){
        ResponseEntity<String> apiResponse = departmentService.addDepartment(departmentDto);
        return apiResponse;
    }
}
