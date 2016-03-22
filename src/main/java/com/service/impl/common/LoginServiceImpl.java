package com.service.impl.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.entity.SysMenuGroup;
import com.entity.SysMenuItem;
import com.entity.SysUser;
import com.entity.UserInfo;
import com.service.common.LoginService;
import com.util.CollectionUtil;

@Service("loginService")
public class LoginServiceImpl extends BaseServiceImpl<SysUser> implements
		LoginService {

	public UserInfo login(String userCode,String password,HttpServletRequest request){
		UserInfo userInfo = new UserInfo();
		String hql="from SysUser where userCode=:userCode";
		List<SysUser> userList = super.getSession().createQuery(hql).setString("userCode", userCode).list();
		if(CollectionUtil.isEmptyCollection(userList)){
			userInfo.setErrorMsg("该用户不存在");
			return userInfo;
		}
		SysUser user = userList.get(0);
		if(!user.getUserPwd().equals(password)){
			userInfo.setErrorMsg("密码错误");
			return userInfo;
		}
		userInfo.setUserCode(user.getUserCode());
		userInfo.setUserName(user.getUserName());
		userInfo.setRoleType(user.getRoleType());
		userInfo.setBuildingNo(user.getBuildingNo());
		String itemSql= "select sm.sys_menu_item_id ,sm.menu_title ,sm.sys_menu_group_id ,"
				+ "sm.url url,sm.created_by_user ,sm.updated_by_user  from role_item ri left join sys_menu_item sm on sm.sys_menu_item_id"
				+ "=ri.sys_menu_item_id and ri.role_type=:roleType";//查询角色的菜单
		List<SysMenuItem> itemList = super.getSession().createSQLQuery(itemSql).addEntity(SysMenuItem.class).setInteger("roleType", user.getRoleType()).list();
//		List<SysMenuItem> items = new ArrayList<SysMenuItem>();
//		for(Object o:itemList){
//			Object[] map = (Object[])o;
//			SysMenuItem item = new SysMenuItem();
//			
//			item.setSysMenuItemId(((BigInteger)map[0]).longValue());
//			item.setMenuTitle((String) map[1]);
//			item.setSysMenuGroupId(((BigInteger)map[2]).longValue());
//			item.setUrl((String) map[3]);
//			item.setCreatedByUser((String) map[4]);
//			item.setUpdatedByUser((String) map[5]);
//			items.add(item);
//		}
		userInfo.setItems(itemList);
		String groupHql = "from SysMenuGroup";
		List<SysMenuGroup> groupList = super.getSession().createQuery(groupHql).list();
		HttpSession session = request.getSession();
		session.setAttribute("userInfo", userInfo);
		session.setAttribute("groupList", groupList);
		return userInfo;
	}


}
