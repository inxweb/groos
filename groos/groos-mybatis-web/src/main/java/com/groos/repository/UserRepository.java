package com.groos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.groos.domain.model.User;

public interface UserRepository extends JpaRepository<User, Integer>, QueryDslPredicateExecutor<User> {

}
