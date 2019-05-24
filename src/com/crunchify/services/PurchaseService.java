package com.crunchify.services;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.AutocompleteDesignBean;
import com.crunchify.model.PurDataHdr;
import com.crunchify.model.StockData;
import com.crunchify.model.view.PurDataViewBean;


public interface PurchaseService {

	public String purchaseEntry(PurDataHdr purDataHdr) throws SpringCrunchifyException;
	
	
	public String purchaseReturnEntry(PurDataHdr purDataHdr) throws SpringCrunchifyException;
	
	public List<PurDataViewBean> getPurchaseDetails(String co_id) throws SpringCrunchifyException;


	List<AutocompleteDesignBean> fetchDesign(String id) throws SpringCrunchifyException;
  
  
}
