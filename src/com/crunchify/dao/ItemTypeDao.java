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

public interface ItemTypeDao {
		
	
	public String itemTypeCreate(ItemTypeBean item) throws SpringCrunchifyException;
	
	public List<ItemTypeBean> item_type() throws SpringCrunchifyException;
		String viewTypCreate(ItemTypeBean item_type)
			throws SpringCrunchifyException;

		String itemTypeUpdate(ItemTypeBean item) throws SpringCrunchifyException;

		String itemTypeDelete(ItemTypeBean item_typ) throws SpringCrunchifyException;

}
