
public class School {
	private String name;
	private double minGPA;
	private int distance;
	private String awards;
	
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setGPA(double gpa) {
		this.minGPA = gpa;
	}
	
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public void setAwards(String awards) {
		this.awards = awards;
	}
	
	public String getName() {
		return name;
	}
	
	public double getGPA() {
		return minGPA;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public String getAwards() {
		return awards;
	}
}
