package com.groos.service.admin.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.groos.domain.expression.UserExpressions;
import com.groos.domain.expression.UserOrders;
import com.groos.domain.model.User;
import com.groos.repository.UserRepository;
import com.groos.service.admin.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@PostConstruct
	public void init() {
		DataFactory df = new DataFactory();
		User user = new User();

		user.setName(df.getBusinessName());

		this.userRepository.save(user);

		user = new User();

		user.setName(df.getBusinessName());

		this.userRepository.save(user);

		user = new User();

		user.setName(df.getBusinessName());

		this.userRepository.save(user);

		user = new User();

		user.setName(df.getBusinessName());

		this.userRepository.save(user);
	}

	@Autowired
	private UserRepository userRepository;
 
	@Override
	public List<User> findUserListByUserName(String userName) {
		List<User> userList = (List<User>) userRepository.findAll(
				UserExpressions.lastNameIsLike("Tucker Gymnasium")
				.or(UserExpressions.lastNameIsLike("Lenox Motors"))
				 ,  UserOrders.orderByNameAsc());

		return userList;
	}

	@Override
	public List<User> findAllUserList() {
		List<User> userList = (List<User>) userRepository.findAll(); 

		return userList;
	}

}
