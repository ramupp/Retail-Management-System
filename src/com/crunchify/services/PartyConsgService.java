package com.crunchify.services;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ConsgMasterBean;
import com.crunchify.model.ConsgViewBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.PartyMasterBean;
import com.crunchify.model.PartyViewBean;



public interface PartyConsgService {
	
	public String consgMasterCreate(ConsgMasterBean consg_m) throws SpringCrunchifyException;
	
	public List<ConsgViewBean> consg_master() throws SpringCrunchifyException;

	String consgUpdate(ConsgMasterBean consg) throws SpringCrunchifyException;

	String consgTypeDelete(ConsgMasterBean consg_typ)
			throws SpringCrunchifyException;


}
