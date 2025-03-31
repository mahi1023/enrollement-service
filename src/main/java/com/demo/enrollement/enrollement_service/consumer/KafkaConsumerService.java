package com.demo.enrollement.enrollement_service.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.enrollement.enrollement_service.entity.Enrollement;
import com.demo.enrollement.enrollement_service.service.EnrollmentService;

@Service
public class KafkaConsumerService {
	@Autowired
    private EnrollmentService enrollmentService;

    @KafkaListener(topics = "course-enrollment", groupId = "enrollment-group")
    public void listen(String message) {
        try {
            String[] parts = message.split(" ");
            String studentName = parts[0];
            Long courseId = Long.parseLong(parts[parts.length - 1]);

            // Since the Course Service already validated the course before publishing,
            // we trust Kafka messages to contain only valid course IDs.
            Enrollement enrollment = new Enrollement();
            enrollment.setStudentName(studentName);
            enrollment.setCourseId(courseId);
            enrollmentService.saveEnrollment(enrollment);
            System.out.println("✅ Enrollment saved from Kafka: " + message);
        } catch (Exception e) {
            System.err.println("❌ Error processing Kafka message: " + e.getMessage());
        }
    }
}
