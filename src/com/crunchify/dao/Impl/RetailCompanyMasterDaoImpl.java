package com.crunchify.dao.Impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crunchify.dao.RetailCompanyMasterDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.RetailCompanyMasterBean;
import com.crunchify.model.RetailDesignBean;

@Repository
public class RetailCompanyMasterDaoImpl implements RetailCompanyMasterDao {
	@Autowired
	   private SessionFactory sessionFactory;
	@Override
	public int addCompany(RetailCompanyMasterBean s)
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		 System.out.println("i am in dao impl");
			int flag=0;
			try{
				Session session = sessionFactory.getCurrentSession();
				//s.setCreated_on("now()");
				session.saveOrUpdate(s);
				session.flush();
				flag=1;
				}catch(HibernateException e)
				{
				flag=0;	
					
				}
				
				return flag;
	}
	@Override
	public List<RetailCompanyMasterBean> fetchAllCompany()
			throws SpringCrunchifyException {
		 Session session = sessionFactory.getCurrentSession();
		 
		 Query q= session.createQuery("from RetailCompanyMasterBean where active='Y'");
			//return sessionFactory.getCurrentSession().createQuery("from RetailDesignBean where active='Y'").list();
		return q.list();
	}

}
