package com.crunchify.dao.Impl;




import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.crunchify.dao.UserDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.CallData;
import com.crunchify.model.CcfrMasterBean;
import com.crunchify.model.OrderCodeMaster;
import com.crunchify.model.User;
import com.crunchify.model.VtplCustomers;
import com.crunchify.model.VtplReports;
import com.crunchify.util.UtilityHelper;

@Repository
public class UserDaoImp implements UserDao {
	
	private static final Logger logger = Logger.getLogger(UserDaoImp.class);

  @Autowired
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
  int f = 0;
  
  /* For Ccfr Entry */

  public String ccfrEntry(CcfrMasterBean ccfr) throws SpringCrunchifyException{
  	  
  	  logger.debug("Inside ccfrEntry method() in Dao");
  	UtilityHelper utilityHelper = new UtilityHelper();
    int idPattern = 0;
    ccfr.setDbId(idPattern);
    System.out.println("i am in ccfr");
    
      String regSql ="insert into tbl_master_ccfr(ID, CUSTOMER_NAME, LOCATION_NAME, SERIAL_NUMBER, FAILURE_TYPE, MODEL, CALL_TYPE, UNIT_FAILED, SERVICE_TYPE, CALL_NUMBER, "
      		+ "SYSTEM_STATUS, NUETRAL_TO_GROUND, SYSTEM_DOWN, PHASE_TO_NEUTRAL, PROBLEM_NATURE, START_DATE1, START_TIME1, START_DATE2, START_TIME2, END_DATE1, END_TIME1,"
      		+ " END_DATE2, END_TIME2, REMARKS, ACTIVE, CREATED_BY, CREATED_ON, CCFR_NUMBER, OEM_CALL_ID, "
      		+ "OLD_SERIAL, NEW_SERIAL, VERIFY) values(:dbId,:customer,:loc,:srlno,:ft,:model,:ct,:uf,:st,:cn,:sysst,:ntog,:sdwn,:pton,"
      		+ ":pnature,:stdt1,:sttm1,:stdt2,:sttm2,:enddt1,:endtm1,:enddt2,:endtm2,:rem,:active,:createdBy,now(),:ccfrno,:oemCallId,:oldsrl,:newsrl,:verify)";
    		  
    		  
    		  
      MapSqlParameterSource namedParameters = new MapSqlParameterSource();
      namedParameters.addValue("dbId",ccfr.getDbId());
      namedParameters.addValue("customer",ccfr.getCustomer_name());
      namedParameters.addValue("loc",ccfr.getLocation_name());
      namedParameters.addValue("srlno", ccfr.getSerial_number());
      namedParameters.addValue("ft", ccfr.getFailure_type());
      namedParameters.addValue("model", ccfr.getModel());
      namedParameters.addValue("ct",ccfr.getCall_type());
      namedParameters.addValue("uf", ccfr.getUnit_failed());
      namedParameters.addValue("st", ccfr.getService_type());
      namedParameters.addValue("cn", ccfr.getCall_number());
      namedParameters.addValue("sysst", ccfr.getSystem_status());
      namedParameters.addValue("ntog",ccfr.getNtg());
      namedParameters.addValue("sdwn", ccfr.getSystem_down());
      namedParameters.addValue("pton", ccfr.getPtn());
      namedParameters.addValue("pnature", ccfr.getProblem_nature());
      namedParameters.addValue("stdt2", ccfr.getCall_date());
      namedParameters.addValue("sttm2", ccfr.getCall_time());
      namedParameters.addValue("enddt2", ccfr.getArrival_date());
      namedParameters.addValue("endtm2", ccfr.getArrival_time());
      namedParameters.addValue("stdt1", ccfr.getStart_date());
      namedParameters.addValue("sttm1", ccfr.getStart_time());
      namedParameters.addValue("enddt1", ccfr.getEnd_date());
      namedParameters.addValue("endtm1", ccfr.getEnd_time());
      namedParameters.addValue("rem", ccfr.getRemarks());
      namedParameters.addValue("active", ccfr.getActive());
      namedParameters.addValue("createdBy", ccfr.getCreated_by());
      namedParameters.addValue("createdOn", "now()");
      namedParameters.addValue("ccfrno",ccfr.getCcfr_number());
      namedParameters.addValue("oemCallId", ccfr.getOem_call_id());
      namedParameters.addValue("oldsrl", ccfr.getOld_serial());
      namedParameters.addValue("newsrl", ccfr.getNew_serial());
      namedParameters.addValue("verify", ccfr.getVerify());
      
      
      
      KeyHolder keyHolder = new GeneratedKeyHolder(); 
      
      try{
      
      namedParameterJdbcTemplate.update(regSql, namedParameters, keyHolder); 
      if(ccfr.getFlag().equals("close")){
      String x=utilityHelper.CCFR_Complete(ccfr.getCreated_by(), ccfr.getCall_number());
      }
      
      }catch(RuntimeException re)
      {
      	logger.error("Explicitly throwing exception inside Dao:Ccfr Entry method()",re);
      	      	throw new SpringCrunchifyException(re);
      	      
      	
      	
      }
     return "success";

    }
    /*For Ccfr Entry */



/* For Booking a Call */

public String callBooking(CallData callData) throws SpringCrunchifyException{
	  
	  logger.debug("Inside getBookingData method()");
	String call_number="";
	UtilityHelper utilityHelper = new UtilityHelper();
     int idPattern = 0;
     String temp_dt = callData.getCall_date_temp().trim();
     
     Date st=utilityHelper.stringToDate(temp_dt);
    
     
     System.out.println("the temp date is:"+temp_dt+"st is:"+st);
     String s1 = temp_dt.substring(0, 2);
     String s2 = temp_dt.substring(8, 10);
     String yr = temp_dt.substring(6, 10);
     String mn = temp_dt.substring(3, 5);
     String mo = utilityHelper.getMonthCode2(mn);
     String pattern = "" + yr + "-" + mn + "-" + s1;
     String ocr = "" + "";
     int ln = ocr.length();
     if (ln == 1) {
         String s3 = s1 + mo + s2 + "00" + ocr;
         System.out.println("Case 1 : " + s3);
         callData.setCall_register(s3);
          }else if (ln == 2) {
         String s3 = s1 + mo + s2 + "0" + ocr;
         System.out.println("Case 2 : " + s3);
         callData.setCall_register(s3);
         }else if (ln == 3) {
         String s3 = s1 + mo + s2 + ocr;
         System.out.println("Case 3 : " + s3);
         callData.setCall_register(s3);
         }
    String regSql =
        "INSERT INTO trn_call_register (ID, SERIAL_NUMBER, ORDER_CODE, ORDER_DATE, REGISTRATION_NUMBER, CUSTOMER_NAME, ITEM, WARRANTY_DATE, AMC_DATE, USER, LOCATION, CONTACT_NUMBER, COMPLAIN_DETAILS, CREATED_BY, CREATED_ON, CALLER_NAME, CALLER_PHONE, CALL_DATE, MAKE, MODEL,CALL_STATUS, ADDRESS) "+
        "VALUES (:dbId, :serial, :oc,:od,:call_number,:customer,:item,:warrenty,:amc,:user,:location,:contact,:complain,:createdBy,now(),:caller,:cphone,:call_date,:mk,:mdl,:status,:add)";
    
    MapSqlParameterSource namedParameters = new MapSqlParameterSource();
    namedParameters.addValue("dbId",idPattern);
    namedParameters.addValue("serial",callData.getSerial());
    namedParameters.addValue("call_date",callData.getCcfr_number());
    namedParameters.addValue("call_number", callData.getCall_register());
    namedParameters.addValue("oc", callData.getOrder_code());
    namedParameters.addValue("od", callData.getOrder_date_temp());
    namedParameters.addValue("warrenty", callData.getEnd_date_oem_warranty());
    namedParameters.addValue("amc", callData.getEnd_date_oem_amc());
    namedParameters.addValue("customer", callData.getCustomer());
    namedParameters.addValue("item", callData.getItem());
    namedParameters.addValue("mk", callData.getItem_make());
    namedParameters.addValue("mdl", callData.getItem_model());
    namedParameters.addValue("user", callData.getUser());
    namedParameters.addValue("location", callData.getLocation());
    namedParameters.addValue("contact", callData.getContact());
    namedParameters.addValue("add", callData.getAddress());
    namedParameters.addValue("complain", callData.getComplain_details());
    namedParameters.addValue("caller", callData.getCaller_name());
    namedParameters.addValue("cphone", callData.getCaller_phone());
    namedParameters.addValue("createdBy", callData.getCreated_by());
    namedParameters.addValue("createdOn", "now()");
    namedParameters.addValue("status", "O");
    
    
    
    KeyHolder keyHolder = new GeneratedKeyHolder(); 
    
    try{
    
    namedParameterJdbcTemplate.update(regSql, namedParameters, keyHolder);
    call_number=callData.getCall_register();
    
    }catch(RuntimeException re)
    {
    	logger.error("Explicitly throwing exception inside Dao:CreateUserRegistration method()",re);
    	call_number="error";
    	throw new SpringCrunchifyException(re);
    	
    	
    }
    System.out.println("call number is:"+call_number);
    return call_number;

  }
  /* For Booking a Call */
  
