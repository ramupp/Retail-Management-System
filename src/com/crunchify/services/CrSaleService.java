package com.crunchify.services;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.CashSaleHdrBean;
import com.crunchify.model.CrSaleHdrBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.PackingSlipHdrBean;
import com.crunchify.model.RetailDesignBean;


public interface CrSaleService {
	
	
	public String addCrSale(CrSaleHdrBean crSale) throws SpringCrunchifyException;

	String addCrSaleForStockOut(CrSaleHdrBean crSale)
			throws SpringCrunchifyException;

}
