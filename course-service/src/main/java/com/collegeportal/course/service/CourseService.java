package com.collegeportal.course.service;

import com.collegeportal.course.model.Course;
import com.collegeportal.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Course getCourse(String id) {
        return courseRepository.findById(id).orElse(null);
    }

    public List<Course> getAllCourses() {
        List<Course> courseList = new ArrayList<>();
        courseRepository.findAll().forEach(u ->{
            courseList.add(u);
        });
        return courseList;
    }

    public boolean courseExists(String id) {
        return courseRepository.findById(id).isPresent();
    }

    public String createNewCourse(Course course) {
        course = courseRepository.save(course);
        return course.getId();
    }

    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
