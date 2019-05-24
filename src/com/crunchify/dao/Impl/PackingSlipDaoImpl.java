package com.crunchify.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crunchify.dao.CashSaleDao;
import com.crunchify.dao.PackingSlipDao;
import com.crunchify.dao.RetailDesignDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.CashSaleDtlBean;
import com.crunchify.model.CashSaleHdrBean;
import com.crunchify.model.CashSaleOtherHeadDtlBean;
import com.crunchify.model.PackingSlipDtlBean;
import com.crunchify.model.PackingSlipHdrBean;
import com.crunchify.model.PackingSlipOtherHeadDtlBean;
import com.crunchify.model.RetailDesignBean;
import com.crunchify.model.RetailDesignBeanDtl;
import com.crunchify.util.UtilityHelper;

@Repository
public class PackingSlipDaoImpl implements PackingSlipDao {

	@Autowired
	   private SessionFactory sessionFactory;
	
	
	


	@Override
	public String addPackingSlip(PackingSlipHdrBean slip)
			throws SpringCrunchifyException {
		Session session = sessionFactory.getCurrentSession();
		UtilityHelper util=new UtilityHelper();
		slip.setOrg_id(util.findOrgIdByCoId(slip.getCo_id()));
		String memo_no=null;
		int idp=0;
		if(slip.getSlp_type().equalsIgnoreCase("CRSA"))
		{
		 String x1[]=util.findFinalUpdatedId("CRSA", String.valueOf(slip.getCo_id()),"PKSL");
		 memo_no=x1[0];
	idp=Integer.parseInt(x1[1]);
		System.out.println("idp is:-"+idp);
		}
		else
		{
		String x1[]=util.findFinalUpdatedId("STKO", String.valueOf(slip.getCo_id()),"PKSL");
		 memo_no=x1[0];
	idp=Integer.parseInt(x1[1]);
			System.out.println("idp is:-"+idp);	
		}
		slip.setPck_sl_no(memo_no);
		slip.setUpdateId(idp);
		session.save(slip);
		PackingSlipDtlBean packingSlipDtlBean=null;
		for(int i=0;i<slip.getDesg_id().length;i++)
		{
			String x=slip.getDesg_id()[i];
			if(!x.equals("") && x!=null){
			packingSlipDtlBean=new PackingSlipDtlBean();
			packingSlipDtlBean.setDesg_id(slip.getDesg_id()[i]);
			packingSlipDtlBean.setSl_no(i);
			packingSlipDtlBean.setBarcode(slip.getBarcode()[i]);
			packingSlipDtlBean.setItem_typ_id(slip.getItem_typ_id()[i]);
			packingSlipDtlBean.setItem_id(slip.getItem_id()[i]);
			packingSlipDtlBean.setHsn_cd(slip.getHsn_cd()[i]);
			packingSlipDtlBean.setQty(slip.getQty()[i]);
			packingSlipDtlBean.setRate(slip.getRate()[i]);
			packingSlipDtlBean.setUom_id(slip.getUom_id()[i]);
			packingSlipDtlBean.setDis_per(slip.getDis_per()[i]);
			packingSlipDtlBean.setDis_amt(slip.getDis_amt()[i]);
			packingSlipDtlBean.setGst_per(slip.getGst_per()[i]);
			packingSlipDtlBean.setCgst_amt(slip.getCgst_amt()[i]);
			packingSlipDtlBean.setSgst_amt(slip.getSgst_amt()[i]);
			packingSlipDtlBean.setIgst_amt(slip.getIgst_amt()[i]);
			packingSlipDtlBean.setBasic(slip.getBasic()[i]);
			packingSlipDtlBean.setAmt(slip.getAmt()[i]);
			packingSlipDtlBean.setCo_id(slip.getCo_id());
			packingSlipDtlBean.setCreated_by(slip.getCreated_by());
			packingSlipDtlBean.setCreated_on(slip.getCreated_on());
			packingSlipDtlBean.setActive(slip.getActive());
			packingSlipDtlBean.setPackingsliphdrbean(slip);
			session.save(packingSlipDtlBean);
			}
		}
		
		PackingSlipOtherHeadDtlBean packingSlipOtherHeadDtlBean=null;
		for(int j=0;j<slip.getMiscH().length;j++)
		{packingSlipOtherHeadDtlBean=new PackingSlipOtherHeadDtlBean();	
			if(slip.getMiscH()[j]!=0)
			{
				packingSlipOtherHeadDtlBean.setActive("Y");
				packingSlipOtherHeadDtlBean.setMiscH(slip.getMiscH()[j]);
				packingSlipOtherHeadDtlBean.setMiscHamt(slip.getMiscHamt()[j]);
				packingSlipOtherHeadDtlBean.setCreated_by(slip.getCreated_by());
				packingSlipOtherHeadDtlBean.setCreated_on(slip.getCreated_on());
				packingSlipOtherHeadDtlBean.setO_amt(slip.getO_amt()[j]);
				packingSlipOtherHeadDtlBean.setO_cgst_amt(slip.getO_cgst_amt()[j]);
				packingSlipOtherHeadDtlBean.setO_gst_per(slip.getO_gst_per()[j]);
				packingSlipOtherHeadDtlBean.setO_igst_amt(slip.getO_igst_amt()[j]);
				packingSlipOtherHeadDtlBean.setO_sgst_amt(slip.getO_sgst_amt()[j]);
				packingSlipOtherHeadDtlBean.setO_cal_typ(slip.getO_cal_typ()[j]);
				//packingSlipOtherHeadDtlBean.set;
				packingSlipOtherHeadDtlBean.setPackingsliphdrbean(slip);
				session.save(packingSlipOtherHeadDtlBean);
			}
		}
		int p=util.updateSerialNumber(slip.getSlp_type(),slip.getUpdateId());
		if(p>0){
		return slip.getPck_sl_no();
		}else{
			return null;	
		}
	}

}
