package com.jpa.bootjpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.bootjpa.entities.User;
//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
public interface UserRepository extends CrudRepository<User, Integer>{
	public List<User> findByName(String name);
	
	public List<User> findByNameAndCity(String name, String city);
	
	public List<User> findByNameStartingWith(String prefix);
	
	
	//Query parameter and JPQL
	@Query("select u from User u")
	public List<User> getAllUser();
	
	@Query("select u from User u WHERE u.name = :n")
	public User getUserByName(@Param("n") String name);
	
	@Query("select u from User u WHERE u.name = :n and u.city = :c")
	public User getUserByNameAndCity(@Param("n") String name, @Param("c") String city);
	
	@Query(value = "select * from user", nativeQuery = true)
	public List<User> getUsers();
}

