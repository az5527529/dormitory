package com.entity;

import java.util.ArrayList;
import java.util.List;

public class UserInfo {
	

	private String userCode;//用户编码
	private String userName;//用户名
	private int buildingNo;//所属楼
	private int roleType;//角色类型 1：超管；2：宿管；3：学生
	private List<SysMenuItem> items = new ArrayList<SysMenuItem>();//用户所能看到的菜单
	private String errorMsg;//登陆错误时返回的错误信息
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
