package com.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.crm.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	public Users findByid(Long profileid);

	public List<Users> findByusername(String username);

	@Query("FROM Users WHERE username=:userName")
	public Users authenticate(@Param("userName") String userName);

}
