package com.crunchify.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crunchify.dao.CashSaleDao;
import com.crunchify.dao.CrSaleDao;
import com.crunchify.dao.PackingSlipDao;
import com.crunchify.dao.RetailDesignDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.CashSaleDtlBean;
import com.crunchify.model.CashSaleHdrBean;
import com.crunchify.model.CashSaleOtherHeadDtlBean;
import com.crunchify.model.CrSaleDtlBean;
import com.crunchify.model.CrSaleHdrBean;
import com.crunchify.model.CrSaleOtherHeadDtlBean;
import com.crunchify.model.PackingSlipDtlBean;
import com.crunchify.model.PackingSlipHdrBean;
import com.crunchify.model.PackingSlipOtherHeadDtlBean;
import com.crunchify.model.RetailDesignBean;
import com.crunchify.model.RetailDesignBeanDtl;
import com.crunchify.util.UtilityHelper;

@Repository
public class CrSaleDaoImpl implements CrSaleDao {

	@Autowired
	   private SessionFactory sessionFactory;
	
	
	


	@Override
	public String addCrSale(CrSaleHdrBean crSale)
			throws SpringCrunchifyException {
		Session session = sessionFactory.getCurrentSession();
		UtilityHelper util=new UtilityHelper();
		crSale.setOrg_id(util.findOrgIdByCoId(crSale.getCo_id()));
		String vr_type=crSale.getVr_type();
		String memo_no=null;
		int idp=0;
		String param_type=null;
		if(vr_type.equals("STKO"))
		{	
			String x1[]=util.findFinalUpdatedId("STKO",String.valueOf(crSale.getCo_id()),"SALE");
			 memo_no=x1[0];
			 idp=Integer.parseInt(x1[1]);
			 //System.out.println("memo:"+memo_no+"idp:"+idp);
			 crSale.setUpdateId(idp);
			param_type="stockout"	;
		}
		else if(vr_type.equals("CRSR"))
		{String x1[]=util.findFinalUpdatedId("CRSR",String.valueOf(crSale.getCo_id()),"SALE");
		 memo_no=x1[0];
		 crSale.setBill_no(memo_no);
		 idp=Integer.parseInt(x1[1]);
		 crSale.setUpdateId(idp);
			param_type="crsaleret"	;
		}
		else
		{	String x1[]=util.findFinalUpdatedId("CRSA",String.valueOf(crSale.getCo_id()),"SALE");
		 memo_no=x1[0];
		 idp=Integer.parseInt(x1[1]);
		 crSale.setUpdateId(idp);
			param_type="crsal"	;	
		}
		session.save(crSale);
		
		String desg=null;
		CrSaleDtlBean crSaleDtlBean=null;
		for(int i=0;i<crSale.getDesg_id().length;i++)
		{
			String x=crSale.getDesg_id()[i];
			if(x.equals("MISC")){ System.out.println("i am in if");
			
			if(!x.equals("") && x!=null){
				crSaleDtlBean=new CrSaleDtlBean();
				desg=crSale.getDesg_id()[i];
				crSaleDtlBean.setDesg_id(crSale.getDesg_id()[i]);
				crSaleDtlBean.setSl_no(i);
				crSaleDtlBean.setItem_typ_id(crSale.getItem_typ_id()[i]);
				crSaleDtlBean.setItem_id(crSale.getItem_id()[i]);
				crSaleDtlBean.setQty(crSale.getQty()[i]);
				crSaleDtlBean.setRate(crSale.getRate()[i]);
				crSaleDtlBean.setDis_per(crSale.getDis_per()[i]);
				crSaleDtlBean.setDis_amt(crSale.getDis_amt()[i]);
				crSaleDtlBean.setGst_per(crSale.getGst_per()[i]);
				crSaleDtlBean.setCgst_amt(crSale.getCgst_amt()[i]);
				crSaleDtlBean.setSgst_amt(crSale.getSgst_amt()[i]);
				crSaleDtlBean.setIgst_amt(crSale.getIgst_amt()[i]);
				crSaleDtlBean.setBasic(crSale.getBasic()[i]);
				crSaleDtlBean.setAmt(crSale.getAmt()[i]);
				crSaleDtlBean.setCo_id(crSale.getCo_id());
				crSaleDtlBean.setBarcode(crSale.getBarcode()[i]);
				crSaleDtlBean.setHsn_cd(crSale.getHsn_cd()[i]);
				crSaleDtlBean.setCreated_by(crSale.getCreated_by());
				crSaleDtlBean.setCreated_on(crSale.getCreated_on());
				crSaleDtlBean.setActive(crSale.getActive());
				crSaleDtlBean.setCrSaleHdrBean(crSale);//(crSale);
				session.save(crSaleDtlBean);
				
				Query q = (Query) session.createSQLQuery("CALL sp_stock_maintnce(:param_design_no,:param_date,:param_item_id,:param_itemtyp_id,:param_co_id,:param_qty,:param_hdr,:param_updateId)");
	       		       		
	       		q.setParameter("param_design_no",desg);
	       		q.setParameter("param_date", crSale.getBill_dt());
	       		q.setParameter("param_item_id", crSale.getItem_id()[i]);
	       		q.setParameter("param_itemtyp_id", crSale.getItem_typ_id()[i]);
	       		q.setParameter("param_co_id", crSale.getCo_id());
	       		q.setParameter("param_qty", crSale.getQty()[i]);
	       		q.setParameter("param_hdr", param_type);
	       		q.setParameter("param_updateId", crSale.getUpdateId());
	       		
	       		q.executeUpdate();
				}
			
			}else
			{
			if(!x.equals("") && x!=null){
			crSaleDtlBean=new CrSaleDtlBean();
			desg=crSale.getDesg_id()[i];
			crSaleDtlBean.setDesg_id(crSale.getDesg_id()[i]);
			crSaleDtlBean.setSl_no(i);
			crSaleDtlBean.setItem_typ_id(crSale.getItem_typ_id()[i]);
			crSaleDtlBean.setItem_id(crSale.getItem_id()[i]);
			crSaleDtlBean.setQty(crSale.getQty()[i]);
			crSaleDtlBean.setRate(crSale.getRate()[i]);
			crSaleDtlBean.setDis_per(crSale.getDis_per()[i]);
			crSaleDtlBean.setDis_amt(crSale.getDis_amt()[i]);
			crSaleDtlBean.setGst_per(crSale.getGst_per()[i]);
			crSaleDtlBean.setCgst_amt(crSale.getCgst_amt()[i]);
			crSaleDtlBean.setSgst_amt(crSale.getSgst_amt()[i]);
			crSaleDtlBean.setIgst_amt(crSale.getIgst_amt()[i]);
			crSaleDtlBean.setBasic(crSale.getBasic()[i]);
			crSaleDtlBean.setAmt(crSale.getAmt()[i]);
			crSaleDtlBean.setCo_id(crSale.getCo_id());
			crSaleDtlBean.setBarcode(crSale.getBarcode()[i]);
			crSaleDtlBean.setHsn_cd(crSale.getHsn_cd()[i]);
			crSaleDtlBean.setCreated_by(crSale.getCreated_by());
			crSaleDtlBean.setCreated_on(crSale.getCreated_on());
			crSaleDtlBean.setActive(crSale.getActive());
			crSaleDtlBean.setCrSaleHdrBean(crSale);//(crSale);
			session.save(crSaleDtlBean);
			
			Query q = (Query) session.createSQLQuery("CALL sp_stock_maintnce(:param_design_no,:param_date,:param_item_id,:param_itemtyp_id,:param_co_id,:param_qty,:param_hdr,:param_updateId)");
       		     		
			q.setParameter("param_design_no",desg);
       		q.setParameter("param_date", crSale.getBill_dt());
       		q.setParameter("param_item_id", crSale.getItem_id()[i]);
       		q.setParameter("param_itemtyp_id", crSale.getItem_typ_id()[i]);
       		q.setParameter("param_co_id", crSale.getCo_id());
       		q.setParameter("param_qty", crSale.getQty()[i]);
       		q.setParameter("param_hdr", param_type);
       		q.setParameter("param_updateId", crSale.getUpdateId());
       		
       		q.executeUpdate();
			}
		}
		}
		
		CrSaleOtherHeadDtlBean crSaleOtherHeadDtlBean=null;
		if(crSale.getMiscH()!=null){
		for(int j=0;j<crSale.getMiscH().length;j++)
		{crSaleOtherHeadDtlBean=new CrSaleOtherHeadDtlBean();	
			if(crSale.getMiscH()[j]!=0 && crSale.getMiscHamt()[j]!=0.0)
			{
				crSaleOtherHeadDtlBean.setActive("Y");
				crSaleOtherHeadDtlBean.setMiscH(crSale.getMiscH()[j]);
				crSaleOtherHeadDtlBean.setMiscHamt(crSale.getMiscHamt()[j]);
				crSaleOtherHeadDtlBean.setCreated_by(crSale.getCreated_by());
				crSaleOtherHeadDtlBean.setCreated_on(crSale.getCreated_on());
				crSaleOtherHeadDtlBean.setO_amt(crSale.getO_amt()[j]);
				crSaleOtherHeadDtlBean.setO_cgst_amt(crSale.getO_cgst_amt()[j]);
				crSaleOtherHeadDtlBean.setO_gst_per(crSale.getO_gst_per()[j]);
				crSaleOtherHeadDtlBean.setO_igst_amt(crSale.getO_igst_amt()[j]);
				crSaleOtherHeadDtlBean.setO_sgst_amt(crSale.getO_sgst_amt()[j]);
				//crSaleOtherHeadDtlBean.setO_cal_typ(crSale.getO_cal_typ()[j]);
				//packingSlipOtherHeadDtlBean.set;
				crSaleOtherHeadDtlBean.setCrSaleHdrBean(crSale);//();
				session.save(crSaleOtherHeadDtlBean);
			}
		}
		}
if(vr_type.equals("CRSR"))	{	

Query qs = (Query) session.createSQLQuery("CALL sp_slno_update(:param_date,:param_co_id,:param_hdr,:param_updateId)");
		
		//q.setParameter("param_design_no",x);
		qs.setParameter("param_date", crSale.getBill_dt());
		qs.setParameter("param_co_id", crSale.getCo_id());
		//q.setParameter("param_qty", cashSale.getQty()[i]);
		qs.setParameter("param_hdr", "crsaleret");
		qs.setParameter("param_updateId", crSale.getUpdateId());   		
		qs.executeUpdate();
		return crSale.getBill_no();
}
else
{
		return "success";
}

	}
	

