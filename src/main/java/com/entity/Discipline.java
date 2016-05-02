package com.entity;

// Generated 2016-4-15 16:30:02 by Hibernate Tools 3.2.2.GA

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * Discipline generated by hbm2java
 */
@Entity
@Table(name = "discipline", catalog = "dormitory")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Discipline implements java.io.Serializable {

	private long disciplineId;
	private Date time;
	private String studentName;
	private int studentNo;
	private int buildingNo;
	private int roomNo;
	private String event;
	private String createdByUser;
	private String updatedByUser;

	public Discipline() {
	}

	public Discipline(long disciplineId, Date time, String studentName,
			int studentNo, int buildingNo, int roomNo, String event,
			String createdByUser, String updatedByUser) {
		this.disciplineId = disciplineId;
		this.time = time;
		this.studentName = studentName;
		this.studentNo = studentNo;
		this.buildingNo = buildingNo;
		this.roomNo = roomNo;
		this.event = event;
		this.createdByUser = createdByUser;
		this.updatedByUser = updatedByUser;
	}

	@Id
	@Column(name = "discipline_id", unique = true, nullable = false)
	public long getDisciplineId() {
		return this.disciplineId;
	}

	public void setDisciplineId(long disciplineId) {
		this.disciplineId = disciplineId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time", nullable = false, length = 19)
	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Column(name = "student_name", nullable = false, length = 64)
	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Column(name = "student_no", nullable = false)
	public int getStudentNo() {
		return this.studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	@Column(name = "building_no", nullable = false)
	public int getBuildingNo() {
		return this.buildingNo;
	}

	public void setBuildingNo(int buildingNo) {
		this.buildingNo = buildingNo;
	}

	@Column(name = "room_no", nullable = false)
	public int getRoomNo() {
		return this.roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	@Column(name = "event", nullable = false)
	public String getEvent() {
		return this.event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	@Column(name = "created_by_user", nullable = false, length = 64)
	public String getCreatedByUser() {
		return this.createdByUser;
	}

	public void setCreatedByUser(String createdByUser) {
		this.createdByUser = createdByUser;
	}

	@Column(name = "updated_by_user", nullable = false, length = 64)
	public String getUpdatedByUser() {
		return this.updatedByUser;
	}

	public void setUpdatedByUser(String updatedByUser) {
		this.updatedByUser = updatedByUser;
	}

}