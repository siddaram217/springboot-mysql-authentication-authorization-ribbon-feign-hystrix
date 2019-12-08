package com.candidate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="candidate")
public class Candidate {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="candidate_id")
	private Integer candidateId;
	
	@Column(name="candidate_name",length=50)
	private String candidateName;
	
	@Column(name="job_title",length=50)
	private String jobTitle;
	
	@Column(name="job_location",length=50)
	private String jobLocation;
	
	@Column(name="job_salary")
	private Integer jobSalary;

	public Integer getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	public Integer getJobSalary() {
		return jobSalary;
	}

	public void setJobSalary(Integer jobSalary) {
		this.jobSalary = jobSalary;
	}

	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", candidateName=" + candidateName + ", jobTitle=" + jobTitle
				+ ", jobLocation=" + jobLocation + ", jobSalary=" + jobSalary + "]";
	}
	
}
