package stable;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

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
		
		assertEquals(expected.get(school), student2);
		assertEquals(expected.get(school2), student);
	}
	
	@Test
	public void testViewSchool(){
		String name = "School University";
		double gpa = 1.5;
		int distance = 100;
		String awards = "None";
		School school = new School(name, gpa, distance, awards);
		SchoolList schoolList = new SchoolList();
		schoolList.add(school);
		
		assertTrue(schoolList.getList().contains(school));
		assertEquals(schoolList.getList().get(0).getName(), name);
		assertEquals(schoolList.getList().get(0).getGPA(), gpa, 0);
		assertEquals(schoolList.getList().get(0).getDistance(), distance);
		assertEquals(schoolList.getList().get(0).getAwards(), awards);
	}
	
	@Test
	public void testViewStudent(){
		String name = "Jane Doe";
		double gpa = 4.0;
		int distance = 50;
		String awards = "Scholarship";
		Student student = new Student(name, gpa, distance, awards);
		StudentList studentList = new StudentList();
		studentList.add(student);
		
		assertTrue(studentList.getList().contains(student));
		assertEquals(studentList.getList().get(0).getName(), name);
		assertEquals(studentList.getList().get(0).getGPA(), gpa, 0);
		assertEquals(studentList.getList().get(0).getDistance(), distance);
		assertEquals(studentList.getList().get(0).getAwards(), awards);
	}
}
