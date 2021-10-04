package com.example.module12.controller;

import com.example.module12.payload.ApiResponse;
import com.example.module12.payload.CompanyDto;
import com.example.module12.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @PostMapping
    public ResponseEntity<ApiResponse> addCompany(@RequestBody CompanyDto companyDto){
        ResponseEntity<String> entity = companyService.addCompanies(companyDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("dfrfr",true));



    }
}
