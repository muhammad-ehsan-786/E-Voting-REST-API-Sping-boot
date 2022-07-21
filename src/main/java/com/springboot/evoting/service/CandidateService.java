package com.springboot.evoting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.evoting.model.CandidateEntity;
import com.springboot.evoting.repository.CandidateRepo;

@Service
public class CandidateService {

	@Autowired
	private CandidateRepo candidateRepo;
	public void saveCandidate(CandidateEntity candidate) {
		
		candidateRepo.save(candidate);
	}
	
	public void delelteCandidate(CandidateEntity candidate) {
		candidateRepo.deleteById(candidate.getCandidateId());
	}
	
	public List<CandidateEntity> getAllCandidate() {
		return candidateRepo.findAll();
	}
}
