package com.example.module12.service;

import com.example.module12.entity.Address;
import com.example.module12.payload.ApiResponse;
import com.example.module12.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServise {
    @Autowired
    AddressRepository addressRepository;
    public ApiResponse addAdress(Address address){
        Address address1=new Address();
        address1.setHomeNumber(address.getHomeNumber());
        address1.setStreet(address.getStreet());
        addressRepository.save(address1);w
        return new ApiResponse("saved",true);
    }


}
