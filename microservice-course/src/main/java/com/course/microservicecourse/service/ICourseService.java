package com.course.microservicecourse.service;

import java.util.List;

import com.course.microservicecourse.entities.Course;
import com.course.microservicecourse.http.response.StudentByCourseResponse;

public interface ICourseService {

    List<Course> findAll();

    Course findById(Long id);

    void save(Course course);

    StudentByCourseResponse findStudentsByIdCourse(Long idCourse);
}
