package com.crunchify.services.Impl;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crunchify.dao.UserDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.CallData;
import com.crunchify.model.CcfrMasterBean;
import com.crunchify.model.User;
import com.crunchify.model.VtplCustomers;
import com.crunchify.model.VtplReports;
import com.crunchify.services.RegService;
import com.crunchify.util.EncoderDecoderPwd;


@Service
public class RegServiceImpl implements RegService {
	
	 private static final Logger logger = Logger.getLogger(RegServiceImpl.class);
	 
  @Autowired
  UserDao userDao;
  
  @Autowired
  EncoderDecoderPwd ecdcpwd;

//  @Override
//  @Transactional
//  public User Registration(User user) throws SpringCrunchifyException {
//    try {
//    	
//    	 logger.debug("Inside Registration() method");
//    	 
//		String enpwd = ecdcpwd.getEncodedValue(user.getPwd());
//         user.setPwd(enpwd);
//      userDao.CreateUserRegitration(user);
//
//    } catch (SpringCrunchifyException e) {
//    	logger.error("Error in  user registration : " + this.getClass(), e);
//    	throw new SpringCrunchifyException(e);
//    }   
//    finally {
//        logger.debug("Dao Implemented:");
//    }
//    
//    return null;
//}
  @Override
  @Transactional
  public List<VtplReports> appReports(VtplReports vtplReports) throws SpringCrunchifyException {
    List<VtplReports> list=new ArrayList<VtplReports>();
    try {    	
    	 logger.debug("Inside appReports() method");
    	// List<VtplReports> list=new ArrayList<VtplReports>();
    	 List<VtplCustomers> listc=null;
    	// VtplCustomers cus=new VtplCustomers();
    	 int flag=vtplReports.getFlag();
    	 if(flag==5){
    	    	list = userDao.appReports(vtplReports);  
    	    	System.out.println("1");
    	    
    	    	for (VtplReports v : list) {
    	    		//v.setFlag(9);
    	    		listc=userDao.appDtlReport(v);
    				//listc.add(cus);
    				v.setList1(listc);
    					
    				}
    	    	//list.add(v);
     	    	}
    	    	else
    	    	{
    	    		list = userDao.appReports(vtplReports);
    	    	}
    	
    } catch (SpringCrunchifyException e) {
    	logger.error("Error in  vtpl reports : " + this.getClass(), e);
    	throw new SpringCrunchifyException(e);
    }   
    finally {
        logger.debug("Dao Implemented:");
    }
    return list;
}
  
  
  @Override
  @Transactional
  public List<User> getPermission(User user) throws SpringCrunchifyException {
    List<User> list=new ArrayList<User>();
    try {    	
    	 logger.debug("Inside getPermission() method");    	
    	    	
    	    	list = userDao.fetchPermission(user);  
    	    	
    	
    } catch (SpringCrunchifyException e) {
    	logger.error("Error in user permission : " + this.getClass(), e);
    	throw new SpringCrunchifyException(e);
    }   
    finally {
        logger.debug("Dao Implemented:");
    }
    return list;
}
  
  
  @Override
  @Transactional
  public List<CallData> getAssignment(CallData callData) throws SpringCrunchifyException {
    List<CallData> list=new ArrayList<CallData>();
    try {    	
    	 logger.debug("Inside getAssignment() method");    	
    	    	
    	    	list = userDao.fetchAssignment(callData);  
    	    	
    	
    } catch (SpringCrunchifyException e) {
    	logger.error("Error in getAssignment : " + this.getClass(), e);
    	throw new SpringCrunchifyException(e);
    }   
    finally {
        logger.debug("Dao Implemented:");
    }
    return list;
}
  
  @Override
  @Transactional
  public List<CallData> getEngDashboard(CallData callData) throws SpringCrunchifyException {
    List<CallData> list=new ArrayList<CallData>();
    try {    	
    	 logger.debug("Inside getEngDashboard() method");    	
    	    	
    	    	list = userDao.fetchEngDashboard(callData);  
    	    	
    	
    } catch (SpringCrunchifyException e) {
    	logger.error("Error in getEngDashboard : " + this.getClass(), e);
    	throw new SpringCrunchifyException(e);
    }   
    finally {
        logger.debug("Dao Implemented:");
    }
    return list;
}
  
  
  
