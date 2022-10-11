/*
	* @author bacng
	* @ Date Jun 15, 2022
*/
package Training.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Training.Utils.Validator;

public class BatchManagement {
	public Batch createBatch() {
		String batchDate = null;
		boolean status = false;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the batch name: ");
		String batchName = scanner.nextLine();
		
		do {
			status = false;
			System.out.println("Enter the batch date: ");
			try {
				batchDate = scanner.nextLine();
				status = !(Validator.isDateValid(batchDate));
			} catch (Exception e) {
				status = true;
			}
		
		} while (status);
		Batch batch = new Batch(batchName, batchDate);
		return batch;
	}

//	public void displayBatch(Batch[] batch) {
//		if (batch == null || batch.length == 0) {
//			System.out.println("No any batch");
//			System.out.println("----------------------");
//			return;
//		}
//		int count = 0;
//		for (Batch batch2 : batch) {
//			System.out.println("No #" + ++count);
//			System.out.println("Batch name: " + batch2.getBatchName());
//			System.out.println("Batch date: " + batch2.getBatchDate());
//			Interviewer[] interviewer = batch2.getInterview();
//			if (interviewer == null || interviewer.length == 0) {
//				System.out.println("No any interviewer!");
//			} else {
//				System.out.println("interviewer list: ");
//				for (Interviewer interviewers : interviewer) {
//					System.out.println("+ " + interviewers);
//
//				}
//			}
//
//			Candidate[] candidate = batch2.getCandidates();
//			if (candidate == null || candidate.length == 0) {
//				System.out.println("No any Candidate!");
//			} else {
//				System.out.println("Candidate list: ");
//				for (Candidate candidates : candidate) {
//					System.out.println("+ " + candidates);
//				}
//			}
//		}
//		System.out.println("----------------------------------------");
//	}
	// use normal array
//	public void displayInterviwer(Interviewer[] interviewer) {
//		if (interviewer == null || interviewer.length == 0) {
//			System.out.println("No any interviewer!");
//		} else {
//			System.out.println("interviewer list: ");
//			for (Interviewer interviewers : interviewer) {
//				System.out.println("+ " + interviewers);
//
//			}
//			
//		}
//		System.out.println("----------------------");
//	}
//	
//	public void displayCandidate(Candidate[] candidate) {
//		if (candidate == null || candidate.length == 0) {
//			System.out.println("No any Candidate!");
//		} else {
//			System.out.println("Candidate list: ");
//			for (Candidate candidates : candidate) {
//				System.out.println("+ " + candidates);
//			}
//			
//		}
//		System.out.println("----------------------");
//
//	}
//	
	
	// use list
	public void displayBatch(List<Batch> batches) {
		List<Interviewer> interviewers = new ArrayList<Interviewer>();
		List<Candidate> candidates = new ArrayList<Candidate>();
		if (batches.isEmpty()) {
			System.out.println("No any batch");
			System.out.println("----------------------");
			return;
		}
		int count = 0;

		for (Batch batch2 : batches) {
			System.out.println("No #" + ++count);
			System.out.println("Batch name: " + batch2.getBatchName());
			System.out.println("Batch date: " + batch2.getBatchDate());

			if (batch2.getInterview() == null) {
				System.out.println("No any interviewer!");
			} else {
				
				System.out.println("interviewer list: ");
				for (Interviewer interviewer : batch2.getInterview()) {
					System.out.println("+ " + interviewer);

				}
			}

			if (batch2.getCandidates() == null) {
				System.out.println("No any candidate!");
			} else {
		
				System.out.println("Candidate list: ");
				for (Candidate candidate : batch2.getCandidates()) {
					System.out.println("+ " + candidate);

				}

			}

		}
//
		System.out.println("----------------------------------------");
	}

	public void displayInterviwer(List<Interviewer> interviewer) {
		if (interviewer.isEmpty()) {
			System.out.println("No any interviewer!");
		} else {
			System.out.println("interviewer list: ");
			for (Interviewer interviewers : interviewer) {
				System.out.println("+ " + interviewers);

			}
			
		}
		System.out.println("----------------------");
	}
	public void displayCandidate(List<Candidate> candidates) {
		if (candidates.isEmpty()) {
			System.out.println("No any candidates!");
		} else {
			System.out.println("candidates list: ");
			for (Candidate candidate : candidates) {
				System.out.println("+ " + candidate);

			}
			
		}
		System.out.println("----------------------");
	}





	public Interviewer createInterviewer() {
		Interviewer interviewer = new Interviewer();
		interviewer.input();
		return interviewer;
	}

	public Candidate createCadidate() {
		Candidate cadidate = new Candidate();
		cadidate.input();
		return cadidate;
	}

}
