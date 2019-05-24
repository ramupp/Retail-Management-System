package com.crunchify.dao;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.AutocompleteBean;
import com.crunchify.model.CashSaleHdrBean;
import com.crunchify.model.RetailDesignBean;
import com.crunchify.model.view.*;

public interface CashSaleDao {
	

	public String addCashSale(CashSaleHdrBean cashSale)throws SpringCrunchifyException;
	public List<CashSaleViewBean> getCashSaleDetails() throws SpringCrunchifyException;
	public List<AutocompleteBean> getCashParty(String co_id) throws SpringCrunchifyException;
}
