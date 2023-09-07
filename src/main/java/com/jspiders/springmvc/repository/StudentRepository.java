package com.jspiders.springmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


import com.jspiders.springmvc.pojo.StudentPojo;

@Repository
public class StudentRepository {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	private static String jpql;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("springmvc");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction != null) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}

	///////////////////////////////////////////////
	
	///Add Student
	public StudentPojo addStudent(String name, String email,
			long mobile, String address) {
		openConnection();
		transaction.begin();
		StudentPojo pojo = new StudentPojo();
		pojo.setName(name);
		pojo.setEmail(email);
		pojo.setMobile(mobile);
		pojo.setAddress(address);
		manager.persist(pojo);
		transaction.commit();
		closeConnection();
		return pojo;
	}
	
	///////////////////////////////////////////////
	
	//Search Student
	public StudentPojo searchStudent(int id)
	{
		openConnection();
		transaction.begin();
		StudentPojo pojo = manager.find(StudentPojo.class, id);
		if(pojo != null)
		{
			transaction.commit();
			closeConnection();
			return pojo;
		}
		transaction.commit();
		closeConnection();
		return null;
	}
	
	//Search All Student
	public List<StudentPojo> searchAllStudents() {
		openConnection();
		transaction.begin();
		jpql = "from StudentPojo";
		query = manager.createQuery(jpql);
		List<StudentPojo> students = query.getResultList();
		transaction.commit();
		closeConnection();
		return students;
	}

	////////////////////////////////////////////////
	
	//Remove Student
	public StudentPojo removeStudent(int id) {
		openConnection();
		transaction.begin();
		 jpql = "from StudentPojo";
		query = manager.createQuery(jpql);
		StudentPojo pojo = manager.find(StudentPojo.class,id);
	
		if(pojo != null) {
			manager.remove(pojo);
			transaction.commit();
			closeConnection();
			return pojo;
		}
		transaction.commit();
		closeConnection();
		return null;
	}

	//////////////////////////////////////////////////
	
	//Update Student
	public StudentPojo updateStudent(int id, String name, String email, long mobile, String address) {
		openConnection();
		transaction.begin();
		StudentPojo pojo = manager.find(StudentPojo.class, id);
		pojo.setName(name);
		pojo.setEmail(email);
		pojo.setMobile(mobile);
		pojo.setAddress(address);
		manager.persist(pojo);
		transaction.commit();
		closeConnection();
		return pojo;
		
	}

	public List<StudentPojo> allStudents() {
		openConnection();
		transaction.begin();
		jpql="from StudentPojo";
		query = manager.createQuery(jpql);
		List<StudentPojo> students = query.getResultList();
		transaction.commit();
		closeConnection();
		return students;
	}


}