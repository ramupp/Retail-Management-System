package com.crunchify.dao;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemRateTypeBean;
import com.crunchify.model.ItemTypeBean;

public interface ItemRateTypeDao {
	
	public String itemRateCreate (ItemRateTypeBean item_rate) throws SpringCrunchifyException;

	
	
	public List<ItemRateTypeBean> item_rate() throws SpringCrunchifyException;
	String viewRateCreate(ItemRateTypeBean item_rate)
		throws SpringCrunchifyException;
	
	String itemRateUpdate(ItemRateTypeBean rate) throws SpringCrunchifyException;

	String rateTypeDelete(ItemRateTypeBean rate_typ)throws SpringCrunchifyException;
}