	@Override
	public String addCrSaleForStockOut(CrSaleHdrBean crSale)
			throws SpringCrunchifyException {
		Session session = sessionFactory.getCurrentSession();
		UtilityHelper util=new UtilityHelper();
		crSale.setOrg_id(util.findOrgIdByCoId(crSale.getCo_id()));
		String vr_type=crSale.getVr_type();
		String memo_no=null;
		int idp=0;
		String param_type=null;
		if(vr_type.equals("STKO"))
		{	
			String x1[]=util.findFinalUpdatedId("STKO",String.valueOf(crSale.getCo_id()),"SALE");
			 memo_no=x1[0];
			 idp=Integer.parseInt(x1[1]);
			 crSale.setBill_no(memo_no);
			 //System.out.println("memo:"+memo_no+"idp:"+idp);
			 crSale.setUpdateId(idp);
			param_type="stockout"	;
		}
		else if(vr_type.equals("CRSR"))
		{String x1[]=util.findFinalUpdatedId("CRSR",String.valueOf(crSale.getCo_id()),"SALE");
		 memo_no=x1[0];
		 crSale.setBill_no(memo_no);
		 idp=Integer.parseInt(x1[1]);
		 crSale.setUpdateId(idp);
			param_type="crsaleret"	;
		}
		else
		{	String x1[]=util.findFinalUpdatedId("CRSA",String.valueOf(crSale.getCo_id()),"SALE");
		 memo_no=x1[0];
		 idp=Integer.parseInt(x1[1]);
		 crSale.setUpdateId(idp);
			param_type="crsal"	;	
		}
		session.save(crSale);
		
		String desg=null;
		CrSaleDtlBean crSaleDtlBean=null;
		for(int i=0;i<crSale.getDesg_id().length;i++)
		{
			String x=crSale.getDesg_id()[i];
			if(!x.equals("") && x!=null){
			crSaleDtlBean=new CrSaleDtlBean();
			desg=crSale.getDesg_id()[i];
			crSaleDtlBean.setDesg_id(crSale.getDesg_id()[i]);
			crSaleDtlBean.setSl_no(i);
			crSaleDtlBean.setItem_typ_id(crSale.getItem_typ_id()[i]);
			crSaleDtlBean.setItem_id(crSale.getItem_id()[i]);
			crSaleDtlBean.setQty(crSale.getQty()[i]);
			crSaleDtlBean.setRate(crSale.getRate()[i]);
			crSaleDtlBean.setDis_per(crSale.getDis_per()[i]);
			crSaleDtlBean.setDis_amt(crSale.getDis_amt()[i]);
			crSaleDtlBean.setGst_per(crSale.getGst_per()[i]);
			crSaleDtlBean.setCgst_amt(crSale.getCgst_amt()[i]);
			crSaleDtlBean.setSgst_amt(crSale.getSgst_amt()[i]);
			crSaleDtlBean.setIgst_amt(crSale.getIgst_amt()[i]);
			crSaleDtlBean.setBasic(crSale.getBasic()[i]);
			crSaleDtlBean.setAmt(crSale.getAmt()[i]);
			crSaleDtlBean.setCo_id(crSale.getCo_id());
			crSaleDtlBean.setBarcode(crSale.getBarcode()[i]);
			crSaleDtlBean.setHsn_cd(crSale.getHsn_cd()[i]);
			crSaleDtlBean.setCreated_by(crSale.getCreated_by());
			crSaleDtlBean.setCreated_on(crSale.getCreated_on());
			crSaleDtlBean.setActive(crSale.getActive());
			crSaleDtlBean.setCrSaleHdrBean(crSale);//(crSale);
			session.save(crSaleDtlBean);
			
Query q = (Query) session.createSQLQuery("CALL sp_stock_maintnce(:param_design_no,:param_date,:param_item_id,:param_itemtyp_id,:param_co_id,:param_qty,:param_hdr,:param_updateId)");
       		
       		q.setParameter("param_design_no",desg);
       		q.setParameter("param_date", crSale.getBill_dt());
       		q.setParameter("param_item_id", crSale.getItem_id()[i]);
       		q.setParameter("param_itemtyp_id", crSale.getItem_typ_id()[i]);
       		q.setParameter("param_co_id", crSale.getCo_id());
       		q.setParameter("param_qty", crSale.getQty()[i]);
       		q.setParameter("param_hdr", param_type);
       		q.setParameter("param_updateId", crSale.getUpdateId());
       		
       		q.executeUpdate();
			}
		}
		
		CrSaleOtherHeadDtlBean crSaleOtherHeadDtlBean=null;
		if(crSale.getMiscH()!=null){
		for(int j=0;j<crSale.getMiscH().length;j++)
		{crSaleOtherHeadDtlBean=new CrSaleOtherHeadDtlBean();	
			if(crSale.getMiscH()[j]!=0)
			{
				crSaleOtherHeadDtlBean.setActive("Y");
				crSaleOtherHeadDtlBean.setMiscH(crSale.getMiscH()[j]);
				crSaleOtherHeadDtlBean.setMiscHamt(crSale.getMiscHamt()[j]);
				crSaleOtherHeadDtlBean.setCreated_by(crSale.getCreated_by());
				crSaleOtherHeadDtlBean.setCreated_on(crSale.getCreated_on());
				crSaleOtherHeadDtlBean.setO_amt(crSale.getO_amt()[j]);
				crSaleOtherHeadDtlBean.setO_cgst_amt(crSale.getO_cgst_amt()[j]);
				crSaleOtherHeadDtlBean.setO_gst_per(crSale.getO_gst_per()[j]);
				crSaleOtherHeadDtlBean.setO_igst_amt(crSale.getO_igst_amt()[j]);
				crSaleOtherHeadDtlBean.setO_sgst_amt(crSale.getO_sgst_amt()[j]);
				//crSaleOtherHeadDtlBean.setO_cal_typ(crSale.getO_cal_typ()[j]);
				//packingSlipOtherHeadDtlBean.set;
				crSaleOtherHeadDtlBean.setCrSaleHdrBean(crSale);//();
				session.save(crSaleOtherHeadDtlBean);
			}
		}
		}
if(vr_type.equals("CRSR"))	{	
Query qs = (Query) session.createSQLQuery("CALL sp_slno_update(:param_date,:param_co_id,:param_hdr,:param_updateId)");
   		
   		//q.setParameter("param_design_no",x);
   		qs.setParameter("param_date", crSale.getBill_dt());
   		qs.setParameter("param_co_id", crSale.getCo_id());
   		//q.setParameter("param_qty", cashSale.getQty()[i]);
   		qs.setParameter("param_hdr", "crsaleret");
   		qs.setParameter("param_updateId", crSale.getUpdateId());   		
   		qs.executeUpdate();
   		return crSale.getBill_no();
}
else
{
	Query qs = (Query) session.createSQLQuery("CALL sp_slno_update(:param_date,:param_co_id,:param_hdr,:param_updateId)");
		
		//q.setParameter("param_design_no",x);
		qs.setParameter("param_date", crSale.getBill_dt());
		qs.setParameter("param_co_id", crSale.getCo_id());
		//q.setParameter("param_qty", cashSale.getQty()[i]);
		qs.setParameter("param_hdr", "stockout");
		qs.setParameter("param_updateId", crSale.getUpdateId());   		
		qs.executeUpdate();
		return crSale.getBill_no();
	//return crSale.getBill_no();
}

	}

}
