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
	public ResponseEntity<List<Student>> getAllStudent(@RequestParam(required = false) Integer id) {
		try {
			List<Student> student = new ArrayList<Student>();

			if (id == null)
				repository.findAll().forEach(student::add);
			else
				repository.findById(id).forEach(student::add);

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
			Student _student = repository.save(new Student(student.getRegId(), student.getIntitutionId(),
					student.getStudentId(), student.getFirstName(), student.getLastName(), student.getRegdate(),
					student.getDateofBirth(), student.getAge(), student.getGender(), student.getNid(),
					student.getOccupation(), student.getStreet(), student.getPostOffice(), student.getUpazilla(),
					student.getDistrict(), student.getDivision(), student.getContact(), student.getEmail(),
					student.getCreated_on(), student.getCreated_by(), student.getDegree(), student.getInstitute(),
					student.getCompletion_year(), student.getGrade()

			));
			return new ResponseEntity<>(_student, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
		Optional<Student> tutorialData = repository.findById(id);

		if (tutorialData.isPresent()) {
			Student _student = tutorialData.get();
			_student.setRegId(student.getRegId());
			_student.setFirstName(student.getFirstName());
			_student.setStudentId(student.getStudentId());

			_student.setLastName(student.getLastName());
			_student.setRegdate(student.getRegdate());
			_student.setDateofBirth(student.getDateofBirth());
			_student.setAge(student.getAge());
			_student.setGender(student.getGender());
			_student.setNid(student.getNid());
			_student.setOccupation(student.getOccupation());
			_student.setStreet(student.getStreet());
			_student.setPostOffice(student.getPostOffice());
			_student.setUpazilla(student.getUpazilla());
			_student.setDistrict(student.getDistrict());
			_student.setDivision(student.getDivision());
			_student.setContact(student.getContact());
			_student.setEmail(student.getEmail());
			_student.setCreated_on(student.getCreated_on());
			_student.setCreated_by(student.getCreated_by());
			_student.setDegree(student.getDegree());
			_student.setInstitute(student.getInstitute());
			_student.setCompletion_year(student.getCompletion_year());
			_student.setGrade(student.getGrade());
			return new ResponseEntity<>(repository.save(_student), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/student/{id}")
	public ResponseEntity<HttpStatus> deletestudent(@PathVariable("id") long id) {
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

	@GetMapping("/student/name/{firstName}")
	public ResponseEntity<List<Student>> findByFirstNameContaining() {
		try {
			List<Student> student = repository.findByFirstNameContaining(null);

			if (student.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(student, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
