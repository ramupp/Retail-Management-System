package com.crunchify.dao;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.CityMasterBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
//import com.crunchify.model.MenuDataBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.StateMasterBean;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;

public interface StateMasterDao {
		
	
	public String stateMasterCreate(StateMasterBean state_m) throws SpringCrunchifyException;
	public List<StateMasterBean> view_state_type() throws SpringCrunchifyException;
	String stateUpdate(StateMasterBean state) throws SpringCrunchifyException;
	String stateTypeDelete(StateMasterBean state_typ)throws SpringCrunchifyException;


}
