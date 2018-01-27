package ua.logos.orm.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "university")
public class University extends BaseEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "year")
	private int year;

	@Column(name = "description")
	private String description;

	@OneToMany(mappedBy = "university", cascade = CascadeType.ALL)
	List<Student> students = new ArrayList<>();

	public University() {
		// TODO Auto-generated constructor stub
	}

	public University(String name, int year, String description) {
		this.name = name;
		this.year = year;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "University [name=" + name + ", year=" + year + ", description=" + description + ", getId()=" + getId()
				+ "]";
	}

}
