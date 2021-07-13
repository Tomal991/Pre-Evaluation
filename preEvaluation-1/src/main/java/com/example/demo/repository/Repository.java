package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.user.Student;

public interface Repository extends JpaRepository<Student, Long> {
    List<Student> findById(Integer id);
    List<Student> findByFirstNameContaining(String firstName);
	
}