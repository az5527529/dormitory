package com.entity;

// Generated 2016-3-22 17:34:00 by Hibernate Tools 3.2.2.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SbBuilding generated by hbm2java
 */
@Entity
@Table(name = "sb_building", catalog = "aa")
public class SbBuilding implements java.io.Serializable {

	private Long sbBuildingId;
	private int buidingNo;
	private int roomNum;
	private int roomLeft;
	private String createdByUser;
	private String updatedByUser;

	public SbBuilding() {
	}

	public SbBuilding(int buidingNo, int roomNum, int roomLeft,
			String createdByUser, String updatedByUser) {
		this.buidingNo = buidingNo;
		this.roomNum = roomNum;
		this.roomLeft = roomLeft;
		this.createdByUser = createdByUser;
		this.updatedByUser = updatedByUser;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sb_building_id", unique = true, nullable = false)
	public Long getSbBuildingId() {
		return this.sbBuildingId;
	}

	public void setSbBuildingId(Long sbBuildingId) {
		this.sbBuildingId = sbBuildingId;
	}

	@Column(name = "buiding_no", nullable = false)
	public int getBuidingNo() {
		return this.buidingNo;
	}

	public void setBuidingNo(int buidingNo) {
		this.buidingNo = buidingNo;
	}

	@Column(name = "room_num", nullable = false)
	public int getRoomNum() {
		return this.roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	@Column(name = "room_left", nullable = false)
	public int getRoomLeft() {
		return this.roomLeft;
	}

	public void setRoomLeft(int roomLeft) {
		this.roomLeft = roomLeft;
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
