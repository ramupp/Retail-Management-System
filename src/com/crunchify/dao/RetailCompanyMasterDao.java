package com.crunchify.dao;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.RetailCompanyMasterBean;


public interface RetailCompanyMasterDao {
	
	public int addCompany(RetailCompanyMasterBean s) throws SpringCrunchifyException;

	List<RetailCompanyMasterBean> fetchAllCompany()
			throws SpringCrunchifyException;

}
