package stable;

import java.util.*;

public class Rankings {
	private List<School> schools;
	private List<Student> students;
	private Map<String, List<Student>> schoolPrefers;
	private Map<String, List<School>> studentPrefers;
	
	//determines a list of rankings each student has for schools and
	//each school has for students
	
		public void rank(){
		schoolPrefers = new HashMap<String, List<Student>>();
		studentPrefers = new HashMap<String, List<School>>();
		
		//find a way to order the lists for each school or student first
		
		schoolPrefers.put(schools.get(0).getName(), students);
		studentPrefers.put(students.get(0).getName(), schools);
		
		
		}
	
	}