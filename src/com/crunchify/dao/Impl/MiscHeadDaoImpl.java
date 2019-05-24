package com.crunchify.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crunchify.dao.ItemTypeDao;
import com.crunchify.dao.MiscHeadDao;
import com.crunchify.dao.RetailRoleDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.MiscHeadBean;
//import com.crunchify.model.MenuDataBean;
import com.crunchify.model.RetailRegistrationBean;

@Repository
public class MiscHeadDaoImpl implements MiscHeadDao {
	@Autowired
	   private SessionFactory sessionFactory;
	
	
	@Override
	public String miscHeadCreate(MiscHeadBean misc) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		//List<RetailRegistrationBean> data= null;
		
		 Session session = sessionFactory.getCurrentSession();
		// session.beginTransaction();
		// String sql = "from RetailRegistrationBean ";
		// RoleDataDtl rdtl= new RoleDataDtl();
		//	rdtl.setRoleDataHdr(rhdr);
		//	rhdr.getRoleDtlList().add(rdtl);
		 System.out.println("id:---------------5d");
		 session.save(misc);
		 
		//System.out.println("id:---------------"+ rhdr.getRoleId());
		
 
    	 
		System.out.println("Done");
		return "success";
	}
	@Override
	public List<MiscHeadBean> misc_head()
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		List<MiscHeadBean> data= null;
		 Session session = sessionFactory.getCurrentSession();
		 String sql = "from MiscHeadBean ";
		 Query q= session.createQuery(sql);
		 data=q.list();
			return data;
	}
	@Override
	public String viewMiscCreate(MiscHeadBean misc_head)
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