  /* For Assigning a Call */

  public String assignCall(CallData callData) throws SpringCrunchifyException{
	  
	  logger.debug("Inside assignCall method()");

    String regSql =
        "update trn_call_register set assign='Yes',assigned_to=:at,mgr_instr=:mi,remarks=:rem where registration_number=:rn";
    
    MapSqlParameterSource namedParameters = new MapSqlParameterSource();
    namedParameters.addValue("at", callData.getAssigned_to());
    namedParameters.addValue("mi", callData.getMgr_instr());
    namedParameters.addValue("rem", callData.getAssigned_oem());
    namedParameters.addValue("rn", callData.getCall_register());
    
    KeyHolder keyHolder = new GeneratedKeyHolder(); 
    System.out.println("SQL==> "+regSql);
    
    System.out.println("callData.getAssigned_to()==> "+callData.getAssigned_to());
    System.out.println("callData.getMgr_instr()==> "+callData.getMgr_instr());
    System.out.println("callData.getAssigned_oem()==> "+callData.getAssigned_oem());
    System.out.println("callData.getCall_register()==> "+callData.getCall_register());
    
    try{
    
    namedParameterJdbcTemplate.update(regSql,namedParameters,keyHolder);
    
    }catch(RuntimeException re)
    {
    	logger.error("Explicitly throwing exception inside assignCall method()",re);
    	throw new SpringCrunchifyException(re);
    	
    }
    return null;

  }
  /* For Booking a Call */
  
  
  /* For Closing a Call */

  public String CallClose(CallData callData) throws SpringCrunchifyException{
	  
	  logger.debug("Inside CallClose method()");
   
    
    String regSql="update trn_call_register set ccfr_number=:cn, call_status='C' ,mng_remarks=:mr where registration_number=:cr";
    
    MapSqlParameterSource namedParameters = new MapSqlParameterSource();
    namedParameters.addValue("cn", callData.getCcfr_number());
    namedParameters.addValue("mr", callData.getRemarks());
    namedParameters.addValue("cr", callData.getCall_register());
    
    KeyHolder keyHolder = new GeneratedKeyHolder(); 
    System.out.println("SQL==> "+regSql);
    
    System.out.println("callData.getCcfr_number()==> "+callData.getAssigned_to());
    System.out.println("callData.getRemarks()==> "+callData.getRemarks());
    System.out.println("callData.getCall_register()==> "+callData.getCall_register());
    
    try{
    
    namedParameterJdbcTemplate.update(regSql,namedParameters,keyHolder);
    
    }catch(RuntimeException re)
    {
    	logger.error("Explicitly throwing exception inside CallClose method()",re);
    	throw new SpringCrunchifyException(re);
    	
    }
    return null;

  }
  /* For Closing a Call */

  
  /*User Permission*/
  @Override
  public List<User> fetchPermission(User u) throws SpringCrunchifyException {
	  String username=u.getUid();
	  String appReportsSql ="SELECT m.module_name,t.add_permission FROM tbl_project_module_user_map t join tbl_module_master m on(m.module_id=t.module_id) where user_id = '"+username+"' and t.project_id=2";
	System.out.println(appReportsSql);
	  try{
	  return namedParameterJdbcTemplate.query(appReportsSql,new ResultSetExtractor<List<User>>(){  
	        @Override  
	        public List<User> extractData(ResultSet rs) throws SQLException,  
	               DataAccessException {       
	        	List<User> listUser=new ArrayList<User>(); 
	           
	           while(rs.next()){  	        	   
	        	  User c = new User();
	        		 c.setModulenm(rs.getString(1));
	        		 c.setAddper(rs.getString(2));
	        		 listUser.add(c);
	        		 
	         
	           }  
	           return listUser;  
	           }  
	       });  
	    
	    
	  }catch(RuntimeException re)
	      {
		  logger.error("Error in  User Permission.. " + this.getClass(), re);    	
		    throw new SpringCrunchifyException(re);
		  }
	    finally{
	        logger.debug("Exit from reports:");
	        }
	  }
  
