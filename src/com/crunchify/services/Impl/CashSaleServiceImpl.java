package com.crunchify.services.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crunchify.dao.CashSaleDao;
import com.crunchify.dao.RetailDesignDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.AutocompleteBean;
import com.crunchify.model.CashSaleHdrBean;
import com.crunchify.model.RetailDesignBean;
import com.crunchify.model.view.CashSaleViewBean;
import com.crunchify.services.CashSaleService;
import com.crunchify.services.RetailDesignService;

@Service
@Transactional
public class CashSaleServiceImpl implements CashSaleService {
	@Autowired
	CashSaleDao cashSaleDao;
	
	@Override
	public String addCashSale(CashSaleHdrBean cashSale)
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return cashSaleDao.addCashSale(cashSale);
	}

	@Override
	public List<CashSaleViewBean> getCashSaleDetails()
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return cashSaleDao.getCashSaleDetails();
	}
	
	@Override
	public List<AutocompleteBean> getCashParty(String co_id)
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return cashSaleDao.getCashParty(co_id);
	}
	

}
