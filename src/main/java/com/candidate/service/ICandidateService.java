package com.candidate.service;

import java.util.Optional;

import com.candidate.model.Candidate;

public interface ICandidateService {
	
	public Candidate createCandidate(Candidate candidate);
	
	public Candidate updateCandidate(Candidate candidate);
	
	public Iterable<Candidate> getAllCandidates();
	
	public Optional<Candidate> getCandidateById(Integer candidateId);
	
	public void deleteCandidateById(Integer candidateId);

}
