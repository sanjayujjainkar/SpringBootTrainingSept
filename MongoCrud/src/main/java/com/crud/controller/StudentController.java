package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Student;
import com.crud.repo.IMongoRepository;

@RestController
public class StudentController {

	@Autowired
	private IMongoRepository reposigtory;

	@PostMapping("/addStudent")
	public ResponseEntity<?> addStudent(@RequestBody Student student) {
		Student save = reposigtory.save(student);
		return ResponseEntity.ok(save);
	}

	@GetMapping("/getStudent")
	public ResponseEntity<?> getAllStudents() {
		return ResponseEntity.ok(reposigtory.findAll());
	}
	
	@GetMapping("/getStudent/{id}")
	public ResponseEntity<?> getStudent(@PathVariable("id") int id) {
		return ResponseEntity.ok(reposigtory.findById(id));
	}
	
	@PostMapping("/deleteStudent/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable("id") int id) {
		reposigtory.deleteById(id);
		return ResponseEntity.ok(true);
	}
	

}
