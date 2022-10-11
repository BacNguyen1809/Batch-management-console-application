/*
	* @author bacng
	* @ Date Jun 15, 2022
*/
package Training.Models;

import java.util.Scanner;

import Training.Utils.Validator;

public class Person {
	private int id;
	private String candidateName;
	private int gender;
	private String birthDate;
	private String email;

	public Person() {
		super();
	}

	public Person(int id, String candidateName, int gender, String birthDate, String email) {
		super();
		this.id = id;
		this.candidateName = candidateName;
		this.gender = gender;
		this.birthDate = birthDate;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void input() {
		Scanner scanner = new Scanner(System.in);
		boolean status;
		do {
			status = false;
			System.out.println("Enter id: ");
			try {

				this.id = Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
				status = true;
			}

		} while (status);

		System.out.println("Enter Name: ");
		this.candidateName = scanner.nextLine();
		do {
			status = false;
			System.out.println("Enter gender: "
									+"\n"+"1:Male"
									+"\n"+"2:Female"
									+"\n"+"3:Other");
	
			try {
				this.gender = Integer.parseInt(scanner.nextLine());
				if(this.gender ==1 ||this.gender ==2||this.gender ==3) {
					status =false;
				}else {
					status =true;
				}
				
			} catch (Exception e) {
				status = true;
			}
		} while (status);

		do {
			status = false;
			System.out.println("Enter birth date: ");
			try {
				this.birthDate = scanner.nextLine();
				status = !(Validator.isDateValid(birthDate));
			} catch (Exception e) {
				status = true;
			}
		} while (status);

		do {
			status = false;
			System.out.println("Enter the email: ");
			try {
				this.email = scanner.nextLine();
				status = !(Validator.isvalidEmail(email));
			} catch (Exception e) {
				status = true;
			}
			
		} while (status);
		;

	}

	@Override
	public String toString() {
		return "id=" + id + ", candidateName=" + candidateName + ", gender=" 
				+ gender + ", birthDate=" + birthDate+ ", email=" + email;
				
	}

}
