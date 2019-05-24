package com.crunchify.dao;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemRateTypeBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.PriceTypeMasterBean;
//import com.crunchify.model.MenuDataBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;

public interface PriceTypeMasterDao {
		
	
	public String priceMasterCreate(PriceTypeMasterBean price_m) throws SpringCrunchifyException;
	public List<PriceTypeMasterBean> price_type() throws SpringCrunchifyException;
	
	public String viewpriceCreate(PriceTypeMasterBean price_type)
			throws SpringCrunchifyException;
	String priceTypUpdate(PriceTypeMasterBean price_type)
			throws SpringCrunchifyException;
	String priceTypeDelete(PriceTypeMasterBean price_typ)
			throws SpringCrunchifyException;

}
