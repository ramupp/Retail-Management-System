package com.crunchify.dao;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.AutocompleteDesignBean;
import com.crunchify.model.PurDataHdr;
//import com.crunchify.model.MenuDataBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.StockData;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;
import com.crunchify.model.view.CashSaleViewBean;
import com.crunchify.model.view.PurDataViewBean;

public interface PurchaseDao {
	
	public String purchaseEntry(PurDataHdr purDataHdr) throws SpringCrunchifyException;
	
	public String purchaseReturnEntry(PurDataHdr purDataHdr) throws SpringCrunchifyException;
	
	public List<PurDataViewBean> getPurchaseDetails(String co_id) throws SpringCrunchifyException;

	List<AutocompleteDesignBean> fetchDesign(String id) throws SpringCrunchifyException;
}
