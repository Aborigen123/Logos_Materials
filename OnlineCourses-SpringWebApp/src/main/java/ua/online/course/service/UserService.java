package ua.online.course.service;

import org.springframework.stereotype.Service;

import ua.online.course.entity.User;

@Service
public interface UserService {

	User findById(int id);
	User findByLoginAndEmail(String login, String email);
	
	void save(User user);
	
}
