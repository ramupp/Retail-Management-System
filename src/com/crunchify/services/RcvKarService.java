package com.crunchify.services;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.RcvRetKarHdrBean;

public interface RcvKarService {

	//void issueUpdate(IssueKarHdrBean rcv_kar);

	//String issueKarUpdate(IssueKarHdrBean rcv_kar)throws SpringCrunchifyException;
	
	public String issueKarUpdate(RcvRetKarHdrBean rcv_kar) throws SpringCrunchifyException ;

	List<RcvRetKarHdrBean> rcv_kar() throws SpringCrunchifyException;

	//String updateKar(IssueKarHdrBean rcv_kar) throws SpringCrunchifyException;

	String updateRcvKar(RcvRetKarHdrBean rcv_kar) throws SpringCrunchifyException;

}
