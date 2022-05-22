package com.guava.cache.config;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.guava.cache.cacheimpl.CacheLoaderImpl;
import com.guava.cache.cacheimpl.StudentCache;
import com.guava.cache.model.Student;
import com.guava.cache.repository.StudentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfiguration {
    @Bean
    public CacheLoader<String, Student> cacheLoaderImpl() {
        return new CacheLoaderImpl(studentRepository());
    }

    @Bean
    public StudentCache studentCache() {
        return new StudentCache(loadingCache()  );
    }

    @Bean
    public LoadingCache<String, Student> loadingCache() {
        return CacheBuilder.newBuilder()
                .build(cacheLoaderImpl());
    }

    @Bean
    public StudentRepository studentRepository() {
        return new StudentRepository();
    }
}
