package com.guava.cache;

import com.guava.cache.model.Student;
import com.guava.cache.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {

    private StudentService studentService;

    public CacheController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{name}")
    public Student getStudentByName(@PathVariable String name) {
        return studentService.findByName(name);
    }
}
