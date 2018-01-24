package ua.logos.orm.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student extends BaseEntity {

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "age")
	private int age;

	@Column(name = "description")
	private String description;

	@ManyToMany
	@JoinTable(name = "course_student", 
	joinColumns = @JoinColumn(name = "student_id"),
	inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> courses = new ArrayList<>();

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String fullName, int age, String description) {
		this.fullName = fullName;
		this.age = age;
		this.description = description;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}
