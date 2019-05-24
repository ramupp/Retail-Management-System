package com.crunchify.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.DropDownBean;
import com.crunchify.model.StockData;

public interface DropDownDao {
	
	public List<Object> getSelectData(DropDownBean getData) throws SpringCrunchifyException;
	
	
}
