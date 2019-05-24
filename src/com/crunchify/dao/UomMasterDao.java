package com.crunchify.dao;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemTypeBean;
//import com.crunchify.model.MenuDataBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.UomMasterBean;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;

public interface UomMasterDao {
		
	
	public String uomMasterCreate(UomMasterBean uom_m) throws SpringCrunchifyException;

	String viewMasterCreate(UomMasterBean uom_master)
			throws SpringCrunchifyException;

	List<UomMasterBean> uom_master() throws SpringCrunchifyException;
	
	public String uomMasterUpdate(UomMasterBean uom_m) throws SpringCrunchifyException;

	String uomTypeDelete(UomMasterBean uom_typ) throws SpringCrunchifyException;

}
