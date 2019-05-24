package com.crunchify.services;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.RetailRegistrationBean;


public interface RetailLoginService {
	public List<RetailRegistrationBean> login(RetailRegistrationBean s) throws SpringCrunchifyException;
	public List<RetailRegistrationBean> getAllUser() throws SpringCrunchifyException;

}
