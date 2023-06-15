package com.m27Shubham.CRUD.StudentInfo.StudentRepository;


//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

import com.m27Shubham.CRUD.StudentInfo.Student.Student;

public interface StudentRepository extends ListCrudRepository<Student, Integer> {

}