  /*User Permission*/
  
  /* fetchEngDashboard */
  @Override
  public List<CallData> fetchEngDashboard(CallData callData) throws SpringCrunchifyException {
	  String user_type=callData.getUser_type();
	  System.out.println("USERTYPE==> " + user_type);
	  String appReportsSql ="";
	 
	              if(user_type.equalsIgnoreCase("MG")){
	            	  appReportsSql = "select r.registration_number,ifnull(concat(trim(e.employee_initial),' ',trim(e.employee_first_name),' ',ifnull(trim(e.employee_middle_name),''),' '," 		
	            			  + "trim(e.employee_last_name)),'**Not Assigned**') as assigned_to,r.serial_number,r.customer_name,r.item,r.call_date,r.order_code,r.order_date,r.complain_details from trn_call_register r left join tbl_master_employee e on(e.id=r.assigned_to) "
	            			  + "where call_status='O' and (r.created_by in(select user_id from tbl_login_master where parent_user='"+callData.getUser_name()+"') or r.created_by='"+callData.getUser_name()+"') "
	            			  		+ " and assign is not null order by r.id desc"; 
	              }
	              if(user_type.equalsIgnoreCase("US")){
	            	  appReportsSql = "select r.registration_number,ifnull(concat(trim(e.employee_initial),' ',trim(e.employee_first_name),' ',ifnull(trim(e.employee_middle_name),''),' ',"
	        			+ "trim(e.employee_last_name)),'**Not Assigned**') as assigned_to,r.serial_number,r.customer_name,r.item,r.call_date,r.order_code,r.order_date,r.complain_details from trn_call_register r left join tbl_master_employee e on(e.id=r.assigned_to) "
	        			+ "where r.call_status='O' and r.created_by='"+callData.getUser_name()+"' and assign is not null order by r.id desc ";
	             }
	 
	System.out.println("SQL==> " + appReportsSql);
	  try{
	  return namedParameterJdbcTemplate.query(appReportsSql,new ResultSetExtractor<List<CallData>>(){  
	        @Override  
	        public List<CallData> extractData(ResultSet rs) throws SQLException,  
	               DataAccessException {       
	        	List<CallData> listUser=new ArrayList<CallData>(); 
	           
	           while(rs.next()){  	        	   
	        	   CallData c = new CallData();
	        		 c.setCall_register(rs.getString(1));
	        		 c.setAssigned_to(rs.getString(2));
	        		 c.setSerial(rs.getString(3));
	        		 c.setCustomer(rs.getString(4));
	        		 c.setItem(rs.getString(5));
	        		 c.setCall_date_temp(rs.getString(6));
	        		 c.setOrder_code(rs.getString(7));
	        		 c.setOrder_date_temp(rs.getString(8));
	        		 c.setComplain_details(rs.getString(9));
	        		 listUser.add(c);	        		 
	         
	           }  
	           return listUser;  
	           }  
	       });  
	    
	    
	  }catch(RuntimeException re)
	      {
		  logger.error("Error in  User Permission.. " + this.getClass(), re);    	
		    throw new SpringCrunchifyException(re);
		  }
	    finally{
	        logger.debug("Exit from reports:");
	        }
	  }
  
  
  /* fetchEngDashboard */
  
  /*Call Assignment*/
  @Override
  public List<CallData> fetchAssignment(CallData callData) throws SpringCrunchifyException {
	  String user_type=callData.getUser_type();
	  System.out.println("USERTYPE==> " + user_type);
	  String appReportsSql ="";
	  if (user_type.equalsIgnoreCase("AD") || user_type.equalsIgnoreCase("SU")) {
	        appReportsSql = "select r.registration_number,ifnull(concat(trim(e.employee_initial),' ',trim(e.employee_first_name),' ',ifnull(trim(e.employee_middle_name),''),' ',"
	        			+ "trim(e.employee_last_name)),'**Not Assigned**') as assigned_to,r.serial_number,r.customer_name,r.item,r.call_date,r.order_code,r.order_date,r.complain_details from trn_call_register r left join tbl_master_employee e on(e.id=r.assigned_to) where call_status='O' order by r.id desc"; 
	              }
	              else if(user_type.equalsIgnoreCase("MG")){
	            	  appReportsSql = "select r.registration_number,ifnull(concat(trim(e.employee_initial),' ',trim(e.employee_first_name),' ',ifnull(trim(e.employee_middle_name),''),' '," 		
	            			  + "trim(e.employee_last_name)),'**Not Assigned**') as assigned_to,r.serial_number,r.customer_name,r.item,r.call_date,r.order_code,r.order_date,r.complain_details from trn_call_register r left join tbl_master_employee e on(e.id=r.assigned_to) "
	            			  + "where call_status='O' and (r.created_by in(select user_id from tbl_login_master where parent_user='"+callData.getUser_name()+"') or r.created_by='"+callData.getUser_name()+"') "
	            			  		+ "order by r.id desc"; 
	              }
	              else if(user_type.equalsIgnoreCase("US")){
	            	  appReportsSql = "select r.registration_number,ifnull(concat(trim(e.employee_initial),' ',trim(e.employee_first_name),' ',ifnull(trim(e.employee_middle_name),''),' ',"
	        			+ "trim(e.employee_last_name)),'**Not Assigned**') as assigned_to,r.serial_number,r.customer_name,r.item,r.call_date,r.order_code,r.order_date,r.complain_details from trn_call_register r left join tbl_master_employee e on(e.id=r.assigned_to) "
	        			+ "where r.call_status='O' and r.created_by='"+callData.getUser_name()+"' order by r.id desc ";
	             }
	 
	System.out.println("SQL==> " + appReportsSql);
	  try{
	  return namedParameterJdbcTemplate.query(appReportsSql,new ResultSetExtractor<List<CallData>>(){  
	        @Override  
	        public List<CallData> extractData(ResultSet rs) throws SQLException,  
	               DataAccessException {       
	        	List<CallData> listUser=new ArrayList<CallData>(); 
	           
	           while(rs.next()){  	        	   
	        	   CallData c = new CallData();
	        		 c.setCall_register(rs.getString(1));
	        		 c.setAssigned_to(rs.getString(2));
	        		 c.setSerial(rs.getString(3));
	        		 c.setCustomer(rs.getString(4));
	        		 c.setItem(rs.getString(5));
	        		 c.setCall_date_temp(rs.getString(6));
	        		 c.setOrder_code(rs.getString(7));
	        		 c.setOrder_date_temp(rs.getString(8));
	        		 c.setComplain_details(rs.getString(9));
	        		 listUser.add(c);	        		 
	         
	           }  
	           return listUser;  
	           }  
	       });  
	    
	    
	  }catch(RuntimeException re)
	      {
		  logger.error("Error in  User Permission.. " + this.getClass(), re);    	
		    throw new SpringCrunchifyException(re);
		  }
	    finally{
	        logger.debug("Exit from reports:");
	        }
	  }
  
