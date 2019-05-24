package com.crunchify.dao;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.CashSaleHdrBean;
import com.crunchify.model.PackingSlipHdrBean;
import com.crunchify.model.RetailDesignBean;

public interface PackingSlipDao {
	

	public String addPackingSlip(PackingSlipHdrBean slip)throws SpringCrunchifyException;
}
