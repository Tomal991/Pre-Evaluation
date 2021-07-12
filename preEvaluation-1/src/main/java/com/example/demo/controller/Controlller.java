package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.Repository;
import com.example.demo.user.Student;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class Controlller {

    @Autowired
    Repository repository;

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getAllStudent(@RequestParam(required = false) Integer regId) {
        try {
            List<Student> student = new ArrayList<Student>();

            if (regId == null)
            	repository.findAll().forEach(student::add);
            else
            	repository.findByRegId(regId).forEach(student::add);

            if (student.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long id) {
        Optional<Student> student = repository.findById(id);

        if (student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        try {
        	Student _student = repository
                     .save(new Student(student.getRegId(),
                    		 student.getIntitutionId(),
                    		 student.getStudentId(),
                    		 student.getFirstName(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null
                    		 
                    		 ));
            return new ResponseEntity<>(_student, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateTutorial(@PathVariable("id") long id, @RequestBody Student student) {
        Optional<Student> tutorialData = repository.findById(id);

        if (tutorialData.isPresent()) {
        	Student _student = tutorialData.get();
        	_student.setRegId(student.getRegId());
        	_student.setFirstName(student.getFirstName());
        	_student.setStudentId(student.getStudentId());
            return new ResponseEntity<>(repository.save(_student), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/student")
    public ResponseEntity<HttpStatus> deleteAllStudent() {
        try {
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/student/firstName")
    public ResponseEntity<List<Student>> findByFirstName() {
        try {
            List<Student> tutorials = repository.findByFirstName(null);

            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

