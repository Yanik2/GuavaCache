package com.guava.cache.cacheimpl;

import com.google.common.cache.LoadingCache;
import com.guava.cache.model.Student;
import com.guava.cache.repository.StudentRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

public class StudentCache {
    private LoadingCache<String, Student> cache;

    public StudentCache(LoadingCache<String, Student> cache) {
        this.cache = cache;
    }

    public Student findByName(String name) {
        return cache.getUnchecked(name);
    }
}
