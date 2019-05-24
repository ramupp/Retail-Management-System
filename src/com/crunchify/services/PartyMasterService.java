package com.crunchify.services;

import java.util.ArrayList;
import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.AutocompleteBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.PartyMasterBean;
import com.crunchify.model.PartyTypeBean;
import com.crunchify.model.PartyViewBean;



public interface PartyMasterService {
	
	public String partyMasterCreate(PartyMasterBean party_m) throws SpringCrunchifyException;
	


	String party_mTypeUpdate(PartyMasterBean party_m)
			throws SpringCrunchifyException;

	String partyTypDelete(PartyMasterBean party_typ)
			throws SpringCrunchifyException;

	public List<AutocompleteBean> fetchCustomerForPartyMaster(String id) throws SpringCrunchifyException;



	List<PartyViewBean> party_master() throws SpringCrunchifyException;

	



	

	
}
