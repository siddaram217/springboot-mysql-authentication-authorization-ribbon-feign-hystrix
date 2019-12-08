package com.candidate.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.candidate.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	@Query("select u from User u where u.username=:username")
	public Optional<User> findByUserName(@Param("username")String username);

}
