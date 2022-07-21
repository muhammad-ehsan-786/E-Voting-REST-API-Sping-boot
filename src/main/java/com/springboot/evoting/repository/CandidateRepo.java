package com.springboot.evoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.evoting.model.CandidateEntity;

@Repository
public interface CandidateRepo extends JpaRepository<CandidateEntity,Integer> {

}
