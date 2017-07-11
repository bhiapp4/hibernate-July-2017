package com.hibernate.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//@DiscriminatorValue(value="FE")
//@PrimaryKeyJoinColumn(name="f_id",referencedColumnName="id")
public class FullTimeEmployee extends Employee {

	private static final long serialVersionUID = 1L;

	private Long salary;

	private int paidVacationDays;

	private int healthInsuranceAmount;

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public int getPaidVacationDays() {
		return paidVacationDays;
	}

	public void setPaidVacationDays(int paidVacationDays) {
		this.paidVacationDays = paidVacationDays;
	}

	public int getHealthInsuranceAmount() {
		return healthInsuranceAmount;
	}

	public void setHealthInsuranceAmount(int healthInsuranceAmount) {
		this.healthInsuranceAmount = healthInsuranceAmount;
	}

}
