package ua.online.course.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.online.course.entity.User;
import ua.online.course.repository.UserRepository;
import ua.online.course.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findById(int id) {
		return userRepository.findOne(id);
	}

	@Override
	public void save(User user) {
		User existedUser = findByLoginAndEmail(user.getLogin(), user.getEmail());
		if(existedUser == null) {
			userRepository.save(user);
		}
	}

	@Override
	public User findByLoginAndEmail(String login, String email) {
		return userRepository.findByLoginAndEmail(email, login);
	}

}
