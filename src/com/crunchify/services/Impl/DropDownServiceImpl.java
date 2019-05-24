package com.crunchify.services.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crunchify.dao.DropDownDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.DropDownBean;
import com.crunchify.model.StockData;
import com.crunchify.services.DropDownService;

@Service
@Transactional
public class DropDownServiceImpl implements DropDownService {
	
	@Autowired
	DropDownDao dropDownDao;

	@Override
	public List<Object> getSelectData(DropDownBean getData) throws SpringCrunchifyException{
		List<Object> data= null;
		data =  dropDownDao.getSelectData(getData);		
		return data;
		
	}

}
