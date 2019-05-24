package com.crunchify.services;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.RetailDesignBean;
import com.crunchify.model.view.DesignViewBean;


public interface RetailDesignService {
	
	public String fetchAllDesign(String code) throws SpringCrunchifyException;
	public String addDesign(RetailDesignBean desg) throws SpringCrunchifyException;
	
	public List<RetailDesignBean> fetchDesignDetails() throws SpringCrunchifyException;
	public List<DesignViewBean> fetchDesignDetails1() throws SpringCrunchifyException;
	public String updateDesign(RetailDesignBean desg)throws SpringCrunchifyException;

}
