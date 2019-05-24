package com.crunchify.services;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.CityMasterBean;
import com.crunchify.model.StateMasterBean;




public interface StateMasterService {
	
	public String stateMasterCreate(StateMasterBean state_m) throws SpringCrunchifyException;
	public List<StateMasterBean> state_type() throws SpringCrunchifyException;
	String stateUpdate(StateMasterBean state) throws SpringCrunchifyException;
	String stateTypeDelete(StateMasterBean state_typ)throws SpringCrunchifyException;

}
