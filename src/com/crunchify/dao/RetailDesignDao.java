package com.crunchify.dao;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.RetailDesignBean;
import com.crunchify.model.view.DesignViewBean;

public interface RetailDesignDao {
	
	public List<DesignViewBean> fetchAllDesign1() throws SpringCrunchifyException;
	public List<RetailDesignBean> fetchAllDesign() throws SpringCrunchifyException;
	public String addDesign(RetailDesignBean desg)throws SpringCrunchifyException;
	public String updateDesign(RetailDesignBean desg) throws SpringCrunchifyException;
}
