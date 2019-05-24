package com.crunchify.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crunchify.dao.ItemMasterDao;
import com.crunchify.dao.ItemTypeDao;
import com.crunchify.dao.RetailRoleDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.RetailDesignBean;
//import com.crunchify.model.MenuDataBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.view.DesignViewBean;
import com.crunchify.model.view.ItemMasterViewBean;

@Repository
public class ItemMasterDaoImpl implements ItemMasterDao {
	@Autowired
	   private SessionFactory sessionFactory;
	
	
	@Override
	public String itemMasterCreate(ItemMasterBean item_m) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		//List<RetailRegistrationBean> data= null;
		
		 Session session = sessionFactory.getCurrentSession();
		// session.beginTransaction();
		// String sql = "from RetailRegistrationBean ";
		// RoleDataDtl rdtl= new RoleDataDtl();
		//	rdtl.setRoleDataHdr(rhdr);
		//	rhdr.getRoleDtlList().add(rdtl);
		 
		 session.save(item_m);
		 
		//System.out.println("id:---------------"+ rhdr.getRoleId());
		
 
    	 
		System.out.println("Done");
		return "success";
	}
	@Override
	public List<ItemMasterViewBean> item_master()
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		List<ItemMasterViewBean> data= null;
		 Session session = sessionFactory.getCurrentSession();
		// String sql = "from ItemMasterBean ";
		 
		 String sql = "select a.itm_id as itm_id, a.itm_nm as itm_nm,b.itm_typ_nm as itm_typ_nm, a.hsn_cd as hsn_cd,a.amount as amount,a.log_cond as log_cond, a.gst_per as gst_per , a.gst_per1 as gst_per1, a.created_by as created_by, a.created_on as created_on,a. modified_by as modified_by, a.modified_on as modified_on from mst_fp_itm a left join mst_itm_typ b on (a.itm_typ_id=b.itm_typ_id) where a.active='Y' ";
		// Query q= session.createQuery(sql);
		// data=q.list();
		 
		 //System.out.println("sql");
		 
		 
		 Query q= session.createSQLQuery(sql).addScalar("itm_id").addScalar("itm_nm").addScalar("itm_typ_nm").addScalar("hsn_cd").addScalar("amount").
				 addScalar("log_cond").addScalar("gst_per").addScalar("gst_per1").addScalar("created_by").addScalar("created_on").addScalar("modified_by").addScalar("modified_on").setResultTransformer(Transformers.aliasToBean(ItemMasterViewBean.class));
			//return sessionFactory.getCurrentSession().createQuery("from RetailDesignBean where active='Y'").list();
		 //System.out.println(q);
		return q.list();
		
		//	return data;
	}
	
	@Override
	public List<ItemMasterBean> fetchAllItemMaster()
			throws SpringCrunchifyException {
		 Session session = sessionFactory.getCurrentSession();
		 
		 Query q= session.createQuery("from ItemMasterViewBean where active='Y'");
			//return sessionFactory.getCurrentSession().createQuery("from RetailDesignBean where active='Y'").list();
		return q.list();
	}
	@Override
	public String viewMasterCreate(ItemMasterBean item_master)
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String itemMasterUpdate(ItemMasterBean item_m) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		//List<RetailRegistrationBean> data= null;
		
		 Session session = sessionFactory.getCurrentSession();
		// session.beginTransaction();
		// String sql = "from RetailRegistrationBean ";
		// RoleDataDtl rdtl= new RoleDataDtl();
		//	rdtl.setRoleDataHdr(rhdr);
		//	rhdr.getRoleDtlList().add(rdtl);
		 
		 session.saveOrUpdate(item_m);
		 
		//System.out.println("id:---------------"+ rhdr.getRoleId());
		
 
    	 
		System.out.println("Done");
		return "success";
	}
	
	@Override
	public String itemMasterDelete(ItemMasterBean item_master) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		//List<RetailRegistrationBean> data= null;
		
		 Session session = sessionFactory.getCurrentSession();
		
		 Query q = session.createQuery("update ItemMasterViewBean set active=:active where itm_id=:id");
		 System.out.println("sql is===>"+q.getQueryString());
		// Query q= session.createQuery(sql);
		   q.setParameter("id",item_master.getItm_id());
		   q.setParameter("active", "N");
		   //data=q.list();
		 int p=q.executeUpdate();
		
		 //session.update(item_typ);
		System.out.println("Done"+p);
	
		return "success";
	}
	
	
	
}
