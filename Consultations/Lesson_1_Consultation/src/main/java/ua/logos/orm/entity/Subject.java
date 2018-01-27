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
@Table(name = "subject")
public class Subject extends BaseEntity {

	@Column(name = "title")
	private String title;

	@Column(name = "duration")
	private int duration;

	@Column(name = "description")
	private String description;

	@ManyToMany
	@JoinTable(name = "student_subject", 
	joinColumns = @JoinColumn(name = "subject_id"),
	inverseJoinColumns = @JoinColumn(name = "student_id"))
	List<Student> students = new ArrayList<>();
	
	public Subject() {
		// TODO Auto-generated constructor stub
	}

	public Subject(String title, int duration, String description) {
		this.title = title;
		this.duration = duration;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Subject [title=" + title + ", duration=" + duration + ", description=" + description + ", getId()="
				+ getId() + "]";
	}

}
