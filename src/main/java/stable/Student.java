package stable;

public class Student {
	private String name;
	private double gpa;
	private int distance;
	private String awards;
	
	public Student(){
		
	}
	
	public Student(String name, double gpa, int distance, String awards){
		this.setName(name);
		this.setGPA(gpa);
		this.setDistance(distance);
		this.setAwards(awards);
	}
	
	public void setName(String name){
		if(!name.isEmpty())
			this.name = name;
		else
			throw new RuntimeException();
		
	}
	
	public void setGPA(double gpa) {
		if(gpa >= 0 && gpa <= 4)
			this.gpa = gpa;
		else
			throw new IndexOutOfBoundsException();
	}
	
	public void setDistance(int distance) {
		if(distance >= 0 && distance <= 100)
			this.distance = distance;
		else
			throw new IndexOutOfBoundsException();
	}
	
	public void setAwards(String awards) {
		this.awards = awards;
	}
	
	public String getName() {
		return name;
	}
	
	public double getGPA() {
		return gpa;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public String getAwards() {
		return awards;
	}
}
