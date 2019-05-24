package com.crunchify.services;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.AutocompleteBean;
import com.crunchify.model.CashSaleHdrBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.RetailDesignBean;
import com.crunchify.model.view.CashSaleViewBean;


public interface CashSaleService {
	
	
	public String addCashSale(CashSaleHdrBean cashSale) throws SpringCrunchifyException;
	public List<CashSaleViewBean> getCashSaleDetails() throws SpringCrunchifyException;
	public List<AutocompleteBean> getCashParty(String co_id) throws SpringCrunchifyException;

}
