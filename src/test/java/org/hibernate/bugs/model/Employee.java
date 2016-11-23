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
		@AssociationOverride(
				name = "experiences",
				joinTable = @JoinTable(name = "employee_information_experiences")
		)
	})
	private EmployeeInformation information = new EmployeeInformation();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EmployeeInformation getInformation() {
		if (information == null) {
			information = new EmployeeInformation();
		}
		return information;
	}

	public void setInformation(EmployeeInformation information) {
		this.information = information;
	}

}
