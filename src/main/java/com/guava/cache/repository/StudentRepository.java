package com.guava.cache.repository;

import com.guava.cache.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentRepository {
    private List<Student> students;

    public StudentRepository() {
        students = List.of(new Student("Chandler", "Bing"), new Student("Leslie", "Knope"), new Student("Michael", "Scott"));
    }

    public Optional<Student> findByName(String name) {
        for(Student s : students) {
            if(s.getFirstName().equals(name))
                return Optional.of(s);
        }
        return Optional.empty();
    }

    public Map<String, Student> findAll() {
        return students.stream().collect(Collectors.toMap(Student::getFirstName, Function.identity()));
    }
}
