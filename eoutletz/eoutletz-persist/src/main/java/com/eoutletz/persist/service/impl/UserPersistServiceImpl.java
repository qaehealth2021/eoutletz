package com.eoutletz.persist.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eoutletz.common.log.Logger;
import com.eoutletz.persist.entity.User;
import com.eoutletz.persist.repository.UserRepository;
import com.eoutletz.persist.service.UserPersistService;

@Transactional
@Service
public class UserPersistServiceImpl implements UserPersistService {

	private final Logger logger = Logger
			.getLogger(UserPersistServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		logger.info("Saving user into db");
		return userRepository.saveOrUpdate(user);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void deleteById(Long id) {
		User user = userRepository.findById(id);
		if (null == user) {
			return;
		}
		userRepository.delete(user);
	}

}
