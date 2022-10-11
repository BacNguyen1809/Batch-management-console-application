/*
	* @author bacng
	* @ Date Jun 30, 2022
*/
package Training.Utils;

import java.util.ArrayList;
import java.util.List;

import Training.Models.Batch;

import Training.Models.Candidate;
import Training.Models.Interviewer;
import Training.Models.Relationships;

public class RelationshipUtil {

	public static List<Relationships> setRelationship(List<Batch> batches) {

		List<Relationships> relationships = new ArrayList<Relationships>();
		List<Integer> getInterviewerID = null;
		List<Integer> getCandidateID = null;
		
		Relationships relationship = null;

		
		for (Batch batch2 : batches) {
			relationship = new Relationships();
			getInterviewerID = new ArrayList<Integer>();
			getCandidateID = new ArrayList<Integer>();
			relationship.setBatchName(batch2.getBatchName());
			if(!(batch2.getInterview() == null)) {
			for (Interviewer interviewer5 : batch2.getInterview()) {
				 getInterviewerID.add(interviewer5.getId());
			}
			relationship.setInterviewerId(getInterviewerID);
			}
			if(!(batch2.getCandidates() == null)) {
				for (Candidate candidate5 : batch2.getCandidates()) {
					 getCandidateID.add(candidate5.getId());
				}
				relationship.setCandidateId(getCandidateID);
				}
			relationships.add(relationship);
			
		}
		return relationships;
		
	}

}
