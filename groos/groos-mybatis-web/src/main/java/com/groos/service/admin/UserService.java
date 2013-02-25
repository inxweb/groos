package com.groos.service.admin;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.groos.domain.model.User;

public interface UserService {
 

	List<User> findUserListByUserName(String userName);

	List<User> findAllUserList();

}
