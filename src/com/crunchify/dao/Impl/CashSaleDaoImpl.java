package com.crunchify.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crunchify.dao.CashSaleDao;
import com.crunchify.dao.RetailDesignDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.AutocompleteBean;
import com.crunchify.model.CashPartyBean;
import com.crunchify.model.CashSaleDtlBean;
import com.crunchify.model.CashSaleHdrBean;
import com.crunchify.model.CashSaleOtherHeadDtlBean;
import com.crunchify.model.RetailDesignBean;
import com.crunchify.model.RetailDesignBeanDtl;
import com.crunchify.model.view.CashSaleViewBean;
import com.crunchify.model.view.DesignViewBean;
import com.crunchify.util.UtilityHelper;

@Repository
public class CashSaleDaoImpl implements CashSaleDao {

	@Autowired
	   private SessionFactory sessionFactory;
	
	
	@Override
	public String addCashSale(CashSaleHdrBean cashSale)
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		UtilityHelper util=new UtilityHelper();
		CashPartyBean cs=new CashPartyBean();
		if(cashSale.getUid().equals(null) || cashSale.getUid().equals(""))
		{
			
			cs.setName(cashSale.getCust_name());
			cs.setAdd1(cashSale.getCust_add1());
			cs.setAdd2(cashSale.getCust_add2());
			cs.setEmail(cashSale.getCust_email());
			cs.setMobile(cashSale.getCust_mob());
			cs.setCo_id(cashSale.getCo_id());
			cs.setActive("Y");
			session.save(cs);
			cashSale.setUid(String.valueOf(cs.getId()));
		}
		System.out.println("cs is-"+cs.getId());
		if(cashSale.getVr_type().equalsIgnoreCase("CASA")){
		String x1[]=util.findFinalUpdatedId("CASA",String.valueOf(cashSale.getCo_id()),"SALE");
		String memo_no=x1[0];
		int idp=Integer.parseInt(x1[1]);
		cashSale.setMemo_no(memo_no);
		cashSale.setUpdateId(idp);
		}
		else
		{
			String x1[]=util.findFinalUpdatedId("CASR",String.valueOf(cashSale.getCo_id()),"SALE");
			String memo_no=x1[0];
			int idp=Integer.parseInt(x1[1]);
			System.out.println("idp is:-"+idp);
			cashSale.setMemo_no(memo_no);
			cashSale.setUpdateId(idp);
		}
		cashSale.setOrg_id(util.findOrgIdByCoId(cashSale.getCo_id()));
		session.save(cashSale);
		
