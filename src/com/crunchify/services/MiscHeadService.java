package com.crunchify.services;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.MiscHeadBean;


public interface MiscHeadService {
	
	public String miscHeadCreate(MiscHeadBean misc) throws SpringCrunchifyException;
	public List<MiscHeadBean> misc_head() throws SpringCrunchifyException;

}
