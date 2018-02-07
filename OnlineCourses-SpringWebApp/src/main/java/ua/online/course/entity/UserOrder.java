package ua.online.course.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_order")
@NoArgsConstructor
@Getter
@Setter
public class UserOrder extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "order_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date orderDate;

	@Override
	public String toString() {
		return "UserOrder [user=" + user + ", orderDate=" + orderDate + ", getId()=" + getId() + "]";
	}

}
