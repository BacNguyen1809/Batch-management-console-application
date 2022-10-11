/*
	* @author bacng
	* @ Date Jun 25, 2022
*/
package Training.Utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import Training.Models.Batch;
import Training.Models.Candidate;
import Training.Models.Interviewer;
import Training.Models.Relationships;

public class WriteDataToTextFile {
	public static void  writeToInterviewerListUseGson(List<Interviewer> interviewers) {
		Gson gson = new Gson();
		try(FileWriter batchWriter = new FileWriter("InterviewerListGson.txt");
				BufferedWriter batchBufferedWriter = new BufferedWriter(batchWriter)){
			gson.toJson(interviewers, batchBufferedWriter);
			
		} catch (IOException e) {


			e.printStackTrace();
		}
	}
	
	public static void  writeToCandidateListUseGson(List<Candidate> candidates) {
		Gson gson = new Gson();
		try(FileWriter batchWriter = new FileWriter("CandidaterListGson.txt");
				BufferedWriter batchBufferedWriter = new BufferedWriter(batchWriter)){
			gson.toJson(candidates, batchBufferedWriter);
			
		} catch (IOException e) {


			e.printStackTrace();
		}
	}
	
	public static void  writeToBatchListUseGson(List<Batch> onlybatch) {
		Gson gson = new Gson();
		try(FileWriter batchWriter = new FileWriter("BatchListGson.txt");
				BufferedWriter batchBufferedWriter = new BufferedWriter(batchWriter)){
			gson.toJson(onlybatch, batchBufferedWriter);
			
		} catch (IOException e) {


			e.printStackTrace();
		}
	}
	public static void  writeToRelationshipsListUseGson(List<Relationships> relationships) {
		Gson gson = new Gson();
		try(FileWriter batchWriter = new FileWriter("RelationshipListGson.txt");
				BufferedWriter batchBufferedWriter = new BufferedWriter(batchWriter)){
			gson.toJson(relationships, batchBufferedWriter);
			
		} catch (IOException e) {


			e.printStackTrace();
		}
	}
	
	
	
	

	public static void writeToBatchInformation(List<Batch> batches) {
		try(FileWriter batchWriter = new FileWriter("BatchInformation.txt");
			BufferedWriter batchBufferedWriter = new BufferedWriter(batchWriter)){
			for (Batch batch3 : batches) {
			
			batchBufferedWriter.write(batch3.getBatchName());
			batchBufferedWriter.write(",");
			batchBufferedWriter.write(batch3.getBatchDate());
			if(!(batch3.getInterview() == null)) {
				batchBufferedWriter.write(",");
				batchBufferedWriter.write("[");
				for (Interviewer interviewer3 : batch3.getInterview()) {
					batchBufferedWriter.write(",");
					batchBufferedWriter.write(String.valueOf(interviewer3.getId()));
					batchBufferedWriter.write(",");
					batchBufferedWriter.write(interviewer3.getCandidateName());
					batchBufferedWriter.write(",");
					batchBufferedWriter.write(String.valueOf(interviewer3.getGender()));
					batchBufferedWriter.write(",");
					batchBufferedWriter.write(String.valueOf(interviewer3.getBirthDate()));
					batchBufferedWriter.write(",");
					batchBufferedWriter.write(interviewer3.getEmail());
					batchBufferedWriter.write(",");
					batchBufferedWriter.write(String.valueOf(interviewer3.getExperience()));
					
				}
				batchBufferedWriter.write(",");
				batchBufferedWriter.write("]");
				
			}else {
				batchBufferedWriter.write(",");
				batchBufferedWriter.write("*");
			}
			if(!(batch3.getCandidates() == null)) {
				batchBufferedWriter.write(",");
				batchBufferedWriter.write("[");
				for (Candidate candidate3 : batch3.getCandidates()) {
					batchBufferedWriter.write(",");
					batchBufferedWriter.write(String.valueOf(candidate3.getId()));
					batchBufferedWriter.write(",");
					batchBufferedWriter.write(candidate3.getCandidateName());
					batchBufferedWriter.write(",");
					batchBufferedWriter.write(String.valueOf(candidate3.getGender()));
					batchBufferedWriter.write(",");
					batchBufferedWriter.write(candidate3.getBirthDate());
					batchBufferedWriter.write(",");
					batchBufferedWriter.write(candidate3.getEmail());
					batchBufferedWriter.write(",");
					batchBufferedWriter.write(String.valueOf(candidate3.getGpa()));
					batchBufferedWriter.write(",");
					batchBufferedWriter.write( candidate3.getStatus());
				}
					
			
				batchBufferedWriter.write(",");
				batchBufferedWriter.write("]");
			}
			batchBufferedWriter.newLine();
		}
		
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	public static void writeToInterviewerList(List<Interviewer> interviewers) {
		
		try(FileWriter batchWriter = new FileWriter("InterviewerList.txt");
				BufferedWriter batchBufferedWriter = new BufferedWriter(batchWriter)){
				
			if(!(interviewers.isEmpty())){
				for (Interviewer interviewer3 : interviewers) {
					batchBufferedWriter.write(String.valueOf(interviewer3.getId()));
					batchBufferedWriter.write(",");
					batchBufferedWriter.write(interviewer3.getCandidateName());
					batchBufferedWriter.write(",");
					batchBufferedWriter.write(String.valueOf(interviewer3.getGender()));
					batchBufferedWriter.write(",");
					batchBufferedWriter.write(String.valueOf(interviewer3.getBirthDate()));
					batchBufferedWriter.write(",");
					batchBufferedWriter.write(interviewer3.getEmail());
					batchBufferedWriter.write(",");
					batchBufferedWriter.write(String.valueOf(interviewer3.getExperience()));
					batchBufferedWriter.newLine();
				}
			
			
				
			}
					
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
				
	
		
	}

	public static void writeToCandidateList(List<Candidate> candidates) {
		try(FileWriter batchWriter = new FileWriter("CandidateList.txt");
				BufferedWriter batchBufferedWriter = new BufferedWriter(batchWriter)){
				
			if(!(candidates.isEmpty())){
				for (Candidate candidate3 :candidates) {
					batchBufferedWriter.write(String.valueOf(candidate3.getId()));
					batchBufferedWriter.write(",");
					batchBufferedWriter.write(candidate3.getCandidateName());
					batchBufferedWriter.write(",");
					batchBufferedWriter.write(String.valueOf(candidate3.getGender()));
					batchBufferedWriter.write(",");
					batchBufferedWriter.write(candidate3.getBirthDate());
					batchBufferedWriter.write(",");
					batchBufferedWriter.write(candidate3.getEmail());
					batchBufferedWriter.write(",");
					batchBufferedWriter.write(String.valueOf(candidate3.getGpa()));
					batchBufferedWriter.write(",");
					batchBufferedWriter.write( candidate3.getStatus());
					batchBufferedWriter.newLine();
				}
			
			
				
			}
					
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		
		
	}

}
