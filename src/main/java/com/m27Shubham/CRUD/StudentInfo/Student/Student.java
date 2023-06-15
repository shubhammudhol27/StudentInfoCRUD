package com.m27Shubham.CRUD.StudentInfo.Student;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity

@Data
@NoArgsConstructor

@Table(name = "student_info")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stdid")
  private int stdid;
	@Column(name = "std_name")
  private String std_name;
	@Column(name = "std_email")
  private String std_email;
	@Column(name = "std_phone")
  private long std_phone;
	public Student(int stdid,String std_name,String std_email,long std_phone){
		this.stdid =stdid;
		this.std_name =std_name;
		this.std_email =std_email;
		this.std_phone =std_phone;
	}
	

}
