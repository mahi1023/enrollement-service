package com.demo.enrollement.enrollement_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.enrollement.enrollement_service.entity.Enrollement;
import com.demo.enrollement.enrollement_service.service.EnrollmentService;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollementController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<Enrollement> enrollStudent(@RequestBody Enrollement enrollment) {
        Enrollement savedEnrollment = enrollmentService.saveEnrollment(enrollment);
        return ResponseEntity.status(201).body(savedEnrollment);
    }

    @GetMapping
    public ResponseEntity<List<Enrollement>> getAllEnrollments() {
        List<Enrollement> enrollments = enrollmentService.getAllEnrollments();
        return ResponseEntity.ok(enrollments);
    }
}