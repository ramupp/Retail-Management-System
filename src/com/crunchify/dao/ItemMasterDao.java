package com.crunchify.dao;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
//import com.crunchify.model.MenuDataBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;
import com.crunchify.model.view.ItemMasterViewBean;

public interface ItemMasterDao {
		
	
	public String itemMasterCreate(ItemMasterBean item_m) throws SpringCrunchifyException;
	
	//public String viewMasterCreate(ItemMasterBean item_master) throws SpringCrunchifyException;

	public List<ItemMasterViewBean> item_master() throws SpringCrunchifyException;

	String viewMasterCreate(ItemMasterBean item_master)
			throws SpringCrunchifyException;

	String itemMasterUpdate(ItemMasterBean item_m) throws SpringCrunchifyException;

	List<ItemMasterBean> fetchAllItemMaster() throws SpringCrunchifyException;

	String itemMasterDelete(ItemMasterBean item_master)throws SpringCrunchifyException;
	
	

	

	

}
