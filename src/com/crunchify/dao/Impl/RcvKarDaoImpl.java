package com.crunchify.dao.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crunchify.dao.RcvKarDao;
import com.crunchify.dao.RetailDesignDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.RcvRetKarDtlBean;
import com.crunchify.model.RcvRetKarHdrBean;
import com.crunchify.model.RcvRetKarProdBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.model.RetailDesignBean;
import com.crunchify.model.RetailDesignBeanDtl;
import com.crunchify.model.view.DesignViewBean;
import com.crunchify.util.UtilityHelper;

@Repository
public class RcvKarDaoImpl implements RcvKarDao {

	@Autowired
	   private SessionFactory sessionFactory;

@Override
	public String updateIssue(RcvRetKarHdrBean rcv_kar)
			throws SpringCrunchifyException {
		System.out.println("hiiii........."+rcv_kar.getItem_id1().length);
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(rcv_kar);
		RcvRetKarProdBean issueKarProdBean=null;
		RcvRetKarDtlBean issueKarDtlBean=null;
		UtilityHelper util=new UtilityHelper();
		
		 String x1[]=util.findFinalUpdatedId("RFRK", String.valueOf(rcv_kar.getCo_id()),"STOK");
		 String memo_no=x1[0];
	int idp=Integer.parseInt(x1[1]);
	rcv_kar.setDoc_no(memo_no);
	
	rcv_kar.setRef_no(rcv_kar.getDoc_no());
	rcv_kar.setRef_dt(rcv_kar.getDoc_dt());

				//session.save(rcv_kar);
		session.saveOrUpdate(rcv_kar);
		
	
		
		int k=0;
		//IssueKarDtlBean issueKarDtlBean=null ;

		
		
		
		
		
		
		for(int i=0;i<rcv_kar.getItem_id1().length; i++)
		{
		
			issueKarDtlBean = new RcvRetKarDtlBean();
			//issueKarProdBean.setId(rcv_kar.getId()[i]);
			issueKarDtlBean.setItm_typ_id(rcv_kar.getItem_typ_id1() [i]);
			issueKarDtlBean.setItm_id(rcv_kar.getItem_id1()[i]);
			issueKarDtlBean.setDesg_no(rcv_kar.getDesg_no1()[i]);
			issueKarDtlBean.setQty(rcv_kar.getQty1()[i]);
			issueKarDtlBean.setUom_id(rcv_kar.getUom_id1()[i]);
			issueKarDtlBean.setCo_id(rcv_kar.getCo_id());
			
			
			issueKarDtlBean.setActive("Y");
			issueKarDtlBean.setCreated_by(rcv_kar.getCreated_by());
			issueKarDtlBean.setCreated_on(rcv_kar.getCreated_on());
			issueKarDtlBean.setIssuekarhdrBean(rcv_kar);
			session.saveOrUpdate(issueKarDtlBean);
			System.out.println("my companyidis ---"+rcv_kar.getCo_id());
			 Query q = (Query) session.createSQLQuery("CALL sp_stock_maintnce(:param_design_no,:param_date,:param_item_id,:param_itemtyp_id,:param_co_id,:param_qty,:param_hdr,:param_updateId)");
	       		
	       		q.setParameter("param_design_no","MISC");
	       		q.setParameter("param_date", rcv_kar.getDoc_dt());
	       		System.out.println("param_date"+rcv_kar.getDoc_dt());
	       		q.setParameter("param_item_id", rcv_kar.getItem_id1()[i]);
	       		q.setParameter("param_itemtyp_id", rcv_kar.getItem_typ_id1()[i]);
	       		q.setParameter("param_co_id", rcv_kar.getCo_id());
	       		q.setParameter("param_qty", rcv_kar.getQty1()[i]);
	       		q.setParameter("param_hdr", "rcvfrmkar");
	       		q.setParameter("param_updateId", "1");
	       		
	       		q.executeUpdate();
			
			
			
		}
		
		for(int i=0;i<rcv_kar.getItem_id().length; i++)
		{
			issueKarProdBean=new RcvRetKarProdBean();
			//issueKarProdBean.setId(rcv_kar.getId()[i]);
			issueKarProdBean.setItm_typ_id(rcv_kar.getItem_typ_id() [i]);
			issueKarProdBean.setItm_id(rcv_kar.getItem_id()[i]);
			issueKarProdBean.setDesg_no(rcv_kar.getDesg_no()[i]);
			issueKarProdBean.setQty(rcv_kar.getQty()[i]);
			issueKarProdBean.setUom_id(rcv_kar.getUom_id()[i]);
			issueKarProdBean.setCo_id(rcv_kar.getCo_id());
			
			
			issueKarProdBean.setActive("Y");
			issueKarProdBean.setCreated_by(rcv_kar.getCreated_by());
			issueKarProdBean.setCreated_on(rcv_kar.getCreated_on());
			issueKarProdBean.setIssuekarhdrBean(rcv_kar);
			session.saveOrUpdate(issueKarProdBean);
			
			 Query q = (Query) session.createSQLQuery("CALL sp_stock_maintnce(:param_design_no,:param_date,:param_item_id,:param_itemtyp_id,:param_co_id,:param_qty,:param_hdr,:param_updateId)");
	       		
	       		q.setParameter("param_design_no",rcv_kar.getDesg_no()[i]);
	       		q.setParameter("param_date", rcv_kar.getDoc_dt());
	       		q.setParameter("param_item_id", rcv_kar.getItem_id()[i]);
	       		q.setParameter("param_itemtyp_id", rcv_kar.getItem_typ_id()[i]);
	       		q.setParameter("param_co_id", rcv_kar.getCo_id());
	       		q.setParameter("param_qty", rcv_kar.getQty()[i]);
	       		q.setParameter("param_hdr", "rcvfrmkar");
	       		q.setParameter("param_updateId", "1");
	       		
	       		q.executeUpdate();
			
			
			
		}
Query qs = (Query) session.createSQLQuery("CALL sp_slno_update(:param_date,:param_co_id,:param_hdr,:param_updateId)");
   		
   		//q.setParameter("param_design_no",x);
   		qs.setParameter("param_date", rcv_kar.getDoc_dt());
   		qs.setParameter("param_co_id", rcv_kar.getCo_id());
   		//q.setParameter("param_qty", cashSale.getQty()[i]);
   	
   		qs.setParameter("param_hdr", "rcvfrmkar");
   		
   		qs.setParameter("param_updateId", idp);
   		
   		qs.executeUpdate();
		
		System.out.println("success");
		return rcv_kar.getDoc_no();

		//return "success";
	}

@Override
public String updateIsueKar(RcvRetKarHdrBean rcv_kar) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String issueKarUpdate(RcvRetKarHdrBean rcv_kar)
		throws SpringCrunchifyException {
	// TODO Auto-generated method stub
	return null;
}


@Override
public List<RcvRetKarHdrBean> rcv_kar() throws SpringCrunchifyException {
//	// TODO Auto-generated method stub
List<RcvRetKarHdrBean> data= null;
 Session session = sessionFactory.getCurrentSession();
 String sql = "select a.hid, doc_no,date_format(a.doc_dt,'%y-%m-%d')doc_dt,ref_no,date_format(a.ref_dt,'%y-%m-%d')ref_dt, narration, party_nm from trn_kar_issue_hd a join mst_party c on (a.kar_cd=c.party_id) where a.type='R' and c.party_typ='SC'";

		 																																				
 Query q= session.createSQLQuery(sql);
 q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
 data=q.list();
	return data;
}

@Override
public String viewRcv_kar(RcvRetKarHdrBean rcv_kar)
		throws SpringCrunchifyException {
	// TODO Auto-generated method stub
	return null;
}
@Override
public String updateRcvKar(RcvRetKarHdrBean rcv_kar) throws SpringCrunchifyException {
	// TODO Auto-generated method stub
	//List<RetailRegistrationBean> data= null;
	
	 Session session = sessionFactory.getCurrentSession();
	// session.beginTransaction();
	// String sql = "from RetailRegistrationBean ";
	// RoleDataDtl rdtl= new RoleDataDtl();
	//	rdtl.setRoleDataHdr(rhdr);
	//	rhdr.getRoleDtlList().add(rdtl);
	 
	 session.saveOrUpdate(rcv_kar);
	 
	//System.out.println("id:---------------"+ rhdr.getRoleId());
	

	 
	System.out.println("Done");
	return "success";
}



}
