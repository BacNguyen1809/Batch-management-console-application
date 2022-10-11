/*
	* @author bacng
	* @ Date Jul 28, 2022
*/
package Training.Utils.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Training.Models.Candidate;
import Training.Utils.DBConnection;

public class CandidateDAO {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet results = null;
	
	public void insertCandidate(Candidate candidate) throws SQLException {
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.CANDIDATE_QUERY_ADD);
			preparedStatement.setInt(1, candidate.getId());
			preparedStatement.setString(2, candidate.getCandidateName());
			preparedStatement.setInt(3, candidate.getGender());
			preparedStatement.setString(4, candidate.getBirthDate());
			preparedStatement.setString(5, candidate.getEmail());
			preparedStatement.setDouble(6, candidate.getGpa());
			preparedStatement.setString(7, candidate.getStatus());
			results = preparedStatement.executeQuery();
			while(results.next()) {
				if(results.getInt(1)==1) {
					System.out.println("Saved");
				}
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
	}

	public void updateCandidateStatus(int id, String updateStatus) throws SQLException {
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.CANDIDATE_QUERY_UPDATE);
			preparedStatement.setInt(2, id);
			preparedStatement.setString(1, updateStatus);
			int i = preparedStatement.executeUpdate();
			System.out.println("updated "+i+" row");
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
		
	}

	public void deleteCandidateFromBatch(String batchName, int id) throws SQLException {
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.CANDIDATE_QUERY_DELETE_BY_BATCH_NAME);
			preparedStatement.setString(1, batchName);
			preparedStatement.setInt(2, id);
		
			int i = preparedStatement.executeUpdate();
			if(i> 0) {
				System.out.println("Delete Success ");
			}else {
				System.out.println("Delete fail ");
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
		
		
	}

	public void deleteAllCandidateFromBatch(String batchName) throws SQLException {
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.CANDIDATE_QUERY_DELETE_All_FROM_BATCH);
			preparedStatement.setString(1, batchName);
			
		
			int i = preparedStatement.executeUpdate();
			if(i> 0) {
				System.out.println("Delete Success ");
			}else {
				System.out.println("Delete fail ");
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
		
		
	}
		
	

}
