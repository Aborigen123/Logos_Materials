package ua.online.course.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "review")
@NoArgsConstructor
@Getter
@Setter
public class Review extends BaseEntity {

	@Column(name = "comment")
	private String comment;

	@Column(name = "rating")
	private int rating; // 1 to 5 Stars

	@ManyToMany
	@JoinTable(name = "user_review", joinColumns = @JoinColumn(name = "review_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id")
	private Course course;

	public Review(String comment, int rating) {
		this.comment = comment;
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Review [comment=" + comment + ", rating=" + rating + ", getId()=" + getId() + "]";
	}

}
