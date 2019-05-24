package com.crunchify.services;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.IssueKarHdrBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;


public interface IssueKarService {
	public String addIssueKar(IssueKarHdrBean kar) throws SpringCrunchifyException;
	public List<IssueKarHdrBean> kar() throws SpringCrunchifyException;
	String updateIssueKar(IssueKarHdrBean kar) throws SpringCrunchifyException;
}
