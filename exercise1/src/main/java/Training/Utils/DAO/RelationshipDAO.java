/*
	* @author bacng
	* @ Date Jul 28, 2022
*/
package Training.Utils.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Training.Utils.DBConnection;

public class RelationshipDAO {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet results = null;

	public void insertBatchInterviewer(String batchName, int id) throws SQLException {
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.BATCH_INTERVIEWER_QUERY_ADD);
			preparedStatement.setString(1, batchName);
			preparedStatement.setInt(2, id);

			results = preparedStatement.executeQuery();
			while (results.next()) {
				if (results.getInt(1) == 1) {
					System.out.println("Saved");
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void insertBatchCandidate(String batchName, int id) throws SQLException {
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.BATCH_CANDIDATE_QUERY_ADD);
			preparedStatement.setString(1, batchName);
			preparedStatement.setInt(2, id);

			results = preparedStatement.executeQuery();
			while (results.next()) {
				if (results.getInt(1) == 1) {
					System.out.println("Saved");
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
