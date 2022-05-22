package com.guava.cache.service;

import com.guava.cache.cacheimpl.StudentCache;
import com.guava.cache.model.Student;
import com.guava.cache.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private static Logger logger = LoggerFactory.getLogger(StudentService.class);
    private StudentCache studentCache;

    public StudentService(StudentCache studentCache) {
        this.studentCache = studentCache;
    }

    public Student findByName(String name) {
        try {
            return studentCache.findByName(name);
        } catch (Exception ex) {
            logger.error("Excpetion in StudentService: " + ex.getMessage());
        }
        return new Student("Default", "Student");
    }
}
