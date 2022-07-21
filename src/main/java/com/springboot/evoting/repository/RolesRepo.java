package com.springboot.evoting.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.evoting.model.RolesEntity;
@Repository
public interface RolesRepo  extends JpaRepository<RolesEntity,Integer>{
	
	Optional<RolesEntity> findByroleName(String name);
	

}
