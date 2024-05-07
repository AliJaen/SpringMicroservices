package com.course.microservicecourse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.microservicecourse.client.StudentClient;
import com.course.microservicecourse.dto.StudentDTO;
import com.course.microservicecourse.entities.Course;
import com.course.microservicecourse.http.response.StudentByCourseResponse;
import com.course.microservicecourse.persistance.CourseRepository;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentClient studentClient;

    @Override
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public StudentByCourseResponse findStudentsByIdCourse(Long idCourse) {

        // Get the course
        Course course = courseRepository.findById(idCourse).orElse(new Course());

        // Get the students of these course
        List<StudentDTO> studentDTOList = studentClient.findAllStudentByCourse(idCourse);

        return StudentByCourseResponse.builder()
            .courseName(course.getName())
            .teacher(course.getTeacher())
            .studentDTOList(studentDTOList)
            .build();
    }
}
