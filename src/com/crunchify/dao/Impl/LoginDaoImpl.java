package com.crunchify.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crunchify.dao.LoginDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.CallData;
import com.crunchify.model.OrderCodeMaster;
import com.crunchify.model.SiteDetails;
import com.crunchify.model.User;
import com.crunchify.model.VtplUser;

@Repository
public class LoginDaoImpl implements LoginDao {
	/* Logger implementation */
	private static final Logger logger = Logger.getLogger(LoginDaoImpl.class);
  
	/* Autowire NamedParameterJdbcTemplate */
	
  @Autowired
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 

  @Override
  public User loginCheck(String userName, String password) throws SpringCrunchifyException {
	  logger.debug("Inside loginCheck() method:");
	  
    String loginCheckSql = "select * from userreg where user_name  = :userName and pwd = :password";
    
    Map<String, String> paramMap = new HashMap<String, String>();
    paramMap.put("userName", userName );
    paramMap.put("password", password );
    
    try{

    return namedParameterJdbcTemplate.queryForObject(loginCheckSql, paramMap, new RowMapper<User>() {
      @Override
      public User mapRow(ResultSet rs, int rowNum) throws SQLException {
          User user = new User();
          
          user.setEmail(rs.getString("email"));
          user.setFname(rs.getString("fname"));
          user.setLname(rs.getString("lname"));
          user.setPwd(rs.getString("pwd"));
          user.setUid(rs.getString("user_name"));
          
          return user;
      }
  });
    
    
  }catch(RuntimeException re)
      {
	  logger.error("Error in  user login " + this.getClass(), re);    	
	    throw new SpringCrunchifyException(re);
	  }
    finally{
        logger.debug("Exit from login:");
        }
  }
  
  @Override
  public SiteDetails getSiteDetails(int id) throws SpringCrunchifyException {
	  logger.debug("Inside loginCheck() method:");
	  
    String loginCheckSql = "select site_name,created_by,created_on from tbl_master_site where id=:id";
    System.out.println("The id"+id);
    Map<String, Integer> paramMap = new HashMap<String, Integer>();
    paramMap.put("id", id );
  
    
    try{

    return namedParameterJdbcTemplate.queryForObject(loginCheckSql, paramMap, new RowMapper<SiteDetails>() {
      @Override
      public SiteDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
    	  SiteDetails s = new SiteDetails();
          
         s.setSite_name(rs.getString(1));
         s.setCreated_on(rs.getDate(3));
         s.setCreated_by(rs.getString(2));
          return s;
      }
  });
    
    
  }catch(RuntimeException re)
      {
	  logger.error("Error in  user login " + this.getClass(), re);    	
	    throw new SpringCrunchifyException(re);
	  }
    finally{
        logger.debug("Exit from login:");
        }
  }
  
  @Override
  public String setSiteDetails(SiteDetails site) throws SpringCrunchifyException {
	  logger.debug("Inside loginCheck() method:");
	  
    String insertSql = "insert into tbl_master_site(SITE_NAME, CREATED_BY, CREATED_ON, flag)values(:site_name,:created_by,:created_on,:flag)";
    Map<String, String> paramMap = new HashMap<String, String>();
    paramMap.put("site_name", site.getSite_name() );
    paramMap.put("created_by", site.getCreated_by());
    paramMap.put("created_on", site.getCreated_on().toString());
    paramMap.put("flag", "1");
    
  
    
    try{
    	int k=0;
     k=namedParameterJdbcTemplate.update(insertSql, paramMap);
    
    if(k>0){return "Success";}else{return "Error";}
  }catch(RuntimeException re)
      {
	  logger.error("Error in  user login " + this.getClass(), re);    	
	    throw new SpringCrunchifyException("Error");
	  }
    finally{
        logger.debug("Exit from login:");
        }
  }


  @Override
  public List<OrderCodeMaster> getOrderCodes() throws SpringCrunchifyException {
	  logger.debug("Inside loginCheck() method:");
	  
    String loginCheckSql = "select a.ord_number,a.project_id,a.ord_date,b.customer_name from trn_order_code a left join tbl_master_customer b on(a.cust_id=b.id) where substr(project_id,1,5)='17-18' and is_delete=1";
   // System.out.println("The id"+id);
    Map<String, Integer> paramMap = new HashMap<String, Integer>();
    
  
    
    try{

    return namedParameterJdbcTemplate.query(loginCheckSql,new ResultSetExtractor<List<OrderCodeMaster>>(){  
        @Override  
        public List<OrderCodeMaster> extractData(ResultSet rs) throws SQLException,  
               DataAccessException {  
         
           List<OrderCodeMaster> list=new ArrayList<OrderCodeMaster>();  
           while(rs.next()){  
        	   OrderCodeMaster e=new OrderCodeMaster();  
           e.setOrder_number(rs.getString(1));
           e.setOrder_code(rs.getString(2));
           e.setOrder_date(rs.getString(3));
           e.setCustomer_name(rs.getString(4));
           list.add(e);  
           }  
           return list;  
           }  
       });  
    
    
  }catch(RuntimeException re)
      {
	  logger.error("Error in  user login " + this.getClass(), re);    	
	    throw new SpringCrunchifyException(re);
	  }
    finally{
        logger.debug("Exit from login:");
        }
  }
  
  @Override
  public List<VtplUser> loginCheckForVtpl(String userName, String password) throws SpringCrunchifyException {
	  logger.debug("Inside loginCheck() method:");
	  
    String loginCheckSql = "select count(*),user_id,user_name,user_type from tbl_login_master a left join tbl_master_employee b on(a.employee_id=b.id) where user_id  = :userName and user_password = md5(:password)";
    
    Map<String, String> paramMap = new HashMap<String, String>();
    paramMap.put("userName", userName );
    paramMap.put("password", password );
    System.out.println("u-"+userName+"p-"+password);
    try{

    return namedParameterJdbcTemplate.query(loginCheckSql, paramMap,new ResultSetExtractor<List<VtplUser>>() {
    	 @Override  
	        public List<VtplUser> extractData(ResultSet rs) throws SQLException,  
	               DataAccessException {       
	        	List<VtplUser> listUser=new ArrayList<VtplUser>(); 
	        	 while(rs.next()){  	        	   
	        		 VtplUser c = new VtplUser();
		        		 c.setUid(rs.getString(2));
		        		 c.setUserName(rs.getString(3));
		        		 c.setUserType(rs.getString(4));
		        		 listUser.add(c);
		        		 
		         
		           }  
	        	 return listUser;  
    	 }
         
     
  });
    
    
  }catch(RuntimeException re)
      {
	  logger.error("Error in  user login " + this.getClass(), re);    	
	    //throw new SpringCrunchifyException(re);
	  return null;
	  }
    finally{
        logger.debug("Exit from login:");
        }
  }

}
