package com.crunchify.dao;

import java.util.List;



import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ContactDetailsBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.PartyMasterBean;
import com.crunchify.model.PartyTypeBean;
import com.crunchify.model.PartyViewBean;
//import com.crunchify.model.MenuDataBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.StockData;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;

public interface PartyMasterDao {
		
	
	//public String partyMasterCreate(PartyMasterBean party_m) throws SpringCrunchifyException;
	
public String partyMasterCreate(PartyMasterBean party_m) throws SpringCrunchifyException;
	
	


String viewPartyMasterCreate(PartyMasterBean party_master)
		throws SpringCrunchifyException;


String party_mTypeUpdate(PartyMasterBean party_m)
		throws SpringCrunchifyException;


String partyTypeDelete(PartyMasterBean party_typ)
		throws SpringCrunchifyException;


List<com.crunchify.model.AutocompleteBean> fetchCustomerForPartyMaster(String id)
		throws SpringCrunchifyException;




public List<PartyViewBean> party_master();




List<PartyViewBean> party_master(PartyViewBean stData)
		throws SpringCrunchifyException;








}

