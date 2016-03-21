package com.entity;

import java.util.ArrayList;
import java.util.List;

public class UserInfo {
	private String userCode;
	private String userName;
	private int buildingNo;
	private int roleType;
	private List<SysMenuItem> items = new ArrayList<SysMenuItem>();
	private String errorMsg;
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getBuildingNo() {
		return buildingNo;
	}
	public void setBuildingNo(int buildingNo) {
		this.buildingNo = buildingNo;
	}
	public int getRoleType() {
		return roleType;
	}
	public void setRoleType(int roleType) {
		this.roleType = roleType;
	}
	public List<SysMenuItem> getItems() {
		return items;
	}
	public void setItems(List<SysMenuItem> items) {
		this.items = items;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
