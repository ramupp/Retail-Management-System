package com.crunchify.dao;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.RcvRetKarHdrBean;

public interface RcvKarDao {

	String updateIsueKar(RcvRetKarHdrBean rcv_kar);

	String updateIssue(RcvRetKarHdrBean rcv_kar) throws SpringCrunchifyException;

	String issueKarUpdate(RcvRetKarHdrBean rcv_kar)throws SpringCrunchifyException;

	List<RcvRetKarHdrBean> rcv_kar() throws SpringCrunchifyException;

	String viewRcv_kar(RcvRetKarHdrBean rcv_kar) throws SpringCrunchifyException;

	String updateRcvKar(RcvRetKarHdrBean rcv_kar) throws SpringCrunchifyException;



	


}
