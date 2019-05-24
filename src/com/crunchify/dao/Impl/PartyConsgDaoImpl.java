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
import com.crunchify.dao.PartyConsgDao;
import com.crunchify.dao.PartyMasterDao;
import com.crunchify.dao.RetailRoleDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.ConsgMasterBean;
import com.crunchify.model.ConsgViewBean;
import com.crunchify.model.ContactConsgBean;
import com.crunchify.model.ContactDetailsBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.PartyMasterBean;
import com.crunchify.model.PartyViewBean;
//import com.crunchify.model.MenuDataBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.StateMasterBean;
import com.crunchify.util.UtilityHelper;

@Repository
public class PartyConsgDaoImpl implements PartyConsgDao {
	@Autowired
	   private SessionFactory sessionFactory;
	
	
	@Override
	public String consgMasterCreate(ConsgMasterBean consg_m) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		//List<RetailRegistrationBean> data= null;
		ContactConsgBean con=new ContactConsgBean();
		 Session session = sessionFactory.getCurrentSession();
		
		 
		 session.save(consg_m);
		
		 
		 con.setSl_no(consg_m.getSl_no());
		 con.setCont_email(consg_m.getCont_email());
		 con.setCont_per(consg_m.getCont_per());
		 con.setCont_mob(consg_m.getCont_mob());
		 //con.setDesig(party_m.getDesig());
		 con.setConsgmasterbean(consg_m);
		 session.save(con);
		//System.out.println("id:---------------"+ rhdr.getRoleId());
		
 
    	 
		System.out.println("Done");
		return "success";
	}
	@Override
	public List<ConsgViewBean> consg_master()
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		List<ConsgViewBean> data= null;
		 Session session = sessionFactory.getCurrentSession();
		 String sql = "from ConsgViewBean where active='Y' ";
		 StateMasterBean sm= new StateMasterBean();

		 Query q= session.createQuery(sql);
		 data=q.list();
		 int state_id=0;
		 UtilityHelper uh= new UtilityHelper();
			//System.out.println("State Id--->"+data.get(0).getState());
           for(int i=0;i<data.size();i++){
		 state_id=data.get(i).getState();
		 System.out.println("STATEID==> "+state_id);
			
			String sname=uh.findStateNameById(state_id);
			sm.setState_nm(sname);
			
			data.get(i).setState_nm(sname);
			
			
			 int city_id=data.get(i).getCity();
				//  UtilityHelper uhp= new UtilityHelper();
				String cname=uh.findCityNameById(city_id);
				//sm.setCity(cname);
				data.get(i).setCity_nm(cname);
           }
			//System.out.println("State Name--->"+cname);

			return data;
	}
	@Override
	public String viewConsgMasterCreate(ConsgMasterBean consg_Master)
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String consgUpdate(ConsgMasterBean consg) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		//List<RetailRegistrationBean> data= null;
		
		 Session session = sessionFactory.getCurrentSession();
		// session.beginTransaction();
		// String sql = "from RetailRegistrationBean ";
		// RoleDataDtl rdtl= new RoleDataDtl();
		//	rdtl.setRoleDataHdr(rhdr);
		//	rhdr.getRoleDtlList().add(rdtl);
		 
		 session.saveOrUpdate(consg);
		 
		//System.out.println("id:---------------"+ rhdr.getRoleId());
		
 
    	 
		System.out.println("Done");
		return "success";
	}
	
	
	@Override
	public String consgTypeDelete(ConsgMasterBean consg_typ) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		//List<RetailRegistrationBean> data= null;
		
		 Session session = sessionFactory.getCurrentSession();
		
		 Query q = session.createQuery("update ConsgMasterBean set active=:active where consg_id=:id");
		 System.out.println("sql is===>"+q.getQueryString());
		// Query q= session.createQuery(sql);
		   q.setParameter("id",consg_typ.getConsg_id());
		   q.setParameter("active", "N");
		   //data=q.list();
		 int p=q.executeUpdate();
		
		 //session.update(item_typ);
		System.out.println("Done"+p);
	
		return "success";
	}
	
	
	
}
