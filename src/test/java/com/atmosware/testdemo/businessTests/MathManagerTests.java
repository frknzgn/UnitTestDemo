package com.atmosware.testdemo.businessTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.atmosware.testdemo.business.concretes.MathManager;

public class MathManagerTests {
	
	MathManager mathManager;
	
	@BeforeEach
	public void setup() {
		mathManager = new MathManager();
	}
	
	//Mocking 
	
	@Test
	public void one_plus_seven_is_eight() {
		
		//Arrange  //given	
		int number1 = 1;
		int number2 = 7;
		int expected = 8;
		
		
		//Act	//when
		int actual = mathManager.add(number1,number2);
		
		
		//Assert	//then
		Assertions.assertEquals(expected,actual);
		
	}
	
	
	@Test
	public void minus_one_plus_seven_is_six() {
		
		//Arrange  //given	
		int number1 = -1;
		int number2 = 7;
		int expected = 6;
		
		
		//Act	//when
		int actual = mathManager.add(number1,number2);
		
		
		//Assert	//then
		Assertions.assertEquals(expected,actual);
		
	}
	
	@ParameterizedTest
	@ValueSource(ints = {2,4,56,8})
	public void multiply_with_zero_should_return_zero(int sourceItem) {
		
		int number1 = 0;
		int number2 = sourceItem;
		int expected = 0;
		
		int actual = mathManager.multiply(number1, number2);
		
		Assertions.assertEquals(actual,expected);
	
	}
	
	
	
	
	
	
	
	
}
