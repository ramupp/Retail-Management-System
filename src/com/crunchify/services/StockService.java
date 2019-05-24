package com.crunchify.services;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.StockData;
import com.crunchify.model.StockDataRm;
import com.crunchify.model.view.CashSaleViewBean;
import com.crunchify.model.view.CrSaleViewBean;


public interface StockService {

public String stockEntry(StockData stData) throws SpringCrunchifyException;

public List<StockData> stockView(StockData stData) throws SpringCrunchifyException;

public List<CrSaleViewBean> getStockTransAcknow(String co_id) throws SpringCrunchifyException;

String stockEntryRm(StockDataRm stData) throws SpringCrunchifyException;
  
  
}
