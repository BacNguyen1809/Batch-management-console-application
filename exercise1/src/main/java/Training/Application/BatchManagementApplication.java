/*
	* @author bacng
	* @ Date Jun 16, 2022
*/
package Training.Application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import Training.Models.Batch;
import Training.Models.BatchManagement;
import Training.Models.Candidate;
import Training.Models.Interviewer;
import Training.Models.Relationships;
import Training.Utils.GetDataFromDatabase;
import Training.Utils.MakeRelationship;
import Training.Utils.ReadDataFromTextFile;
import Training.Utils.RelationshipUtil;
import Training.Utils.WriteDataToTextFile;
import Training.Utils.DAO.BatchDAO;
import Training.Utils.DAO.CandidateDAO;
import Training.Utils.DAO.InterviewerDAO;
import Training.Utils.DAO.RelationshipDAO;

public class BatchManagementApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<Batch> onlyBath = new ArrayList<Batch>();
		List<Batch> batches = new ArrayList<Batch>();
		List<Candidate> candidates = new ArrayList<Candidate>();
		List<Interviewer> interviewers = new ArrayList<Interviewer>();
		List<Relationships> relationships = new ArrayList<Relationships>();

		BatchManagement batchManagement = new BatchManagement();
		GetDataFromDatabase getDataFromDatabase = new GetDataFromDatabase();
		InterviewerDAO inDao = new InterviewerDAO();
		CandidateDAO caDao = new CandidateDAO();
		BatchDAO baDao = new BatchDAO();
		RelationshipDAO reDao = new RelationshipDAO();
		Batch batch = null;
		Candidate candidate = null;
		Interviewer interviewer = null;
		boolean statusSystem = true;
		boolean check = true;
		int option = 0;

		String loop = "";

		// load data form InterviewerList file
//		interviewers.addAll(ReadData.interviewerData());
		// load data form CandidateList file
//		candidates.addAll(ReadData.candidateData());
		// load data form BatchInformation File
