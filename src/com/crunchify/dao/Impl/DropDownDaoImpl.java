package com.crunchify.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.crunchify.dao.DropDownDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.DropDownBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.StockData;

@Repository
public class DropDownDaoImpl implements DropDownDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Object> getSelectData(DropDownBean getData) throws SpringCrunchifyException {
		//String param="select id,design_no,quantity,item_id,item_type_id,uom_id,co_id,yr_code from "+getData.getBeanName()+" where ";
		
		String param="from "+getData.getBeanName()+" where ";
		//String beanName = getData.getBeanName();
		
		for(int i=0;i<getData.getValColumn().length;i++)
		{			
				if(i>0)
				{
					param=param + " and ";
				}
				
				param = param + getData.getValColumn()[i] + "='" + getData.getValValue()[i]+"'";
				
			//}
			
		}
		
		System.out.println("SQLPARAM==> "+param); 
    	 
		System.out.println("Done");
		
		List<Object> data= null;
		//DropDownBean value=null;
		 Session session = sessionFactory.getCurrentSession();
		 Query q= session.createQuery(param);
		// String bean="";
		 data=q.list();
		 
//		 for (Object ob : data) {
//			 value=new DropDownBean();
//			 bean=value.getBeanName();
//			}
		 return data;
		
		
		
		
		
	}
	
	


}
