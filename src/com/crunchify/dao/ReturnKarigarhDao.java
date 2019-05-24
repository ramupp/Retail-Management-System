package com.crunchify.dao;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.RcvRetKarHdrBean;

public interface ReturnKarigarhDao {

	//String returnKarigarhCreate1(IssueKarHdrBean ret_kar);

	String returnKarigarhCreate(RcvRetKarHdrBean ret_kar) throws SpringCrunchifyException;

	List<RcvRetKarHdrBean> ret_kar() throws SpringCrunchifyException;

	String viewRet_kar(RcvRetKarHdrBean ret_kar) throws SpringCrunchifyException;

	

	

}
