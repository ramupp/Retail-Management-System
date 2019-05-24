package com.crunchify.dao;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.DocumentBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;
import com.crunchify.model.view.DocumentRequestBodyBean;

public interface DocumentDao {
		
	
	

	public List<DocumentBean> doc() throws SpringCrunchifyException;

	String viewDocCreate(DocumentBean doc)
			throws SpringCrunchifyException;
	public String addDocument(DocumentRequestBodyBean doc)	throws SpringCrunchifyException;

}
