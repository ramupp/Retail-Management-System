package com.crunchify.dao;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ConsgMasterBean;
import com.crunchify.model.ConsgViewBean;
import com.crunchify.model.ContactDetailsBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.PartyMasterBean;
import com.crunchify.model.PartyViewBean;
//import com.crunchify.model.MenuDataBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;

public interface PartyConsgDao {
		
	
	//public String partyMasterCreate(PartyMasterBean party_m) throws SpringCrunchifyException;
	
public String consgMasterCreate(ConsgMasterBean consg_m) throws SpringCrunchifyException;
	
	
public List<ConsgViewBean> consg_master() throws SpringCrunchifyException;

String viewConsgMasterCreate(ConsgMasterBean consg_master)
		throws SpringCrunchifyException;


String consgUpdate(ConsgMasterBean consg) throws SpringCrunchifyException;


String consgTypeDelete(ConsgMasterBean consg_typ)
		throws SpringCrunchifyException;
}

