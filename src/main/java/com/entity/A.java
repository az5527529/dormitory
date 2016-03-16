package com.entity;

// Generated 2016-3-4 16:53:59 by Hibernate Tools 3.2.2.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * A generated by hbm2java
 */
@Entity
@Table(name = "a", catalog = "aa")
public class A implements java.io.Serializable {

	private String aaid;
	private Character name;

	public A() {
	}

	public A(String aaid) {
		this.aaid = aaid;
	}

	public A(String aaid, Character name) {
		this.aaid = aaid;
		this.name = name;
	}

	@Id
	@Column(name = "aaid", unique = true, nullable = false, length = 10)
	public String getAaid() {
		return this.aaid;
	}

	public void setAaid(String aaid) {
		this.aaid = aaid;
	}

	@Column(name = "name", length = 1)
	public Character getName() {
		return this.name;
	}

	public void setName(Character name) {
		this.name = name;
	}

}