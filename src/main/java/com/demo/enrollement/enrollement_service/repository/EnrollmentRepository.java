package com.demo.enrollement.enrollement_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.enrollement.enrollement_service.entity.Enrollement;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollement, Long> {
}