package com.crunchify.dao;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.OrderCodeMaster;
import com.crunchify.model.SiteDetails;
import com.crunchify.model.User;
import com.crunchify.model.VtplUser;

public interface LoginDao {
  
  public User loginCheck (String userName, String password) throws SpringCrunchifyException;

  public SiteDetails getSiteDetails(int id) throws SpringCrunchifyException;
  
  public String setSiteDetails(SiteDetails site) throws SpringCrunchifyException;
  
  public List<OrderCodeMaster> getOrderCodes() throws SpringCrunchifyException;
  
  public List<VtplUser> loginCheckForVtpl (String userName, String password) throws SpringCrunchifyException;
}
