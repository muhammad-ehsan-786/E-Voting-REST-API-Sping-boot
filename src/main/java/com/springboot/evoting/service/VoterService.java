package com.springboot.evoting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.evoting.model.VoterEntity;
import com.springboot.evoting.repository.VoterRepo;



@Service
public class VoterService {

	@Autowired
	private VoterRepo voterRepo;
	
	public void saveVoter(VoterEntity voterEntity) {
		
		voterRepo.save(voterEntity);
		
	}
	
	public void deleteVoter(VoterEntity voterEntity) {
		voterRepo.deleteById(voterEntity.getVoterId());
	}
	
	public List<VoterEntity> findAllVoter(){
		
		return voterRepo.findAll();
	}
}
