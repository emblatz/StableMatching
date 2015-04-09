package edu.fgcu;

import java.util.*;

public class Matching {
	private List<School> schools;
	private List<Student> students;
	private HashMap matched = new HashMap();
	
	public void viewSchools() {
		//school s that exists in a list of schools will show up when viewSchools() is run
		//school x that doesn't exist in a list of schools will not show up when viewSchools is run
		for (School school:schools) {
			System.out.println("School name: "+school.getName());
			System.out.println("Preferred minimum GPA: "+school.getGPA());
			System.out.println("Preferred living distance: "+school.getDistance());
			System.out.println("Preferred award: "+school.getAwards()+"\n");
		}
	}
	
	public void runMatch(List<School> schools, List<Student> students) {
		//for a school and a student who match according to Stable Matching algorithm, runMatch should pair them and display this pair
		/*this will mean that a student A with a GPA of 3.5, Honors Award, and a distance of 10mi from the school S
		will be matched with school S requiring a minimum of 3.5 GPA, Honors Award, and a distance of 30mi 
		if another student B only has a GPA of 3.0, no award, and is a distance 40mi and
		if another school T that requires a minimum of 2.0 GPA, requires no awards and is also a distance of 10mi
		*/
		while (!students.isEmpty()) {
			for (Student student:students) {
				for (School school:schools) {
					if (!matched.containsKey(school)) {
						matched.put(school, student);
						break;
					}
					else {
						int newCount = 0;
						int oldCount = 0;
						Student oldStudent = (Student) matched.get(school);
						if (school.getDistance()>=student.getDistance()) {
							newCount++;
						}
						if (school.getAwards()==student.getAwards()) {
							newCount++;
						}
						if (school.getGPA()<=student.getGPA() && student.getGPA() > oldStudent.getGPA()) {
							newCount++;
						}
						if (school.getDistance()>=oldStudent.getDistance()) {
							oldCount++;
						}
						if (school.getAwards()==oldStudent.getAwards()) {
							oldCount++;
						}
						if (school.getGPA()<=oldStudent.getGPA() && student.getGPA() <= oldStudent.getGPA()) {
							oldCount++;
						}
						if (oldCount < newCount) {
							matched.remove(school);
							matched.put(school, student);
							students.remove(student);
							students.add(oldStudent);
							break;
						}
					}
				}
			}
		}
	}
	
	public HashMap getMap() {
		return matched;
	}
}