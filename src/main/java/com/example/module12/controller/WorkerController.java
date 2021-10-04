package com.example.module12.controller;

import com.example.module12.payload.WorkerDto;
import com.example.module12.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/worker")
public class WorkerController {
@Autowired
    WorkerService workerService;
    public ResponseEntity<String> addWorker(@RequestBody WorkerDto workerDto){
        ResponseEntity<String> apiResponse = workerService.addWorker(workerDto);
        return apiResponse;


    }
}
