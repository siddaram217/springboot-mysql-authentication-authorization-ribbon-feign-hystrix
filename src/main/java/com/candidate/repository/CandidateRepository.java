package com.candidate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.candidate.model.Candidate;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, Integer>{

}
