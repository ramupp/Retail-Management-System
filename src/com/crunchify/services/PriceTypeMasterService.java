package com.crunchify.services;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemRateTypeBean;
import com.crunchify.model.PriceTypeMasterBean;




public interface PriceTypeMasterService {
	
	public String priceMasterCreate(PriceTypeMasterBean price_m) throws SpringCrunchifyException;

	public List<PriceTypeMasterBean> price_type() throws SpringCrunchifyException;

	String priceTypUpdate(PriceTypeMasterBean price_type)
			throws SpringCrunchifyException;

	String priceTypeDelete(PriceTypeMasterBean price_typ)
			throws SpringCrunchifyException;

}