  /*Call Assignment*/
  
  /*Call Register*/
  @Override
  public List<CallData> fetchRegister(CallData callData) throws SpringCrunchifyException {
	  String serailVal=callData.getSerial();
	  System.out.println("SERIAL==> " + serailVal);
	  String appReportsSql ="select serial_number from trn_installation_serial where serial_number like '%"+serailVal+"%' and active='Y'";
	  
	 
	System.out.println("SQL==> " + appReportsSql);
	  try{
	  return namedParameterJdbcTemplate.query(appReportsSql,new ResultSetExtractor<List<CallData>>(){  
	        @Override  
	        public List<CallData> extractData(ResultSet rs) throws SQLException,  
	               DataAccessException {       
	        	List<CallData> listUser=new ArrayList<CallData>(); 
	           
	           while(rs.next()){  	        	   
	        	   CallData c = new CallData();
	        		 c.setSerial(rs.getString(1));	        		 
	        		 listUser.add(c);
	        		 
	         
	           }  
	           return listUser;  
	           }  
	       });  
	    
	    
	  }catch(RuntimeException re)
	      {
		  logger.error("Error in  fetch register.. " + this.getClass(), re);    	
		    throw new SpringCrunchifyException(re);
		  }
	    finally{
	        logger.debug("Exit from reports:");
	        }
	  }
  
  /*Call Register*/
  
  /* getRemainingCallNo */
  @Override
  public List<CallData> getRemainingCallNo(CallData callData) throws SpringCrunchifyException {
	  String type=callData.getUser_type();
	  System.out.println("User Type==> " + type);
	  String appReportsSql="";
      if(type.equals("SU") || type.equals("AD"))
      {
    	  appReportsSql="SELECT registration_number,user_name FROM trn_call_register a right join tbl_login_master b on(a.assigned_to=b.employee_id) where call_status='O' and assigned_to is not null order by 1";
      }
      else if(type.equals("MG"))
      {
    	  appReportsSql="SELECT registration_number,user_name FROM trn_call_register a right join tbl_login_master b on(a.assigned_to=b.employee_id) where b.user_id='"+callData.getUser()+"' and call_status='O' union SELECT registration_number,user_name FROM trn_call_register a right join tbl_login_master b on(a.assigned_to=b.employee_id) where b.parent_user='"+callData.getUser()+"' and call_status='O'";
      }
      else{
    	  appReportsSql="SELECT registration_number,user_name FROM trn_call_register a right join tbl_login_master b on(a.assigned_to=b.employee_id) where b.user_id='"+callData.getUser()+"' and call_status='O'";
      }
	  
	 
	System.out.println("SQL==> " + appReportsSql);
	  try{
	  return namedParameterJdbcTemplate.query(appReportsSql,new ResultSetExtractor<List<CallData>>(){  
	        @Override  
	        public List<CallData> extractData(ResultSet rs) throws SQLException,  
	               DataAccessException {       
	        	List<CallData> listUser=new ArrayList<CallData>(); 
	           
	           while(rs.next()){  	        	   
	        	   CallData c = new CallData();
	        		 c.setCall_register(rs.getString(1));	 
	        		 c.setUser_name(rs.getString(2));
	        		 listUser.add(c);
	        		 
	         
	           }  
	           return listUser;  
	           }  
	       });  
	    
	    
	  }catch(RuntimeException re)
	      {
		  logger.error("Error in  fetch register.. " + this.getClass(), re);    	
		    throw new SpringCrunchifyException(re);
		  }
	    finally{
	        logger.debug("Exit from reports:");
	        }
	  }
  
  /* getRemainingCallNo */
  
  /* getRemainingCallDetail */
  @Override
  public List<CallData> getRemainingCallDetail(CallData callData) throws SpringCrunchifyException {	  
	  String appReportsSql="";
     appReportsSql="select a.call_date,a.customer_name,a.user,a.location,a.contact_number,a.complain_details,a.remarks,a.serial_number,a.model from trn_call_register a where a.registration_number='"+callData.getCall_register()+"'";
	  
	 
	System.out.println("SQL==> " + appReportsSql);
	  try{
	  return namedParameterJdbcTemplate.query(appReportsSql,new ResultSetExtractor<List<CallData>>(){  
	        @Override  
	        public List<CallData> extractData(ResultSet rs) throws SQLException,  
	               DataAccessException {       
	        	List<CallData> listUser=new ArrayList<CallData>(); 
	           
	           while(rs.next()){  	        	   
	        	   CallData c = new CallData();
	        		 c.setCall_date(rs.getDate(1));	 
	        		 c.setCustomer(rs.getString(2));
	        		 c.setUser(rs.getString(3));
	        		 c.setLocation(rs.getString(4));
	        		 c.setContact(rs.getString(5));
	        		 c.setComplain_details(rs.getString(6));
	        		 c.setRemarks(rs.getString(7));
	        		 c.setSerial(rs.getString(8));
	        		 c.setModel(rs.getString(9));
	        		 listUser.add(c);
	        		 
	         
	           }  
	           return listUser;  
	           }  
	       });  
	    
	    
	  }catch(RuntimeException re)
	      {
		  logger.error("Error in  fetch register.. " + this.getClass(), re);    	
		    throw new SpringCrunchifyException(re);
		  }
	    finally{
	        logger.debug("Exit from reports:");
	        }
	  }
  
  /* getRemainingCallDetail */
  
