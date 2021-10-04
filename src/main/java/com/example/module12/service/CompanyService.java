package com.example.module12.service;

import com.example.module12.entity.Address;
import com.example.module12.entity.Company;
import com.example.module12.payload.CompanyDto;
import com.example.module12.repositories.AddressRepository;
import com.example.module12.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    AddressRepository addressRepository;

    public ResponseEntity<String> addCompanies(CompanyDto companyDto) {
        Company company = new Company();
        company.setCorpName(companyDto.getCorpName());
        company.setDirectorName(companyDto.getDirectorName());
        Address address = new Address();
        Optional<Address> optionalAddress = addressRepository.findById(companyDto.getAddressId());
        if (!optionalAddress.isPresent())
            return ResponseEntity.status(HttpStatus.MULTI_STATUS).body("address not found");
        company.setAddress(optionalAddress.get());
        companyRepository.save(company);
        return ResponseEntity.status(HttpStatus.CREATED).body("successfully saved");


    }
}
