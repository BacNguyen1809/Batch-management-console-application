/*
	* @author bacng
	* @ Date Jul 28, 2022
*/
package Training.Utils.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Period;

import Training.Models.Interviewer;
import Training.Utils.DBConnection;

public class InterviewerDAO {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet results = null;
	
	public void insertInterviewer(Interviewer interviewer) throws SQLException {
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.INTERVIEWER_QUERY_ADD);
			preparedStatement.setInt(1, interviewer.getId());
			preparedStatement.setString(2, interviewer.getCandidateName());
			preparedStatement.setInt(3, interviewer.getGender());
			preparedStatement.setString(4, interviewer.getBirthDate());
			preparedStatement.setString(5, interviewer.getEmail());
			preparedStatement.setInt(6, interviewer.getExperience());
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

}