		CashSaleDtlBean cashSaleDtlBean=null;
		String desg=null;
		CashSaleOtherHeadDtlBean cashSaleOtherHeadDtlBean=null;
		System.out.println("after header save");
		int s=0;
		for(int i=0;i<cashSale.getDesg_id().length;i++)
		{
			String x=cashSale.getDesg_id()[i];
			int p=cashSale.getQty()[i];
			if(x.equals("MISC")){ System.out.println("i am in ifff");
				
				if(!x.equals("") && x!=null && p!=0){
		       		//desg=util.findDesignByDisgnId(cashSale.getDesg_id()[i]);
					cashSaleDtlBean=new CashSaleDtlBean();
					cashSaleDtlBean.setBarcode(cashSale.getBarcode()[i]);
					cashSaleDtlBean.setDesg_id(cashSale.getDesg_id()[i]);
					cashSaleDtlBean.setHsn_cd(cashSale.getHsn_cd()[i]);
					cashSaleDtlBean.setSl_no(s);
					s++;
					cashSaleDtlBean.setItem_typ_id(cashSale.getItem_typ_id()[i]);
					cashSaleDtlBean.setItem_id(cashSale.getItem_id()[i]);
					cashSaleDtlBean.setQty(cashSale.getQty()[i]);
					cashSaleDtlBean.setRate(cashSale.getRate()[i]);
					cashSaleDtlBean.setDis_per(cashSale.getDis_per()[i]);
					cashSaleDtlBean.setDis_amt(cashSale.getDis_amt()[i]);
					cashSaleDtlBean.setGst_per(cashSale.getGst_per()[i]);
					cashSaleDtlBean.setCgst_amt(cashSale.getCgst_amt()[i]);
					cashSaleDtlBean.setSgst_amt(cashSale.getSgst_amt()[i]);
//					cashSaleDtlBean.setIgst_amt(cashSale.getIgst_amt()[i]);
					cashSaleDtlBean.setUom_id(cashSale.getUom_id()[i]);
					cashSaleDtlBean.setBasic(cashSale.getBasic()[i]);
					cashSaleDtlBean.setAmt(cashSale.getAmt()[i]);
					cashSaleDtlBean.setCo_id(cashSale.getCo_id());
					cashSaleDtlBean.setCreated_by(cashSale.getCreated_by());
					cashSaleDtlBean.setCreated_on(cashSale.getCreated_on());
					cashSaleDtlBean.setActive(cashSale.getActive());
					cashSaleDtlBean.setCashsalehdrbean(cashSale);
					session.save(cashSaleDtlBean);
					System.out.println("trdt is:-"+cashSale.getTr_dt());
					Query q = (Query) session.createSQLQuery("CALL sp_stock_maintnce(:param_design_no,:param_date,:param_item_id,:param_itemtyp_id,:param_co_id,:param_qty,:param_hdr,:param_updateId)");
		       		
		       		q.setParameter("param_design_no",x);
		       		//q.setParameter("param_", arg1)
		       		q.setParameter("param_date", cashSale.getTr_dt());
		       		q.setParameter("param_item_id", cashSale.getItem_id()[i]);
		       		q.setParameter("param_itemtyp_id", cashSale.getItem_typ_id()[i]);
		       		q.setParameter("param_co_id", cashSale.getCo_id());
		       		q.setParameter("param_qty", cashSale.getQty()[i]);
		       		if(cashSale.getVr_type().equalsIgnoreCase("CASA"))
		       		{
		       		q.setParameter("param_hdr", "cashsal");
		       		}
		       		else
		       		{
		       			q.setParameter("param_hdr", "salret");	
		       		}
		       		q.setParameter("param_updateId", cashSale.getUpdateId());
		       		
		       		q.executeUpdate();
					}	
				
			}else{ //System.out.println("i am in elseeeeeeeeee");
			
			if(!x.equals("") && x!=null && p!=0){
       		//desg=util.findDesignByDisgnId(cashSale.getDesg_id()[i]);
			cashSaleDtlBean=new CashSaleDtlBean();
			cashSaleDtlBean.setBarcode(cashSale.getBarcode()[i]);
			cashSaleDtlBean.setDesg_id(cashSale.getDesg_id()[i]);
			cashSaleDtlBean.setHsn_cd(cashSale.getHsn_cd()[i]);
			cashSaleDtlBean.setSl_no(s);
			s++;
			cashSaleDtlBean.setItem_typ_id(cashSale.getItem_typ_id()[i]);
			cashSaleDtlBean.setItem_id(cashSale.getItem_id()[i]);
			cashSaleDtlBean.setQty(cashSale.getQty()[i]);
			cashSaleDtlBean.setRate(cashSale.getRate()[i]);
			cashSaleDtlBean.setDis_per(cashSale.getDis_per()[i]);
			cashSaleDtlBean.setDis_amt(cashSale.getDis_amt()[i]);
			cashSaleDtlBean.setGst_per(cashSale.getGst_per()[i]);
			cashSaleDtlBean.setCgst_amt(cashSale.getCgst_amt()[i]);
			cashSaleDtlBean.setSgst_amt(cashSale.getSgst_amt()[i]);
//			cashSaleDtlBean.setIgst_amt(cashSale.getIgst_amt()[i]);
			cashSaleDtlBean.setUom_id(cashSale.getUom_id()[i]);
			cashSaleDtlBean.setBasic(cashSale.getBasic()[i]);
			cashSaleDtlBean.setAmt(cashSale.getAmt()[i]);
			cashSaleDtlBean.setCo_id(cashSale.getCo_id());
			cashSaleDtlBean.setCreated_by(cashSale.getCreated_by());
			cashSaleDtlBean.setCreated_on(cashSale.getCreated_on());
			cashSaleDtlBean.setActive(cashSale.getActive());
			cashSaleDtlBean.setCashsalehdrbean(cashSale);
			session.save(cashSaleDtlBean);
			System.out.println("trdt is:-"+cashSale.getTr_dt());
			Query q = (Query) session.createSQLQuery("CALL sp_stock_maintnce(:param_design_no,:param_date,:param_item_id,:param_itemtyp_id,:param_co_id,:param_qty,:param_hdr,:param_updateId)");
       		
       		q.setParameter("param_design_no",x);
       		//q.setParameter("param_", arg1)
       		q.setParameter("param_date", cashSale.getTr_dt());
       		q.setParameter("param_item_id", cashSale.getItem_id()[i]);
       		q.setParameter("param_itemtyp_id", cashSale.getItem_typ_id()[i]);
       		q.setParameter("param_co_id", cashSale.getCo_id());
       		q.setParameter("param_qty", cashSale.getQty()[i]);
       		if(cashSale.getVr_type().equalsIgnoreCase("CASA"))
       		{
       		q.setParameter("param_hdr", "cashsal");
       		}
       		else
       		{
       			q.setParameter("param_hdr", "salret");	
       		}
       		q.setParameter("param_updateId", cashSale.getUpdateId());
       		
       		q.executeUpdate();
			}
			
			}
			System.out.println("after detail save");
		}
		Query qs = (Query) session.createSQLQuery("CALL sp_slno_update(:param_date,:param_co_id,:param_hdr,:param_updateId)");
   		
