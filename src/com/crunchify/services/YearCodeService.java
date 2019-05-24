package com.crunchify.services;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.PriceTypeMasterBean;
import com.crunchify.model.YearCodeBean;



public interface YearCodeService {
	
	public String yearCodeCreate(YearCodeBean year_c) throws SpringCrunchifyException;

	public List<YearCodeBean> yearcd_master() throws SpringCrunchifyException;

	String yearCodeUpdate(YearCodeBean yr_cd) throws SpringCrunchifyException;

	String yearCodeDelete(YearCodeBean year_cd) throws SpringCrunchifyException;

	

}
