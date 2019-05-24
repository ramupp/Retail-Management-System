package com.crunchify.dao;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.CityMasterBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.PartyTypeBean;
//import com.crunchify.model.MenuDataBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;

public interface CityMasterDao {
		
	
	public String cityMasterCreate(CityMasterBean city_m) throws SpringCrunchifyException;
	public List<CityMasterBean> view_city_type() throws SpringCrunchifyException;
	String cityUpdate(CityMasterBean city) throws SpringCrunchifyException;
	String cityTypeDelete(CityMasterBean city_typ)throws SpringCrunchifyException;

}
