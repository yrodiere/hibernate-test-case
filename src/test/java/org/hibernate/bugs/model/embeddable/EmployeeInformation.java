package org.hibernate.bugs.model.embeddable;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.MapKeyJoinColumn;

import org.hibernate.bugs.model.JobTitle;

@Embeddable
public class EmployeeInformation implements Serializable {

	private static final long serialVersionUID = -1721175105380352776L;

	@ElementCollection(fetch = FetchType.LAZY)
	@MapKeyJoinColumn(name = "jobtitle_id")
	@Column(name = "details")
	private Map<JobTitle, String> experiences = new HashMap<>();

	public Map<JobTitle, String> getExperiences() {
		return experiences;
	}

	public void setExperiences(Map<JobTitle, String> experiences) {
		this.experiences = experiences;
	}

}
