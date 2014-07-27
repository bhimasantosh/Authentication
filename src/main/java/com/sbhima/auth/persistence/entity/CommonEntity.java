package com.sbhima.auth.persistence.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class CommonEntity {
	@Column(name = "creation_date", insertable = false, updatable = false)
	private Timestamp creation_date;

	@Column(name = "modified_date", insertable = false, updatable = false)
	private Timestamp modified_date;

	public Timestamp getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Timestamp creation_date) {
		this.creation_date = creation_date;
	}

	public Timestamp getModified_date() {
		return modified_date;
	}

	public void setModified_date(Timestamp modified_date) {
		this.modified_date = modified_date;
	}
}
