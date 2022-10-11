/*
	* @author bacng
	* @ Date Jun 15, 2022
*/
package Training.Models;

import java.util.Scanner;

public class Candidate extends Person implements Comparable<Candidate>{
	private double gpa;
	private String status;

	public Candidate() {
		super();
	}

	public Candidate(int id, String candidateName, int gender, String birthDate, String email, double gpa, String status) {
		super(id, candidateName, gender, birthDate, email);
		this.gpa = gpa;
		this.status = status;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void input() {
		Scanner scanner = new Scanner(System.in);
		super.input();
		this.status = "UnKnown";
		boolean status;
		do {
			status = false;
			System.out.println("Enter GPA:");
			try {
				this.gpa = Integer.parseInt(scanner.nextLine());
				if(this.gpa >10 ) status =true;
				else status = false;

			} catch (Exception e) {
				status = true;
			}

		} while (status);


	}

	@Override
	public String toString() {
		return "id=" + getId() + ", candidateName=" + getCandidateName() + ", gender=" 
				+ getGender() + ", birthDate=" + getBirthDate()+ ", email=" + getEmail()
				+ ", gpa=" + gpa+ ", Status:" + status;
	}



	@Override
	public int compareTo(Candidate o) {
		
		return this.getCandidateName().compareTo(o.getCandidateName());
	}

}
