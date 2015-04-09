package edu.fgcu;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class MatchingSystemTest {
	private List<School> schools;
	private List<Student> students;
	private HashMap expected = new HashMap();
	
	public void setup() {
		School school1 = new School();
		school1.setName("Florida Gulf Coast University");
		school1.setGPA(2.5);
		school1.setDistance(100);
		school1.setAwards("President's Gold Award");
		schools.add(school1);
		School school2 = new School();
		school2.setName("University of Central Florida");
		school2.setGPA(2.0);
		school2.setDistance(200);
		school2.setAwards("Honors Award");
		schools.add(school2);
		School school3 = new School();
		school3.setName("MIT");
		school3.setGPA(3.5);
		school3.setDistance(2000);
		school3.setAwards("Excellence Award");
		schools.add(school3);
		School school4 = new School();
		school4.setName("Harvard");
		school4.setGPA(4.0);
		school4.setDistance(1000);
		school4.setAwards("Harvard Book Award");
		schools.add(school4);
		School school5 = new School();
		school5.setName("Florida State University");
		school5.setGPA(2.5);
		school5.setDistance(100);
		school5.setAwards("Honors Award");
		schools.add(school5);
		Student student1 = new Student();
		student1.setName("John Smith");
		student1.setGPA(3.5);
		student1.setDistance(50);
		student1.setAwards("Excellence Award");
		students.add(student1);
		Student student2 = new Student();
		student2.setName("Bob Jones");
		student2.setGPA(4.0);
		student2.setDistance(200);
		student2.setAwards("President's Gold Award");
		students.add(student2);
		Student student3 = new Student();
		student3.setName("Jane Doe");
		student3.setGPA(3.0);
		student3.setDistance(100);
		student3.setAwards("");
		students.add(student3);
		Student student4 = new Student();
		student4.setName("Smitty Smitherson");
		student4.setGPA(2.0);
		student4.setDistance(150);
		student4.setAwards("Honors Award");
		students.add(student4);
		Student student5 = new Student();
		student5.setName("Emma Watson");
		student5.setGPA(4.0);
		student5.setDistance(500);
		student5.setAwards("Harvard Book Award");
		students.add(student5);
		
		expected.put(school1, student2);
		expected.put(school2, student4);
		expected.put(school3, student1);
		expected.put(school4, student5);
		expected.put(school5, student3);
	}
	
	@Test(expected = RuntimeException.class)
	public void TestViewSchools() {
		//school s that exists in a list of schools will show up when viewSchools() is run
		//school x that doesn't exist in a list of schools will not show up when viewSchools is run
		Matching matching = new Matching();
		matching.runMatch(schools, students);
		HashMap matched = matching.getMap();
		assertEquals(matched.size(), 5);
	}
	
	@Test(expected = RuntimeException.class)
	public void TestRunMatch() {
		//for a school and a student who match according to Stable Matching algorithm, runMatch should pair them and display this pair
		/*this will mean that a student A with a GPA of 3.5, Honors Award, and a distance of 10mi from the school S
		will be matched with school S requiring a minimum of 3.5 GPA, Honors Award, and a distance of 30mi 
		if another student B only has a GPA of 3.0, no award, and is a distance 40mi and
		if another school T that requires a minimum of 2.0 GPA, requires no awards and is also a distance of 10mi
		*/
		Matching matching = new Matching();
		matching.runMatch(schools, students);
		HashMap matched = matching.getMap();
		Iterator it = expected.entrySet().iterator();
		while (it.hasNext()) {
		    Map.Entry pair = (Map.Entry)it.next();
		    assertEquals(matched.get(pair.getKey()), pair.getValue());
		    it.remove();
		}
	}
}