  /*Fetch Assigned To*/
  @Override
  public List<CallData> fetchAssignedTo(CallData callData) throws SpringCrunchifyException {
	  String user_type=callData.getUser_type();
	  String uid=callData.getUser();
	  System.out.println("USERTYPE==> " + user_type);
	  String qry="";
	  if(user_type.equals("AD") || user_type.equals("SU"))
      {
          qry="select ID,CONCAT(EMPLOYEE_FIRST_NAME,' ',EMPLOYEE_LAST_NAME ) from tbl_master_employee where ACTIVE='Y' AND employee_designation in(263,25,39,43,46,260,45,28,30,27,31,34,29,40,285,284,282,36) ORDER BY 2";
      }
      else{
      qry = "select ID,CONCAT(EMPLOYEE_FIRST_NAME,' ',EMPLOYEE_LAST_NAME ) from tbl_master_employee a left join tbl_login_master b on(a.id=b.employee_id) where a.ACTIVE='Y' AND a.employee_designation"
+" in(263,25,39,43,46,260,45,28,30,27,31,34,29,40,285,284,282,36) and b.parent_user='"+uid+"' union select ID,CONCAT(EMPLOYEE_FIRST_NAME,' ',EMPLOYEE_LAST_NAME ) from"
+" tbl_master_employee a left join tbl_login_master b on(a.id=b.employee_id) where a.ACTIVE='Y' AND a.employee_designation"
+" in(263,25,39,43,46,260,45,28,30,27,31,34,29,40,285,284,282,36) and b.parent_user in(select p.user_id from tbl_login_master p where p.parent_user='"+uid+"') union"
+" select ID,CONCAT(EMPLOYEE_FIRST_NAME,' ',EMPLOYEE_LAST_NAME ) from tbl_master_employee a left join tbl_login_master b on(a.id=b.employee_id) where a.ACTIVE='Y' AND a.employee_designation"
+" in(263,25,39,43,46,260,45,28,30,27,31,34,29,40,285,284,282,36) and b.user_id='"+uid+"' order by 2";
      }
	  
	 
	System.out.println("SQL==> " + qry);
	  try{
	  return namedParameterJdbcTemplate.query(qry,new ResultSetExtractor<List<CallData>>(){  
	        @Override  
	        public List<CallData> extractData(ResultSet rs) throws SQLException,  
	               DataAccessException {       
	        	List<CallData> listUser=new ArrayList<CallData>(); 
	        	CallData ob=new CallData();
	        	ob.setDbId(0);
	        	ob.setAssigned_to("--Select An Engineer--");
	        	listUser.add(ob);
	           
	           while(rs.next()){  	        	   
	        	   CallData c = new CallData();
	        	     c.setDbId(rs.getInt(1));
	        		 c.setAssigned_to(rs.getString(2));	        		 
	        		 listUser.add(c);
	        		 
	         
	           }  
	           return listUser;  
	           }  
	       });  
	    
	    
	  }catch(RuntimeException re)
	      {
		  logger.error("Error in  fetchAssignedTo.. " + this.getClass(), re);    	
		    throw new SpringCrunchifyException(re);
		  }
	    finally{
	        logger.debug("Exit from fetchAssignedTo:");
	        }
	  }
  
  /*Fetch Assigned To*/
  
  /*Fetch Assigned OEM*/
  @Override
  public List<CallData> fetchAssignedOEM() throws SpringCrunchifyException {

    String qry="SELECT OEM_CODE FROM TBL_MASTER_CUSTOMER WHERE TYPE='OEM' AND ACTIVE='Y' ORDER BY 1";	  
	 
	System.out.println("SQL==> " + qry);
	  try{
	  return namedParameterJdbcTemplate.query(qry,new ResultSetExtractor<List<CallData>>(){  
	        @Override  
	        public List<CallData> extractData(ResultSet rs) throws SQLException,  
	               DataAccessException {       
	        	List<CallData> listUser=new ArrayList<CallData>(); 
	           
	           while(rs.next()){  	        	   
	        	   CallData c = new CallData();
	        		 c.setAssigned_oem(rs.getString(1));	        		 
	        		 listUser.add(c);
	        		 
	         
	           }  
	           return listUser;  
	           }  
	       });  
	    
	    
	  }catch(RuntimeException re)
	      {
		  logger.error("Error in  fetchAssignedTo.. " + this.getClass(), re);    	
		    throw new SpringCrunchifyException(re);
		  }
	    finally{
	        logger.debug("Exit from fetchAssignedTo:");
	        }
	  }
  
  /*Fetch Assigned To*/
  
  /*checkSerialStatus*/
  @Override
  public CallData checkSerialStatus(CallData callData) throws SpringCrunchifyException {
	  String serailVal=callData.getSerial();
	  String qry="SELECT COUNT(*) FROM TRN_CALL_REGISTER WHERE SERIAL_NUMBER='" + serailVal + "' AND CALL_STATUS <> 'C'";
	  System.out.println("SERIAL==> " + serailVal);
	 
	 
	System.out.println("SQL==> " + qry);
	  try{
	  return namedParameterJdbcTemplate.query(qry,new ResultSetExtractor<CallData>(){  
	        @Override  
	        public CallData extractData(ResultSet rs) throws SQLException,  
	               DataAccessException {       
	        	List<CallData> listUser=new ArrayList<CallData>(); 
	        	CallData callData = new CallData();
	           
	           while(rs.next()){  	        	   
	        	   CallData c = new CallData();
	        		c.setCount(rs.getInt(1));
	        		 callData=c;
	        		 
	         
	           }  
	           return callData;  
	           }  
	       });  
	    
	    
	  }catch(RuntimeException re)
	      {
		  logger.error("Error in  fetch register detail.. " + this.getClass(), re);    	
		    throw new SpringCrunchifyException(re);
		  }
	    finally{
	        logger.debug("Exit from reports:");
	        }
	  }
  
