package com.crunchify.dao;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
//import com.crunchify.model.MenuDataBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.UomConvMasterBean;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;

public interface UomConvMasterDao {
		
	
	public String uomConvCreate(UomConvMasterBean conv) throws SpringCrunchifyException;
	
	public List<UomConvMasterBean> uom_cnv() throws SpringCrunchifyException;

	String viewUOMCCreate(UomConvMasterBean uom_cnv)throws SpringCrunchifyException;

	String uom_convUpdate(UomConvMasterBean uom_cnv)throws SpringCrunchifyException;

	String uomcnvTypDelete(UomConvMasterBean ucnv_typ)throws SpringCrunchifyException;
	
	

}
