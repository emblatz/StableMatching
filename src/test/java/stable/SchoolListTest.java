package stable;

import static org.junit.Assert.*;

import org.junit.Test;


public class SchoolListTest {
	
	@Test
	public void testAddSchool(){
		SchoolList schoolList = new SchoolList();
		School school = new School();
		school.setName("School University");
		school.setGPA(1.0);
		school.setDistance(100);
		schoolList.add(school);
		assertTrue(schoolList.getList().contains(school));
		assertEquals(schoolList.getList().get(0), school);
		
	}
	
	
}
