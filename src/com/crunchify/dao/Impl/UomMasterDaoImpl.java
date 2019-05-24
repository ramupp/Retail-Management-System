package com.crunchify.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crunchify.dao.ItemMasterDao;
import com.crunchify.dao.ItemTypeDao;
import com.crunchify.dao.RetailRoleDao;
import com.crunchify.dao.UomMasterDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
//import com.crunchify.model.MenuDataBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.UomMasterBean;

@Repository
public class UomMasterDaoImpl implements UomMasterDao {
	@Autowired
	   private SessionFactory sessionFactory;
	
	
	@Override
	public String uomMasterCreate(UomMasterBean uom_m) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		//List<RetailRegistrationBean> data= null;
		
		 Session session = sessionFactory.getCurrentSession();
		// session.beginTransaction();
		// String sql = "from RetailRegistrationBean ";
		// RoleDataDtl rdtl= new RoleDataDtl();
		//	rdtl.setRoleDataHdr(rhdr);
		//	rhdr.getRoleDtlList().add(rdtl);
		 
		 session.save(uom_m);
		 
		//System.out.println("id:---------------"+ rhdr.getRoleId());
		
 
    	 
		System.out.println("Done");
		return "success";
	}
	
	@Override
	public List<UomMasterBean> uom_master()
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		List<UomMasterBean> data= null;
		 Session session = sessionFactory.getCurrentSession();
		 String sql = "from UomMasterBean where active='Y'";
		 Query q= session.createQuery(sql);
		 data=q.list();
			return data;
	}
	@Override
	public String viewMasterCreate(UomMasterBean uom_master)
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String uomMasterUpdate(UomMasterBean uom_m) throws SpringCrunchifyException{	 
		Session session = sessionFactory.getCurrentSession();
	// session.beginTransaction();
	// String sql = "from RetailRegistrationBean ";
	// RoleDataDtl rdtl= new RoleDataDtl();
	//	rdtl.setRoleDataHdr(rhdr);
	//	rhdr.getRoleDtlList().add(rdtl);
	 
	 session.saveOrUpdate(uom_m);
	 
	//System.out.println("id:---------------"+ rhdr.getRoleId());
	

	 
	System.out.println("Done");
	return "success";
		
	}
	
	
	@Override
	public String uomTypeDelete(UomMasterBean uom_typ) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		//List<RetailRegistrationBean> data= null;
		
		 Session session = sessionFactory.getCurrentSession();
		
		 Query q = session.createQuery("update UomMasterBean set active=:active where uom_id=:id");
		 System.out.println("sql is===>"+q.getQueryString());
		// Query q= session.createQuery(sql);
		   q.setParameter("id",uom_typ.getUom_id());
		   q.setParameter("active", "N");
		   //data=q.list();
		 int p=q.executeUpdate();
		
		 //session.update(item_typ);
		System.out.println("Done"+p);
	
		return "success";
	}
	
	
}
