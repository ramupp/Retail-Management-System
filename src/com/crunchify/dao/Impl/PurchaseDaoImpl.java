package com.crunchify.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crunchify.dao.PurchaseDao;
import com.crunchify.dao.RetailRoleDao;
import com.crunchify.dao.StockDao;
import com.crunchify.exception.SpringCrunchifyException;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.crunchify.model.AutocompleteBean;
import com.crunchify.model.AutocompleteDesignBean;
import com.crunchify.model.PurDataDtl;
import com.crunchify.model.PurDataHdr;
import com.crunchify.model.PurchaseOtherHeadDtlBean;
import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataDtl;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.StockData;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;
import com.crunchify.model.view.CashSaleViewBean;
import com.crunchify.model.view.PurDataViewBean;
import com.crunchify.util.UtilityHelper;

@Repository
public class PurchaseDaoImpl implements PurchaseDao {
	@Autowired
	   private SessionFactory sessionFactory;
	
	
	@Override
	public String purchaseEntry(PurDataHdr purHdr) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		//List<RetailRegistrationBean> data= null;
		try{
		  List<PurDataDtl> purDtlList=new ArrayList<PurDataDtl>();	
		 Session session = sessionFactory.getCurrentSession();
		 UtilityHelper util=new UtilityHelper();
		 purHdr.setPur_typ("PU");
		 String memo_no=null;
			int idp=0;
		 int count=0;
			String vr_type=purHdr.getVr_type();
			String param_type="";
			System.out.println("vr_type==> "+vr_type);
			if(vr_type.equals("STKI"))
			{
				param_type="stockin";
				String x[]=util.findFinalUpdatedId("STKI",String.valueOf(purHdr.getCo_id()),"PURC");
				memo_no=x[0];
				 idp=Integer.parseInt(x[1]);
				purHdr.setPur_no(memo_no);
				purHdr.setUpdateId(idp);
				 session.save(purHdr);
			}
			else if(vr_type.equals("PURC"))
			{String x[]=util.findFinalUpdatedId("PURC",String.valueOf(purHdr.getCo_id()),"PURC");
			memo_no=x[0];
			 idp=Integer.parseInt(x[1]);
			purHdr.setPur_no(memo_no);
			System.out.println("idp is:-"+idp);
			purHdr.setUpdateId(idp);
				param_type="pur";
				 session.save(purHdr);
			}
			else if(vr_type.equals("SDTAG"))
			{String x[]=util.findFinalUpdatedId("PURC",String.valueOf(purHdr.getCo_id()),"PURC");
			memo_no=x[0];
			 idp=Integer.parseInt(x[1]);
			purHdr.setPur_no(memo_no);
			System.out.println("idp is in sdtag is:-"+idp);
			purHdr.setUpdateId(idp);
			//purHdr.setVr_type("PURC");
				param_type="pur";
				 session.save(purHdr);
				 
				++count;
			}
		
		
		 PurDataDtl purdtl = null;  		
		 PurchaseOtherHeadDtlBean puroth=null;
		 
		 Date now = new Date();
  		 
  		 
  		int i=0;     	
  		String desg="",uom_nm="";
  		UtilityHelper u = new UtilityHelper();
  		
       	
       	for(int j=0;j<purHdr.getDesg_id().length;j++)
       	{
       		if(purHdr.getDesg_id()[j]!=0){
       		purdtl =new PurDataDtl();       		
       		purdtl.setCo_id(purHdr.getCo_id());
       		purdtl.setDesg_id(purHdr.getDesg_id()[j]); 
       		
       		if(purHdr.getVr_type().equals("PURC")){
       		desg=u.findDesignByDisgnId(purHdr.getDesg_id()[j]);
       		purdtl.setDesg_no(desg);
       		}
       		else if(purHdr.getVr_type().equals("STKI")){
       			desg=purHdr.getDesg_no()[j];
       		}
       		else if(purHdr.getVr_type().equals("SDTAG")){
       			desg=purHdr.getDesg_no()[j];
       		}
       		
       		
       		uom_nm=u.findUOMIdByUOM(purHdr.getUom_id()[j]);
       		System.out.println("UOM==> "+uom_nm);
       		purdtl.setUom_id(uom_nm);
       		purdtl.setItm_typ_id(purHdr.getItem_typ_id()[j]); 
       		purdtl.setItm_id(purHdr.getItem_id()[j]); 
       		purdtl.setQty(purHdr.getQty()[j]);        	
       		purdtl.setRate(purHdr.getRate()[j]);
       		purdtl.setBar_code(purHdr.getBar_code()[j]);
       		purdtl.setActive("Y");
       		purdtl.setDis_per(purHdr.getDis_per()[j]);    
       		purdtl.setDis_amt(purHdr.getDis_amt()[j]);     
       		purdtl.setGst_per(purHdr.getGst_per()[j]);
       		purdtl.setCgst_amt(purHdr.getCgst_amt()[j]);
       		purdtl.setSgst_amt(purHdr.getSgst_amt()[j]);
       		purdtl.setIgst_amt(purHdr.getIgst_amt()[j]);
       		purdtl.setAmt(purHdr.getAmt()[j]); 
       		purdtl.setCreated_by(purHdr.getCreated_by());
       		purdtl.setBasic_amt(purHdr.getBasic()[j]);
       		purdtl.setCreated_on(now);
       		purdtl.setPurdatahdr(purHdr);
       		//purdtl.setVr_type("PU");
       		session.save(purdtl);
       		
       		if(!desg.equals("MISC"))
       		{
       	  //System.out.println("PARAMS=>=> "+desg+","+purHdr.getPur_dt()+","+purHdr.getQty());
     		Query q = (Query) session.createSQLQuery("CALL sp_stock_maintnce(:param_design_no,:param_date,:param_item_id,:param_itemtyp_id,:param_co_id,:param_qty,:param_hdr,:param_updateId)");
     		
     		q.setParameter("param_design_no",desg);
     		q.setParameter("param_date", purHdr.getPur_dt());
     		q.setParameter("param_item_id", purHdr.getItem_id()[j]);
       		q.setParameter("param_itemtyp_id", purHdr.getItem_typ_id()[j]);
     		q.setParameter("param_co_id", purHdr.getCo_id());
     		
     		q.setParameter("param_qty", purHdr.getQty()[j]);
     		q.setParameter("param_hdr", param_type);
     		q.setParameter("param_updateId", purHdr.getUpdateId());
     		q.executeUpdate();
       		}
       		else
       		{
       			
       		// System.out.println("PARAMS=>=> "+desg+","+purHdr.getPur_dt()+","+purHdr.getQty());
       			Query q = (Query) session.createSQLQuery("CALL sp_stock_maintnce(:param_design_no,:param_date,:param_item_id,:param_itemtyp_id,:param_co_id,:param_qty,:param_hdr,:param_updateId)");
         		
         		q.setParameter("param_design_no",desg);
         		q.setParameter("param_date", purHdr.getPur_dt());
         		q.setParameter("param_item_id", purHdr.getItem_id()[j]);
           		q.setParameter("param_itemtyp_id", purHdr.getItem_typ_id()[j]);
         		q.setParameter("param_co_id", purHdr.getCo_id());
         		
         		q.setParameter("param_qty", purHdr.getQty()[j]);
         		q.setParameter("param_hdr", param_type);
         		q.setParameter("param_updateId", purHdr.getUpdateId());
      		q.executeUpdate();
       			
       		}
       		}
       
       
       	}
       	
       	
       	
    	for(int k=0;k<purHdr.getMiscH().length;k++)
       	{
    		if(purHdr.getMiscH()[k]!=0){
    		puroth = new PurchaseOtherHeadDtlBean();    		
       		puroth.setMiscH(purHdr.getMiscH()[k]);
       		puroth.setMiscHamt(purHdr.getMiscHamt()[k]);
       		puroth.setO_amt(purHdr.getO_amt()[k]);
       		//puroth.setO_cal_typ(purHdr.getO_cal_typ()[k]);
       		puroth.setActive("Y");
       		puroth.setO_igst_amt(purHdr.getO_igst_amt()[k]);
       		puroth.setO_sgst_amt(purHdr.getO_sgst_amt()[k]);
       		puroth.setO_cgst_amt(purHdr.getO_cgst_amt()[k]);
       		puroth.setO_gst_per(purHdr.getO_gst_per()[k]);
       		puroth.setCreated_by(purHdr.getCreated_by());
       		puroth.setCreated_on(now);
       		puroth.setPurdatahdr(purHdr);
       		session.save(puroth);
    		}
       	}
    	
 		if(count>0)
		{
			 purHdr.setVr_type("SDTAG");
		}
		
		
		if(purHdr.getVr_type().equals("STKI"))
       	{
       		
       		Session session1 = sessionFactory.getCurrentSession();
   		 String sql="update cr_sale_hd set accepted='Y' where co_id="+purHdr.getFrom_co_id()+" and bill_no='"+purHdr.getInv_no()+"'";
   		 System.out.println("SQL111===> "+sql);
   		Query q= session1.createSQLQuery(sql);
   		q.executeUpdate();
   			
       		
       	}
		
		if(purHdr.getVr_type().equals("SDTAG"))
       	{
       		
       		Session session1 = sessionFactory.getCurrentSession();
   		 String sql="update cr_sale_hd set accepted='Y' where co_id="+purHdr.getFrom_co_id()+" and bill_no='"+purHdr.getInv_no()+"'";
   		 System.out.println("SQL2222===> "+sql);
   		purHdr.setVr_type("PURC");
   		Query q= session1.createSQLQuery(sql);
   		q.executeUpdate();
   			
       		
       	}
		Query qs = (Query) session.createSQLQuery("CALL sp_slno_update(:param_date,:param_co_id,:param_hdr,:param_updateId)");
    	//qs.setParameter("param_design_no",desg);
 		qs.setParameter("param_date", purHdr.getPur_dt());
 		qs.setParameter("param_co_id", purHdr.getCo_id());
 	//	qs.setParameter("param_qty", purHdr.getQty()[j]);
 		qs.setParameter("param_hdr", param_type);
 		qs.setParameter("param_updateId", purHdr.getUpdateId());
 		qs.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
    	 
		System.out.println("Done");
		return purHdr.getPur_no();
	}
	
