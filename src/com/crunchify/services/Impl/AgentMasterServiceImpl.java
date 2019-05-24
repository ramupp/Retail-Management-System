package com.crunchify.services.Impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crunchify.dao.AgentMasterDao;
import com.crunchify.dao.ItemTypeDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.AgentMasterBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.services.AgentMasterService;
import com.crunchify.services.ItemTypeService;




@Service
@Transactional
public class AgentMasterServiceImpl implements AgentMasterService {
	
	 private static final Logger logger = Logger.getLogger(AgentMasterServiceImpl.class);
	 
  @Autowired
  private AgentMasterDao itemDao;
  
  
  @Override
  //@Transactional
  public String agentMasterCreate(AgentMasterBean agent) throws SpringCrunchifyException{
  
    try {    	
    	 logger.debug("Inside agentMasterCreate() method");
    	 
    	
    	 return itemDao.agentMasterCreate(agent);
    	
    	
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
	public List<AgentMasterBean> agent()
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return itemDao.agent();
	}

@Override
//@Transactional
public String agentMasterUpdate(AgentMasterBean agent) throws SpringCrunchifyException{

  try {    	
  	 logger.debug("Inside agentMasterCreate() method");
  	 
  	
  	 return itemDao.agentMasterUpdate(agent);
  	
  	
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
//@Transactional
public String agentTypeDelete(AgentMasterBean agent_typ) throws SpringCrunchifyException{

  try {    	
  	 logger.debug("Inside itemTypeCreate() method");
  	 
  	
  	 return itemDao.agentTypeDelete(agent_typ);
  	
  	
  } catch (Exception e) {
  	logger.error("Error in  roleCreate : " + this.getClass(), e);
  	throw new SpringCrunchifyException(e);
  }   
  finally {
      logger.debug("Dao Implemented:");
  }
  //return "";
}

}