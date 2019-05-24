package com.crunchify.services.Impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crunchify.dao.RetailCompanyMasterDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.RetailCompanyMasterBean;
import com.crunchify.model.RetailOrgMasterBean;
import com.crunchify.services.RetailCompanyMasterService;
import com.crunchify.services.RetailOrgMasterService;


@Service
@Transactional
public class RetailCompanyMasterServiceImpl implements RetailCompanyMasterService {

	@Autowired
	RetailCompanyMasterDao r;

	@Override
	public int addCompany(RetailCompanyMasterBean s)
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return r.addCompany(s);
	}
	
	

}
