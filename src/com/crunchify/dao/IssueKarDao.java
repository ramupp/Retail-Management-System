package com.crunchify.dao;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.CashSaleHdrBean;
import com.crunchify.model.IssueKarHdrBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.RetailDesignBean;

public interface IssueKarDao {
	

	public String addIssueKar(IssueKarHdrBean kar)throws SpringCrunchifyException;
	public List<IssueKarHdrBean> kar() throws SpringCrunchifyException;
	String viewTypCreate(IssueKarHdrBean kar)
		throws SpringCrunchifyException;
	//String updateIssueKar(IssueKarHdrBean kar) throws SpringCrunchifyException;
	
}
