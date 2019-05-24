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
import com.crunchify.dao.RetailCompanyMasterDao;
import com.crunchify.dao.RetailRoleDao;
import com.crunchify.dao.YearCodeDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.RetailCompanyMasterBean;
//import com.crunchify.model.MenuDataBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.UomMasterBean;
import com.crunchify.model.YearCodeBean;

@Repository
public class YearCodeDaoImpl implements YearCodeDao {
	@Autowired
	   private SessionFactory sessionFactory;
	@Autowired
	private RetailCompanyMasterDao retailCompanyMasterDao;
	
	
	@Override
	public String yearCodeCreate(YearCodeBean year_c) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		//List<RetailRegistrationBean> data= null;
		
		 Session session = sessionFactory.getCurrentSession();
		
		 session.save(year_c);
		 
		 List<RetailCompanyMasterBean> company=retailCompanyMasterDao.fetchAllCompany();
		 
		 for (RetailCompanyMasterBean retailCompanyMasterBean : company) {
			 Query qs = (Query) session.createSQLQuery("CALL create_slno_master(:param_co_id,:param_yrcd,:user_id)");
		   		
		   		//q.setParameter("param_design_no",x);
		   		qs.setParameter("param_co_id",retailCompanyMasterBean.getCo_id() );
		   		//q.setParameter("param_qty", cashSale.getQty()[i]);
		   		qs.setParameter("param_yrcd", year_c.getYr_cd());
		   		qs.setParameter("user_id", year_c.getCreated_by());   		
		   		qs.executeUpdate();
		}
		 
		
 
    	 
		System.out.println("Done");
		return "success";
	}
	
	@Override
	public List<YearCodeBean> yearcd_master()
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		List<YearCodeBean> data= null;
		 Session session = sessionFactory.getCurrentSession();
		 String sql = "from YearCodeBean where active='Y' ";
		 Query q= session.createQuery(sql);
		 data=q.list();
			return data;
	}
	@Override
	public String viewYearCodeCreate(YearCodeBean yearcd_master)
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String yearCodeUpdate(YearCodeBean yr_cd) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		//List<RetailRegistrationBean> data= null;
		
		 Session session = sessionFactory.getCurrentSession();
		// session.beginTransaction();
		// String sql = "from RetailRegistrationBean ";
		// RoleDataDtl rdtl= new RoleDataDtl();
		//	rdtl.setRoleDataHdr(rhdr);
		//	rhdr.getRoleDtlList().add(rdtl);
		 System.out.println("id:---------------5d");
		 session.saveOrUpdate(yr_cd);
		 
		//System.out.println("id:---------------"+ rhdr.getRoleId());
		
 
    	 
		System.out.println("Done");
		return "success";
	}
	
	@Override
	public String yearCodeDelete(YearCodeBean year_cd) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		//List<RetailRegistrationBean> data= null;
		
		 Session session = sessionFactory.getCurrentSession();
		
		 Query q = session.createQuery("update YearCodeBean set active=:active where yr_cd_id=:id");
		 System.out.println("sql is===>"+q.getQueryString());
		// Query q= session.createQuery(sql);
		   q.setParameter("id",year_cd.getYr_cd_id());
		   q.setParameter("active", "N");
		   //data=q.list();
		 int p=q.executeUpdate();
		
		 //session.update(item_typ);
		System.out.println("Done"+p);
	
		return "success";
	}
	
}
