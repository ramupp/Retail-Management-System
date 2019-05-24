package com.crunchify.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crunchify.dao.ItemMasterDao;
import com.crunchify.dao.ItemTypeDao;
import com.crunchify.dao.PartyMasterDao;
import com.crunchify.dao.RetailRoleDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.AutocompleteBean;
import com.crunchify.model.ContactDetailsBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemRateTypeBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.PartyMasterBean;
import com.crunchify.model.PartyTypeBean;
import com.crunchify.model.PartyViewBean;
//import com.crunchify.model.MenuDataBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.StateMasterBean;
import com.crunchify.model.StockData;
import com.crunchify.util.UtilityHelper;

@Repository
public class PartyMasterDaoImpl implements PartyMasterDao {
	@Autowired
	   private SessionFactory sessionFactory;
	
	
	@Override
	public String partyMasterCreate(PartyMasterBean party_m) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		//List<RetailRegistrationBean> data= null;
		ContactDetailsBean con=new ContactDetailsBean();
		 Session session = sessionFactory.getCurrentSession();
		
		 
		 session.save(party_m);
		
		 
		 con.setSl_no(party_m.getSl_no());
		 con.setCont_email(party_m.getCont_email());
		 con.setCont_per(party_m.getCont_per());
		 con.setCont_mob(party_m.getCont_mob());
		 //con.setDesig(party_m.getDesig());
		 con.setPartymasterbean(party_m);
		 session.save(con);
		//System.out.println("id:---------------"+ rhdr.getRoleId());
		
 
    	 
		System.out.println("Done");
		return "success";
	}
/*@Override
	public List<PartyViewBean> party_master()
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		List<PartyViewBean> data= null;
		 Session session = sessionFactory.getCurrentSession();
		
		 String sql = "from PartyViewBean where active='Y'";
		 StateMasterBean sm= new StateMasterBean();
		 PartyViewBean stData= new PartyViewBean();

		 Query q= session.createQuery(sql);
		 data=q.list();
		 UtilityHelper uh= new UtilityHelper();
			//System.out.println("State Id--->"+data.get(0).getState());
			 */
	
	
		 
		/*if(stData.getParty_nm()==" ")
	
			//--if(stData.getParty_id()!=-999 && !stData.getParty_nm().equals("-999"))
			
			 {
				 sql = "from PartyViewBean where party_id  = :party_id and party_nm like :party_nm and active='Y'";	
				 q= session.createQuery(sql);
				//-- q.setParameter("co_id", stData.getCo_id());
				 q.setParameter("party_nm", stData.getParty_nm()+"%");
				 
				 System.out.println("sql......>>>"+sql);
			 }*/
	
		 
	
	
		/* for(int i=0;i<data.size();i++){
		 int state_id=data.get(i).getState();
			
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
	}*/
	@Override
	public String viewPartyMasterCreate(PartyMasterBean party_Master)
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String party_mTypeUpdate(PartyMasterBean party_m) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		//List<RetailRegistrationBean> data= null;
		
		 Session session = sessionFactory.getCurrentSession();
		// session.beginTransaction();
		// String sql = "from RetailRegistrationBean ";
		// RoleDataDtl rdtl= new RoleDataDtl();
		//	rdtl.setRoleDataHdr(rhdr);
		//	rhdr.getRoleDtlList().add(rdtl);
		 System.out.println("id:---------------5d");
		 session.saveOrUpdate(party_m);
		 
		//System.out.println("id:---------------"+ rhdr.getRoleId());
		
 
    	 
		System.out.println("Done");
		return "success";
	}
	
	
	@Override
	public String partyTypeDelete(PartyMasterBean party_typ) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		//List<RetailRegistrationBean> data= null;
		
		 Session session = sessionFactory.getCurrentSession();
		
		 Query q = session.createQuery("update PartyMasterBean set active=:active where party_id=:id");
		 System.out.println("sql is===>"+q.getQueryString());
		// Query q= session.createQuery(sql);
		   q.setParameter("id",party_typ.getParty_id());
		   q.setParameter("active", "N");
		   //data=q.list();
		 int p=q.executeUpdate();
		
		 //session.update(item_typ);
		System.out.println("Done"+p);
	
		return "success";
	}
	
	
	@Override
	public List<AutocompleteBean> fetchCustomerForPartyMaster(String id)
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		 String sql="select party_id as id , party_nm as label, '1' as description from mst_party a where a.active='Y' and party_nm like '"+id+"%'";
		 System.out.println(sql);
		 Query q= session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(AutocompleteBean.class));
		 List<AutocompleteBean> data=new ArrayList<AutocompleteBean>();
			//return sessionFactory.getCurrentSession().createQuery("from RetailDesignBean where active='Y'").list();
		
			data=q.list();
			return data;
	}

@Override

	//public List<PartyViewBean> party_master(PartyViewBean stData) throws SpringCrunchifyException {
public List<PartyViewBean> party_master(PartyViewBean stData) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		List<PartyViewBean> data= null;
		 Session session = sessionFactory.getCurrentSession();
		 PartyViewBean st= new PartyViewBean();
		 PartyViewBean stData1= new PartyViewBean();
		 String sql = "";
		System.out.println("customer name$$$$$$$$$$$$$$$$$===> " + stData1.getParty_nm());
		 Query q=null;
	
		 
	//if(stData.getParty_id()!=-999 && !stData.getParty_nm().equals("-999"))
		 if(stData.getParty_nm()=="party_nm")
		 {
			 sql = "from PartyViewBean where party_id  = :party_id and party_nm like :party_nm and active='Y'";	
			 q= session.createQuery(sql);
			// q.setParameter("co_id", stData.getCo_id());
			 q.setParameter("party_nm", stData.getParty_nm()+"%");
		 }
		
	
		 
		 data=q.list();
		 UtilityHelper uh= new UtilityHelper();
			//System.out.println("State Id--->"+data.get(0).getState());
		 StateMasterBean sm= new StateMasterBean();

	
		 
		 for(int i=0;i<data.size();i++){
		 int state_id=data.get(i).getState();
			
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
public List<PartyViewBean> party_master() {
	// TODO Auto-generated method stub
	return null;
}



}
