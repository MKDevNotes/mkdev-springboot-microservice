package com.mkdev.example.model;

import java.io.Serializable;

/**
 * @author Muthukumar Thangavinayagam
 * @date 2020-May-03 9:53:44 pm 
 */
public class DnUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long userId;

	private String firstName;

	private String lastName;

	private String jobTitle;

	private Double salary;

	public DnUser() {
		// TODO Auto-generated constructor stub
	}


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}
