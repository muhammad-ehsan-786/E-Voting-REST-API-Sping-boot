package com.springboot.evoting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.evoting.model.CandidateEntity;
import com.springboot.evoting.service.CandidateService;

@RestController
@RequestMapping("/api/candidate")

public class CandidateController {
	
	@Autowired
	private CandidateService candidateService;
	
	@PostMapping("/add")
	public String insertCandiate(@RequestBody CandidateEntity candidate) {
		
		candidateService.saveCandidate(candidate);
		
		return "Candidate is added into table";
		
	}
	
	@DeleteMapping("/delete")
	public String deleteCandidate(@RequestBody CandidateEntity candidate) {
		candidateService.delelteCandidate(candidate);
		return "Candidate Deleted";
	}
	
	@GetMapping("/getall")
	public List<CandidateEntity> getAll(){
		return candidateService.getAllCandidate();
	}
	

}
