package com.entity;

// Generated 2016-4-12 23:28:16 by Hibernate Tools 3.2.2.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * ChangeRoom generated by hbm2java
 */
@Entity
@Table(name = "change_room", catalog = "aa")
@DynamicInsert(true)
@DynamicUpdate(true)
public class ChangeRoom implements java.io.Serializable {

	private Long changeRoomId;
	private long studentId;
	private long startRoomId;
	private long endRoomId;
	private String changeTime;
	private String createdByUser;
	private String updateByUser;
	private String reason;
	private int buildingNo;

	public ChangeRoom() {
	}

	public ChangeRoom(long studentId, long startRoomId, long endRoomId,
			String changeTime, String createdByUser, String updateByUser,
			String reason, int buildingNo) {
		this.studentId = studentId;
		this.startRoomId = startRoomId;
		this.endRoomId = endRoomId;
		this.changeTime = changeTime;
		this.createdByUser = createdByUser;
		this.updateByUser = updateByUser;
		this.reason = reason;
		this.buildingNo = buildingNo;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "change_room_id", unique = true, nullable = true)
	public Long getChangeRoomId() {
		return this.changeRoomId;
	}

	public void setChangeRoomId(Long changeRoomId) {
		this.changeRoomId = changeRoomId;
	}

	@Column(name = "student_id", nullable = true)
	public long getStudentId() {
		return this.studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	@Column(name = "start_room_id", nullable = true)
	public long getStartRoomId() {
		return this.startRoomId;
	}

	public void setStartRoomId(long startRoomId) {
		this.startRoomId = startRoomId;
	}

	@Column(name = "end_room_id", nullable = true)
	public long getEndRoomId() {
		return this.endRoomId;
	}

	public void setEndRoomId(long endRoomId) {
		this.endRoomId = endRoomId;
	}

	@Column(name = "change_time", nullable = true, length = 64)
	public String getChangeTime() {
		return this.changeTime;
	}

	public void setChangeTime(String changeTime) {
		this.changeTime = changeTime;
	}

	@Column(name = "created_by_user", nullable = true, length = 64)
	public String getCreatedByUser() {
		return this.createdByUser;
	}

	public void setCreatedByUser(String createdByUser) {
		this.createdByUser = createdByUser;
	}

	@Column(name = "update_by_user", nullable = true, length = 64)
	public String getUpdateByUser() {
		return this.updateByUser;
	}

	public void setUpdateByUser(String updateByUser) {
		this.updateByUser = updateByUser;
	}

	@Column(name = "reason", nullable = true)
	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Column(name = "building_no", nullable = true)
	public int getBuildingNo() {
		return this.buildingNo;
	}

	public void setBuildingNo(int buildingNo) {
		this.buildingNo = buildingNo;
	}

}
