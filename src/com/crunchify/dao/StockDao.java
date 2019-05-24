package com.crunchify.dao;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
//import com.crunchify.model.MenuDataBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.StockData;
import com.crunchify.model.StockDataRm;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;
import com.crunchify.model.view.CashSaleViewBean;
import com.crunchify.model.view.CrSaleViewBean;

public interface StockDao {
	
	public String stockEntry(StockData stData) throws SpringCrunchifyException ;
	
	public List<StockData> stockView(StockData stData) throws SpringCrunchifyException;
	
	public List<CrSaleViewBean> getStockTransAcknow(String co_id) throws SpringCrunchifyException;

	String stockEntryRm(StockDataRm stDataRm) throws SpringCrunchifyException;
}
