package org.example.studentservice.repository;

import org.example.studentservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByStudentCode(String studentCode);
    Optional<Student> findByEmail(String email);
}