package stable;

import java.util.ArrayList;
import java.util.List;

public class SchoolList {
	
	private List<School> schoolList = new ArrayList<School>();
	
	public void add(School school) {
		schoolList.add(school);
	}
	
	public List<School> getList() {
		return schoolList;
	}
}