package com.crunchify.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crunchify.dao.CityMasterDao;
import com.crunchify.dao.ItemMasterDao;
import com.crunchify.dao.ItemTypeDao;
import com.crunchify.dao.RetailRoleDao;
import com.crunchify.dao.StateMasterDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.CityMasterBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
//import com.crunchify.model.MenuDataBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.StateMasterBean;

@Repository
public class StateMasterDaoImpl implements StateMasterDao {
	@Autowired
	   private SessionFactory sessionFactory;
	
	
	@Override
	public String stateMasterCreate(StateMasterBean state_m) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		//List<RetailRegistrationBean> data= null;
		
		 Session session = sessionFactory.getCurrentSession();
		// session.beginTransaction();
		// String sql = "from RetailRegistrationBean ";
		// RoleDataDtl rdtl= new RoleDataDtl();
		//	rdtl.setRoleDataHdr(rhdr);
		//	rhdr.getRoleDtlList().add(rdtl);
		 
		 session.save(state_m);
		 
		//System.out.println("id:---------------"+ rhdr.getRoleId());
		
 
    	 
		System.out.println("Done");
		return "success";
	}
	@Override
	public List<StateMasterBean> view_state_type()
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		List<StateMasterBean> data= null;
		 Session session = sessionFactory.getCurrentSession();
		 String sql = "from StateMasterBean where active='Y'";
		 Query q= session.createQuery(sql);
		 data=q.list();
			return data;
	}
	@Override
	public String stateUpdate(StateMasterBean state) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		//List<RetailRegistrationBean> data= null;
		
		 Session session = sessionFactory.getCurrentSession();
		// session.beginTransaction();
		// String sql = "from RetailRegistrationBean ";
		// RoleDataDtl rdtl= new RoleDataDtl();
		//	rdtl.setRoleDataHdr(rhdr);
		//	rhdr.getRoleDtlList().add(rdtl);
		 System.out.println("id:---------------5d");
		 session.saveOrUpdate(state);
		 
		//System.out.println("id:---------------"+ rhdr.getRoleId());
		
 
    	 
		System.out.println("Done");
		return "success";
	}
	
	@Override
	public String stateTypeDelete(StateMasterBean state_typ) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		//List<RetailRegistrationBean> data= null;
		
		 Session session = sessionFactory.getCurrentSession();
		
		 Query q = session.createQuery("update StateMasterBean set active=:active where state_id=:id");
		 System.out.println("sql is===>"+q.getQueryString());
		// Query q= session.createQuery(sql);
		   q.setParameter("id",state_typ.getState_id());
		   q.setParameter("active", "N");
		   //data=q.list();
		 int p=q.executeUpdate();
		
		 //session.update(item_typ);
		System.out.println("Done"+p);
	
		return "success";
	}
	
}
