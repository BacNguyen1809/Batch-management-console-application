/*
	* @author bacng
	* @ Date Jun 15, 2022
*/
package Training.Models;

import java.util.List;

public class Batch {
	private String batchName;
	private String batchDate;
	private List<Interviewer> interview;
	private List<Candidate> candidates;

	public Batch() {
		super();
	}

	public Batch(String batchName, String batchDate) {
		super();
		this.batchName = batchName;
		this.batchDate = batchDate;

	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getBatchDate() {
		return batchDate;
	}

	public void setBatchDate(String batchDate) {
		this.batchDate = batchDate;
	}

	public List<Interviewer> getInterview() {
		return interview;
	}

	public void setInterview(List<Interviewer> interview) {
		this.interview = interview;
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	@Override
	public String toString() {
		return "Batch [batchName=" + batchName + ", batchDate=" + batchDate + ", interview=" + interview
				+ ", candidates=" + candidates + "]";
	}
	

}
