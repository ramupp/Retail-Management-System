package com.crunchify.services;


import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.CallData;
import com.crunchify.model.CcfrMasterBean;
import com.crunchify.model.User;
import com.crunchify.model.VtplCustomers;
import com.crunchify.model.VtplReports;

public interface RegService {

 // public User Registration(User user) throws SpringCrunchifyException;
  public List<VtplReports> appReports(VtplReports vtplReports) throws SpringCrunchifyException;
 // public List<VtplReports> getDropDownList(String status) throws SpringCrunchifyException;
   public List<User> getPermission(User user) throws SpringCrunchifyException;
public List<CallData> getAssignment(CallData callData) throws SpringCrunchifyException;

public List<CallData> getRegister(CallData callData) throws SpringCrunchifyException;

public List<CallData> getRegisterDetail(CallData callData) throws SpringCrunchifyException;

public String callBooking(CallData callData) throws SpringCrunchifyException;

public List<CallData> getAssignedTo(CallData callData) throws SpringCrunchifyException;

public List<CallData> getAssignedOEM() throws SpringCrunchifyException;


public String assignCall(CallData callData) throws SpringCrunchifyException; 

public List<CallData> callClosureView(CallData callData) throws SpringCrunchifyException;

public String CallClose(CallData callData) throws SpringCrunchifyException;

public List<CallData> getRemainingCallNo(CallData callData) throws SpringCrunchifyException;

public List<CallData> getRemainingCallDetail(CallData callData) throws SpringCrunchifyException;

public List<CallData> getEngDashboard(CallData callData) throws SpringCrunchifyException;

public String ccfrEntry(CcfrMasterBean ccfr) throws SpringCrunchifyException;
  
  
}
