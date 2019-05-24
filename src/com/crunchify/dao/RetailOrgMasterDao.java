package com.crunchify.dao;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.RetailOrgMasterBean;

public interface RetailOrgMasterDao {

	public int addOrg(RetailOrgMasterBean s) throws SpringCrunchifyException;
	
}
