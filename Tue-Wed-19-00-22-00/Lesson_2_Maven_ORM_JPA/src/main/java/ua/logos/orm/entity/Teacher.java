package ua.logos.orm.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher extends BaseEntity {

	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// private Long id;

	@Column(name = "login")
	private String login;

	@Column(name = "password")
	private String password;

	@OneToOne
	@JoinColumn(name = "teacher_details_id")
	private TeacherDetails teacherDetails;

	@OneToMany(mappedBy = "teacher")
	private List<Course> courses = new ArrayList<>();

	public Teacher() {

	}

	public Teacher(String login, String password) {
		this.login = login;
		this.password = password;
	}

	// public Long getId() {
	// return id;
	// }
	//
	// public void setId(Long id) {
	// this.id = id;
	// }

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TeacherDetails getTeacherDetails() {
		return teacherDetails;
	}

	public void setTeacherDetails(TeacherDetails teacherDetails) {
		this.teacherDetails = teacherDetails;
	}

	@Override
	public String toString() {
		return "Teacher [login=" + login + ", password=" + password + "]";
	}

}
