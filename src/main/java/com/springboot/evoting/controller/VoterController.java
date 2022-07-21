package com.springboot.evoting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.evoting.model.CandidateEntity;
import com.springboot.evoting.model.UsersEntity;
import com.springboot.evoting.model.VoterEntity;
import com.springboot.evoting.repository.VoterRepo;
import com.springboot.evoting.service.VoterService;

@RestController
@RequestMapping("/api/voter")
public class VoterController {

	
	@Autowired
	private VoterService voterService;
	
	@Autowired
	private VoterRepo voterRepo;
	
	@PostMapping("/add")
	public ResponseEntity<String> addVoter(@RequestBody VoterEntity voter,@RequestBody CandidateEntity candidate){
		
		if(voterRepo.existsByvoterCnic(voter.getVoterCnic()))
		{
			return new ResponseEntity<>("Voter already exits",HttpStatus.BAD_REQUEST);
		}
		
		VoterEntity voterEntity = new VoterEntity();
		voterEntity.setVoterCnic(voter.getVoterCnic());
		
		//voterEntity.setUser(user);
		
		voterEntity.setCandidate(candidate);
		
		
		voterService.saveVoter(voterEntity);
		return new ResponseEntity<>("Voter created",HttpStatus.OK);
	}
	
	
}
