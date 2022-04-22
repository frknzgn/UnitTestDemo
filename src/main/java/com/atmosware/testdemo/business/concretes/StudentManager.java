package com.atmosware.testdemo.business.concretes;

import java.util.ArrayList;
import java.util.List;

import com.atmosware.testdemo.business.common.exceptions.BusinessException;
import com.atmosware.testdemo.entities.concretes.Student;

public class StudentManager {
	
	public List<Student> students = new ArrayList<Student>();
	
	public StudentManager() {
		students.add(new Student(1,"Furkan"));
		students.add(new Student(2,"engin"));
		students.add(new Student(3,"özgür"));
		students.add(new Student(4,"fatih"));
		students.add(new Student(5,"burak"));
		students.add(new Student(6,"can"));
		students.add(new Student(7,"umut"));
	}
	
	public void add(Student student) {
					
		checkStudentNameExists(student.getName());
		students.add(student);
		 
	}
	
	private void checkStudentNameExists(String name) {
		
		for (Student student : students) {
			if(student.getName().toLowerCase().equals(name.toLowerCase())) {
				throw new BusinessException("Öğrenci Mevcut");
			}
		}			
	}
	
}
