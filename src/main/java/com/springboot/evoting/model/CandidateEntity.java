package com.springboot.evoting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "candidate")
public class CandidateEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "candidate_id")
	private int candidateId;
	
	@Column(name = "candidate_name")
	private String candidateName;
	
	@Column(name = "candiate_details")
	private String candidateDetails;
	
	@Column(name = "candidate_symbol")
	private String candidateSymbol;
	
	@OneToOne(mappedBy = "candidate")
	private VoterEntity voter;

	public CandidateEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CandidateEntity(int candidateId, String candidateName, String candidateDetails, String candidateSymbol,
			VoterEntity voter) {
		super();
		this.candidateId = candidateId;
		this.candidateName = candidateName;
		this.candidateDetails = candidateDetails;
		this.candidateSymbol = candidateSymbol;
		this.voter = voter;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public String getCandidateaName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getCandidateDetails() {
		return candidateDetails;
	}

	public void setCandidateDetails(String candidateDetails) {
		this.candidateDetails = candidateDetails;
	}

	public String getCandidateSymbol() {
		return candidateSymbol;
	}

	public void setCandidateSymbol(String candidateSymbol) {
		this.candidateSymbol = candidateSymbol;
	}

	public VoterEntity getVoter() {
		return voter;
	}

	public void setVoter(VoterEntity voter) {
		this.voter = voter;
	}
	
	
	
	
}
