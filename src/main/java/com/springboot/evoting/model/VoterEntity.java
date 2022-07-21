package com.springboot.evoting.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "voter")
public class VoterEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "voter_id")
	private int voterId;
	
	@Column(name = "voter_cnic")
	private String voterCnic;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id" ,referencedColumnName ="user_id")
	private UsersEntity user;

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(
			name = "votes",
			joinColumns = { @JoinColumn(name = "voter_id" , referencedColumnName ="voter_id")},
			inverseJoinColumns = { @JoinColumn(name ="candidate_id", referencedColumnName = "candidate_id")}
			
			)
	private CandidateEntity candidate;


	public VoterEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public VoterEntity(int voterId, String voterCnic, UsersEntity user, CandidateEntity candidate) {
		super();
		this.voterId = voterId;
		this.voterCnic = voterCnic;
		this.user = user;
		this.candidate = candidate;
	}


	public int getVoterId() {
		return voterId;
	}


	public void setVoterId(int voterId) {
		this.voterId = voterId;
	}


	public String getVoterCnic() {
		return voterCnic;
	}


	public void setVoterCnic(String voterCnic) {
		this.voterCnic = voterCnic;
	}


	public UsersEntity getUser() {
		return user;
	}


	public void setUser(UsersEntity user) {
		this.user = user;
	}


	public CandidateEntity getCandidate() {
		return candidate;
	}


	public void setCandidate(CandidateEntity candidate) {
		this.candidate = candidate;
	}
	

}
