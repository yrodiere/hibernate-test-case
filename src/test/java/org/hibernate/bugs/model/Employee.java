package org.hibernate.bugs.model;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;

import org.hibernate.bugs.model.embeddable.EmployeeInformation;

@Entity
public class Employee {

	@Id
	private Long id;

	@Embedded
	@AssociationOverrides({
			@AssociationOverride(name = "experiences", joinTable = @JoinTable(name = "employee_informationbefore_experiences"))
	})
	private EmployeeInformation informationBefore = new EmployeeInformation();

	@Embedded
	@AssociationOverrides({
			@AssociationOverride(name = "experiences", joinTable = @JoinTable(name = "employee_informationafter_experiences"))
	})
	private EmployeeInformation informationAfter = new EmployeeInformation();

	@Embedded
	private EmployeeInformation informationWithoutAssociationOverride = new EmployeeInformation();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EmployeeInformation getInformationBefore() {
		if (informationBefore == null) {
			informationBefore = new EmployeeInformation();
		}
		return informationBefore;
	}

	public void setInformationBefore(EmployeeInformation informationBefore) {
		this.informationBefore = informationBefore;
	}

	public EmployeeInformation getInformationAfter() {
		if (informationAfter == null) {
			informationAfter = new EmployeeInformation();
		}
		return informationAfter;
	}

	public void setInformationAfter(EmployeeInformation informationAfter) {
		this.informationAfter = informationAfter;
	}

	public EmployeeInformation getInformationWithoutAssociationOverride() {
		if (informationWithoutAssociationOverride == null) {
			informationWithoutAssociationOverride = new EmployeeInformation();
		}
		return informationWithoutAssociationOverride;
	}

	public void setInformationWithoutAssociationOverride(EmployeeInformation informationWithoutAssociationOverride) {
		this.informationWithoutAssociationOverride = informationWithoutAssociationOverride;
	}

}