  @Override
  @Transactional
  public List<CallData> getRegister(CallData callData) throws SpringCrunchifyException {
    List<CallData> list=new ArrayList<CallData>();
    try {    	
    	 logger.debug("Inside getRegister() method");    	
    	    	
    	    	list = userDao.fetchRegister(callData);  
    	    	
    	
    } catch (SpringCrunchifyException e) {
    	logger.error("Error in getRegister : " + this.getClass(), e);
    	throw new SpringCrunchifyException(e);
    }   
    finally {
        logger.debug("Dao Implemented:");
    }
    return list;
}
  
  
  @Override
  @Transactional
  public List<CallData> getRemainingCallNo(CallData callData) throws SpringCrunchifyException {
    List<CallData> list=new ArrayList<CallData>();
    try {    	
    	 logger.debug("Inside getRemainingCallNo() method");    	
    	    	
    	    	list = userDao.getRemainingCallNo(callData);  
    	    	
    	
    } catch (SpringCrunchifyException e) {
    	logger.error("Error in getRemainingCallNo : " + this.getClass(), e);
    	throw new SpringCrunchifyException(e);
    }   
    finally {
        logger.debug("Dao Implemented:");
    }
    return list;
}
  
  @Override
  @Transactional
  public List<CallData> getRemainingCallDetail(CallData callData) throws SpringCrunchifyException {
    List<CallData> list=new ArrayList<CallData>();
    try {    	
    	 logger.debug("Inside getRemainingCallNo() method");    	
    	    	
    	    	list = userDao.getRemainingCallDetail(callData);  
    	    	
    	
    } catch (SpringCrunchifyException e) {
    	logger.error("Error in getRemainingCallNo : " + this.getClass(), e);
    	throw new SpringCrunchifyException(e);
    }   
    finally {
        logger.debug("Dao Implemented:");
    }
    return list;
}
  
  
  @Override
  @Transactional
  public List<CallData> getAssignedTo(CallData callData) throws SpringCrunchifyException {
    List<CallData> list=new ArrayList<CallData>();
    try {    	
    	 logger.debug("Inside getAssignedTo() method");    	
    	    	
    	    	list = userDao.fetchAssignedTo(callData);  
    	    	
    	
    } catch (SpringCrunchifyException e) {
    	logger.error("Error in getRegister : " + this.getClass(), e);
    	throw new SpringCrunchifyException(e);
    }   
    finally {
        logger.debug("Dao Implemented:");
    }
    return list;
}
  
  @Override
  @Transactional
  public List<CallData> getAssignedOEM() throws SpringCrunchifyException {
    List<CallData> list=new ArrayList<CallData>();
    try {    	
    	 logger.debug("Inside getAssignedOEM() method");    	
    	    	
    	    	list = userDao.fetchAssignedOEM();  
    	    	
    	
    } catch (SpringCrunchifyException e) {
    	logger.error("Error in getRegister : " + this.getClass(), e);
    	throw new SpringCrunchifyException(e);
    }   
    finally {
        logger.debug("Dao Implemented:");
    }
    return list;
}
  
  
  @Override
  @Transactional
  public List<CallData> getRegisterDetail(CallData callData) throws SpringCrunchifyException {
    List<CallData> list=new ArrayList<CallData>();
    try {    	
    	 logger.debug("Inside getRegisterDetail() method");   
    	 
    	        CallData ob=userDao.checkSerialStatus(callData);
    	        
    	        if(ob.getCount()>0)
    	        {
    	        	list.add(ob);
    	        }
    	        else
    	        {
    	        	list = userDao.fetchRegisterDetail(callData);  
    	        }
    	    	
    	    	
    	    	
    	
    } catch (SpringCrunchifyException e) {
    	logger.error("Error in getRegisterDetail : " + this.getClass(), e);
    	throw new SpringCrunchifyException(e);
    }   
    finally {
        logger.debug("Dao Implemented:");
    }
    return list;
}
  
  
  @Override
  @Transactional
  public String callBooking(CallData callData) throws SpringCrunchifyException {
    try {
    	
    	 logger.debug("Inside callBooking() method");
    	 
		   userDao.callBooking(callData);

    } catch (SpringCrunchifyException e) {
    	logger.error("Error in  callBooking : " + this.getClass(), e);
    	throw new SpringCrunchifyException(e);
    }   
    finally {
        logger.debug("Dao Implemented:");
    }
    
    return null;
}
  
  @Override
  @Transactional
  public String ccfrEntry(CcfrMasterBean ccfr) throws SpringCrunchifyException {
	  String msg="";
    try {
    	
    	 logger.debug("Inside ccfrEntry() method");
    	 
		   msg=userDao.ccfrEntry(ccfr);

    } catch (SpringCrunchifyException e) {
    	logger.error("Error in  ccfrEntry : " + this.getClass(), e);
    	throw new SpringCrunchifyException(e);
    }   
    finally {
        logger.debug("Dao Implemented:");
    }
    
    return msg;
}
  
  
  
