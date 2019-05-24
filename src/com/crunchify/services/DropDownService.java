package com.crunchify.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.DropDownBean;
//import com.crunchify.model.MenuDataBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.StockData;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;

public interface DropDownService {
	
	public List<Object> getSelectData(DropDownBean getData) throws SpringCrunchifyException;

  
}
