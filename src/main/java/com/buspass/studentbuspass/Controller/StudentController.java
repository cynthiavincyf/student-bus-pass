package com.buspass.studentbuspass.Controller;

import com.buspass.studentbuspass.Service.StudentService;
import com.buspass.studentbuspass.entity.StudentEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentEntity> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentEntity getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public StudentEntity addStudent(@RequestBody StudentEntity student) {
        return studentService.saveStudent(student);
    }

    @PutMapping("/{id}")
    public StudentEntity updateStudent(
            @PathVariable Long id,
            @RequestBody StudentEntity student) {

        StudentEntity existingStudent =
                studentService.getStudentById(id);

        if (existingStudent == null) {
            return null;
        }

        existingStudent.setName(student.getName());
        existingStudent.setRegisterNumber(student.getRegisterNumber());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setYear(student.getYear());

        return studentService.saveStudent(existingStudent);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}