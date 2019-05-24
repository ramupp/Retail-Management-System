package com.crunchify.dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crunchify.dao.RetailLoginDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.RetailRegistrationBean;

@Repository
//@Transactional
public class RetailLoginDaoImpl implements RetailLoginDao {
	@Autowired
	   private SessionFactory sessionFactory;
//	 @PersistenceContext
//	 public EntityManager entityManager;
	@Override
	// @Transactional(readOnly=false)
	public List<RetailRegistrationBean> login(RetailRegistrationBean s)
			throws SpringCrunchifyException {
		System.out.println("in dao impl");
		 Session session = sessionFactory.getCurrentSession();
		 String sql = "from RetailRegistrationBean r where r.user_id='"+s.getUser_id()+"' and r.user_pw='"+s.getUser_pw()+"'";
		 
		 //List<RetailRegistrationBean> user= entityManager.createQuery(sql).getResultList();
		
	     Query q= session.createQuery(sql);
		return q.list();
	}
	@Override
	public List<RetailRegistrationBean> getAllUser()
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		List<RetailRegistrationBean> data= null;
		 Session session = sessionFactory.getCurrentSession();
		 String sql = "from RetailRegistrationBean ";
		 Query q= session.createQuery(sql);
		 data=q.list();
			return data;
	}

}
