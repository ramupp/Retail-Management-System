package com.crunchify.dao.Impl;

import java.util.List;

import javax.persistence.Transient;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crunchify.dao.RcvKarDao;
import com.crunchify.dao.RetailDesignDao;
import com.crunchify.dao.ReturnKarigarhDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.RcvRetKarDtlBean;
import com.crunchify.model.RcvRetKarHdrBean;
import com.crunchify.model.RcvRetKarProdBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.RetailDesignBean;
import com.crunchify.model.RetailDesignBeanDtl;
import com.crunchify.model.view.DesignViewBean;
import com.crunchify.util.UtilityHelper;

@Repository
public class ReturnKarigarhDaoImpl implements ReturnKarigarhDao {

	@Autowired
	   private SessionFactory sessionFactory;


	

	@Override
	public String returnKarigarhCreate(RcvRetKarHdrBean ret_kar)
			throws SpringCrunchifyException {
		System.out.println("hiiii........."+ret_kar.getItem_id1().length);
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(ret_kar);
		RcvRetKarProdBean issueKarProdBean=null;
		UtilityHelper util=new UtilityHelper();
		 String x1[]=util.findFinalUpdatedId("RTOK", String.valueOf(ret_kar.getCo_id()),"STOK");
		 String memo_no=x1[0];
	int idp=Integer.parseInt(x1[1]);
	ret_kar.setDoc_no(memo_no);
	
	ret_kar.setRef_no(ret_kar.getDoc_no());
	ret_kar.setRef_dt(ret_kar.getDoc_dt());

				session.save(ret_kar);
		
	
		
		int k=0;
		RcvRetKarDtlBean issueKarDtlBean=null ;

		
		for(int i=0;i<ret_kar.getItem_id1().length; i++)
		{
			System.out.println("im in for loop");
			
			///if(ret_kar.getDesg_no1()[i]==null || ret_kar.getDesg_no1()[i].equals(""))
			if(ret_kar.getDesg_id1()[i]==null || ret_kar.getDesg_id1()[i].equals(""))
			
			{
				
			}
			else
			
		{
			issueKarProdBean=new RcvRetKarProdBean();
			//issueKarProdBean.setId(rcv_kar.getId()[i]);
			issueKarProdBean.setDesg_no(ret_kar.getDesg_id1()[i]);
			issueKarProdBean.setItm_typ_id(ret_kar.getItem_typ_id1() [i]);
			issueKarProdBean.setItm_id(ret_kar.getItem_id1()[i]);
			
			issueKarProdBean.setQty(ret_kar.getQty1()[i]);
			issueKarProdBean.setUom_id(ret_kar.getUom_id1()[i]);
			
			issueKarProdBean.setActive("Y");
			issueKarProdBean.setCreated_by(ret_kar.getCreated_by());
			issueKarProdBean.setCreated_on(ret_kar.getCreated_on());
			issueKarProdBean.setIssuekarhdrBean(ret_kar);
			session.saveOrUpdate(issueKarProdBean);
		}
			
			Query q = (Query) session.createSQLQuery("CALL sp_stock_maintnce(:param_design_no,:param_date,:param_item_id,:param_itemtyp_id,:param_co_id,:param_qty,:param_hdr,:param_updateId)");
       		
       		q.setParameter("param_design_no","MISC");
       		q.setParameter("param_date", ret_kar.getDoc_dt());
       		q.setParameter("param_item_id", ret_kar.getItem_id1()[i]);
       		q.setParameter("param_itemtyp_id", ret_kar.getItem_typ_id1()[i]);
       		q.setParameter("param_co_id", ret_kar.getCo_id());
       		q.setParameter("param_qty", ret_kar.getQty1()[i]);
       		q.setParameter("param_hdr", "retkar");
     		q.setParameter("param_updateId", "1");
      		
       		q.executeUpdate();
			
			
			
			
			
		
			
		}
		
Query qs = (Query) session.createSQLQuery("CALL sp_slno_update(:param_date,:param_co_id,:param_hdr,:param_updateId)");
   		
   		//q.setParameter("param_design_no",x);
   		qs.setParameter("param_date", ret_kar.getDoc_dt());
   		qs.setParameter("param_co_id", ret_kar.getCo_id());
   		//q.setParameter("param_qty", cashSale.getQty()[i]);
   	
   		qs.setParameter("param_hdr", "rettokar");
   		
   		qs.setParameter("param_updateId", idp);
   		
   		qs.executeUpdate();
		
		System.out.println("success");
		return ret_kar.getDoc_no();

		//return "success";
	}


	@Override
	public List<RcvRetKarHdrBean> ret_kar() throws SpringCrunchifyException {
//		// TODO Auto-generated method stub
	List<RcvRetKarHdrBean> data= null;
	 Session session = sessionFactory.getCurrentSession();
	 String sql = "select a.hid, doc_no,date_format(a.doc_dt,'%y-%m-%d')doc_dt,ref_no,date_format(a.ref_dt,'%y-%m-%d')ref_dt, narration, party_nm from trn_kar_issue_hd a join mst_party c on (a.kar_cd=c.party_id) where type='T' and party_typ='SC'";

			 																																				
	 Query q= session.createSQLQuery(sql);
	 q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
	 data=q.list();
		return data;
	}

	@Override
	public String viewRet_kar(RcvRetKarHdrBean ret_kar)
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return null;
	}


	
}
