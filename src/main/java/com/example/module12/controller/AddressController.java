package com.example.module12.controller;

import com.example.module12.entity.Address;
import com.example.module12.payload.ApiResponse;
import com.example.module12.service.AddressServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    AddressServise addressServise;

    public ApiResponse add(@RequestBody Address address){
        ApiResponse apiResponse = addressServise.addAdress(address);
        return apiResponse;
    }
}
