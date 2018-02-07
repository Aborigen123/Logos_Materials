package ua.online.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.online.course.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
