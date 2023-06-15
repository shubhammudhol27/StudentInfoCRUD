package com.m27Shubham.CRUD.StudentInfo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.m27Shubham.CRUD.StudentInfo.Student.Student;
import com.m27Shubham.CRUD.StudentInfo.StudentRepository.StudentRepository;
import com.m27Shubham.CRUD.StudentInfo.StudentServices.StudentService;

import jakarta.persistence.Table;

@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
	StudentRepository studentRepository;
	@PostMapping("/students")
	public ResponseEntity<String> createNewStd(@RequestBody Student student){
		studentRepository.save(student);
		return new ResponseEntity<String>(" student saved ",HttpStatus.OK);
	}
//	public String createNewStudent(@RequestBody Student student) {
//		studentRepository.save(student);
//		System.out.println(student.toString());
//		return "Student created in database";
//	}
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudent(){
		List<Student> stdList =new ArrayList<>();
		studentRepository.findAll().forEach(stdList::add);
		return new ResponseEntity<List<Student>>(stdList,HttpStatus.OK);
	}
	@GetMapping("/students/{stdid}")
	public ResponseEntity<Student> getStudentById(@PathVariable int stdid){
		Optional<Student> std =studentRepository.findById(stdid);
		if(std.isPresent()) {
			return new ResponseEntity<Student>(std.get(),HttpStatus.FOUND);
		}else {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	//Update
	@PutMapping("/students/{stdid}")
	public String updateById(@PathVariable int stdid,@RequestBody Student student) {
		Optional<Student> std =studentRepository.findById(stdid);
		if(std.isPresent()) {
			Student existStd =std.get();
			existStd.setStd_name(student.getStd_name());
			existStd.setStd_email(student.getStd_email());
			existStd.setStd_phone(student.getStd_phone());
			studentRepository.save(existStd);
			return "Student Details against id " +stdid+" updated";
		}else {
			return "Student Dtails Does not exist for id "+stdid;
		}
	}
	@DeleteMapping("students/{stdid}")
	public String DeleteById(@PathVariable int stdid) {
		studentRepository.deleteById(stdid);
		return "Student Details Deletes Successfully";
	}
	
}
