package com.crunchify.services;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.RetailOrgMasterBean;

public interface RetailOrgMasterService {
	
	public int addOrg(RetailOrgMasterBean s) throws SpringCrunchifyException;

}
