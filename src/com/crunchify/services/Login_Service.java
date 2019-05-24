package com.crunchify.services;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.OrderCodeMaster;
import com.crunchify.model.SiteDetails;
import com.crunchify.model.User;
import com.crunchify.model.VtplUser;

public interface Login_Service {
	
	public User login(String userName, String password) throws SpringCrunchifyException;

	public SiteDetails getVal(int id) throws SpringCrunchifyException;
	
	public String setVal(SiteDetails s) throws SpringCrunchifyException;
	
	public List<OrderCodeMaster> getOrderCodes() throws SpringCrunchifyException;
	
	public List<VtplUser> getLoginStatus(String userName, String password) throws SpringCrunchifyException;

}
