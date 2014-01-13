package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.*;

import daten.Student;

public class StudentTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void constructorTestName(){
		Student s = new Student("","",true, new Date(1996,05,05));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void constructorTestDate(){
		Student s = new Student("Lars","Vogel",true, null);
	}
	
	@Test
	public void constructorTestValid(){
		Student s = new Student("Lars","Vogel",true, new Date(1996,05,05));
	}
	
	@Test
	public void constructorTest(){
		Student s = new Student("Lars","Vogel",true, new Date(1996,03,06));
		assertEquals("Lars Vogel, born on Mon Apr 06 00:00:00 CEST 3896", s.toString());
		
	}
	
}
