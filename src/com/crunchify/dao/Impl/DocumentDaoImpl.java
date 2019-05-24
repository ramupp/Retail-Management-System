package com.crunchify.dao.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crunchify.dao.DocumentDao;
import com.crunchify.dao.ItemMasterDao;
import com.crunchify.dao.ItemTypeDao;
import com.crunchify.dao.RetailRoleDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.DocumentBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
//import com.crunchify.model.MenuDataBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.view.DocumentRequestBodyBean;

@Repository
public class DocumentDaoImpl implements DocumentDao {
	@Autowired
	   private SessionFactory sessionFactory;
	
	
	@Override
	public List<DocumentBean> doc()
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		List<DocumentBean> data= null;
		 Session session = sessionFactory.getCurrentSession();
		 String sql = "from DocumentBean ";
		 Query q= session.createQuery(sql);
		 data=q.list();
			return data;
	}
	@Override
	public String viewDocCreate(DocumentBean doc)
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String addDocument(DocumentRequestBodyBean doc)
			throws SpringCrunchifyException {
		System.out.println("i am in dao");
		 Session session = sessionFactory.getCurrentSession();
		int co_id[]=doc.getCo_id();
		  //HashMap<Integer, List<String>> c=doc.getDoc_nm();
		  HashMap<Integer, List<String>> docid=doc.getDoc_id();
		  HashMap<Integer, List<String>> type=doc.getType();
		  HashMap<Integer, List<String>> docnm=doc.getFlags();
		  HashMap<Integer, List<String>> docnm1=doc.getDoc_nm1();
		  HashMap<Integer, List<String>> pre=doc.getPrefix();
		  HashMap<Integer, List<Integer>> digits=doc.getDigits();
		  HashMap<Integer, List<String>> sln=doc.getSln_pattern();
		  HashMap<Integer, List<String>> suf=doc.getSufix();
		  DocumentBean db=null;
		  Date dt=new Date();
		  for(int i=0;i<co_id.length;i++)
		  {
			// List<String> keyy=c.get(co_id[i]);
			 List<String> docidf=docid.get(co_id[i]);
			 List<String> docnmf=docnm.get(co_id[i]);
			 List<String> docnmf1=docnm1.get(co_id[i]);
			 List<String> typef=type.get(co_id[i]);
			 List<String> pref=pre.get(co_id[i]);
			 List<String> slnf=sln.get(co_id[i]);
			 List<String> suff=suf.get(co_id[i]);
			 List<Integer> digitsf=digits.get(co_id[i]);
			
			 for(int k=0;k<docnmf1.size();k++)
			 { System.out.println("data is:----"+docnmf1.get(k)+"-data 1 is:-"+docnmf.get(k)+"--coid--"+co_id[i]);
				 if(docnmf.get(k).equals("on"))
				 {System.out.println("i am in dao-----"+docidf.get(k)+"-digit is:-"+digitsf.get(k));
				 try{
					db=new DocumentBean();
					db.setDoc_id(docidf.get(k));
					db.setDoc_nm(docnmf1.get(k));
					db.setPrefix(pref.get(k));
					db.setSuffix(suff.get(k));
					db.setDigits(digitsf.get(k));
					db.setType(typef.get(k));
					db.setSln_pattern(slnf.get(k));
					db.setCo_id(co_id[i]);
					db.setActive("Y");
					db.setCreated_on(dt);
					session.save(db);
				 }catch(Exception e){
					 e.printStackTrace();
				 }
					
				 }
			 }
			 
			  
		  }
		  return "success";
	}
	
}

