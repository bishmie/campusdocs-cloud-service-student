package org.example.studentservice.service;

import org.example.studentservice.entity.Student;
import org.example.studentservice.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(id).orElse(null);

        if (existingStudent == null) {
            return null;
        }

        existingStudent.setStudentCode(updatedStudent.getStudentCode());
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setDepartment(updatedStudent.getDepartment());

        return studentRepository.save(existingStudent);
    }

    public boolean deleteStudent(Long id) {
        Student existingStudent = studentRepository.findById(id).orElse(null);

        if (existingStudent == null) {
            return false;
        }

        studentRepository.deleteById(id);
        return true;
    }
}