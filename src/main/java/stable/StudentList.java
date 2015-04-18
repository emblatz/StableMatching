package stable;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
	
	private List<Student> studentList = new ArrayList<Student>();
	
	public void add(Student student) {
		studentList.add(student);

	}
	
	public List<Student> getList() {
		return studentList;
	}
}