  @Override
  @Transactional
  public List<CallData> callClosureView(CallData callData) throws SpringCrunchifyException {
	  List<CallData> list=new ArrayList<CallData>();
    try {
    	
    	 logger.debug("Inside callClosureView() method");
    	 
		   list=userDao.callClosureView(callData);

    } catch (SpringCrunchifyException e) {
    	logger.error("Error in  callClosureView : " + this.getClass(), e);
    	throw new SpringCrunchifyException(e);
    }   
    finally {
        logger.debug("Dao Implemented:");
    }
    
    return list;
}
  
  
  @Override
  @Transactional
  public String assignCall(CallData callData) throws SpringCrunchifyException {
    try {
    	
    	 logger.debug("Inside getBooking() method");
    	 
		   userDao.assignCall(callData);

    } catch (SpringCrunchifyException e) {
    	logger.error("Error in  user registration : " + this.getClass(), e);
    	throw new SpringCrunchifyException(e);
    }   
    finally {
        logger.debug("Dao Implemented:");
    }
    
    return null;
}
  
  
  @Override
  @Transactional
  public String CallClose(CallData callData) throws SpringCrunchifyException {
    try {
    	
    	 logger.debug("Inside CallClose() method");
    	 
		   userDao.CallClose(callData);

    } catch (SpringCrunchifyException e) {
    	logger.error("Error in  CallClose : " + this.getClass(), e);
    	throw new SpringCrunchifyException(e);
    }   
    finally {
        logger.debug("Dao Implemented:");
    }
    
    return null;
}
  
  
  
  
//  @Override
//  public List<OspProfessionalDTO> fetchApprovalProfList(String profStatus)
//      throws OSPBusinessException {
//    logger.debug(" Entering AdminServiceImpl >> fetchApprovalProfList() method");
//    
//    List<OspProfessionalDTO> profDetailsList = null;
//    List<OspProfSpecialization> specializationList = null;
//    List<OspProfCat> listsubCategory = null;
//    try {
//     
//      profDetailsList = adminDAO.fetchApprovalProfList(profStatus);
//
//      for (OspProfessionalDTO professionalDTO : profDetailsList) {
//        specializationList = profDAO.getProfSpecializationList(professionalDTO.getProfId());
//        professionalDTO.setSpecializationList(specializationList);
//        List<OspProfChamber> chamberDetailsList = null;
//        long chamberActiveId =
//            configParamBean.getParameterByCodeName(AppConstants.PARAM_CODE_CHAMBER_STATUS,
//                AppConstants.PROF_COMM_MODE_ACTIVE).getParameterid();
//        chamberDetailsList =
//            profDAO.getProfChamberDetailsListById(professionalDTO.getProfId(), chamberActiveId);
//        if (null != chamberDetailsList && !chamberDetailsList.isEmpty()) {
//          for (OspProfChamber cham : chamberDetailsList.subList(0, 1)) {
//
//            List<OspContact> chamberContactList =
//                profDAO.chamberContactDetails(cham.getChamberId());
//            cham.setContactList(chamberContactList);
//            AddressLocation chamberAdd =
//                AppUtil.manipulateLocationByAddressId(cham.getAddress(), masterDataBean);
//            chamberAdd.getAddress().setActiveStatus(0);
//            chamberAdd.getAddress().setLocationId(0);
//            chamberAdd.getAddress().setOtherArea(null);
//            List<AddressLocation> chamberLocationList = new ArrayList<AddressLocation>();
//            chamberAdd.setAddressId(0);
//            chamberLocationList.add(chamberAdd);
//            cham.setChamberAdress(chamberLocationList);
//            cham.setAddress(null);
//
//            chamberContactList = profDAO.chamberContactDetails(cham.getChamberId());
//            if (null != chamberContactList && !chamberContactList.isEmpty()) {
//              chamberContactList.get(0).setContactType(0);
//              cham.setContactList(chamberContactList.subList(0, 1));
//            }
//
//            chamberDetailsList = new ArrayList<OspProfChamber>();
//            chamberDetailsList.add(cham);
//            professionalDTO.setProfChamberDetailsList(chamberDetailsList);
//            cham.setChamberId(0);
//            cham.setChamberType(0);
//            cham.setEstablishmnetDesc(null);
//            cham.setActiveStatus(0);
//            cham.setFlag(null);
//            cham.setChamberActiveStatus(null);
//            break;
//          }
//        }
  
}
