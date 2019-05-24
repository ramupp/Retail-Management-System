package com.crunchify.services;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.PartyTypeBean;


public interface PartyTypeService {
	
	public String partyTypeCreate(PartyTypeBean party) throws SpringCrunchifyException;
	
	public List<PartyTypeBean> party_type() throws SpringCrunchifyException;

	String partyTypeUpdate(PartyTypeBean party) throws SpringCrunchifyException;

	String associateTypeDelete(PartyTypeBean associate_typ)throws SpringCrunchifyException;



}