	@Override
	public String purchaseReturnEntry(PurDataHdr purHdr) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		//List<RetailRegistrationBean> data= null;
		UtilityHelper u = new UtilityHelper();
		try{
		  List<PurDataDtl> purDtlList=new ArrayList<PurDataDtl>();	
		 Session session = sessionFactory.getCurrentSession();
		 purHdr.setPur_typ("PR");
		 String x[]=u.findFinalUpdatedId("PURR",String.valueOf(purHdr.getCo_id()),"PURC");
			String memo_no=x[0];
			int idp=Integer.parseInt(x[1]);
			purHdr.setRef_pur_no(purHdr.getPur_no());
			purHdr.setPur_no(memo_no);
			System.out.println("idp is:-"+idp);
			purHdr.setUpdateId(idp);
		 session.save(purHdr);
		
		 Date now = new Date();
		 PurDataDtl purdtl = null;  	
		 PurchaseOtherHeadDtlBean puroth=null;
  		 
  		 
  		int i=0;     	
  		String desg="";
       	
       	for(int j=0;j<purHdr.getDesg_id().length;j++)
       	{
       		if(purHdr.getDesg_id()[j]!=0 && purHdr.getQty()[j]!=0){
       		purdtl =new PurDataDtl();
       		purdtl.setCo_id(purHdr.getCo_id());
       		//purdtl.setUom_id(purHdr.getUom_id()[j]);
       		purdtl.setDesg_id(purHdr.getDesg_id()[j]); 
       		desg=u.findDesignByDisgnId(purHdr.getDesg_id()[j]);
       		purdtl.setDesg_no(desg);
       		purdtl.setItm_typ_id(purHdr.getItem_typ_id()[j]); 
       		purdtl.setItm_id(purHdr.getItem_id()[j]); 
       		purdtl.setQty(purHdr.getQty()[j]);        	
       		purdtl.setRate(purHdr.getRate()[j]);        	
       		purdtl.setDis_per(purHdr.getDis_per()[j]);    
       		purdtl.setDis_amt(purHdr.getDis_amt()[j]);     
       		purdtl.setGst_per(purHdr.getGst_per()[j]);
       		purdtl.setRet_qty(purHdr.getDiffqty()[j]);
       		purdtl.setActive("Y");
       		purdtl.setAmt(purHdr.getAmt()[j]); 
       		//purdtl.setVr_type("PURC");
       		purdtl.setCreated_by(purHdr.getCreated_by());
       		purdtl.setBasic_amt(purHdr.getBasic()[j]);
       		purdtl.setCreated_on(now);
       		purdtl.setPurdatahdr(purHdr);
       		session.save(purdtl);
       		
       	 if(!desg.equals("MISC"))
         {
//         		Query q = (Query) session.createSQLQuery("CALL sp_stock_maintnce(:param_design_no,:param_date,:param_co_id,:param_qty,:param_hdr,:param_updateId)");
//         		
//         		q.setParameter("param_design_no",desg);
//         		q.setParameter("param_date", purHdr.getPur_dt());
//         		q.setParameter("param_co_id", purHdr.getCo_id());
//         		q.setParameter("param_qty", purHdr.getQty()[j]);
//         		q.setParameter("param_hdr", "purret");
//         		q.setParameter("param_updateId", purHdr.getUpdateId());
         		
  Query q = (Query) session.createSQLQuery("CALL sp_stock_maintnce(:param_design_no,:param_date,:param_item_id,:param_itemtyp_id,:param_co_id,:param_qty,:param_hdr,:param_updateId)");
       		
       		q.setParameter("param_design_no",desg);
       		q.setParameter("param_date", purHdr.getPur_dt());
       		q.setParameter("param_item_id", purHdr.getItem_id()[j]);
         		q.setParameter("param_itemtyp_id", purHdr.getItem_typ_id()[j]);
       		q.setParameter("param_co_id", purHdr.getCo_id());
       		
       		q.setParameter("param_qty", purHdr.getQty()[j]);
       		q.setParameter("param_hdr", "purret");
       		q.setParameter("param_updateId", purHdr.getUpdateId());
         		
         		q.executeUpdate();
         }
         else
         {
      	   Query q = (Query) session.createSQLQuery("CALL sp_stock_maintnce(:param_design_no,:param_date,:param_item_id,:param_itemtyp_id,:param_co_id,:param_qty,:param_hdr,:param_updateId)");
      		
      		q.setParameter("param_design_no",desg);
      		q.setParameter("param_date", purHdr.getPur_dt());
      		q.setParameter("param_item_id", purHdr.getItem_id()[j]);
        		q.setParameter("param_itemtyp_id", purHdr.getItem_typ_id()[j]);
      		q.setParameter("param_co_id", purHdr.getCo_id());
      		
      		q.setParameter("param_qty", purHdr.getQty()[j]);
      		q.setParameter("param_hdr", "purret");
      		q.setParameter("param_updateId", purHdr.getUpdateId());
       		q.executeUpdate();
         }
       }
       
       		//UtilityHelper u =new UtilityHelper();
       		desg=u.findDesignByDisgnId(purdtl.getDesg_id());
       		
       System.out.println("PARAMS=> "+desg+","+purHdr.getPur_dt()+","+purHdr.getQty());
       		//call sp_stock_maintnce('new2','2018-05-01',2,5.0,'purret');
      
       	}
       	
       	for(int j=0;j<purHdr.getMiscH().length;j++)
       	{
    		if(purHdr.getMiscH()[j]!=0){
    		puroth = new PurchaseOtherHeadDtlBean();    		
       		puroth.setMiscH(purHdr.getMiscH()[j]);
       		puroth.setMiscHamt(purHdr.getMiscHamt()[j]);
       		puroth.setO_amt(purHdr.getO_amt()[j]);
       		puroth.setO_cal_typ(purHdr.getO_cal_typ()[j]);
       		puroth.setActive("Y");
       		puroth.setO_igst_amt(purHdr.getO_igst_amt()[j]);
       		puroth.setO_sgst_amt(purHdr.getO_sgst_amt()[j]);
       		puroth.setO_cgst_amt(purHdr.getO_cgst_amt()[j]);
       		puroth.setO_gst_per(purHdr.getO_gst_per()[j]);
       		puroth.setCreated_by(purHdr.getCreated_by());
       		puroth.setCreated_on(now);
       		puroth.setPurdatahdr(purHdr);
       		session.save(puroth);
    		}
       	}
       	Query qs = (Query) session.createSQLQuery("CALL sp_slno_update(:param_date,:param_co_id,:param_hdr,:param_updateId)");
    	//qs.setParameter("param_design_no",desg);
 		qs.setParameter("param_date", purHdr.getPur_dt());
 		qs.setParameter("param_co_id", purHdr.getCo_id());
 	//	qs.setParameter("param_qty", purHdr.getQty()[j]);
 		qs.setParameter("param_hdr", "purret");
 		qs.setParameter("param_updateId", purHdr.getUpdateId());
 		qs.executeUpdate();
       	
    
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
    	 
		System.out.println("Done"+purHdr.getPur_no());
		
		return purHdr.getPur_no();
	}
	
