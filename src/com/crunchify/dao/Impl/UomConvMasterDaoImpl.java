package com.crunchify.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crunchify.dao.ItemTypeDao;
import com.crunchify.dao.RetailRoleDao;
import com.crunchify.dao.UomConvMasterDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
//import com.crunchify.model.MenuDataBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.UomConvMasterBean;

@Repository
public class UomConvMasterDaoImpl implements UomConvMasterDao {
	@Autowired
	   private SessionFactory sessionFactory;
	
	
	@Override
	public String uomConvCreate(UomConvMasterBean conv) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		//List<RetailRegistrationBean> data= null;
		
		 Session session = sessionFactory.getCurrentSession();
		// session.beginTransaction();
		// String sql = "from RetailRegistrationBean ";
		// RoleDataDtl rdtl= new RoleDataDtl();
		//	rdtl.setRoleDataHdr(rhdr);
		//	rhdr.getRoleDtlList().add(rdtl);
		 
		 session.save(conv);
		 
		//System.out.println("id:---------------"+ rhdr.getRoleId());
		
 
    	 
		System.out.println("Done");
		return "success";
	}
	
	@Override
	public List<UomConvMasterBean> uom_cnv()
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		List<UomConvMasterBean> data= null;
		 Session session = sessionFactory.getCurrentSession();
		 String sql = "from UomConvMasterBean where active='Y' ";
		 Query q= session.createQuery(sql);
		 data=q.list();
			return data;
	}
	@Override
	public String viewUOMCCreate(UomConvMasterBean uom_cnv)
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String uom_convUpdate(UomConvMasterBean uom_cnv) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		//List<RetailRegistrationBean> data= null;
		
		 Session session = sessionFactory.getCurrentSession();
		// session.beginTransaction();
		// String sql = "from RetailRegistrationBean ";
		// RoleDataDtl rdtl= new RoleDataDtl();
		//	rdtl.setRoleDataHdr(rhdr);
		//	rhdr.getRoleDtlList().add(rdtl);
		 System.out.println("id:---------------5d");
		 session.saveOrUpdate(uom_cnv);
		 
		//System.out.println("id:---------------"+ rhdr.getRoleId());
		
 
    	 
		System.out.println("Done");
		return "success";
	}
	
	@Override
	public String uomcnvTypDelete(UomConvMasterBean ucnv_typ) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		//List<RetailRegistrationBean> data= null;
		
		 Session session = sessionFactory.getCurrentSession();
		
		 Query q = session.createQuery("update UomConvMasterBean set active=:active where con_fr=:id");
		 System.out.println("sql is===>"+q.getQueryString());
		// Query q= session.createQuery(sql);
		   q.setParameter("id",ucnv_typ.getCon_fr());
		   q.setParameter("active", "N");
		   //data=q.list();
		 int p=q.executeUpdate();
		
		 //session.update(item_typ);
		System.out.println("Done"+p);
	
		return "success";
	}
	
}
            
	   
		                                                                                   