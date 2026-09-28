package com.buspass.studentbuspass.Service;

import com.buspass.studentbuspass.Repository.StudentRepository;
import com.buspass.studentbuspass.entity.StudentEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    public StudentEntity getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public StudentEntity saveStudent(StudentEntity student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}