/*
	* @author bacng
	* @ Date Jun 30, 2022
*/
package Training.Models;

import java.util.List;

public class Relationships {
	private String batchName;
	private List<Integer> interviewerId;
	private List<Integer> candidateId;
	
	
	
	public Relationships() {
		super();
	}
	public Relationships(String batchName, List<Integer> interviewerId, List<Integer> candidateId) {
		super();
		this.batchName = batchName;
		this.interviewerId = interviewerId;
		this.candidateId = candidateId;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public List<Integer> getInterviewerId() {
		return interviewerId;
	}
	public void setInterviewerId(List<Integer> interviewerId) {
		this.interviewerId = interviewerId;
	}
	public List<Integer> getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(List<Integer> candidateId) {
		this.candidateId = candidateId;
	}
	@Override
	public String toString() {
		return "Relationships [batchName=" + batchName + ", interviewerId=" + interviewerId + ", candidateId="
				+ candidateId + "]";
	}
	
	
	

}
