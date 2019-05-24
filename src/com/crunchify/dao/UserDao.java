package com.crunchify.dao;

import java.util.List;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.CallData;
import com.crunchify.model.CcfrMasterBean;
import com.crunchify.model.User;
import com.crunchify.model.VtplCustomers;
import com.crunchify.model.VtplReports;

public interface UserDao {
	/**  
	  * This is the method to be used to create 
	  * a record in the Employee table. 
	  */  
  public void CreateUserRegitration(User user) throws SpringCrunchifyException;

	public List<VtplReports> appReports(VtplReports vtplReports) throws SpringCrunchifyException; 
	
	//public List<VtplReports> appDropDownListReports(VtplReports vtplReports) throws SpringCrunchifyException;

	//List<VtplReports> appDropDownListReports(String status)
	//		throws SpringCrunchifyException;

	public List<VtplCustomers> appDtlReport(VtplReports v) throws SpringCrunchifyException;
	
	 public List<User> fetchPermission(User u) throws SpringCrunchifyException;

	public List<CallData> fetchAssignment(CallData callData)  throws SpringCrunchifyException;
	
	public List<CallData> fetchRegister(CallData callData) throws SpringCrunchifyException;
	
	public List<CallData> fetchRegisterDetail(CallData callData) throws SpringCrunchifyException;

	public String callBooking(CallData callData) throws SpringCrunchifyException;
	
	public List<CallData> fetchAssignedTo(CallData callData) throws SpringCrunchifyException;
	
	
	public List<CallData> fetchAssignedOEM() throws SpringCrunchifyException;
	
	public String assignCall(CallData callData) throws SpringCrunchifyException;
	
	public CallData checkSerialStatus(CallData callData) throws SpringCrunchifyException;
	
	public List<CallData> callClosureView(CallData callData) throws SpringCrunchifyException;	
	
	public String CallClose(CallData callData) throws SpringCrunchifyException;
	
	public List<CallData> getRemainingCallNo(CallData callData) throws SpringCrunchifyException;
	
	public List<CallData> getRemainingCallDetail(CallData callData) throws SpringCrunchifyException;
	
	public List<CallData> fetchEngDashboard(CallData callData) throws SpringCrunchifyException;

	public String ccfrEntry(CcfrMasterBean ccfr) throws SpringCrunchifyException;

}
