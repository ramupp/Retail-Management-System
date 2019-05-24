package com.crunchify.services;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.UomMasterBean;



public interface UomMasterService {
	
	public String uomMasterCreate(UomMasterBean uom_m) throws SpringCrunchifyException;
	public List<UomMasterBean> uom_master() throws SpringCrunchifyException;
	public String uomMasterUpdate(UomMasterBean uom_m) throws SpringCrunchifyException;
	String uomTypeDelete(UomMasterBean uom_typ) throws SpringCrunchifyException;

}
