package com.microservice.studen.microservicestudent.service;

import java.util.List;

import com.microservice.studen.microservicestudent.entities.Student;

public interface IStudenService {

        List<Student> findAll();

        Student findById(Long id);

        void save(Student student);

        List<Student> findByIdCourse(Long idCourse);
} 