  /*checkSerialStatus*/
  
  
  /*callClosureView*/
  @Override
  public List<CallData> callClosureView(CallData callData) throws SpringCrunchifyException {
	  String user_type=callData.getUser_type();
	  String uid=callData.getUser();
	  System.out.println("USERTYPE==> " + user_type);
	  String qry="";
	  if(user_type.equals("AD") || user_type.equals("SU")){
	  qry="select a.registration_number,b.customer_name,a.order_code,a.created_by,concat(employee_first_name,' ',employee_middle_name,' ',employee_last_name) assigned_to,"
	  		+ "a.complain_details,a.serial_number,a.item,group_concat(b.ccfr_number SEPARATOR ',') ccfr,b.remarks from trn_call_register a left join "
	  		+ "tbl_master_ccfr b on(a.registration_number=b.call_number) left join tbl_master_employee c on(a.assigned_to=c.id) where a.call_status='P' "
	  		+ "group by a.registration_number";	 
	  }
	  if(user_type.equals("MG")){
		  qry="select a.registration_number,b.customer_name,a.order_code,a.created_by,concat(employee_first_name,' ',employee_middle_name,' ',employee_last_name) assigned_to,"
		  		+ "a.complain_details,a.serial_number,a.item,group_concat(b.ccfr_number SEPARATOR ',') ccfr,b.remarks from trn_call_register a left join tbl_master_ccfr b "
		  		+ "on(a.registration_number=b.call_number) left join tbl_master_employee c on(a.assigned_to=c.id) where a.call_status='P' and (a.created_by in "
		  		+ "(select user_id from tbl_login_master where parent_user='amars') or a.created_by='"+uid+"') group by a.registration_number";
	  }
	  if(user_type.equals("US")){
		  qry="select a.registration_number,b.customer_name,a.order_code,a.created_by,concat(employee_first_name,' ',employee_middle_name,' ',employee_last_name) assigned_to,"
		  		+ "a.complain_details,a.serial_number,a.item,group_concat(b.ccfr_number SEPARATOR ',') ccfr,b.remarks from trn_call_register a left join tbl_master_ccfr b "
		  		+ "on(a.registration_number=b.call_number) left join tbl_master_employee c on(a.assigned_to=c.id) where a.call_status='P' and a.created_by='"+uid+"' "
		  		+ "group by a.registration_number";
	  }
	  
	 
	System.out.println("SQL==> " + qry);
	  try{
	  return namedParameterJdbcTemplate.query(qry,new ResultSetExtractor<List<CallData>>(){  
	        @Override  
	        public List<CallData> extractData(ResultSet rs) throws SQLException,  
	               DataAccessException {       
	        	List<CallData> listUser=new ArrayList<CallData>(); 
	        	CallData callData = new CallData();
	           
	           while(rs.next()){  	        	   
	        	   CallData c = new CallData();
	        	     c.setCall_register(rs.getString(1));	
	        		 c.setCustomer(rs.getString(2));	
	        		 c.setOrder_code(rs.getString(3));	
	        		 c.setCreated_by(rs.getString(4));	
	        		 c.setAssigned_to(rs.getString(5));	
	        		 c.setComplain_details(rs.getString(6));	
	        		 c.setSerial(rs.getString(7));	
	        		 c.setItem(rs.getString(8));	
	        		 c.setCcfr_number(rs.getString(9));	
	        		 c.setRemarks(rs.getString(10));	
	        		 listUser.add(c);
	           }  
	           return listUser;  
	           }  
	       });  
	    
	    
	  }catch(RuntimeException re)
	      {
		  logger.error("Error in  Call Closure View.. " + this.getClass(), re);    	
		    throw new SpringCrunchifyException(re);
		  }
	    finally{
	        logger.debug("Exit from reports:");
	        }
	  }
  
  /*callClosureView*/
  
  
  
  
  /*Call Register*/
  @Override
  public List<CallData> fetchRegisterDetail(CallData callData) throws SpringCrunchifyException {
	  String serailVal=callData.getSerial();	 
	  System.out.println("SERIAL==> " + serailVal);
	  String appReportsSql ="select a.order_code,b.ord_date,CONCAT(d.ITEM_CATEGORY,' | ',d.ITEM_SUBCATEGORY),DATE_FORMAT(d.END_DATE_COMPANY_WARRANTY, '%Y-%m-%d') warrenty,"
	  		+ "DATE_FORMAT(d.END_DATE_COMPANTY_AMC, '%Y-%m-%d') project,c.make,c.model,a.end_user_name,a.location_name,a.contact_number,a.address,e.cust_name from trn_installation_serial a "
	  		+ "left join trn_order_code b on(a.order_code=b.project_id and b.is_delete=1) left join trn_order_detail c on(a.transaction_id=c.id) left join trn_installation_detail d on(a.detail_id=d.id) left join trn_order_header e on(a.order_code=e.ord_code and e.active='Y' and e.is_delete) "
	  		+ "where serial_number='"+serailVal+"'";
	  
	 
	System.out.println("SQL==> " + appReportsSql);
	  try{
	  return namedParameterJdbcTemplate.query(appReportsSql,new ResultSetExtractor<List<CallData>>(){  
	        @Override  
	        public List<CallData> extractData(ResultSet rs) throws SQLException,  
	               DataAccessException {       
	        	List<CallData> listUser=new ArrayList<CallData>(); 
	           
	           while(rs.next()){  	        	   
	        	   CallData c = new CallData();
	        		 c.setOrder_code(rs.getString(1));	
	        		 c.setOrder_date_temp(rs.getString(2));	 
	        		 c.setItem(rs.getString(3));	 
	        		 c.setWarranty_temp(rs.getString(4));	 
	        		 c.setEnd_date_oem_warranty(rs.getString(5));	 
	        		 c.setMake(rs.getString(6));	 
	        		 c.setModel(rs.getString(7));
	        		 c.setUser(rs.getString(8));	 
	        		 c.setLocation(rs.getString(9));	 
	        		 c.setContact(rs.getString(10));	 
	        		 c.setAddress(rs.getString(11));	
	        		 c.setCustomer(rs.getString(12));	
	        		 listUser.add(c);
	        		 
	         
	           }  
	           return listUser;  
	           }  
	       });  
	    
	    
	  }catch(RuntimeException re)
	      {
		  logger.error("Error in  fetch register detail.. " + this.getClass(), re);    	
		    throw new SpringCrunchifyException(re);
		  }
	    finally{
	        logger.debug("Exit from reports:");
	        }
	  }
  
  /*Call Register*/
  
  
  @Override
  public List<VtplCustomers> appDtlReport(VtplReports v) throws SpringCrunchifyException {
	  String cname=v.getCustName();
	  String appReportsSql ="select count(a.registration_number) cnt,a.customer_name,ifnull(concat(b.employee_first_name,' ',b.employee_last_name),'-::Not Assigned::-') eng_name from trn_call_register a left join tbl_master_employee b on(a.assigned_to=b.id) where a.call_status in('O') and a.customer_name='"+cname+"' group by 2,3";
	System.out.println(appReportsSql);
	  try{
	  return namedParameterJdbcTemplate.query(appReportsSql,new ResultSetExtractor<List<VtplCustomers>>(){  
	        @Override  
	        public List<VtplCustomers> extractData(ResultSet rs) throws SQLException,  
	               DataAccessException {        
	        //	List<VtplReports> list=new ArrayList<VtplReports>(); 
	        	List<VtplCustomers> listc=new ArrayList<VtplCustomers>(); 
	           
	           while(rs.next()){  
	        	   System.out.println("while(f)-->>> "+f);
	        	   VtplReports v=new VtplReports(); 
	        	   VtplCustomers c=new VtplCustomers();
	        	
	        	
	        	        		 
	        		 c.setTotCall(rs.getInt(1));
	        		 c.setCustName(rs.getString(2));
	        		 c.setEngName(rs.getString(3));
	        		 //listc.add(c);        		 
	        		//v.setList1(listc);
	        		 listc.add(c);
	        		 
	         
	           }  
	           return listc;  
	           }  
	       });  
	    
	    
	  }catch(RuntimeException re)
	      {
		  logger.error("Error in  reports " + this.getClass(), re);    	
		    throw new SpringCrunchifyException(re);
		  }
	    finally{
	        logger.debug("Exit from reports:");
	        }
	  }

  

