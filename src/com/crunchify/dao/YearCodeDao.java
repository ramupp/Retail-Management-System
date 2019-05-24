package com.crunchify.dao;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
//import com.crunchify.model.MenuDataBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;
import com.crunchify.model.YearCodeBean;

public interface YearCodeDao {
		
	
	public String yearCodeCreate(YearCodeBean year_c) throws SpringCrunchifyException;

	public List<YearCodeBean> yearcd_master() throws SpringCrunchifyException;

	String viewYearCodeCreate(YearCodeBean yearcd_master)
			throws SpringCrunchifyException;

	String yearCodeUpdate(YearCodeBean yr_cd) throws SpringCrunchifyException;

	String yearCodeDelete(YearCodeBean year_cd) throws SpringCrunchifyException;

}
