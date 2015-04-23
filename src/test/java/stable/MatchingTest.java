package stable;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import org.junit.Test;

import stable.Matching;
import stable.School;
import stable.Student;


public class MatchingTest {
	
	// Tests to see if one student and one school are automatically matched together.
	@Test
	public void matchToSchool() {
		List<School> schools = new ArrayList<School>();
		List<Student> students = new ArrayList<Student>();
		HashMap expected = new HashMap();
		Matching matching = new Matching();
		
		School school = new School();
		school.setName("Florida Gulf Coast University");
		school.setGPA(2.5);
		school.setDistance(100);
		school.setAwards("Scholarship");
		schools.add(school);
		
		Student student = new Student();
		student.setName("Bob Jones");
		student.setGPA(4.0);
		student.setDistance(100);
		student.setAwards("Scholarship");
		students.add(student);
		
		matching.runMatch(schools, students);
		expected = matching.getMap();
		
		Iterator it = expected.entrySet().iterator();
		while (it.hasNext()) {
		    Map.Entry pair = (Map.Entry)it.next();
		    Student newStudent = (Student) pair.getValue();
		    School newSchool = (School) pair.getKey();
		    assertEquals(newStudent.getName(), student.getName());
		    assertEquals(newSchool.getName(), school.getName());
		    it.remove();
		}
	}
	
	// Tests to create the best match.
	@Test
	public void bestMatch() {
		List<School> schools = new ArrayList<School>();
		List<Student> students = new ArrayList<Student>();
		HashMap expected = new HashMap();
		Matching matching = new Matching();
		
		School school = new School();
		school.setName("Florida Gulf Coast University");
		school.setGPA(2.5);
		school.setDistance(100);
		school.setAwards("Scholarship");
		schools.add(school);
		
		Student student = new Student();
		student.setName("John Smith");
		student.setGPA(3.5);
		student.setDistance(50);
		student.setAwards("Honors Award");
		students.add(student);
		
		Student student2 = new Student();
		student2.setName("Bob Jones");
		student2.setGPA(4.0);
		student2.setDistance(100);
		student2.setAwards("Scholarship");
		students.add(student2);
		
		School school2 = new School();
		school2.setName("MIT");
		school2.setGPA(3.5);
		school2.setDistance(50);
		school2.setAwards("Honors Award");
		schools.add(school2);
		
		matching.runMatch(schools, students);
		expected = matching.getMap();
		
		Student expStudent1 = (Student) expected.get(school);
		Student expStudent2 = (Student) expected.get(school2);
		
		assertEquals(expStudent1.getName(), student2.getName());
		assertEquals(expStudent2.getName(), student.getName());
	}
	
	/*
	@Test
	public void testViewSchool(){
	
		
	}
	
	@Test
	public void testViewStudent(){
		
		
	}*/
}
