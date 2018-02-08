package ua.online.course.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course extends BaseEntity {

	@Column(name = "title", unique = true)
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "price", columnDefinition = "DECIMAL(5,2)")
	private BigDecimal price;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinColumn(name = "user_id")
	private User user;

	public Course(String title, String description, BigDecimal price) {
		this.title = title;
		this.description = description;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Course [title=" + title + ", description=" + description + ", price=" + price + ", getId()=" + getId()
				+ "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
