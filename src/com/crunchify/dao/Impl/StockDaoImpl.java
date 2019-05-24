package com.crunchify.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crunchify.dao.RetailRoleDao;
import com.crunchify.dao.StockDao;
import com.crunchify.exception.SpringCrunchifyException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.crunchify.model.RetailRegistrationBean;
import com.crunchify.model.RoleDataDtl;
import com.crunchify.model.RoleDataHdr;
import com.crunchify.model.StockData;
import com.crunchify.model.StockDataRm;
import com.crunchify.model.UserRegRoleCompany;
import com.crunchify.model.UserRoleCompany;
import com.crunchify.model.view.CashSaleViewBean;
import com.crunchify.model.view.CrSaleViewBean;
import com.crunchify.util.UtilityHelper;

@Repository
public class StockDaoImpl implements StockDao {
	@Autowired
	   private SessionFactory sessionFactory;
	
	
	@Override
	public String stockEntry(StockData stData) throws SpringCrunchifyException {
		Session session1	 = sessionFactory.getCurrentSession();
		 double cl = stData.getOp_bal() + stData.getPurch() - stData.getPur_ret() - stData.getCash_sal() - stData.getCr_sal() + stData.getSale_ret();		 
		 stData.setCl_bal(cl);	
		 
		 Date now = new Date();
		 stData.setOp_bal(0.00);
		 //stData.setOp_stk(stData.getCl_bal());
		 stData.setStk_dt(now);
		 stData.setCreated_on(now);
		 stData.setActive("Y");
		 Session session = sessionFactory.getCurrentSession();
		 // int site1 = ((Integer)session1.getAttribute("site_code")).intValue();
		 // this.session = HibernateUtil.getSession();
		 //this.transaction = this.session.beginTransaction();
		
		 Query q= session.createQuery("update StockData set active=:active where item_id=:item_id and item_type_id=:item_type_id and desg_no=:desg_no and co_id=:co_id");
		  
	 	  q.setParameter("item_id", stData.getItem_id()); 
	      q.setParameter("item_type_id", stData.getItem_type_id()); 
		      q.setParameter("desg_no", stData.getDesg_no());
		      q.setParameter("co_id", stData.getCo_id());
		      q.setParameter("active", "N");
		      
		     q.executeUpdate();
//		
//		     this.transaction.commit();
//		 
		 
		 
		 session1.save(stData);
 	 
    	 
		System.out.println("Done");
		return "success";
	}
	
	
	@Override
	public String stockEntryRm(StockDataRm stDataRm) throws SpringCrunchifyException {
		Session session1	 = sessionFactory.getCurrentSession();
		 double cl = stDataRm.getOp_bal() + stDataRm.getPurch() - stDataRm.getPur_ret() - stDataRm.getCash_sal() - stDataRm.getCr_sal() + stDataRm.getSale_ret();		 
		 stDataRm.setCl_bal(cl);	
		 
		 Date now = new Date();
		 stDataRm.setOp_bal(0.00);
		 //stData.setOp_stk(stData.getCl_bal());
		 stDataRm.setStk_dt(now);
		 stDataRm.setCreated_on(now);
		 stDataRm.setActive("Y");
		 Session session = sessionFactory.getCurrentSession();
		     // int site1 = ((Integer)session1.getAttribute("site_code")).intValue();
		 
		// this.session = HibernateUtil.getSession();
	  //this.transaction = this.session.beginTransaction();
		
		 Query q= session.createQuery("update StockDataRm set active=:active where item_id=:item_id and item_type_id=:item_type_id and co_id=:co_id");
		 
		 	  q.setParameter("item_id", stDataRm.getItem_id()); 
		      q.setParameter("item_type_id", stDataRm.getItem_type_id()); 
		      q.setParameter("co_id", stDataRm.getCo_id());
		      q.setParameter("active", "N");
		      
		     q.executeUpdate();
//		
//		     this.transaction.commit();
//		 
		 
		 
		 session1.save(stDataRm);
 	 
    	 
		System.out.println("Done");
		return "success";
	}
	
	
	@Override
	public List<CrSaleViewBean> getStockTransAcknow(String co_id) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		 String sql1="SELECT a.tr_hid as tr_hid,a.pck_sl_no as pck_sl_no,a.pck_sl_dt as pck_sl_dt, a.co_id as co_id,concat(b.co_nm,'-',b.outlet) as co_nm, "+
	" a.no_of_pck as no_of_pck, a.tot_qty as tot_qty, a.finBasic as finBasic, a.bill_no as bill_no,a.bill_dt as bill_dt,a.amt_in_word as amt_in_word, a.fin_dis_amt as fin_dis_amt, a.fin_cgst_amt as fin_cgst_amt,"+
	" a.fin_sgst_amt as fin_sgst_amt, a.fin_igst_amt as fin_igst_amt, a.net_amt as net_amt,"+
	"  a.active as active, "+
	 " (SELECT sm_nm FROM mst_sales_man where sm_id=a.salesman) as salesman,"+
	 " (SELECT sm_nm FROM mst_sales_man where sm_id=a.helper) as helper FROM cr_sale_hd a join mst_company b on(a.co_id=b.co_id) right join mst_party m on(m.party_id=a.party_id) where a.active='Y' and a.accepted='N'  and m.co_id="+co_id;

