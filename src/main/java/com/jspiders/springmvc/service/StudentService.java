package com.jspiders.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jspiders.springmvc.pojo.StudentPojo;
import com.jspiders.springmvc.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;
	
    //Add Student
	public StudentPojo addStudent(String name, String email,long mobile, String address) {
		StudentPojo pojo = repository.addStudent(name, email, mobile, address);
		return pojo;
	}
     
	//////////////////////////////////////////////////////////
	
	//Search Student
	public StudentPojo searchStudent(int id)
	{
		StudentPojo pojo = repository.searchStudent(id);
		return pojo;
	}
    //Search All Student
	public List<StudentPojo> searchAllStudents() {
		List<StudentPojo> students  = repository.searchAllStudents();
		return students;
	}
     
	///////////////////////////////////////////////////////////
	
	//Remove Student
	public StudentPojo removeStudent(int id) {
		StudentPojo pojo = repository.removeStudent(id);
		return pojo;
	}
	
    ///////////////////////////////////////////////////////////
	
	//Update Student
	public StudentPojo updateStudent(int id, String name, String email, long mobile, String address) {
		StudentPojo pojo = repository.updateStudent(id,name,email,mobile,address);
		return pojo;
	}

	public List<StudentPojo> allStudents() {
		List<StudentPojo> students = repository.searchAllStudents();
		
		return students;
	}



	




}