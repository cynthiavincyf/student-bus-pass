package com.buspass.studentbuspass.Repository;

import com.buspass.studentbuspass.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}