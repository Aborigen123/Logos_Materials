package ua.online.course.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

	@Column(name = "login", unique = true)
	private String login;

	@Column(name = "password")
	private String password;

	@Column(name = "email", unique = true)
	private String email;

	@Enumerated(EnumType.STRING)
	@Column(name = "user_role")
	private Role userRole;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private List<Course> courses = new ArrayList<>();

	public User(String login, String password, String email) {
		this.login = login;
		this.password = password;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + ", email=" + email + ", userRole=" + userRole
				+ ", getId()=" + getId() + "]";
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}