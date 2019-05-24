package com.crunchify.dao;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.PartyTypeBean;
//import com.crunchify.model.MenuDataBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;

public interface PartyTypeDao {
		
	
	public String partyTypeCreate(PartyTypeBean party) throws SpringCrunchifyException;

	public List<PartyTypeBean> view_party_type() throws SpringCrunchifyException;

	String partyTypeUpdate(PartyTypeBean party) throws SpringCrunchifyException;

	String associateTypeDelete(PartyTypeBean associate_typ)throws SpringCrunchifyException;



	


}
