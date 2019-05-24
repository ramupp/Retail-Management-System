package com.crunchify.services.Impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crunchify.dao.LoginDao;
import com.crunchify.dao.Impl.LoginDaoImpl;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.OrderCodeMaster;
import com.crunchify.model.SiteDetails;
import com.crunchify.model.User;
import com.crunchify.model.VtplUser;
import com.crunchify.services.Login_Service;

@Service
public class LoginServiceImpl implements Login_Service {
	/* Logger implementation */
	private static final Logger logger = Logger.getLogger(LoginServiceImpl.class);
	
	/*LoginDao autowiring */
  @Autowired
  LoginDao loginDao;

/* Login Service method */
  @Override
  public User login(String userName, String password) throws SpringCrunchifyException {
    try {
      User user = loginDao.loginCheck(userName, password);
      logger.debug("Inside Service login() method");
      if (user != null) {
        return user;
      } else {
        return null;
      }
    } catch (Exception e) {
    	logger.error("Error in  user login " + this.getClass(), e);    	
     throw new SpringCrunchifyException(e);
    }
    finally {
        logger.debug("Entrying to dao loginCheck() method:");
    }

  }
  @Override
  public SiteDetails getVal(int id) throws SpringCrunchifyException {
    try {
    	SiteDetails s = loginDao.getSiteDetails(id);
      logger.debug("Inside Service login() method");
      if (s != null) {
        return s;
      } else {
        return null;
      }
    } catch (Exception e) {
    	logger.error("Error in  user login " + this.getClass(), e);    	
     throw new SpringCrunchifyException(e);
    }
    finally {
        logger.debug("Entrying to dao loginCheck() method:");
    }

  }
  
  @Override
  public String setVal(SiteDetails site) throws SpringCrunchifyException {
    try {
    	String s = loginDao.setSiteDetails(site);
      logger.debug("Inside Service login() method");
      if (s != null) {
        return s;
      } else {
        return null;
      }
    } catch (Exception e) {
    	logger.error("Error in  user login " + this.getClass(), e);    	
     throw new SpringCrunchifyException(e);
    }
    finally {
        logger.debug("Entrying to dao loginCheck() method:");
    }

  }
  
  @Override
  public List<OrderCodeMaster> getOrderCodes() throws SpringCrunchifyException {
    try {
    	List<OrderCodeMaster> s = loginDao.getOrderCodes();
      logger.debug("Inside Service login() method");
      if (s.size()>0) {
        return s;
      } else {
        return null;
      }
    } catch (Exception e) {
    	logger.error("Error in  user login " + this.getClass(), e);    	
     throw new SpringCrunchifyException(e);
    }
    finally {
        logger.debug("Entrying to dao loginCheck() method:");
    }

  }
  @Override
  public List<VtplUser> getLoginStatus(String userName, String password) throws SpringCrunchifyException {
    try {
    	List<VtplUser> listData = loginDao.loginCheckForVtpl(userName, password);
      logger.debug("Inside Service login() method");
      if (listData != null) {
        return listData;
      } else {
        return null;
      }
    } catch (Exception e) {
    	logger.error("Error in  user login " + this.getClass(), e);    	
     throw new SpringCrunchifyException(e);
    }
    finally {
        logger.debug("Entrying to dao loginCheck() method:");
    }

  }

}
