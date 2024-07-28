package com.javatechie.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "COURSE_TBL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "COURSE_NAME")
    private String courseName;

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID")
    private Student student;
}