	@Override
	public List<PurDataViewBean> getPurchaseDetails(String co) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		 String sql="SELECT c.co_nm as co_nm,t.pur_id as pur_id, t.pur_no as pur_no, t.pur_dt as pur_dt, t.inv_no as inv_no, t.inv_dt as inv_dt, t.party_cd as party_cd, t.pur_typ as pur_typ, t.tot_amt as tot_amt, t.tot_disc as tot_disc, t.tot_gst as tot_gst, t.net_amt as net_amt, t.round_off as round_off,"
+"t.created_by as created_by, t.created_on as created_on, t.modified_by as modified_by, t.modified_on as modified_on, t.active as active, t.tot_bas_amt as tot_bas_amt, "
+ "t.tot_dis_amt as tot_dis_amt, t.tot_cgst_amt as tot_cgst_amt, t.tot_sgst_amt as tot_sgst_amt,t.tot_igst_amt as tot_igst_amt,"
+ " t.pay_terms as pay_terms FROM trn_pur_hdr t join mst_company c on(t.co_id=c.co_id) where t.co_id='"+co+"'";

		 System.out.println("SQL++ "+sql);
		 
		 Query q= session.createSQLQuery(sql).addScalar("co_nm").addScalar("pur_id").addScalar("pur_no").addScalar("pur_dt").addScalar("inv_no").
				 addScalar("inv_dt").addScalar("party_cd").addScalar("pur_typ").addScalar("tot_amt").addScalar("tot_disc").addScalar("tot_gst").
				 addScalar("net_amt").addScalar("round_off").addScalar("tot_bas_amt").addScalar("tot_dis_amt").addScalar("tot_cgst_amt")
				 .addScalar("tot_sgst_amt").addScalar("tot_igst_amt").addScalar("pay_terms").setResultTransformer(Transformers.aliasToBean(PurDataViewBean.class));
			//return sessionFactory.getCurrentSession().createQuery("from RetailDesignBean where active='Y'").list();
		return q.list();
	}
	
	@Override
	public List<AutocompleteDesignBean> fetchDesign(String id) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		 String sql="select desg_no as id,desg_no as label,'1' as description from mst_design a where a.active='Y' and desg_no like '"+id+"%'";
		 System.out.println(sql);
		 Query q= session.createSQLQuery(sql).addScalar("id").addScalar("label").addScalar("description").setResultTransformer(Transformers.aliasToBean(AutocompleteDesignBean.class));
		 List<AutocompleteDesignBean> data=new ArrayList<AutocompleteDesignBean>();
			//return sessionFactory.getCurrentSession().createQuery("from RetailDesignBean where active='Y'").list();
		
			data=q.list();
			return data;
	}
	
}
