/*
	* @author bacng
	* @ Date Jul 28, 2022
*/
package Training.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Training.Models.Batch;
import Training.Models.Candidate;
import Training.Models.Interviewer;
import Training.Models.Relationships;
import Training.Utils.DAO.SQLCommand;

public class GetDataFromDatabase {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet results = null;
	public List<Batch> getOnlyBatchs() throws SQLException{
		List<Batch> onlyBatchs = new ArrayList<Batch>();
		Batch batch = null;
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.BATCH_QUERY_FIND_ALL);
			results = preparedStatement.executeQuery();
			while(results.next()) {
				batch =new Batch();
				
				batch.setBatchName(results.getString("batch_name"));
				batch.setBatchDate(results.getString("batch_date"));
				onlyBatchs.add(batch);
			}
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return onlyBatchs;
	}
	public List<Interviewer> getInterviewers() throws SQLException{
		List<Interviewer> interviewers = new ArrayList<>();
		Interviewer interviewer = null;
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.INTERVIEWER_QUERY_FIND_ALL);
			results = preparedStatement.executeQuery();
			while(results.next()) {
				interviewer =new Interviewer();
				
				interviewer.setId(results.getInt("id"));
				interviewer.setCandidateName(results.getString("name"));
				interviewer.setGender(results.getInt("gender"));
				interviewer.setBirthDate(results.getString("birth_day"));
				interviewer.setEmail(results.getString("email"));
				interviewer.setExperience(results.getInt("experience"));
				interviewers.add(interviewer);
			}
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return interviewers;
	}
	
	public List<Candidate> getCandidates() throws SQLException{
		List<Candidate> candidates = new ArrayList<>();
		Candidate candidate = null;
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.CANDIDATE_QUERY_FIND_ALL);
			results = preparedStatement.executeQuery();
			while(results.next()) {
				candidate =new Candidate();
				
				candidate.setId(results.getInt("id"));
				candidate.setCandidateName(results.getString("name"));
				candidate.setGender(results.getInt("gender"));
				candidate.setBirthDate(results.getString("birth_day"));
				candidate.setEmail(results.getString("email"));
				candidate.setGpa(results.getDouble("gpa"));
				candidate.setStatus(results.getString("status"));
				candidates.add(candidate);
			}
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return candidates;
	}
	public List<Relationships> getRelationships() throws SQLException{
		List<Relationships> relationships = new ArrayList<>();
		Relationships relationships2 = null;
		List<Integer> interviewerID = null;
		List<Integer> candidateID = null;
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.BATCH_RELATIONSHIP_QUERY_FIND_ALL);
			results = preparedStatement.executeQuery();
			while(results.next()) {
				relationships2 =new Relationships();
				interviewerID = new ArrayList<Integer>();
				candidateID = new ArrayList<Integer>();
				relationships2.setBatchName(results.getString("batch_name"));
				interviewerID.add(results.getInt("interviewer_id"));
				candidateID.add(results.getInt("candidate_id"));
				relationships2.setInterviewerId(interviewerID);
				relationships2.setCandidateId(candidateID);
				relationships.add(relationships2);
			}
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return relationships;
	}


}
