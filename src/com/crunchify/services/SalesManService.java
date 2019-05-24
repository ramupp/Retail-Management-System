package com.crunchify.services;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.SalesManBean;


public interface SalesManService {
	
	public String salesManCreate(SalesManBean sales_man) throws SpringCrunchifyException;
	public List<SalesManBean> sales_man() throws SpringCrunchifyException;
	String salesManUpdate(SalesManBean sales_m) throws SpringCrunchifyException;
	String sales_manTypDelete(SalesManBean s_m_typ)throws SpringCrunchifyException;


}