   		//q.setParameter("param_design_no",x);
   		qs.setParameter("param_date", cashSale.getTr_dt());
   		qs.setParameter("param_co_id", cashSale.getCo_id());
   		//q.setParameter("param_qty", cashSale.getQty()[i]);
   		if(cashSale.getVr_type().equalsIgnoreCase("CASA"))
   		{
   		qs.setParameter("param_hdr", "cashsal");
   		}
   		else
   		{
   			qs.setParameter("param_hdr", "salret");	
   		}
   		qs.setParameter("param_updateId", cashSale.getUpdateId());
   		
   		qs.executeUpdate();
		
		
//		for(int j=0;j<cashSale.getMiscH().length;j++)
//		{cashSaleOtherHeadDtlBean=new CashSaleOtherHeadDtlBean();	
//			if(cashSale.getMiscH()[j]!=0)
//			{
//				cashSaleOtherHeadDtlBean.setActive("Y");
//				cashSaleOtherHeadDtlBean.setMiscH(cashSale.getMiscH()[j]);
//				cashSaleOtherHeadDtlBean.setMiscHamt(cashSale.getMiscHamt()[j]);
//				cashSaleOtherHeadDtlBean.setCreated_by(cashSale.getCreated_by());
//				cashSaleOtherHeadDtlBean.setCreated_on(cashSale.getCreated_on());
//				cashSaleOtherHeadDtlBean.setO_amt(cashSale.getO_amt()[j]);
//				cashSaleOtherHeadDtlBean.setO_cgst_amt(cashSale.getO_cgst_amt()[j]);
//				cashSaleOtherHeadDtlBean.setO_gst_per(cashSale.getO_gst_per()[j]);
//				cashSaleOtherHeadDtlBean.setO_igst_amt(cashSale.getO_igst_amt()[j]);
//				cashSaleOtherHeadDtlBean.setO_sgst_amt(cashSale.getO_sgst_amt()[j]);
//				cashSaleOtherHeadDtlBean.setO_cal_typ(cashSale.getO_cal_typ()[j]);
//				cashSaleOtherHeadDtlBean.setCashsalehdrbean(cashSale);
//				session.save(cashSaleOtherHeadDtlBean);
//			}
//		}
		
		return cashSale.getMemo_no();
	}


	@Override
	public List<CashSaleViewBean> getCashSaleDetails()
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		 String sql="SELECT tr_hid as tr_hid, a.co_id as co_id,b.co_nm as co_nm, a.org_id as org_id, memo_no as memo_no, tr_dt as tr_dt, cust_name as cust_name, cust_add1 as cust_add1,"+
" cust_add2 as cust_add2, cust_mob as cust_mob, cust_email as cust_email, user_id, fin_dis_amt as fin_dis_amt, fin_cgst_amt as fin_cgst_amt,"+
" net_amt as net_amt, pay_type as pay_type, pay_amt as pay_amt, bal_amt as bal_amt, doc_no , doc_dt, drawn_on, remarks,"+
" a.created_by as created_by, a.created_on as created_on, a.modified_by, a.modified_on, a.active,"+
 " finBasic as finBasic, fin_sgst_amt as fin_sgst_amt, amt_in_word,"+
 " (SELECT sm_nm FROM mst_sales_man where sm_id=a.salesman) as salesman,"+
 " (SELECT sm_nm FROM mst_sales_man where sm_id=a.helper) as helper FROM cash_sale_hd a join mst_company b on(a.co_id=b.co_id) where a.active='Y'";

		 
		 Query q= session.createSQLQuery(sql).addScalar("tr_hid").addScalar("co_nm").addScalar("memo_no").addScalar("tr_dt").
				 addScalar("cust_name").addScalar("cust_add1").addScalar("cust_add2").addScalar("cust_mob").addScalar("cust_email").addScalar("fin_dis_amt").
				 addScalar("fin_cgst_amt").addScalar("net_amt").addScalar("finBasic").addScalar("fin_sgst_amt").addScalar("salesman")
				 .addScalar("helper").addScalar("created_by").addScalar("created_on").setResultTransformer(Transformers.aliasToBean(CashSaleViewBean.class));
			//return sessionFactory.getCurrentSession().createQuery("from RetailDesignBean where active='Y'").list();
		return q.list();
	}
	
	@Override
	public List<AutocompleteBean> getCashParty(String co_id) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		 String sql="select id as id,concat(name,'-',id) as label,'1' as description from mst_cash_party a where a.active='Y' and co_id="+co_id;
		 Query q= session.createSQLQuery(sql).addScalar("id").addScalar("label").addScalar("description").setResultTransformer(Transformers.aliasToBean(AutocompleteBean.class));
		 List<AutocompleteBean> data=new ArrayList<AutocompleteBean>();
			//return sessionFactory.getCurrentSession().createQuery("from RetailDesignBean where active='Y'").list();
		
			data=q.list();
			return data;
	}

}
