package ua.online.course.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_details")
@NoArgsConstructor
@Getter
@Setter
public class UserDetails extends BaseEntity {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private int age;

	private String description;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "userDetails", fetch = FetchType.LAZY)
	private User user;

	public UserDetails(String firstName, String lastName, int age, String description) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.description = description;
	}

	@Override
	public String toString() {
		return "UserDetails [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", description="
				+ description + ", getId()=" + getId() + "]";
	}

}
