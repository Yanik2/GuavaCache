package com.guava.cache.cacheimpl;

import com.google.common.cache.CacheLoader;
import com.guava.cache.model.Student;
import com.guava.cache.repository.StudentRepository;

public class CacheLoaderImpl extends CacheLoader<String, Student> {
    private StudentRepository studentRepository;

    public CacheLoaderImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student load(String s) throws Exception {
        return studentRepository.findByName(s).orElseThrow();
    }
}
