package com.entity;

// Generated 2016-3-28 17:16:14 by Hibernate Tools 3.2.2.GA

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * SbRoom generated by hbm2java
 */
@Entity
@Table(name = "sb_room", catalog = "aa")
@DynamicInsert(true)
@DynamicUpdate(true)
public class SbRoom implements java.io.Serializable {

	private Long sbRoomId;
	private int roomNo;
	private int buildingNo;
	private BigDecimal area;
	private int bedNum;
	private int bedLeft;
	private String createdByUser;
	private String updatedByUser;
	private byte isFull;

	public SbRoom() {
	}

	public SbRoom(int roomNo, int buildingNo, BigDecimal area, int bedNum,
			int bedLeft, String createdByUser, String updatedByUser, byte isFull) {
		this.roomNo = roomNo;
		this.buildingNo = buildingNo;
		this.area = area;
		this.bedNum = bedNum;
		this.bedLeft = bedLeft;
		this.createdByUser = createdByUser;
		this.updatedByUser = updatedByUser;
		this.isFull = isFull;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sb_room_Id", unique = true, nullable = true)
	public Long getSbRoomId() {
		return this.sbRoomId;
	}

	public void setSbRoomId(Long sbRoomId) {
		this.sbRoomId = sbRoomId;
	}

	@Column(name = "room_no", nullable = true)
	public int getRoomNo() {
		return this.roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	@Column(name = "building_no", nullable = true)
	public int getBuildingNo() {
		return this.buildingNo;
	}

	public void setBuildingNo(int buildingNo) {
		this.buildingNo = buildingNo;
	}

	@Column(name = "area", nullable = true, precision = 11)
	public BigDecimal getArea() {
		return this.area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	@Column(name = "bed_num", nullable = true)
	public int getBedNum() {
		return this.bedNum;
	}

	public void setBedNum(int bedNum) {
		this.bedNum = bedNum;
	}

	@Column(name = "bed_left", nullable = true)
	public int getBedLeft() {
		return this.bedLeft;
	}

	public void setBedLeft(int bedLeft) {
		this.bedLeft = bedLeft;
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

	@Column(name = "is_full", nullable = true)
	public byte getIsFull() {
		return this.isFull;
	}

	public void setIsFull(byte isFull) {
		this.isFull = isFull;
	}

}
