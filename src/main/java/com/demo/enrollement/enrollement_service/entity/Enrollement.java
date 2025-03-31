package com.demo.enrollement.enrollement_service.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "enrollements")
public class Enrollement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;
    private Long courseId;
    private LocalDateTime enrolledAt = LocalDateTime.now();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public LocalDateTime getEnrolledAt() {
		return enrolledAt;
	}
	public void setEnrolledAt(LocalDateTime enrolledAt) {
		this.enrolledAt = enrolledAt;
	}
	@Override
	public String toString() {
		return "Enrollement [id=" + id + ", studentName=" + studentName + ", courseId=" + courseId + ", enrolledAt="
				+ enrolledAt + "]";
	}
    
    
    
}