package com.crunchify.services.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crunchify.dao.RetailLoginDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.services.RetailLoginService;

@Service
@Transactional
public class RetailLoginServiceImpl implements RetailLoginService {


	@Autowired
	RetailLoginDao r;
	
	public List<RetailRegistrationBean> login(RetailRegistrationBean s)
			throws SpringCrunchifyException {
		
		return r.login(s);
	}

	@Override
	public List<RetailRegistrationBean> getAllUser()
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return r.getAllUser();
	}

}
