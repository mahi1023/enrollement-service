package com.demo.enrollement.enrollement_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.enrollement.enrollement_service.entity.Enrollement;
import com.demo.enrollement.enrollement_service.repository.EnrollmentRepository;

@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public Enrollement saveEnrollment(Enrollement enrollment) {
        return enrollmentRepository.save(enrollment);
    }
    
    public List<Enrollement> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }
}
