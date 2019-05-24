package com.crunchify.services;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;


public interface ItemTypeService {
	
	public String itemTypeCreate(ItemTypeBean item) throws SpringCrunchifyException;
	public List<ItemTypeBean> item_type() throws SpringCrunchifyException;
	String itemTypeUpdate(ItemTypeBean item) throws SpringCrunchifyException;
	String itemTypeDelete(ItemTypeBean item_typ) throws SpringCrunchifyException;
}
