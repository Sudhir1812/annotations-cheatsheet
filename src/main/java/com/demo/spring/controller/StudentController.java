package com.demo.spring.controller;

import com.demo.spring.LazyLoadingBean;
import com.demo.spring.TestBean;
import com.demo.spring.config.MailProps;
import com.demo.spring.entity.Student;
import com.demo.spring.service.StudentService;
import com.demo.spring.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@PropertySource("classpath:custom.properties")
//@Scope("singleton") //only one time single object will be created
@Scope("prototype") // multiple object will be created on request
public class StudentController {

    @Autowired
    //@Qualifier("studentServiceImpl")
    private StudentService studentService;

    @Autowired
    private TestBean testBean;

    @Autowired
    private LazyLoadingBean lazyLoadingBean;

    @Value("${mail.from}")
    private String from;
    @Value("${mail.host}")
    private String host;
    @Value("${mail.port}")
    private String port;

    @Value("${message}")
    private String message;

    @Autowired
    private MailProps mailProps;

    public StudentController(){
        System.out.println("controller object created...");
    }



    @PostMapping("/save")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.addStudent(student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> getStudent(@PathVariable int id) throws StudentNotFoundException {
        Optional<Student> student = studentService.getStudent(id);
        if (student.isPresent()) {
            return ResponseEntity.ok(student);
        } else {
            throw new StudentNotFoundException("student not found with id " + id);
        }

    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getStudents() {
        //System.out.println("Mail props load using @Value :" +from+" :"+host+" : "+port);
        //System.out.println("new value : "+ message);
        //testBean.method();
        System.out.println("mail properties : "+ mailProps);
        return ResponseEntity.ok(studentService.getStudents());
    }

}
