package com.crunchify.dao;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemTypeBean;
//import com.crunchify.model.MenuDataBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;

public interface RetailRoleDao {
	
	public String roleCreate(RoleDataHdr rhdr) throws SpringCrunchifyException;
	
	
	public String userCreate(RetailRegistrationBean rbean,List<UserRoleCompany> roleComp) throws SpringCrunchifyException;
	
	//public String menuCreate(MenuDataBean mbean) throws SpringCrunchifyException;
	
	String changePwdUpdate(RetailRegistrationBean pwd) throws SpringCrunchifyException;


	String roleUpdate(RoleDataHdr rhdr) throws SpringCrunchifyException;

}
