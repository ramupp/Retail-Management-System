package com.crunchify.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crunchify.dao.RetailRoleDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemTypeBean;
//import com.crunchify.model.MenuDataBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataDtl;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;

@Repository
public class RetailRoleDaoImpl implements RetailRoleDao {
	@Autowired
	   private SessionFactory sessionFactory;
	
	
	@Override
	public String roleCreate(RoleDataHdr rhdr) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		//List<RetailRegistrationBean> data= null;
		  List<RoleDataDtl> roleDtlList=new ArrayList<RoleDataDtl>();	
		 Session session = sessionFactory.getCurrentSession();
		// session.beginTransaction();
		// String sql = "from RetailRegistrationBean ";
		// RoleDataDtl rdtl= new RoleDataDtl();
		//	rdtl.setRoleDataHdr(rhdr);
		//	rhdr.getRoleDtlList().add(rdtl);
		 
		 rhdr.setActive("Y");
		 session.save(rhdr);
		 
		System.out.println("id:---------------"+ rhdr.getRoleId());
		 
		 
		 
 RoleDataDtl rddtl = null;  		 
  		 
  		 
  		int i=0;     	
       	
       	
       	for(int j=0;j<rhdr.getAddId().length;j++)
       	{
       		if(!rhdr.getAddId()[j].equals("no"))
       		{   
       			rddtl = new RoleDataDtl();  
       			if(i<rhdr.getMenuId().length){
       			rddtl.setMenuId(rhdr.getMenuId()[i]);
       			i++;
       			}
       			rddtl.setAddId(rhdr.getAddId()[j]); 
       	       	rddtl.setEditId(rhdr.getEditId()[j]); 
       	      	rddtl.setDeleteId(rhdr.getDeleteId()[j]); 
       	       	rddtl.setViewId(rhdr.getViewId()[j]);        	
       	      	rddtl.setRoledatahdr(rhdr);
       	      	session.save(rddtl);
       			
       		}
       		
        
        }
  	 
    	 
		System.out.println("Done");
		return "success";
	}
	
	@Override
	public String roleUpdate(RoleDataHdr rhdr) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		//List<RetailRegistrationBean> data= null;
		  List<RoleDataDtl> roleDtlList=new ArrayList<RoleDataDtl>();	
		 Session session = sessionFactory.getCurrentSession();
		 rhdr.setActive("Y");
		 session.saveOrUpdate(rhdr);
		 
		System.out.println("id:---------------"+ rhdr.getRoleId());
		 
		 
		 
 RoleDataDtl rddtl = null;  		 
  		 
  		 
  		int i=0;     	
       	
       	
       	for(int j=0;j<rhdr.getAddId().length;j++)
       	{
       		if(!rhdr.getAddId()[j].equals("no") || !rhdr.getAddId()[j].equals("false"))
       		{   
       			rddtl = new RoleDataDtl();  
       			if(i<rhdr.getMenuId().length){
       			rddtl.setMenuId(rhdr.getMenuId()[i]);
       			i++;
       			}
       			rddtl.setRoleDtlId(rhdr.getRole_dtl_id()[j]);
       			rddtl.setAddId(rhdr.getAddId()[j]); 
       	       	rddtl.setEditId(rhdr.getEditId()[j]); 
       	      	rddtl.setDeleteId(rhdr.getDeleteId()[j]); 
       	       	rddtl.setViewId(rhdr.getViewId()[j]);        	
       	      	rddtl.setRoledatahdr(rhdr);
       	      	session.saveOrUpdate(rddtl);
       			
       		}
       		
        
        }
  	 
    	 
		System.out.println("Done");
		return "success";
	}
	
	
	@Override
	public String userCreate(RetailRegistrationBean rbean,List<UserRoleCompany> roleComp) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		//List<RetailRegistrationBean> data= null;
		 // List<RoleDataDtl> roleDtlList=new ArrayList<RoleDataDtl>();	
		   List<UserRegRoleCompany> list=new ArrayList<UserRegRoleCompany>();
		//   
//		     HashMap<Integer, List<Integer>> c=urc.getRoleId();
		//    
//		     for (Entry<Integer, List<Integer>> entry : c.entrySet()) {
//		    	    System.out.println("aaa-"+entry.getKey()+"-bbb-"+entry.getValue());// entry.getKey();
//		    	  //  Object value = entry.getValue();
//		    	    // ...
//		    	}
		 Session session = sessionFactory.getCurrentSession();
		// session.beginTransaction();
		// String sql = "from RetailRegistrationBean ";
		// RoleDataDtl rdtl= new RoleDataDtl();
		//	rdtl.setRoleDataHdr(rhdr);
		//	rhdr.getRoleDtlList().add(rdtl);
		 
		 session.save(rbean);
		 
	//	System.out.println("id:---------------"+ rhdr.getRoleId());
		 
		 
		 
		for (UserRoleCompany value : roleComp) {
			
			session.save(value);
			
		}
    	 
    	 
		System.out.println("Done");
		return "success";
	}
	
	
	
//	public String menuCreate(MenuDataBean mbean) throws SpringCrunchifyException{
//		 Session session = sessionFactory.getCurrentSession();
//		 session.save(mbean);
//		 System.out.println("Done");
//		return "success";
//	}
	
	
	@Override
	public String changePwdUpdate(RetailRegistrationBean pwd) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		//List<RetailRegistrationBean> data= null;
		
		 Session session = sessionFactory.getCurrentSession();
		 
		 
		 Query q = session.createQuery("from RetailRegistrationBean where name=:user_pw");
		 System.out.println("sql is===>"+q);
		// Query q= session.createQuery(sql);
		   q.setParameter("user_pw","user_pw");
		   //data=q.list();
		 
		
		 session.update(pwd);
		System.out.println("Done");
		return "success";
	}

}
