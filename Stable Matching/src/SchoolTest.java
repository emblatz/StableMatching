import org.junit.Test;

public class SchoolTest {
	private String name;
	private double minGPA;
	private int distance;
	private String awards;
	
	
	@Test
	public void testSetName(String name){
		//test setName(StringName) -> should pass
		//test setName(IntName) -> should fail
	}
	
	@Test
	public void TestSetGPA(double gpa) {
		//test setGPA(doubleGPA) -> should pass
		//test setGPA(StringGPA) -> should fail
	
	}
	
	@Test
	public void TestSetDistance(int distance) {
		//test setDistance(intDistance) -> should pass
		//test setDistance(StringDistance) -> should fail
	}
	
	@Test
	public void TestSetAwards(String awards) {
		//test setAwards(StringName) -> should pass
		//test setAwards(IntName) -> should fail
	}
}
