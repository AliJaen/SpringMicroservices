package com.course.microservicecourse.persistance;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.course.microservicecourse.entities.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long>{

}
