package com.crunchify.services;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.RetailCompanyMasterBean;

public interface RetailCompanyMasterService {
	
	public int addCompany(RetailCompanyMasterBean s) throws SpringCrunchifyException;

}
