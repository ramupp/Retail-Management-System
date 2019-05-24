package com.crunchify.dao;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.MiscHeadBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;

public interface MiscHeadDao {
		
	
	public String miscHeadCreate(MiscHeadBean misc) throws SpringCrunchifyException;
	
	public List<MiscHeadBean> misc_head() throws SpringCrunchifyException;
		String viewMiscCreate(MiscHeadBean misc_head)
			throws SpringCrunchifyException;

	

}
