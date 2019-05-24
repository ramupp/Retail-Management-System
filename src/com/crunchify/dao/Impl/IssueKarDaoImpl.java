package com.crunchify.dao.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crunchify.dao.IssueKarDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.IssueKarDtlBean;
import com.crunchify.model.IssueKarHdrBean;
import com.crunchify.model.IssueKarProdBean;
import com.crunchify.model.ItemMasterBean;
import com.crunchify.model.ItemTypeBean;
import com.crunchify.util.UtilityHelper;

@Repository
public class IssueKarDaoImpl implements IssueKarDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public String addIssueKar(IssueKarHdrBean kar)
			throws SpringCrunchifyException {
		Session session = sessionFactory.getCurrentSession();
		//{
		
		 UtilityHelper util=new UtilityHelper();
		 String x1[]=util.findFinalUpdatedId("ITOK", String.valueOf(kar.getCo_id()),"STOK");
		 String memo_no=x1[0];
	int idp=Integer.parseInt(x1[1]);
	if(kar.getHid()==0){
	kar.setDoc_no(memo_no);
	}
		session.saveOrUpdate(kar);
		
	
		
		int k=0;
		IssueKarDtlBean issueKarDtlBean=null ;
		for(k=0;k<kar.getItm_id().length;k++)
			 {
			System.out.println("1");
			// String x=kar.getDesg_id()[i];
			// if(!x.equals("") && x!=null){
			issueKarDtlBean = new IssueKarDtlBean();
//			IssueKarDtlBean issueKarDtlBean = new IssueKarDtlBean();
			// issueKarDtlBean.setDesg_id(kar.getDesg_id()[i]);
			//issueKarDtlBean.setDesg_no("MISC");
			if(kar.getDid()[k].equals("0")){}else{
			issueKarDtlBean.setId(Integer.parseInt(kar.getDid()[k]));
			}
			issueKarDtlBean.setDesg_no(kar.getDesg_no()[k]);
			issueKarDtlBean.setItm_id(kar.getItm_id()[k]);
			issueKarDtlBean.setItm_typ_id(kar.getItm_typ_id()[k]);
			issueKarDtlBean.setUom_id(kar.getUom_id()[k]);
			issueKarDtlBean.setQty(kar.getQty()[k]);
			issueKarDtlBean.setActive("Y");
			issueKarDtlBean.setCo_id(kar.getCo_id());
			issueKarDtlBean.setOrg_id(kar.getOrg_id());
			issueKarDtlBean.setCreated_by(kar.getCreated_by());
			issueKarDtlBean.setCreated_on(kar.getCreated_on());
			// packingSlipDtlBean.setSl_no(i);
			// packingSlipDtlBean.setBarcode(slip.getBarcode()[i]);
//			System.out.println(issueKarDtlBean.getItm_typ_id());
//			issueKarDtlBean.setItm_typ_id(issueKarDtlBean.getItm_typ_id());
//			issueKarDtlBean.setItm_id(issueKarDtlBean.getItm_id());
			// packingSlipDtlBean.setHsn_cd(slip.getHsn_cd()[i]);
			// packingSlipDtlBean.setQty(slip.getQty()[i]);
			// packingSlipDtlBean.setRate(slip.getRate()[i]);
//			issueKarDtlBean.setUom_id(issueKarDtlBean.getUom_id());
			// packingSlipDtlBean.setDis_per(slip.getDis_per()[i]);
			// packingSlipDtlBean.setDis_amt(slip.getDis_amt()[i]);
			// packingSlipDtlBean.setGst_per(slip.getGst_per()[i]);
			// packingSlipDtlBean.setCgst_amt(slip.getCgst_amt()[i]);
			// packingSlipDtlBean.setSgst_amt(slip.getSgst_amt()[i]);
			// packingSlipDtlBean.setIgst_amt(slip.getIgst_amt()[i]);
			// packingSlipDtlBean.setBasic(slip.getBasic()[i]);
			// packingSlipDtlBean.setAmt(slip.getAmt()[i]);
			// packingSlipDtlBean.setCo_id(slip.getCo_id());
			// packingSlipDtlBean.setCreated_by(slip.getCreated_by());
			// packingSlipDtlBean.setCreated_on(slip.getCreated_on());
			// packingSlipDtlBean.setActive(slip.getActive());
			
			 issueKarDtlBean.setIssuekarhdrBean(kar);
			 session.saveOrUpdate(issueKarDtlBean);
			 
			 Query q = (Query) session.createSQLQuery("CALL sp_stock_maintnce(:param_design_no,:param_date,:param_item_id,:param_itemtyp_id,:param_co_id,:param_qty,:param_hdr,:param_updateId)");
	       		
	       		q.setParameter("param_design_no",kar.getDesg_no()[k]);
	       		q.setParameter("param_date", kar.getDoc_dt());
	       		q.setParameter("param_item_id", kar.getItm_id()[k]);
	       		q.setParameter("param_itemtyp_id", kar.getItm_typ_id()[k]);
	       		q.setParameter("param_co_id", kar.getCo_id());
	       		q.setParameter("param_qty", kar.getQty()[k]);
	       		q.setParameter("param_hdr", "issuetokar");
	       		q.setParameter("param_updateId", "1");
	       		
	       		q.executeUpdate();
//			
 			
	}
		
		
		int i=0;
		IssueKarProdBean issuekarprodBean ;
		for(i=0;i<kar.getItm_id1().length;i++)
			 {
			//System.out.println("1");
			// String x=kar.getDesg_id()[i];
			// if(!x.equals("") && x!=null){
			issuekarprodBean = new IssueKarProdBean();
//			IssueKarDtlBean issueKarDtlBean = new IssueKarDtlBean();
			if(kar.getPid()[i].equals("0")){}else{
			issuekarprodBean.setId(Integer.parseInt(kar.getPid()[i]));
			}
			issuekarprodBean.setDesg_no(kar.getDesg_no1()[i]);
			issuekarprodBean.setItm_id(kar.getItm_id1()[i]);
			issuekarprodBean.setItm_typ_id(kar.getItm_typ_id1()[i]);
			issuekarprodBean.setUom_id(kar.getUom_id1()[i]);
			issuekarprodBean.setQty(kar.getQty1()[i]);
			issuekarprodBean.setActive("Y");
			issuekarprodBean.setCo_id(kar.getCo_id());
			issuekarprodBean.setOrg_id(kar.getOrg_id());
			issuekarprodBean.setCreated_by(kar.getCreated_by());
			issuekarprodBean.setCreated_on(kar.getCreated_on());
			// packingSlipDtlBean.setSl_no(i);
			// packingSlipDtlBean.setBarcode(slip.getBarcode()[i]);
//			System.out.println(issueKarDtlBean.getItm_typ_id());
//			issueKarDtlBean.setItm_typ_id(issueKarDtlBean.getItm_typ_id());
//			issueKarDtlBean.setItm_id(issueKarDtlBean.getItm_id());
			// packingSlipDtlBean.setHsn_cd(slip.getHsn_cd()[i]);
			// packingSlipDtlBean.setQty(slip.getQty()[i]);
			// packingSlipDtlBean.setRate(slip.getRate()[i]);
//			issueKarDtlBean.setUom_id(issueKarDtlBean.getUom_id());
			// packingSlipDtlBean.setDis_per(slip.getDis_per()[i]);
			// packingSlipDtlBean.setDis_amt(slip.getDis_amt()[i]);
			// packingSlipDtlBean.setGst_per(slip.getGst_per()[i]);
			// packingSlipDtlBean.setCgst_amt(slip.getCgst_amt()[i]);
			// packingSlipDtlBean.setSgst_amt(slip.getSgst_amt()[i]);
			// packingSlipDtlBean.setIgst_amt(slip.getIgst_amt()[i]);
			// packingSlipDtlBean.setBasic(slip.getBasic()[i]);
			// packingSlipDtlBean.setAmt(slip.getAmt()[i]);
			// packingSlipDtlBean.setCo_id(slip.getCo_id());
			// packingSlipDtlBean.setCreated_by(slip.getCreated_by());
			// packingSlipDtlBean.setCreated_on(slip.getCreated_on());
			// packingSlipDtlBean.setActive(slip.getActive());
			issuekarprodBean.setIssuekarhdrBean(kar);
			
			session.saveOrUpdate(issuekarprodBean);
	}
Query qs = (Query) session.createSQLQuery("CALL sp_slno_update(:param_date,:param_co_id,:param_hdr,:param_updateId)");
   		
   		//q.setParameter("param_design_no",x);
   		qs.setParameter("param_date", kar.getDoc_dt());
   		qs.setParameter("param_co_id", kar.getCo_id());
   		//q.setParameter("param_qty", cashSale.getQty()[i]);
   	
   		qs.setParameter("param_hdr", "issuetokar");
   		
   		qs.setParameter("param_updateId", idp);
   		
   		qs.executeUpdate();
		
		System.out.println("success");
		return kar.getDoc_no();
	}

	@Override
	public List<IssueKarHdrBean> kar() throws SpringCrunchifyException {
//		// TODO Auto-generated method stub
	List<IssueKarHdrBean> data= null;
	 Session session = sessionFactory.getCurrentSession();
	 String sql = "select date_format(trn_kar_issue_hd.doc_dt,'%d-%m-%Y')doc_dt,trn_kar_issue_hd.doc_no,mst_party.party_nm from trn_kar_issue_hd inner join mst_party on (trn_kar_issue_hd.kar_cd=mst_party.party_id) where type='I' and trn_kar_issue_hd.active='Y'";
	 Query q= session.createSQLQuery(sql);
	 q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
	 data=q.list();
		return data;
	}

	@Override
	public String viewTypCreate(IssueKarHdrBean kar)
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return null;
	}
//	@Override
//	public String updateIssueKar(IssueKarHdrBean kar) throws SpringCrunchifyException {
//		// TODO Auto-generated method stub
//		//List<RetailRegistrationBean> data= null;
//		
//		 Session session = sessionFactory.getCurrentSession();
//		// session.beginTransaction();
//		// String sql = "from RetailRegistrationBean ";
//		// RoleDataDtl rdtl= new RoleDataDtl();
//		//	rdtl.setRoleDataHdr(rhdr);
//		//	rhdr.getRoleDtlList().add(rdtl);
//		 
//		 session.saveOrUpdate(kar);
//		 
//		//System.out.println("id:---------------"+ rhdr.getRoleId());
//		
// 
//    	 
//		System.out.println("Done");
//		return "success";
//	}


}
