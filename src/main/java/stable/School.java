package stable;


public class School {
	private String name;
	private double minGPA;
	private int distance;
	private String awards;
	
	public School(){
		
	}
	
	public School(String name, double gpa, int distance, String awards){
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
			this.minGPA = gpa;
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
		return minGPA;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public String getAwards() {
		return awards;
	}
}
