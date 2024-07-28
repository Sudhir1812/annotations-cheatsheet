package com.demo.spring.service;

import com.demo.spring.entity.Student;

import java.util.List;
import java.util.Optional;


public interface StudentService {

    public Student addStudent(Student student);

    public Optional<Student> getStudent(int id);

    public List<Student> getStudents();
}
