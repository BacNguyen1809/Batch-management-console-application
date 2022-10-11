/*
	* @author bacng
	* @ Date Jul 28, 2022
*/
package Training.Utils.DAO;

public class SQLCommand {

	public static  String CANDIDATE_QUERY_DELETE_All_FROM_BATCH =" DELETE batch_interviewer_candidate "
			+ "WHERE batch_name = ? ";

	public static  String CANDIDATE_QUERY_DELETE_BY_BATCH_NAME = "DELETE batch_interviewer_candidate "
			+ "WHERE batch_name = ? AND candidate_id=? ";

	public static  String BATCH_QUERY_DELETE_BY_BATCH_NAME = "DELETE batch_list WHERE batch_name = ?\n"
															+ "DELETE batch_interviewer_candidate WHERE batch_name = ?";

	public static  String BATCH_QUERY_DELETE_ALL = "TRUNCATE TABLE batch_list\n"
											+ "TRUNCATE TABLE batch_interviewer_candidate";

	public static  String CANDIDATE_QUERY_UPDATE = "UPDATE candidate_list SET status = ? WHERE id = ?";

	public static String INTERVIEWER_QUERY_ADD = "INSERT INTO interviwer_list(id, name, gender, birth_day, email, experience\n) "
			+ " VALUES (?, ?, ?, ?, ?, ?)\n" 
			+ "SELECT @@ROWCOUNT";

	public static String CANDIDATE_QUERY_ADD = "INSERT INTO candidate_list(id, name, gender, birth_day, email, gpa, status\n) "
			+ " VALUES (?, ?, ?, ?, ?, ?,?)\n" 
			+ "SELECT @@ROWCOUNT";

	public static String BATCH_QUERY_ADD = "INSERT INTO batch_list(batch_name, batch_date\n) " 
			+ " VALUES (?, ?)\n"
			+ "SELECT @@ROWCOUNT";
	public static String BATCH_INTERVIEWER_QUERY_ADD = "INSERT INTO batch_interviewer_candidate(batch_name, interviewer_id\n) "
			+ " VALUES (?, ?)\n" 
			+ "SELECT @@ROWCOUNT";
	public static String BATCH_CANDIDATE_QUERY_ADD = "INSERT INTO batch_interviewer_candidate(batch_name,candidate_id\n) "
			+ " VALUES (?, ?)\n" 
			+ "SELECT @@ROWCOUNT";

	public static String CANDIDATE_QUERY_FIND_ALL = "SELECT id, name, gender, birth_day, email, gpa, status\n"
			+ "FROM candidate_list";
	public static String INTERVIEWER_QUERY_FIND_ALL = "SELECT id, name, gender, birth_day, email, experience\n"
			+ "FROM interviwer_list";
	public static String BATCH_QUERY_FIND_ALL = "SELECT batch_name, batch_date\n" + "FROM batch_list";
	public static String BATCH_RELATIONSHIP_QUERY_FIND_ALL = "SELECT batch_name, interviewer_id, candidate_id\n"
			+ "FROM batch_interviewer_candidate";

}
