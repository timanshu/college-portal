package com.collegeportal.course.controller;

import com.collegeportal.course.model.Course;
import com.collegeportal.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable String id)
    {
        if(courseService.courseExists(id))
            return courseService.getCourse(id);

        throw new SecurityException("Course does not exists");
    }

    @GetMapping("/")
    public List<Course> getAllCourses()
    {
        return courseService.getAllCourses();
    }

    @PostMapping("/")
    public String createNewCourse(@RequestBody Course course)
    {
        if(Objects.nonNull(course.getId()) && courseService.courseExists(course.getId()))
        {
            throw new SecurityException("Illegal access");
        }
        return courseService.createNewCourse(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable String id, @RequestBody Course course) {
        if(courseService.courseExists(id))
        {
            course.setId(id);
            return courseService.updateCourse(course);
        }

        throw new SecurityException("Course does not exists");
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable String id)
    {
        if(courseService.courseExists(id))
        {
            courseService.deleteCourse(id);
            return;
        }
        throw new SecurityException("Course does not exists");
    }
}
