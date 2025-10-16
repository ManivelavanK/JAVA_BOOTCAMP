package com.example.demoleafsql.repository;

import com.example.demoleafsql.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