  @Override
  public List<VtplReports> appReports(VtplReports vtplReports) throws SpringCrunchifyException {
	  String appReportsSql ="";
	  int flag = vtplReports.getFlag();
	  String cname=vtplReports.getCustName();
	  logger.debug("Inside appReportsDao() method:");
	if(flag==1)
	{
		 appReportsSql = "select substr(a.project_id,1,5) fin_year,count(distinct a.project_id) no_of_ordrs,ifnull(sum(c.amount),'0.00') tot_amount from trn_order_code a left join trn_order_header b on(a.project_id=b.ord_code) left join trn_order_detail c "
		 		+ "on(b.ord_code=c.order_code_header) where a.is_delete=1 and b.is_delete=1 and a.ord_tag in('N','C') and b.active in('Y','C') group by substr(a.project_id,1,5) order by substr(a.project_id,1,5) desc";
	
			
	}
	if(flag==2)
	{
		//item wise order
		appReportsSql ="select concat(b.category_name,'-',c.sub_category_name) items,a.make,a.model,count(*) as tot_order from trn_order_detail a left join tbl_master_category b on(a.cat_id=b.id)"
				+ " left join tbl_master_subcategory c on(a.subcategory_id=c.id and a.cat_id=c.category_id)"
                +   " where order_date_header between '"+vtplReports.getFromDt()+"' and '"+vtplReports.getToDt()+"' group by a.item_id order by tot_order desc";
	}
	if(flag==3)
	{
		// eng wise call
		appReportsSql ="SELECT X.ENGINEER_NAME,COUNT(X.REGISTRATION_NUMBER) TOTAL_CALLS,COUNT(X.OPEN_CALLS) OPEN_CALLS,COUNT(X.CLOSED_CALLS) CLOSED_CALLS"
                       + " FROM (SELECT CONCAT(B.EMPLOYEE_FIRST_NAME,' ',B.EMPLOYEE_MIDDLE_NAME,' ',B.EMPLOYEE_LAST_NAME) ENGINEER_NAME,REGISTRATION_NUMBER,"
                       +   " CASE WHEN CALL_STATUS = 'O' THEN CALL_STATUS END OPEN_CALLS,CASE WHEN CALL_STATUS = 'C' THEN CALL_STATUS END CLOSED_CALLS"
                       + " FROM TRN_CALL_REGISTER A LEFT OUTER JOIN TBL_MASTER_EMPLOYEE B ON A.ASSIGNED_TO = B.ID WHERE A.CALL_DATE BETWEEN '"+vtplReports.getFromDt()+"' AND '"+vtplReports.getToDt()+"') X"
                       +" WHERE X.ENGINEER_NAME IS NOT NULL AND X.ENGINEER_NAME LIKE '" + vtplReports.getEngName() + "%' GROUP BY X.ENGINEER_NAME";
	}
	if(flag==4)
	{
		 // Repeated call
		appReportsSql ="select serial_number,item,CUSTOMER_NAME,USER,count(serial_number) no_of_calls FROM trn_call_register A where A.CUSTOMER_NAME like '"+vtplReports.getCustName() + "%' AND "
				+ "call_date between '"+vtplReports.getFromDt()+"' and '"+vtplReports.getToDt()+"' group by serial_number having count(serial_number) >='"+vtplReports.getSrlNo()+"' order by 5 desc";
	}
//	if(flag==5)
//	{
//		// pending call
//		appReportsSql ="SELECT A.REGISTRATION_NUMBER,A.LOCATION,A.COMPLAIN_DETAILS,B.END_DATE2,B.REMARKS,B.CCFR_NUMBER,A.CALL_DATE, "
//				+ "if(a.call_status='O','OPEN','PENDING'),B.UNIT_FAILED,datediff(now(),a.call_date) period,"
//				+ "(SELECT CONCAT(EMPLOYEE_INITIAL, ' ',EMPLOYEE_FIRST_NAME, ' ',EMPLOYEE_MIDDLE_NAME, ' ',EMPLOYEE_LAST_NAME) FROM TBL_MASTER_EMPLOYEE"
//				+ " WHERE ID = A.ASSIGNED_TO) ENGINEER_NAME FROM TRN_CALL_REGISTER A LEFT OUTER JOIN TBL_MASTER_CCFR B ON A.REGISTRATION_NUMBER = B.CALL_NUMBER"
//				+ " WHERE A.CALL_DATE BETWEEN '"+vtplReports.getFromDt()+"' and '"+vtplReports.getToDt()+"' AND A.CUSTOMER_NAME like '" + vtplReports.getCustName() + "%' AND "
//						+ "A.CALL_STATUS IN('P','O') ORDER BY CALL_DATE DESC, CALL_NUMBER ASC";
//
//	}
	if(flag==6)
	{
		appReportsSql ="";
	}
	if(flag==7)
	{
		appReportsSql ="select item,make,model,count(*) as cnt,(select sum(order_quantity) sum_ord_qty from trn_installation_detail where a.item=concat(item_category,' | ',item_subcategory) and item_make=a.make and "
				+ "item_model=a.model group by item_make,item_model) as order_qty from trn_call_register a where ITEM NOT IN('') AND "
				+ "call_date between '"+vtplReports.getFromDt()+"' and '"+vtplReports.getToDt()+"' group by a.item,a.make,a.model order by cnt desc,a.item,a.make";
	}
	if(flag==5)
	{
		appReportsSql ="select customer_name,concat(customer_name, ' has number of call:- ',count(registration_number)) val from trn_call_register where call_status in('O') group by customer_name order by 1 desc" ;

	}
	if(flag==8)
	{
		appReportsSql ="SELECT (SELECT CUSTOMER_NAME FROM tbl_master_customer WHERE ID = B.CUSTOMER_ID) CUST_NAME, A.ORDER_CODE, A.END_DATE_COMPANTY_AMC AS PROJECT_END_DATE,B.CUSTOMER_ID FROM trn_installation_detail A LEFT JOIN trn_installation_header B"
				+ " ON A.HEADER_ID = B.ID WHERE A.END_DATE_COMPANTY_AMC BETWEEN now() AND date_add(now(),INTERVAL 90 DAY) group by a.order_code ORDER BY 3";
	}
	
	if(flag==10)
	{
		appReportsSql ="select a.account,concat(d.employee_first_name,' ',d.employee_last_name) name,count(a.project_id) tot_order,sum(c.amount) amt from trn_order_code a left join trn_order_header b on(a.project_id=b.ord_code)"
				+ " left join trn_order_detail c on(b.ord_code=c.order_code_header) left join tbl_master_employee d on(a.account=d.id) where a.is_delete=1 and b.is_delete=1 and c.is_delete=1 and a.ord_tag in('N','C')"
				+ " and b.active in('Y','C') and substr(a.project_id,1,5)='17-18' group by  a.account order by 4 desc";
	}
   
   System.out.println("QRY--  "+appReportsSql);
   // Map<String, Integer> paramMap = new HashMap<String, Integer>();
  // List<VtplReports> list=null;
    try{
    f=flag;	
    System.out.println("f-->>> "+f);
    return namedParameterJdbcTemplate.query(appReportsSql,new ResultSetExtractor<List<VtplReports>>(){  
        @Override  
        public List<VtplReports> extractData(ResultSet rs) throws SQLException,  
               DataAccessException {        
        	List<VtplReports> list=new ArrayList<VtplReports>(); 
        	List<VtplCustomers> listc=new ArrayList<VtplCustomers>(); 
           
           while(rs.next()){  
        	   System.out.println("while(f)-->>> "+f);
        	   VtplReports v=new VtplReports(); 
        	   VtplCustomers c=new VtplCustomers();
        	
        	 if(f==1)
        	 {        		  
                   v.setFinyear(rs.getString(1));
                   v.setNo_of_ord(rs.getInt(2));
                   v.setTot_amt(rs.getInt(3));                  
                  
        		 //daily order report//
        	 }
        	 if(f==2)
        	 {
        		 v.setItem(rs.getString("items"));
        		 v.setMake(rs.getString("make"));
        		 v.setModel(rs.getString("model"));
        		 v.setTotOrder(rs.getInt("tot_order"));        		
        	 }
        	 if(f==3)
        	 {        		 
        		 v.setEngName(rs.getString("ENGINEER_NAME"));
        		 v.setTotCall(rs.getInt("TOTAL_CALLS"));
        		 v.setOpenCall(rs.getInt("OPEN_CALLS"));
        		 v.setClosedCall(rs.getInt("CLOSED_CALLS"));
        	 }
        	 if(f==4)
        	 {
        		 v.setSrlnumber(rs.getString("serial_number"));
        		 v.setItem(rs.getString("item"));
        		 v.setCustName(rs.getString("CUSTOMER_NAME"));
        		 v.setUsername(rs.getString("USER"));
        		 v.setTotCall(rs.getInt("no_of_calls"));
        		 
        	 }
        	 if(f==5)
        	 {
        		 v.setProbdesc(rs.getString(2));
        		 v.setCustName(rs.getString(1));
        		
        		 
        	 }
        	 if(f==6)
        	 {
        		//weekly call status//
        		 
        	 }
        	 if(f==7)
        	 {
        		 v.setItem(rs.getString(1));
        		 v.setMake(rs.getString(2));
        		 v.setModel(rs.getString(3));
        		 v.setTotCall(rs.getInt(4));
        		 v.setTotInstall(rs.getInt(5));        		 
        	 }
        	 if(f==8)
        	 {
        		 
        		 v.setCustName(rs.getString(1));
        		 v.setOrdCode(rs.getString(2));
        		 v.setOrder_date(rs.getString(3));        		
        		 
        	 }          
        	 if(f==10)
        	 {
        		 
        		 v.setCustName(rs.getString(2));
        		 v.setTotOrder(rs.getInt(3));
        		 v.setTotamount(rs.getDouble(4));        		
        		 
        	 }          
           list.add(v); 
           }  
           return list;  
           }  
       });  
    
    
  }catch(RuntimeException re)
      {
	  logger.error("Error in  reports " + this.getClass(), re);    	
	    throw new SpringCrunchifyException(re);
	  }
    finally{
        logger.debug("Exit from reports:");
        }
  }

@Override
public void CreateUserRegitration(User user) throws SpringCrunchifyException {
	// TODO Auto-generated method stub
	
}

//@Override
//public List<VtplReports> appDropDownListReports(String status) throws SpringCrunchifyException {
//	System.out.println("STATUS: "+ status);
//	  String dropDownSql = "";
//	if(status.equals("ewcall"))
//	{
//		dropDownSql = "select ID,CONCAT(EMPLOYEE_FIRST_NAME,' ',EMPLOYEE_MIDDLE_NAME,' ',EMPLOYEE_LAST_NAME ) from tbl_master_employee where ACTIVE='Y'"
//  		+ " AND employee_designation in(263,25,39,43,46,260,45,28,30,27,31,34,29,40,285,284,282) ORDER BY 2";
//	}
//	else if(status.equals("pencall") || status.equals("repcall"))
//	{
//		dropDownSql = "select id,customer_name FROM tbl_master_customer";
//	}
//	System.out.println("SQL==> "+dropDownSql);
//  
//  try{
//
//  return namedParameterJdbcTemplate.query(dropDownSql,new ResultSetExtractor<List<VtplReports>>(){  
//      @Override  
//      public List<VtplReports> extractData(ResultSet rs) throws SQLException,  
//             DataAccessException {  
//       
//         List<VtplReports> list=new ArrayList<VtplReports>();  
//         while(rs.next()){  
//        	 VtplReports e=new VtplReports(); 
//        	 e.setId(rs.getInt(1));
//        	 e.setCustName(rs.getString(2));
//        	 list.add(e);  
//         }  
//         return list;  
//         }  
//     });  
//  
//  
//}catch(RuntimeException re)
//    {
//	  logger.error("Error in  user login " + this.getClass(), re);    	
//	    throw new SpringCrunchifyException(re);
//	  }
//  finally{
//      logger.debug("Exit from login:");
//      }
//}


}
