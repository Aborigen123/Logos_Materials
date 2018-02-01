package ua.logos.orm2.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "film")
public class Film extends BaseEntity {

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "description", length = 500)
	private String description;

	@Column(name = "release_year")
	private int releaseYear;

	@ManyToMany(cascade = {
			CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH
	})
	@JoinTable(name = "film_actor", joinColumns = @JoinColumn(name = "film_id"), inverseJoinColumns = @JoinColumn(name = "actor_id"))
	private List<Actor> actors = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY, 
			cascade = {
					CascadeType.DETACH, CascadeType.MERGE, 
					CascadeType.PERSIST, CascadeType.REFRESH
			})
	@JoinColumn(name = "category_id")
	private Category category;

	public Film() {
	}

	public Film(String title, String description, int releaseYear) {
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	@Override
	public String toString() {
		return "Film [title=" + title + ", description=" + description + ", releaseYear=" + releaseYear + ", getId()="
				+ getId() + "]";
	}

}
