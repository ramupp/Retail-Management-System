package com.crunchify.services;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.UomConvMasterBean;


public interface UomConvMasterService {
	
	public String uomConvCreate(UomConvMasterBean conv) throws SpringCrunchifyException;
	
	public List<UomConvMasterBean> uom_cnv() throws SpringCrunchifyException;

	String uom_convUpdate(UomConvMasterBean uom_cnv)
			throws SpringCrunchifyException;

	String uomcnvTypDelete(UomConvMasterBean ucnv_typ)throws SpringCrunchifyException;
	
}
