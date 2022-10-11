/*
	* @author bacng
	* @ Date Jul 28, 2022
*/
package Training.Utils.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Training.Models.Batch;

import Training.Utils.DBConnection;

public class BatchDAO {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet results = null;
	
	public void insertBatch(Batch batch) throws SQLException {
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.BATCH_QUERY_ADD);
			preparedStatement.setString(1, batch.getBatchName());
			preparedStatement.setString(2, batch.getBatchDate());
		
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

	public void deleteAllBatch() throws SQLException {
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.BATCH_QUERY_DELETE_ALL);
		
			int i = preparedStatement.executeUpdate();
			if(i>0) {
				System.out.println("Deleted all batch");	
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

	public void removeByBatchName(String batchName) throws SQLException {
		try {
			connection = DBConnection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.BATCH_QUERY_DELETE_BY_BATCH_NAME);
			preparedStatement.setString(1, batchName);
			preparedStatement.setString(2, batchName);
		
			int i = preparedStatement.executeUpdate();
			System.out.println("Deleted "+i+" row(batch and relationship of batch)");
			
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
