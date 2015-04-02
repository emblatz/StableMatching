package edu.fgcu;

public class Student {
	private String name;
	private double gpa;
	private int distance;
	private String awards;
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setGPA(double gpa) {
		this.gpa = gpa;
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
		return gpa;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public String getAwards() {
		return awards;
	}
}
