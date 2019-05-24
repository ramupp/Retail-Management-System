package com.crunchify.dao;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
//import com.crunchify.model.MenuDataBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.SalesManBean;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;

public interface SalesManDao {
		
	
	public String salesManCreate(SalesManBean sales_man) throws SpringCrunchifyException;
	
	public List<SalesManBean> sales_man() throws SpringCrunchifyException;

	String viewsalesManCreate(SalesManBean sales_man)
			throws SpringCrunchifyException;

	String salesManUpdate(SalesManBean sales_m) throws SpringCrunchifyException;

	String sales_manTypDelete(SalesManBean s_m_typ)throws SpringCrunchifyException;

}