package com.crunchify.services.Impl;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crunchify.dao.RetailRoleDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemTypeBean;
//import com.crunchify.model.MenuDataBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;
import com.crunchify.services.RoleService;


@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	
	 private static final Logger logger = Logger.getLogger(RoleServiceImpl.class);
	 
  @Autowired
  RetailRoleDao roleDao;
  
  
  @Override
  @Transactional
  public String roleCreate(RoleDataHdr rhdr) throws SpringCrunchifyException {
  
    try {    	
    	 logger.debug("Inside roleCreate() method");
    	 
    	
    	 roleDao.roleCreate(rhdr);
    	
    	
    } catch (Exception e) {
    	logger.error("Error in  roleCreate : " + this.getClass(), e);
    	throw new SpringCrunchifyException(e);
    }   
    finally {
        logger.debug("Dao Implemented:");
    }
    return "";
}
  
  @Override
  @Transactional
  public String roleUpdate(RoleDataHdr rhdr) throws SpringCrunchifyException {
  
    try {    	
    	 logger.debug("Inside roleUpdate() method");
    	 
    	
    	 roleDao.roleUpdate(rhdr);
    	
    	
    } catch (Exception e) {
    	logger.error("Error in  roleCreate : " + this.getClass(), e);
    	throw new SpringCrunchifyException(e);
    }   
    finally {
        logger.debug("Dao Implemented:");
    }
    return "";
}
  
  
//  @Override
//  @Transactional
//  public String menuCreate(MenuDataBean mbean) throws SpringCrunchifyException {
//  
//    try {    	
//    	 logger.debug("Inside roleCreate() method");
//    	 
//    	
//    	 roleDao.menuCreate(mbean);
//    	
//    	
//    } catch (Exception e) {
//    	logger.error("Error in  roleCreate : " + this.getClass(), e);
//    	throw new SpringCrunchifyException(e);
//    }   
//    finally {
//        logger.debug("Dao Implemented:");
//    }
//    return "";
//}
  
  
  
  
  @Override
  @Transactional
  public String userCreate(RetailRegistrationBean rbean,List<UserRoleCompany> roleComp) throws SpringCrunchifyException {
  
    try {    	
    	 logger.debug("Inside userCreate() method");
    	 
    	
    	 roleDao.userCreate(rbean,roleComp);
    	
    	
    } catch (Exception e) {
    	logger.error("Error in  userCreate : " + this.getClass(), e);
    	throw new SpringCrunchifyException(e);
    }   
    finally {
        logger.debug("Dao Implemented:");
    }
    return "";
}
  
  
  @Override
  //@Transactional
  public String changePwdUpdate(RetailRegistrationBean pwd) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside changePwdCreate() method");
    	 
    	
    	 return roleDao.changePwdUpdate(pwd);
    	
    	
    } catch (Exception e) {
    	logger.error("Error in  roleCreate : " + this.getClass(), e);
    	throw new SpringCrunchifyException(e);
    }   
    finally {
        logger.debug("Dao Implemented:");
    }
    //return "";
}


@Override
public List<RetailRegistrationBean> change_pwd() {
	// TODO Auto-generated method stub
	return null;
}
  
  
  
  
}
