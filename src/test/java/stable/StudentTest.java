package stable;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import stable.Student;

public class StudentTest {
	
	
	
	@Test
	public void testStudentConstructor(){
				
		String name = "Jane Doe";
		double gpa = 4.0;
		int distance = 30;
		String awards = "None";
		
		Student student = new Student(name, gpa, distance, awards);
		
		assertEquals(student.getName(), name);
		assertEquals(student.getGPA(), gpa, 0);
		assertEquals(student.getDistance(), distance);
		assertEquals(student.getAwards(), awards);
	}
	
	@Test
	public void testSetName(){
		Student student = new Student();
		student.setName("John Smith");
		assertEquals(student.getName(), "John Smith");
	}
	
	@Test(expected=RuntimeException.class)
	public void testSetNameFail(){
		Student student = new Student();
		student.setName("");
	}
	
	@Test
	public void testSetGPA() {
		Student student = new Student();
		student.setGPA(3.0);
		String actualGPA = student.getGPA()+"";
		String expectedGPA = "3.0";
		assertEquals(actualGPA, expectedGPA);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testSetGPAFail() {
		Student student = new Student();
		student.setGPA(30.0);
	}
	
	@Test
	public void testSetDistance() {
		Student student = new Student();
		student.setDistance(50);
		assertEquals(student.getDistance(), 50);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testSetDistanceFail() {
		Student student = new Student();
		student.setDistance(300);
	}
	
	@Test
	public void testSetAwards() {
		Student student = new Student();
		student.setAwards("Scholarship");
		assertEquals(student.getAwards(), "Scholarship");
	}
}
