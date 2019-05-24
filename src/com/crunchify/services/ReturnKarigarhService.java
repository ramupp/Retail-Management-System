package com.crunchify.services;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.RcvRetKarHdrBean;

public interface ReturnKarigarhService {

	String returnKarigarhCreate(RcvRetKarHdrBean ret_kar) throws SpringCrunchifyException;

	List<RcvRetKarHdrBean> ret_kar() throws SpringCrunchifyException;





}
