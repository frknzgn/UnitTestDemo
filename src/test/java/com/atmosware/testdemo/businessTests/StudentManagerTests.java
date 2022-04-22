package com.atmosware.testdemo.businessTests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.atmosware.testdemo.business.common.exceptions.BusinessException;
import com.atmosware.testdemo.business.concretes.StudentManager;
import com.atmosware.testdemo.entities.concretes.Student;

public class StudentManagerTests {
	
	StudentManager studentManager;
	
	@BeforeEach
	public void setup() {
		studentManager = new StudentManager();
	}
	
	@AfterEach
	public void cleanup() {
		
	}
	
	@BeforeAll
	public void initialize(){
		
	}
	
	@AfterAll
	public void finish(){
		
	}
	
	
	@Test
	public void throws_exception_when_student_exists() {
		
		Student student = new Student(9,"FURKAN");
		
		Executable executable = () -> studentManager.add(student);
		
		Assertions.assertThrows(BusinessException.class, executable);
		
	}
	
	@Test
	public void throws_exception_when_student_exists1() {
				
		Student student = new Student(9,"FURKAN");
		
		Executable executable = () -> studentManager.add(student);
		
		Assertions.assertThrows(BusinessException.class, executable);
		
	}
//	
//	@Test(expected = BusinessException.class )
//	public void check_student_name_exist_if_throw_bussiness_exception() {
//		
//		StudentManager studentManager = new StudentManager();
//		studentManager.add(new Student(0,"furkan"));
//		
//	}
	
}
