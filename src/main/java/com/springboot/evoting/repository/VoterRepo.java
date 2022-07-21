package com.springboot.evoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.evoting.model.VoterEntity;
@Repository
public interface VoterRepo extends JpaRepository<VoterEntity,Integer> {
	
	Boolean existsByvoterCnic(String voterCnic);

}
