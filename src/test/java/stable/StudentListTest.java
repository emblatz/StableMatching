package stable;

import static org.junit.Assert.*;

import org.junit.Test;

import stable.Student;

public class StudentListTest {
	
	@Test
	public void testAddStudent(){
		StudentList studentList = new StudentList();
		Student student = new Student();
		student.setName("Jane Doe");
		student.setGPA(4.0);
		student.setDistance(40);
		studentList.add(student);
		assertTrue(studentList.getList().contains(student));
		assertEquals(studentList.getList().get(0), student);
		
	}
	
	
}
