package com.candidate.rest;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.candidate.model.Candidate;
import com.candidate.service.ICandidateService;

@RestController
@RequestMapping("/candidate")
@PreAuthorize(value = "hasAnyRole('ADMIN')")
public class CandidateRest {

	private static final Logger logger = LoggerFactory.getLogger(CandidateRest.class);

	@Autowired
	private ICandidateService candidateService;

	@PostMapping("/createCandidate")
	public Candidate createCandidate(Candidate candidate) {
		logger.info("CandidateRest.createCandidate() " + candidate);
		return candidateService.createCandidate(candidate);
	}

	@PostMapping("/updateCandidate")
	public Candidate updateCandidate(Candidate candidate) {
		logger.info("CandidateRest.updateCandidate() " + candidate);
		return candidateService.updateCandidate(candidate);
	}

	@GetMapping("/getAllCandidates")
	public Iterable<Candidate> getAllCandidates() {
		logger.info("CandidateRest.getAllCandidates() ");
		return candidateService.getAllCandidates();
	}

	@GetMapping("/getCandidateById/{candidateId}")
	public Optional<Candidate> getCandidateById(@PathParam(value = "candidateId") Integer candidateId) {
		logger.info("CandidateRest.getCandidateById() " + candidateId);
		return candidateService.getCandidateById(candidateId);
	}

	@DeleteMapping("/deleteCandidateById/{candidateId}")
	public void deleteCandidateById(@PathParam(value = "candidateId") Integer candidateId) {
		logger.info("CandidateRest.deleteCandidateById() " + candidateId);
		candidateService.deleteCandidateById(candidateId);
	}
	}
