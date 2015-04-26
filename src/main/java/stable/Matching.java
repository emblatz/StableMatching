package stable;

import java.util.*;

public class Matching {
	
	private HashMap matched = new HashMap();
	
	public ArrayList<String> runMatch(List<School> schools, List<Student> students) {
		//for a school and a student who match according to Stable Matching algorithm, runMatch should pair them and display this pair
		/*this will mean that a student A with a GPA of 3.5, Honors Award, and a distance of 10mi from the school S
		will be matched with school S requiring a minimum of 3.5 GPA, Honors Award, and a distance of 30mi 
		if another student B only has a GPA of 3.0, no award, and is a distance 40mi and
		if another school T that requires a minimum of 2.0 GPA, requires no awards and is also a distance of 10mi
		*/
		
		ArrayList<String> matches = new ArrayList<String>();
		
		ListIterator<Student> iterStudent = students.listIterator();
		
		while (iterStudent.hasNext()) {
			Student student = iterStudent.next();
			System.out.println(student.getName());
			
			for (School school:schools) {
				List<Student> accepted = new ArrayList<Student>();
				if (matched.containsKey(school))
					accepted = (List<Student>) matched.get(school);
				if (!matched.containsKey(school) || accepted.size()<3) {
					if (school.getGPA()<=student.getGPA() && student.getGPA() <= (school.getGPA()+.5) 
							&& school.getDistance()>=student.getDistance()) {
						accepted.add(student);
						if (matched.containsKey(school))
							matched.remove(school);
						matched.put(school, accepted);
						System.out.println("Student "+student.getName()+" matched to "+school.getName());
						matches.add("Student "+student.getName()+" matched to "+school.getName());
						iterStudent.remove();
						break;
					}

				}
				else {
					accepted = (List<Student>)matched.get(school);
					ListIterator<Student> iterAcc = accepted.listIterator();
					while(iterAcc.hasNext()) {
						int newCount = 0;
						int oldCount = 0;
						Student oldStudent = iterAcc.next();
						if (school.getAwards()==student.getAwards()) {
							newCount++;
						}
						if (school.getAwards()==oldStudent.getAwards()) {
							oldCount++;
						}
						if (student.getGPA()>oldStudent.getGPA()) {
							newCount++;
						}
						if (oldCount < newCount) {
							matched.remove(school);
							iterAcc.remove();
							iterAcc.add(student);
							iterAcc.previous();
							matched.put(school, accepted);
							System.out.println("New student "+student.getName()+" beat "+oldStudent.getName()+" at "+school.getName());
							matches.add("New student "+student.getName()+" beat "+oldStudent.getName()+" at "+school.getName());
							break;
						}
					}
				}
			}
		}
		
		return matches;
	}
	
	public HashMap getMap() {
		return matched;
	}
}