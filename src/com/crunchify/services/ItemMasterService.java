package com.crunchify.services;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.view.ItemMasterViewBean;



public interface ItemMasterService {
	
	public String itemMasterCreate(ItemMasterBean item_m) throws SpringCrunchifyException;
	
	//public String itemMasterview(ItemMasterBean item_master) throws SpringCrunchifyException;

	public List<ItemMasterViewBean> item_master() throws SpringCrunchifyException;

	String itemMasterUpdate(ItemMasterBean item_m) throws SpringCrunchifyException;

	String itemMasterDelete(ItemMasterBean item_master)throws SpringCrunchifyException;

	
	
}
