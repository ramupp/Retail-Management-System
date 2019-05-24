package com.crunchify.services;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.DocumentBean;
import com.crunchify.model.view.DocumentRequestBodyBean;




public interface DocumentService {


	public List<DocumentBean> doc() throws SpringCrunchifyException;
	public String addDocument(DocumentRequestBodyBean doc) throws SpringCrunchifyException;
	
}
