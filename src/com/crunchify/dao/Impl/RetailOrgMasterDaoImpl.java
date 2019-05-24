package com.crunchify.dao.Impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crunchify.dao.RetailOrgMasterDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.RetailOrgMasterBean;


@Repository
public class RetailOrgMasterDaoImpl implements RetailOrgMasterDao {
	@Autowired
	   private SessionFactory sessionFactory;
	@Override
	public int addOrg(RetailOrgMasterBean s)
			throws SpringCrunchifyException {
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

	

}
