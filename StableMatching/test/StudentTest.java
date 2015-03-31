import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StudentTest {
	
	@Test
	public void testSetName(){
		Student student = new Student();
		student.setName("John Smith");
		assertEquals(student.getName(), "John Smith");
	}
	
	@Test
	public void testSetGPA() {
		Student student = new Student();
		student.setGPA(3.0);
		String actualGPA = student.getGPA()+"";
		String expectedGPA = "3.0";
		assertEquals(actualGPA, expectedGPA);
	}
	
	@Test
	public void testSetDistance() {
		Student student = new Student();
		student.setDistance(50);
		assertEquals(student.getDistance(), 50);
	}
	
	@Test
	public void testSetAwards() {
		Student student = new Student();
		student.setAwards("Cool Scholarship Thing");
		assertEquals(student.getAwards(), "Cool Scholarship Thing");
	}
}
