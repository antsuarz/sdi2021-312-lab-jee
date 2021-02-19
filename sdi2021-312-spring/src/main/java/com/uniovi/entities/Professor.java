package com.uniovi.entities;

public class Professor {
	private Long id;
	private String dni;
	private String name;
	private String surname;
	private String course;
	
	
	public Professor(Long id, String dni, String name, String surname, String course) {
		this.id = id;
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.course = course;
	}
	
	public Long getId() {
		return id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCourse() {
		return course;
	}
	
	public void setCourse(String course) {
		this.course = course;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
	return "Professor [id= " + id + ", dni= "+ dni  +", name= " + name + ", surname= " + surname + ", course= " + course +"]";
	
	}
	

}
