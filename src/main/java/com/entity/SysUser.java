package com.entity;

// Generated 2016-3-23 17:31:53 by Hibernate Tools 3.2.2.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * SysUser generated by hbm2java
 */
@Entity
@Table(name = "sys_user", catalog = "aa")
@DynamicInsert(true)
@DynamicUpdate(true)
public class SysUser implements java.io.Serializable {

	private Long sysUserId;
	private String userCode;
	private String userName;
	private String userPwd;
	private int buildingNo;
	private int roleType;
	private String createdByUser;
	private String updatedByUser;

	public SysUser() {
	}

	public SysUser(String userCode, String userName, String userPwd,
			int buildingNo, int roleType, String createdByUser,
			String updatedByUser) {
		this.userCode = userCode;
		this.userName = userName;
		this.userPwd = userPwd;
		this.buildingNo = buildingNo;
		this.roleType = roleType;
		this.createdByUser = createdByUser;
		this.updatedByUser = updatedByUser;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sys_user_id", unique = true, nullable = true)
	public Long getSysUserId() {
		return this.sysUserId;
	}

	public void setSysUserId(Long sysUserId) {
		this.sysUserId = sysUserId;
	}

	@Column(name = "user_code", nullable = true, length = 64)
	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	@Column(name = "user_name", nullable = true, length = 64)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "user_pwd", nullable = true, length = 64)
	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	@Column(name = "building_no", nullable = true)
	public int getBuildingNo() {
		return this.buildingNo;
	}

	public void setBuildingNo(int buildingNo) {
		this.buildingNo = buildingNo;
	}

	@Column(name = "role_type", nullable = true)
	public int getRoleType() {
		return this.roleType;
	}

	public void setRoleType(int roleType) {
		this.roleType = roleType;
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

}
