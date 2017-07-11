package com.hibernate.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//@DiscriminatorValue(value="CE")
//@PrimaryKeyJoinColumn(name="c_id",referencedColumnName="id")
public class ContractingEmployee extends Employee{

	private static final long serialVersionUID = 1L;
	private int hourlyRate;
	private int noOfHours;

	public int getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(int hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public int getNoOfHours() {
		return noOfHours;
	}

	public void setNoOfHours(int noOfHours) {
		this.noOfHours = noOfHours;
	}

}
