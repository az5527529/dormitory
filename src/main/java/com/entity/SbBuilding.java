package com.entity;

// Generated 2016-3-28 17:15:11 by Hibernate Tools 3.2.2.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * SbBuilding generated by hbm2java
 */
@Entity
@Table(name = "sb_building", catalog = "aa")
@DynamicInsert(true)
@DynamicUpdate(true)
public class SbBuilding implements java.io.Serializable {

	private Long sbBuildingId;
	private int buildingNo;
	private int roomNum;
	private int roomLeft;
	private String createdByUser;
	private String updatedByUser;
	private String floorNum;

	public SbBuilding() {
	}

	public SbBuilding(int buildingNo, int roomNum, int roomLeft,
			String createdByUser, String updatedByUser, String floorNum) {
		this.buildingNo = buildingNo;
		this.roomNum = roomNum;
		this.roomLeft = roomLeft;
		this.createdByUser = createdByUser;
		this.updatedByUser = updatedByUser;
		this.floorNum = floorNum;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sb_building_id", unique = true, nullable = true)
	public Long getSbBuildingId() {
		return this.sbBuildingId;
	}

	public void setSbBuildingId(Long sbBuildingId) {
		this.sbBuildingId = sbBuildingId;
	}

	@Column(name = "building_no", nullable = true)
	public int getBuildingNo() {
		return this.buildingNo;
	}

	public void setBuildingNo(int buildingNo) {
		this.buildingNo = buildingNo;
	}

	@Column(name = "room_num", nullable = true)
	public int getRoomNum() {
		return this.roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	@Column(name = "room_left", nullable = true)
	public int getRoomLeft() {
		return this.roomLeft;
	}

	public void setRoomLeft(int roomLeft) {
		this.roomLeft = roomLeft;
	}

	@Column(name = "created_by_user", nullable = true, length = 64)
	public String getCreatedByUser() {
		return this.createdByUser;
	}

	public void setCreatedByUser(String createdByUser) {
		this.createdByUser = createdByUser;
	}

	@Column(name = "updated_by_user", nullable = true, length = 64)
	public String getUpdatedByUser() {
		return this.updatedByUser;
	}

	public void setUpdatedByUser(String updatedByUser) {
		this.updatedByUser = updatedByUser;
	}

	@Column(name = "floor_num", nullable = true, length = 16)
	public String getFloorNum() {
		return this.floorNum;
	}

	public void setFloorNum(String floorNum) {
		this.floorNum = floorNum;
	}

}