//		batches.addAll(ReadData.batchesData());
		// load data from InterviewerListGson
		// load data form CandidateList file

		// load data form BatchInformation File
		// batches.addAll(ReadData.GsonBatchData());

		// get relationships between batch interviewer and candidate
		do {
			try {
				System.out.println(
						"Press 1: To choose read data from txt file\n" + "Press 2: To choose read data from database");
				option = Integer.parseInt(scanner.nextLine());
				if (option == 1) {
					check = false;
					readDataFromTxtFile(onlyBath, batches, candidates, interviewers, relationships);
					System.out.println("-----Read Data Completed-----\n");
				} else if (option == 2) {
//				readDataFromDatabase();
					readDataFromDatabase(onlyBath, batches, candidates, interviewers, relationships,
							getDataFromDatabase);
					System.out.println("-----Read Data Completed-----\n");
					check = false;

				} else {
					check = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
				check = true;
			}
		} while (check);

		do {
			menu();
			int key = Integer.parseInt(scanner.nextLine());
			switch (key) {

			case 1:
				if (option == 1) {
					do {
						interviewer = new Interviewer();
						interviewer.input();
						interviewers.add(interviewer);
						System.out.println("Do you want to continue? (Y/N)");
						loop = scanner.nextLine();
					} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');

				} else {
					do {
						interviewer = new Interviewer();
						interviewer.input();
						try {
							inDao.insertInterviewer(interviewer);
							interviewers.add(interviewer);
						} catch (SQLException e) {

							e.printStackTrace();
						}

						System.out.println("Do you want to continue? (Y/N)");
						loop = scanner.nextLine();
					} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');
				}

				break;
			case 2:
				if (option == 1) {
					do {
						candidate = new Candidate();
						candidate.input();
						candidates.add(candidate);
						System.out.println("Do you want to continue? (Y/N)");
						loop = scanner.nextLine();
					} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');

				} else {
					do {
						candidate = new Candidate();
						interviewer.input();
						try {
							caDao.insertCandidate(candidate);
							candidates.add(candidate);
						} catch (SQLException e) {

							e.printStackTrace();
						}

						System.out.println("Do you want to continue? (Y/N)");
						loop = scanner.nextLine();
					} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');
				}

				break;
			case 3:
				if (option == 1) {
					do {
						batch = new Batch();
						batch = batchManagement.createBatch();
						batches.add(batch);
						onlyBath.add(batch);
						System.out.println("Do you want to continue? (Y/N)");
						loop = scanner.nextLine();
					} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');
				} else {
					do {
						batch = new Batch();
						batch = batchManagement.createBatch();
						try {
							baDao.insertBatch(batch);
							batches.add(batch);
							onlyBath.add(batch);
						} catch (SQLException e) {

							e.printStackTrace();
						}

						System.out.println("Do you want to continue? (Y/N)");
						loop = scanner.nextLine();
					} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');
				}

				break;
			case 4:

				if (batches.isEmpty()) {
					System.out.println("No any Batch! Please Input batch fist!!");
					System.out.println("---------------------------------");
					break;
				} else {
					addInterviewers(scanner, batches, interviewers, batchManagement, option, reDao);
				}

				break;
			case 5:

				if (batches.isEmpty()) {
					System.out.println("No any Batch! Please Input batch fist!!");
					System.out.println("---------------------------------");
					break;
				} else {
					addCandidates(scanner, batches, candidates, batchManagement, option, reDao);
				}

				break;
			case 6:
				
					if (batches.isEmpty()) {
						System.out.println("No any Batch! Please Input batch fist!!");
						System.out.println("---------------------------------");
						break;
					} else {
						processBatch(scanner, batches, candidates, batchManagement, option, caDao);
					}
				

				break;

			case 7:
				
					deleteBatch(scanner, batches, batchManagement, baDao, option);
				

				break;
			case 8:
				
					removeOneCandidate(scanner, batches, batchManagement, option, caDao);
				

				break;
			case 9:
				
					removeListCandidate(scanner, batches, batchManagement, option, caDao);
				

				break;
			case 10:

				displayCandidateByCandidateName(scanner, candidates);

				break;
			case 11:

				System.out.println("------------Display all information------");
				batchManagement.displayBatch(batches);
				batchManagement.displayInterviwer(interviewers);
				batchManagement.displayCandidate(candidates);

				break;
			case 0:
				if (option == 1) {
					// write data into txt file
					statusSystem = writeData(onlyBath, batches, candidates, interviewers, relationships);
					
				} else {
					statusSystem = false;
					
				}

				System.out.println("-----EXITED-------");
				break;
			}

		} while (statusSystem);
		scanner.close();
	}

	private static void readDataFromDatabase(List<Batch> onlyBath, List<Batch> batches, List<Candidate> candidates,
			List<Interviewer> interviewers, List<Relationships> relationships, GetDataFromDatabase getDataFromDatabase)
			throws SQLException {
		try {
			interviewers.addAll(getDataFromDatabase.getInterviewers());
		} catch (NullPointerException e) {
			System.out.println("have no available interviewer!!");
		}
		try {
			candidates.addAll(getDataFromDatabase.getCandidates());
		} catch (NullPointerException e) {
			System.out.println("have no available candidate!!");
		}
		try {
			onlyBath.addAll(getDataFromDatabase.getOnlyBatchs());
		} catch (NullPointerException e) {
			System.out.println("have no available batch!!");
		}
		try {
			relationships.addAll(getDataFromDatabase.getRelationships());
		} catch (NullPointerException e) {
			System.out.println("have no available batch!!");
		}

		batches.addAll(MakeRelationship.setBatchesFromDatabase(interviewers, candidates, onlyBath, relationships));
	}

	private static void readDataFromTxtFile(List<Batch> onlyBath, List<Batch> batches, List<Candidate> candidates,
			List<Interviewer> interviewers, List<Relationships> relationships) {
		try {
			interviewers.addAll(ReadDataFromTextFile.GsonInterviewerData());
		} catch (NullPointerException e) {
			System.out.println("have no available interviewer!!");
		}
		try {
			candidates.addAll(ReadDataFromTextFile.GsonCandidateData());
		} catch (NullPointerException e) {
			System.out.println("have no available candidate!!");
		}
		try {
			onlyBath.addAll(ReadDataFromTextFile.GsonBatchData());
		} catch (NullPointerException e) {
			System.out.println("have no available batch!!");
		}
		try {
			relationships.addAll(ReadDataFromTextFile.GsonRelationshipData());
		} catch (NullPointerException e) {

		}

		batches.addAll(MakeRelationship.setBatches(interviewers, candidates, onlyBath, relationships));
	}

	private static boolean writeData(List<Batch> onlyBath, List<Batch> batches, List<Candidate> candidates,
			List<Interviewer> interviewers, List<Relationships> relationships) {
		boolean statusSystem;
		statusSystem = false;
		relationships.removeAll(relationships);
		relationships.addAll(RelationshipUtil.setRelationship(batches));
		WriteDataToTextFile.writeToInterviewerListUseGson(interviewers);
		WriteDataToTextFile.writeToCandidateListUseGson(candidates);
		WriteDataToTextFile.writeToRelationshipsListUseGson(relationships);
		for (Batch batch1 : batches) {
			batch1.setCandidates(null);
			batch1.setInterview(null);
		}
		WriteDataToTextFile.writeToBatchListUseGson(onlyBath);
		return statusSystem;
	}

	private static void displayCandidateByCandidateName(Scanner scanner, List<Candidate> candidates) {
		BatchManagement batchManagement = new BatchManagement();
		Collections.sort(candidates);
		batchManagement.displayCandidate(candidates);
//		System.out.println("Enter name candidate want to display:");
//		String candidateName = scanner.nextLine();
//		int count = 0;
//		
//		for (Candidate candidate2 : candidates) {
//			if (candidateName.equals(candidate2.getCandidateName())) {
//				System.out.println("No#" + (++count));
//				System.out.println(candidate2.toString());
//			}
//		}
//		if (count == 0) {
//			System.out.println("Have no candidate with name [" + candidateName + "]");
//		}
//		System.out.println("----------------------------------------------");
	}

	private static void removeListCandidate(Scanner scanner, List<Batch> batches, BatchManagement batchManagement, int option, CandidateDAO caDao) {
		String loop;
		String batchName;
		do {// choose the batch want to delete candidate
			System.out.println("Choose the batch want to delete candidate");
			batchManagement.displayBatch(batches);
			batchName = scanner.nextLine();
			for (Batch batch1 : batches) {
				if (batchName.equals(batch1.getBatchName())) {
					if (!(batch1.getCandidates() == null)) {
						if(option == 1) {
							//DELETE FROM TXT FILE
							batch1.getCandidates().removeAll(batch1.getCandidates());
							batch1.setCandidates(null);
							System.out.println("------Delete completed----");
						}else { //DELETE FROM DATABASE
							try {
								caDao.deleteAllCandidateFromBatch(batchName);
								batch1.getCandidates().removeAll(batch1.getCandidates());
								batch1.setCandidates(null);
							} catch (SQLException e) {
								
								e.printStackTrace();
							}
						}
						
					}
				}

			}

			System.out.println("Do you want to continue:(Y/N)");
			loop = scanner.nextLine();
		} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');
	}

	private static void removeOneCandidate(Scanner scanner, List<Batch> batches, BatchManagement batchManagement, int option, CandidateDAO caDao) {
		String loop;
		String batchName;
		do {// choose the batch want to delete candidate
			System.out.println("Choose the batch want to delete candidate");
			batchManagement.displayBatch(batches);
			batchName = scanner.nextLine();
			for (Batch batch1 : batches) {
				if (batchName.equals(batch1.getBatchName())) {
					if (batch1.getCandidates() == null) {
						System.out.println("No any candidate");
						break;
					} else {
						System.out.println("Choose ID Candidate want to delete:");
						batchManagement.displayCandidate(batch1.getCandidates());
						int deleteCandidateID = Integer.parseInt(scanner.nextLine());
						for (Candidate candidate2 : batch1.getCandidates()) {
							if (deleteCandidateID == candidate2.getId()) {
								if(option ==1) {
									batch1.getCandidates().remove(candidate2);
									System.out.println("------Delete completed----");	
								}else {
									try {
										caDao.deleteCandidateFromBatch(batch1.getBatchName(), candidate2.getId());
										batch1.getCandidates().remove(candidate2);
										
									} catch (SQLException e) {
									
										e.printStackTrace();
									}
								}
								
								break;
							}

						}
						if (batch1.getCandidates().isEmpty()) {
							batch1.setCandidates(null);
						}

					}

				}

			}

			System.out.println("Do you want to continue:(Y/N)");
			loop = scanner.nextLine();
		} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');
	}

	private static void deleteBatch(Scanner scanner, List<Batch> batches, BatchManagement batchManagement, BatchDAO baDao,int option) {
		boolean statusSub;
		String loop;
		int delete = 0;
		do {
			statusSub = false;

			System.out.println("1: Choose batch want to delete:\n" + "2: Delete all Batch:");
			try {

				delete = Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
				statusSub = true;
			}

		} while (statusSub);
		if (delete == 2) {
			System.out.println("Delete all batch. Are you sure:(Y/N)");
			loop = scanner.nextLine();
			if (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y') {
				if(option ==1) {
					batches.removeAll(batches);	
					System.out.println("--------Deleted---------");
				}else {
					try {
						baDao.deleteAllBatch();
						batches.removeAll(batches);
						System.out.println("--------Deleted---------");
						
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					
				}
				
				
				
			}

		}
		if (delete == 1) {
			do {
				System.out.println("Choose Name Batch want to delete:");
				batchManagement.displayBatch(batches);
				String deleteBatchName = scanner.nextLine();
				for (Batch batch1 : batches) {
					if (deleteBatchName.equals(batch1.getBatchName())) {
						if(option == 1) {
							batches.remove(batch1);
							System.out.println("------Delete completed----");
						}else {
							try {
								baDao.removeByBatchName(batch1.getBatchName());
								batches.remove(batch1);
								System.out.println("------Delete completed----");
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
					
						break;
					}
				}

				System.out.println("Do you want to continue:(Y/N)");
				loop = scanner.nextLine();
			} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');
		}
	}

	private static void processBatch(Scanner scanner, List<Batch> batches, List<Candidate> candidates,
			BatchManagement batchManagement, int option, CandidateDAO caDao) {
		String loop;
		String batchName;
		int IdCandidate;
		String updateStatus;
		do {
			batchManagement.displayBatch(batches);
			System.out.println("Enter batch name want to process");
			batchName = scanner.nextLine();
			for (Batch batch1 : batches) {
				if (batch1.getBatchName().equals(batchName)) {
					// display candidate list
					if (batch1.getCandidates() == null) {
						System.out.println("No any Candidate! Please input candidate fist");
						System.out.println("---------------------------");
						break;
					} else {

						System.out.println("Enter Id candidate want to change status: ");
						IdCandidate = Integer.parseInt(scanner.nextLine());

						for (Candidate cadidate2 : batch1.getCandidates()) {
							if (IdCandidate == cadidate2.getId()) {
								System.out.println("type status: (pass/fail)");
								updateStatus = scanner.nextLine();
								cadidate2.setStatus(updateStatus);
								// update information in Candidate list
								for (Candidate candidate3 : candidates) {
									if (candidate3.getId() == IdCandidate) {
										//update candidate status
										if(option == 1) {
											candidate3.setStatus(updateStatus);	
										}else {
											try {
												caDao.updateCandidateStatus(candidate3.getId(), updateStatus);
												candidate3.setStatus(updateStatus);	
											} catch (SQLException e) {
												
												e.printStackTrace();
											}
										}
										
									}

								}

							}
						}

					}

				}

			}
			System.out.println("Do you want to continue? (Y/N)");
			loop = scanner.nextLine();
		} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');
	}

	private static void addCandidates(Scanner scanner, List<Batch> batches, List<Candidate> candidates,
			BatchManagement batchManagement, int option, RelationshipDAO reDao) {
		List<Candidate> addCandidate;
		String loop;
		String batchName;
		int IdCandidate;
		do {
			addCandidate = new ArrayList<Candidate>();
			batchManagement.displayBatch(batches);
			System.out.println("Enter batch name want to add candidate");
			batchName = scanner.nextLine();
			for (Batch batch1 : batches) {
				if (batch1.getBatchName().equals(batchName)) {
					// display candidate list
					if (candidates.isEmpty()) {
						System.out.println("No any Candidate! Please input candidate fist");
						System.out.println("---------------------------");
						break;
					} else {
						batchManagement.displayCandidate(candidates);
						System.out.println("Enter Id candidate want to add to Batch name: " + batch1.getBatchName());
						IdCandidate = Integer.parseInt(scanner.nextLine());

						for (Candidate cadidate2 : candidates) {
							if (IdCandidate == cadidate2.getId()) {
								//add relationship between batch and candidate
								if (option == 1) {
									addCandidate.add(cadidate2);
								} else {

									try {
										reDao.insertBatchCandidate(batch1.getBatchName(), cadidate2.getId());
										addCandidate.add(cadidate2);
									} catch (SQLException e) {

										e.printStackTrace();
									}
								}
							}
						}

					}
					if (batch1.getCandidates() != null) {
						addCandidate.addAll(batch1.getCandidates());
					}
					batch1.setCandidates(addCandidate);
				}

			}
			System.out.println("Do you want to continue? (Y/N)");
			loop = scanner.nextLine();

		} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');
	}

	private static void addInterviewers(Scanner scanner, List<Batch> batches, List<Interviewer> interviewers,
			BatchManagement batchManagement, int option, RelationshipDAO reDao) {
		List<Interviewer> addInterviewer;
		String loop;
		String batchName;
		int IdInterviewer;
		do {
			batchManagement.displayBatch(batches);
			System.out.println("Enter batch name want to add interviewer");
			addInterviewer = new ArrayList<Interviewer>();
			batchName = scanner.nextLine();
			for (Batch batch1 : batches) {
				if (batch1.getBatchName().equals(batchName)) {
					// display interviewers list
					if (interviewers.isEmpty()) {
						System.out.println("No any Interviewer! Please input interviewer fist");
						System.out.println("---------------------------");
						break;
					} else {
						batchManagement.displayInterviwer(interviewers);
						System.out.println("Enter Id interviewer want to add to Batch name: " + batch1.getBatchName());
						IdInterviewer = Integer.parseInt(scanner.nextLine());

						for (Interviewer interviewer2 : interviewers) {
							if (IdInterviewer == interviewer2.getId()) {
								// add relationship between batch and interviewer
								if (option == 1) {
									addInterviewer.add(interviewer2);
								} else {

									try {
										reDao.insertBatchInterviewer(batch1.getBatchName(), interviewer2.getId());
										addInterviewer.add(interviewer2);
									} catch (SQLException e) {

										e.printStackTrace();
									}

								}
							}
						}

					}
					if (batch1.getInterview() != null) {
						addInterviewer.addAll(batch1.getInterview());
					}

					batch1.setInterview(addInterviewer);
				}

			}
			System.out.println("Do you want to continue? (Y/N)");
			loop = scanner.nextLine();

		} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');
	}

	private static void menu() {

		System.out.println("1:Enter Interviewer Information " + "\n"
		+ "2:Enter Candidates Information " + "\n"
				+ "3:Enter Batch Information " + "\n" 
		+ "4.Add one or more interviewer(s) into a specific Batch" + "\n"
				+ "5.Add one or more candidate(s) into a specific Batch " + "\n" 
		+ "6:Process Batch Interviewer " + "\n"
				+ "7:Delete Batch " + "\n" 
		+ "8:Remove 1 candidate out of the Batch " + "\n"
				+ "9:Remove list candidate out of the Batch " 
		+ "\n" + "10:Display candidate based on candidate's name "
				+ "\n" + "11:Display all information " 
		+ "\n" + "0:Exit program");
	}

}
