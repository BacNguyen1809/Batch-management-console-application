/*
	* @author bacng
	* @ Date Jun 15, 2022
*/
package Training.Models;


import java.util.Scanner;

public class Interviewer extends Person {
	private int experience;

	public Interviewer() {
		super();
	}

	public Interviewer(int id, String candidateName, int gender,
			String birthDate, String email, int experience) {
		super(id, candidateName, gender, birthDate, email);
		this.experience = experience;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
	public void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("-------Interview Information-----");
		super.input();
		System.out.println("Enter Experience:");
		this.experience =Integer.parseInt(scanner.nextLine());
	
	}

	@Override
	public String toString() {
		return "id: " + getId() + ", Interviewer Name: " + getCandidateName() + ", gender: " 
				+ getGender() + ", birthDate: " + getBirthDate()+ ", email: " + getEmail()+", experience: " + experience ;
	}
	
	
	

}