		 String sql2=" union SELECT a.tr_hid as tr_hid,a.pck_sl_no as pck_sl_no,a.pck_sl_dt as pck_sl_dt, a.co_id as co_id,concat(b.co_nm,'-',b.outlet) as co_nm, "+
					" a.no_of_pck as no_of_pck, a.tot_qty as tot_qty, a.finBasic as finBasic, a.bill_no as bill_no,a.bill_dt as bill_dt,a.amt_in_word as amt_in_word, a.fin_dis_amt as fin_dis_amt, a.fin_cgst_amt as fin_cgst_amt,"+
					" a.fin_sgst_amt as fin_sgst_amt, a.fin_igst_amt as fin_igst_amt, a.net_amt as net_amt,"+
					"  a.active as active, "+
					 " (SELECT sm_nm FROM mst_sales_man where sm_id=a.salesman) as salesman,"+
					 " (SELECT sm_nm FROM mst_sales_man where sm_id=a.helper) as helper FROM cr_sale_hd a join mst_company b on(a.co_id=b.co_id) right join mst_party m on(m.party_id=a.party_id) where a.active='Y' and a.accepted='N' and m.sd_tag='Y' and m.co_id="+co_id;
String sql=sql1+sql2;
		System.out.println("the sql is:-"+sql); 
		 Query q= session.createSQLQuery(sql).addScalar("tr_hid").addScalar("pck_sl_no").addScalar("pck_sl_dt").addScalar("co_nm").addScalar("no_of_pck").addScalar("tot_qty").
				 addScalar("finBasic").addScalar("bill_no").addScalar("bill_dt").addScalar("amt_in_word").addScalar("fin_dis_amt").addScalar("fin_cgst_amt").
				 addScalar("fin_sgst_amt").addScalar("fin_igst_amt").addScalar("net_amt").addScalar("salesman").
				 addScalar("helper").setResultTransformer(Transformers.aliasToBean(CrSaleViewBean.class));
			//return sessionFactory.getCurrentSession().createQuery("from RetailDesignBean where active='Y'").list();
		return q.list();
	}
	
//	   { name: "tr_hid", type: "text", width: 50, validate: "required",title : "ID" },
//	     { name: "pck_sl_no", type: "text", width: 50,title : "Packing Slip No"  },
//	     { name: "pck_sl_dt", type: "text", width: 50,title : "Packing Slip Data"  },
//	     { name: "co_nm", type: "text", width: 50 ,title : "Outlet" },
//	     { name: "no_of_pck", type: "text", width: 50,title : "No. of Packing"  },
//	     { name: "tot_qty", type: "text", width: 50,title : "Total Quantity"  },
//	     { name: "finBasic", type: "text", width: 50,title : "Basic"  },
//	     { name: "bill_no", type: "text", width: 50,title : "Bill No"  },
//	     { name: "bill_dt", type: "text", width: 50,title : "Bill Date"  },
//	     { name: "amt_in_word", type: "text", width: 50,title : "Amount In Word"  },
//	     { name: "fin_dis_amt", type: "text", width: 50,title : "Discount Amount"  },
//	     { name: "fin_igst_amt", type: "text", width: 50,title : "Discount IGST"  },
//	     { name: "fin_cgst_amt", type: "text", width: 50,title : "Discount CGST"  },
//	     { name: "fin_sgst_amt", type: "text", width: 50,title : "Discount SGST"  },
//	     { name: "salesman", type: "text", width: 50,title : "Salesman"  },
//	     { name: "helper", type: "text", width: 50,title : "Helper"  },
	
	
	
	@Override
	public List<StockData> stockView(StockData stData) throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		List<StockData> data= null;
		 Session session = sessionFactory.getCurrentSession();
		 StockData st= new StockData();
		 String sql = "";
		 System.out.println("CompanyId====> " + stData.getCo_id());
		 System.out.println("Design===> " + stData.getDesg_no());
		 Query q=null;
		 /*Sunando*/
		 if(stData.getCo_id()!=-999 && !stData.getDesg_no().equals("-999"))
		 {
			 sql = "from StockData where co_id  = :co_id and desg_no like :desg_no and active='Y'";	
			 q= session.createQuery(sql);
			 q.setParameter("co_id", stData.getCo_id());
			 q.setParameter("desg_no", stData.getDesg_no()+"%");
		 }
		 if(stData.getCo_id()==-999 && stData.getDesg_no().equals("-999"))
		 {
			 sql="from StockData where active='Y'";
			q= session.createQuery(sql);
			// q.setParameter("co_id", stData.getCo_id()+"%");
			// q.setParameter("desg_no", stData.getDesg_no()+"%");
		 }
		 
		 if(stData.getCo_id()!=-999 && stData.getDesg_no().equals("-999"))
		 {
			 sql = "from StockData where co_id  = :co_id and active='Y')";	
		 q= session.createQuery(sql);
			 q.setParameter("co_id", stData.getCo_id());
			// q.setParameter("desg_no", stData.getDesg_no()+"%");
		 }
		 if(stData.getCo_id()==-999 && !stData.getDesg_no().equals("-999"))
		 {
			 sql = "from StockData where desg_no like :desg_no and active='Y'";	
	q= session.createQuery(sql);
			// q.setParameter("co_id", stData.getCo_id()+"%");
			 q.setParameter("desg_no", stData.getDesg_no()+"%");
		 }
		 
		 
		 
		
		 data=q.list();
		 UtilityHelper uob=new UtilityHelper();
		 System.out.println("data size is:-"+ data.size());
		  for(int i=0;i<data.size();i++){
		 int itm_id=data.get(i).getItem_id();
		 int itm_typ_id=data.get(i).getItem_type_id();
		
		String iname= uob.findItemNameById(itm_id);
		String itname= uob.findItemTypeNameById(itm_typ_id);
		System.out.println("co id is:-"+stData.getCo_id());
		String compnm=uob.findCoNameFromId(data.get(i).getCo_id());
		st.setItm_nm(iname);
		st.setItm_typ_nm(itname);
		st.setComp_nm(compnm);
		data.get(i).setItm_typ_nm(itname);
		data.get(i).setItm_nm(iname);
		data.get(i).setComp_nm(compnm);
		  }
		 	return data;
	}


}
