package com.crunchify.services.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crunchify.dao.CashSaleDao;
import com.crunchify.dao.PackingSlipDao;
import com.crunchify.dao.RetailDesignDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.CashSaleHdrBean;
import com.crunchify.model.PackingSlipHdrBean;
import com.crunchify.model.RetailDesignBean;
import com.crunchify.services.CashSaleService;
import com.crunchify.services.PackingSlipService;
import com.crunchify.services.RetailDesignService;

@Service
@Transactional
public class PackingSlipServiceImpl implements PackingSlipService {
	@Autowired
	PackingSlipDao packingSlipDao;
	
	

	@Override
	public String addPackingSlip(PackingSlipHdrBean slip)
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return packingSlipDao.addPackingSlip(slip);
	}
	
	
	

}
