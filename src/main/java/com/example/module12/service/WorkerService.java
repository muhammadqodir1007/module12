package com.example.module12.service;

import com.example.module12.entity.Address;
import com.example.module12.entity.Department;
import com.example.module12.entity.Worker;
import com.example.module12.payload.WorkerDto;
import com.example.module12.repositories.AddressRepository;
import com.example.module12.repositories.DepartmentRepository;
import com.example.module12.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkerService {


    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    AddressRepository addressRepository;


    public ResponseEntity<String> addWorker(WorkerDto workerDto) {
        Worker worker = new Worker();
        worker.setName(workerDto.getName());
        worker.setPhoneNumber(workerDto.getPhoneNumber());
        Optional<Department> departmentRepositoryById = departmentRepository.findById(workerDto.getDepartmentId());
        if (!departmentRepositoryById.isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT).body("department not found");
        worker.setDepartment(departmentRepositoryById.get());
        Optional<Address> addressRepositoryById = addressRepository.findById(workerDto.getAddressId());
        if (!addressRepositoryById.isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT).body("address not found");
        worker.setAddress(addressRepositoryById.get());
        workerRepository.save(worker);
        return ResponseEntity.status(HttpStatus.CREATED).body("created");
    }

}
