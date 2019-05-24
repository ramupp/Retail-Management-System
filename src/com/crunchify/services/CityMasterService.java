package com.crunchify.services;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.CityMasterBean;
import com.crunchify.model.PartyTypeBean;




public interface CityMasterService {
	
	public String cityMasterCreate(CityMasterBean city_m) throws SpringCrunchifyException;
	public List<CityMasterBean> city_type() throws SpringCrunchifyException;
	String cityUpdate(CityMasterBean city) throws SpringCrunchifyException;
	String cityTypeDelete(CityMasterBean city_typ)throws SpringCrunchifyException;

}
