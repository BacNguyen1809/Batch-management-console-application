/*
	* @author bacng
	* @ Date Jun 25, 2022
*/
package Training.Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import Training.Models.Batch;
import Training.Models.Candidate;
import Training.Models.Interviewer;
import Training.Models.Relationships;

public class ReadDataFromTextFile {
	public static List<Interviewer> GsonInterviewerData() {
		Gson gson = new Gson();
		List<Interviewer> interviewers2 = new ArrayList<Interviewer>();
		Interviewer[] interviewers = null;
		try (FileReader batchFileIn = new FileReader("InterviewerListGson.txt");
				BufferedReader readFile = new BufferedReader(batchFileIn);) {
			interviewers = gson.fromJson(readFile, Interviewer[].class);
			interviewers2 = Arrays.asList(interviewers);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (NullPointerException e) {

		}
		return interviewers2;

	}

	public static List<Candidate> GsonCandidateData() {
		Gson gson = new Gson();
		List<Candidate> candidates2 = new ArrayList<Candidate>();
		Candidate[] candidates = null;
		try (FileReader batchFileIn = new FileReader("CandidaterListGson.txt");
				BufferedReader readFile = new BufferedReader(batchFileIn);) {
			candidates = gson.fromJson(readFile, Candidate[].class);
			candidates2 = Arrays.asList(candidates);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (NullPointerException e) {

		}
		return candidates2;

	}

	public static List<Batch> GsonBatchData() {
		Gson gson = new Gson();
		List<Batch> batches2 = new ArrayList<Batch>();
		Batch[] batchs = null;
		try (FileReader batchFileIn = new FileReader("BatchListGson.txt");
				BufferedReader readFile = new BufferedReader(batchFileIn);) {
			batchs = gson.fromJson(readFile, Batch[].class);
			batches2 = Arrays.asList(batchs);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (NullPointerException e) {

		}
		return batches2;

	}

	public static List<Relationships> GsonRelationshipData() {
		Gson gson = new Gson();
		List<Relationships> relationships = new ArrayList<Relationships>();
		Relationships[] relationships2 = null;
		try (FileReader batchFileIn = new FileReader("RelationshipListGson.txt");
				BufferedReader readFile = new BufferedReader(batchFileIn);) {
			relationships2 = gson.fromJson(readFile, Relationships[].class);
			relationships = Arrays.asList(relationships2);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return relationships;

	}

	// -------------------not use gson---------------------------
	public static List<Batch> batchesData() {
		List<Batch> batches = new ArrayList<Batch>();
		List<Interviewer> AddInterviewer = null;
		List<Candidate> AddCandidate = null;
		Batch batch = null;
		Candidate candidate = null;
		Interviewer interviewer = null;
		String line = null;

		try (FileReader batchFileIn = new FileReader("BatchInformation.txt");
				BufferedReader readFile = new BufferedReader(batchFileIn);) {
			while ((line = readFile.readLine()) != null) {
				batch = new Batch();

				AddInterviewer = new ArrayList<Interviewer>();
				AddCandidate = new ArrayList<Candidate>();
				String[] arr = line.split(",");
				// only have batch name and batch date information
				if (arr.length == 3) {
					batch = new Batch();
					batch.setBatchName(arr[0]);
					batch.setBatchDate(arr[1]);
					batches.add(batch);
				}
				if (arr.length > 4) {
					// check get information have interviewer information or not
					if (arr[2].equalsIgnoreCase("[")) {
						// take data interviewer

						batch.setBatchName(arr[0]);
						batch.setBatchDate(arr[1]);

						for (int i = 3; i < arr.length;) {
							interviewer = new Interviewer();
							interviewer.setId(Integer.parseInt(arr[i]));
							i += 1;
							interviewer.setCandidateName(arr[i]);
							i += 1;
							interviewer.setGender(Integer.parseInt(arr[i]));
							i += 1;
							interviewer.setBirthDate(arr[i]);
							i += 1;
							interviewer.setEmail(arr[i]);
							i += 1;
							interviewer.setExperience(Integer.parseInt(arr[i]));
							AddInterviewer.add(interviewer);
							i += 1;
							// check finished list interviewer or not
							if (arr[i].equalsIgnoreCase("]")) {
								// finished list interviewer
								// check have cadidate information or not
								int j = i + 1;
								if ((j + 1) >= arr.length) {
									break;
								}
								if (arr[j].equalsIgnoreCase("[")) {
									// take cadidate information
									for (int j2 = (j + 1); j2 < arr.length;) {
										candidate = new Candidate();
										candidate.setId(Integer.parseInt(arr[j2]));
										++j2;
										candidate.setCandidateName(arr[j2]);
										++j2;
										candidate.setGender(Integer.parseInt(arr[j2]));
										++j2;
										candidate.setBirthDate(arr[j2]);
										++j2;
										candidate.setEmail(arr[j2]);
										++j2;
										candidate.setGpa(Double.parseDouble(arr[j2]));
										++j2;
										candidate.setStatus(arr[j2]);
										++j2;
										AddCandidate.add(candidate);
										if (arr[j2].equalsIgnoreCase("]")) {
											i = arr.length;
											break;
										}

									}
								}
							}
						}
						// add interviewer list and candidates list into batch
						if (AddCandidate.isEmpty()) {
							batch.setCandidates(null);
						} else {
							batch.setCandidates(AddCandidate);
						}
						if (AddInterviewer.isEmpty()) {
							batch.setInterview(null);
						} else {
							batch.setInterview(AddInterviewer);
						}

					}
					batches.add(batch);

				}

			}
		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		} catch (IOException e1) {

			e1.printStackTrace();
		}

		return batches;
	}

	public static List<Interviewer> interviewerData() {
		List<Interviewer> AddInterviewer = new ArrayList<Interviewer>();
		Interviewer interviewer = null;
		String line = null;

		try (FileReader batchFileIn = new FileReader("InterviewerList.txt");
				BufferedReader readFile = new BufferedReader(batchFileIn);) {
			while ((line = readFile.readLine()) != null) {

				String[] arr = line.split(",");

				for (int i = 0; i < arr.length;) {
					interviewer = new Interviewer();
					interviewer.setId(Integer.parseInt(arr[i]));
					i += 1;
					interviewer.setCandidateName(arr[i]);
					i += 1;
					interviewer.setGender(Integer.parseInt(arr[i]));
					i += 1;
					interviewer.setBirthDate(arr[i]);
					i += 1;
					interviewer.setEmail(arr[i]);
					i += 1;
					interviewer.setExperience(Integer.parseInt(arr[i]));
					AddInterviewer.add(interviewer);
					i += 1;

				}

			}
		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		} catch (IOException e1) {

			e1.printStackTrace();
		}

		return AddInterviewer;

	}

	public static List<Candidate> candidateData() {
		List<Candidate> AddCandidate = new ArrayList<Candidate>();
		Candidate candidate = null;
		String line = null;

		try (FileReader batchFileIn = new FileReader("CandidateList.txt");
				BufferedReader readFile = new BufferedReader(batchFileIn);) {
			while ((line = readFile.readLine()) != null) {

				String[] arr = line.split(",");

				for (int i = 0; i < arr.length;) {
					candidate = new Candidate();
					candidate.setId(Integer.parseInt(arr[i]));
					++i;
					candidate.setCandidateName(arr[i]);
					++i;
					candidate.setGender(Integer.parseInt(arr[i]));
					++i;
					candidate.setBirthDate(arr[i]);
					++i;
					candidate.setEmail(arr[i]);
					++i;
					candidate.setGpa(Double.parseDouble(arr[i]));
					++i;
					candidate.setStatus(arr[i]);
					++i;
					AddCandidate.add(candidate);

				}

			}
		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		} catch (IOException e1) {

			e1.printStackTrace();
		}

		return AddCandidate;
	}

}
