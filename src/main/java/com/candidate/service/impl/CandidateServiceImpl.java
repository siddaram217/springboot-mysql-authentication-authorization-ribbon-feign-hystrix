package com.candidate.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.candidate.model.Candidate;
import com.candidate.repository.CandidateRepository;
import com.candidate.service.ICandidateService;

@Service
public class CandidateServiceImpl implements ICandidateService {

	private Logger logger=LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CandidateRepository candidateRepository;
	
	@Transactional
	public Candidate createCandidate(Candidate candidate) {
		logger.info("CandidateServiceImpl.createCandidate() "+candidate);
		return candidateRepository.save(candidate);
	}
	
	@Transactional
	public Candidate updateCandidate(Candidate candidate) {
		logger.info("CandidateServiceImpl.updateCandidate() "+candidate);
		return candidateRepository.save(candidate);
	}
	
	public Iterable<Candidate> getAllCandidates(){
		logger.info("CandidateServiceImpl.getAllCandidates() ");
		return candidateRepository.findAll(); 
	}
	
	public Optional<Candidate> getCandidateById(Integer candidateId) {
		logger.info("CandidateServiceImpl.getCandidateById() "+candidateId);
		return candidateRepository.findById(candidateId);
	}
	
	@Transactional
	public void deleteCandidateById(Integer candidateId) {
		logger.info("CandidateServiceImpl.deleteCandidateById() "+candidateId);
		candidateRepository.deleteById(candidateId);
	}
	
}
