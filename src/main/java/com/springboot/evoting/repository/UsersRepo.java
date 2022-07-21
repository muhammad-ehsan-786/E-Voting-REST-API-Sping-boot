package com.springboot.evoting.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.evoting.model.UsersEntity;

@Repository
public interface UsersRepo extends JpaRepository<UsersEntity,Integer>{
	
	Optional<UsersEntity> findByuserEmail(String userEmail);
	
	
	Boolean existsByuserEmail(String userEmail);

	
	

}
