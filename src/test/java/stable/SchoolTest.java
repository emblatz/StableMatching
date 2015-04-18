package stable;

import static org.junit.Assert.*;

import org.junit.Test;

import stable.School;

public class SchoolTest {

	@Test
	public void testSetName(){
		School school = new School();
		school.setName("Florida Gulf Coast University");
		assertEquals(school.getName(), "Florida Gulf Coast University");
	}
	
	// Floating point numbers are causing a problem.
	// Changed them to strings so they wouldn't cause a problem.
	@Test
	public void testSetGPA() {
		School school = new School();
		school.setGPA(2.5);
		String actualGPA = school.getGPA()+"";
		String expectedGPA = "2.5";
		assertEquals(actualGPA, expectedGPA);
	}
	
	@Test
	public void testSetDistance() {
		School school = new School();
		school.setDistance(100);
		assertEquals(school.getDistance(), 100);
	}
	
	@Test
	public void testSetAwards() {
		School school = new School();
		school.setAwards("Scholarship");
		assertEquals(school.getAwards(), "Scholarship");
	}
}
