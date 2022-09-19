package com.student.app.entity;

public class Student {
	
	String student;
	String classOfStudent;
	
	public Student(String student, String classOfStudent) {
		super();
		this.student = student;
		this.classOfStudent = classOfStudent;
	}
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}
	public String getClassOfStudent() {
		return classOfStudent;
	}
	public void setClassOfStudent(String classOfStudent) {
		this.classOfStudent = classOfStudent;
	}
	
	
	

}
