/*
	* @author bacng
	* @ Date Jun 30, 2022
*/
package Training.Utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Training.Models.Batch;
import Training.Models.Candidate;
import Training.Models.Interviewer;
import Training.Models.Relationships;

public class MakeRelationship {

	public static Collection<? extends Batch> setBatches(List<Interviewer> interviewers, List<Candidate> candidates,
			List<Batch> onlyBath, List<Relationships> relationships) {

		List<Batch> batches = new ArrayList<Batch>();

		List<Interviewer> addFistInterviewer = null;
		List<Candidate> addFistCandidate = null;
		// insert interviewer and candidate(if have) into batch
		for (Relationships relationships2 : relationships) {
			for (Batch batch6 : onlyBath) {
				addFistInterviewer = new ArrayList<Interviewer>();
				addFistCandidate = new ArrayList<Candidate>();
				if (batch6.getBatchName().equals(relationships2.getBatchName())) {
					// insert interviewer into batch
					for (Interviewer interviewer5 : interviewers) {
						if (!(relationships2.getInterviewerId() == null)) {
							for (Integer interviewerId : relationships2.getInterviewerId()) {
								if (interviewer5.getId() == interviewerId) {
									addFistInterviewer.add(interviewer5);
								}

							}

						}
						if (batch6.getInterview() == null) {
							batch6.setInterview(null);
						}
						batch6.setInterview(addFistInterviewer);
					}
					// insert candidates into batch
					for (Candidate candidate5 : candidates) {
						if (!(relationships2.getCandidateId() == null)) {
							for (Integer candidateId : relationships2.getCandidateId()) {
								if (candidate5.getId() == candidateId) {
									addFistCandidate.add(candidate5);
								}

							}

						}

						batch6.setCandidates(addFistCandidate);
					}
					if (batch6.getCandidates() == null) {
						batch6.setCandidates(null);
					}
					batches.add(batch6);
				}else {
					batches.add(batch6);
				}

			}
		}

		return batches;
	}

	public static Collection<? extends Batch> setBatchesFromDatabase(List<Interviewer> interviewers,
			List<Candidate> candidates, List<Batch> onlyBath, List<Relationships> relationships) {
		List<Batch> batches = new ArrayList<Batch>();
		List<Relationships> newRelationships = new ArrayList<Relationships>();
		List<Integer> interviewerId = null;
		List<Integer> candidateId = null;

		// create new relationship have list of cadidate and interviewer
		for (Relationships relationships2 : relationships) {
			if (newRelationships.isEmpty()) {
				newRelationships.add(relationships2);
			} else {
				for (int i = 0; i < newRelationships.size(); i++) {
					if (relationships2.getBatchName().equals(newRelationships.get(i).getBatchName())) {
						interviewerId = new ArrayList<Integer>();
						interviewerId.addAll(newRelationships.get(i).getInterviewerId());
						interviewerId.addAll(relationships2.getInterviewerId());
						newRelationships.get(i).setInterviewerId(interviewerId);

						candidateId = new ArrayList<Integer>();
						candidateId.addAll(newRelationships.get(i).getCandidateId());
						candidateId.addAll(relationships2.getCandidateId());
						newRelationships.get(i).setCandidateId(candidateId);
					} else {
						if ((i + 1) == newRelationships.size()) {
							newRelationships.add(relationships2);
							break;
						}
					}

				}

			}
		}

		// make relationship for batch
		List<Interviewer> addFistInterviewer = null;
		List<Candidate> addFistCandidate = null;
		// insert interviewer and candidate(if have) into batch
		for (Relationships relationships2 : newRelationships) {
			for (Batch batch6 : onlyBath) {
				addFistInterviewer = new ArrayList<Interviewer>();
				addFistCandidate = new ArrayList<Candidate>();
				if (batch6.getBatchName().equals(relationships2.getBatchName())) {
					// insert interviewer into batch
					for (Interviewer interviewer5 : interviewers) {
						if (!(relationships2.getInterviewerId() == null)) {
							for (Integer interviewerId1 : relationships2.getInterviewerId()) {
								if (interviewer5.getId() == interviewerId1) {
									addFistInterviewer.add(interviewer5);
								}

							}

						}
						if (batch6.getInterview() == null) {
							batch6.setInterview(null);
						}
						batch6.setInterview(addFistInterviewer);
					}
					// insert candidates into batch
					for (Candidate candidate5 : candidates) {
						if (!(relationships2.getCandidateId() == null)) {
							for (Integer candidateId1 : relationships2.getCandidateId()) {
								if (candidate5.getId() == candidateId1) {
									addFistCandidate.add(candidate5);
								}

							}

						}

						batch6.setCandidates(addFistCandidate);
					}
					if (batch6.getCandidates() == null) {
						batch6.setCandidates(null);
					}
					batches.add(batch6);
				}else {
					batches.add(batch6);
				}

			}
		}

		return batches;

	}

}
