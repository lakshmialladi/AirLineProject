package com.jsp.airline.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.airline.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>
{
//	@Query("SELECT u FROM User u WHERE u.userName = :userName AND u.password = :password")
	Optional<User> findByUserNameAndPassword(String userName, String password);
}
