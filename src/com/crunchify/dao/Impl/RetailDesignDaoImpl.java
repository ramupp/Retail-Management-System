package com.crunchify.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crunchify.dao.RetailDesignDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.RetailDesignBean;
import com.crunchify.model.RetailDesignBeanDtl;
import com.crunchify.model.view.DesignViewBean;
import com.crunchify.util.UtilityHelper;

@Repository
public class RetailDesignDaoImpl implements RetailDesignDao {

	@Autowired
	   private SessionFactory sessionFactory;
	
	@Override
	public List<DesignViewBean> fetchAllDesign1()
			throws SpringCrunchifyException {
		 Session session = sessionFactory.getCurrentSession();
		 String sql="select a.tr_id as tr_id, desg_no as desg_no, v_desg_no as v_desg_no, desg_on as desg_on, desg_desc as desg_desc, a.item_typ,b.itm_typ_nm as item_typ_nm, a.item_id,c.itm_nm as item_id_nm,"+
		 " bar_code as bar_code, design_by as design_by ,d.party_nm as design_by_nm, a.created_by as created_by, a.created_on as created_on, a.modified_by, a.modified_on, file_name, cost as cost from mst_design a join mst_itm_typ b on(a.item_typ=b.itm_typ_id) "+
		 " join mst_fp_itm c on (a.item_id=c.itm_id and a.item_typ=c.itm_typ_id) join mst_party d on(a.design_by=d.party_id) where a.active='Y'";
		 System.out.println("the fetch sql is:-"+sql);
		 Query q= session.createSQLQuery(sql).addScalar("tr_id").addScalar("desg_no").addScalar("v_desg_no").addScalar("desg_on").
				 addScalar("desg_desc").addScalar("bar_code").addScalar("design_by").addScalar("created_by").addScalar("created_on").addScalar("item_typ_nm").addScalar("item_id_nm").addScalar("design_by_nm").addScalar("cost").setResultTransformer(Transformers.aliasToBean(DesignViewBean.class));
			//return sessionFactory.getCurrentSession().createQuery("from RetailDesignBean where active='Y'").list();
		return q.list();
	}
	
	@Override
	public List<RetailDesignBean> fetchAllDesign()
			throws SpringCrunchifyException {
		 Session session = sessionFactory.getCurrentSession();
		 
		 Query q= session.createQuery("from RetailDesignBean where active='Y'");
			//return sessionFactory.getCurrentSession().createQuery("from RetailDesignBean where active='Y'").list();
		return q.list();
	}
	
	@Override
	public String addDesign(RetailDesignBean desg)
			throws SpringCrunchifyException {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(desg);
		RetailDesignBeanDtl retailDesignBeanDtl=null;
		UtilityHelper util=new UtilityHelper();
		for(int i=0;i<desg.getCo_id().length;i++)
		{
			retailDesignBeanDtl=new RetailDesignBeanDtl();
			retailDesignBeanDtl.setCo_id(desg.getCo_id()[i]);
			retailDesignBeanDtl.setRt_type(desg.getRt_type()[i]);
			retailDesignBeanDtl.setRate(desg.getRate()[i]);
			retailDesignBeanDtl.setRemarks(desg.getRemarks()[i]);
			retailDesignBeanDtl.setDefault_rate(desg.getDefault_rate()[i]);
			retailDesignBeanDtl.setOrg_id(util.findOrgIdByCoId(desg.getCo_id()[i]));
			retailDesignBeanDtl.setrCode(desg.getrCode()[i]);
			retailDesignBeanDtl.setSale_type(desg.getSale_type()[i]);
			retailDesignBeanDtl.setActive("Y");
			retailDesignBeanDtl.setCreated_by(desg.getCreated_by());
			retailDesignBeanDtl.setCreated_on(desg.getCreated_on());
			retailDesignBeanDtl.setRetaildesignbean(desg);
			session.saveOrUpdate(retailDesignBeanDtl);
		}
		return "success";
	}
	@Override
	public String updateDesign(RetailDesignBean desg)
			throws SpringCrunchifyException {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(desg);
		RetailDesignBeanDtl retailDesignBeanDtl=null;
		UtilityHelper util=new UtilityHelper();
		for(int i=0;i<desg.getCo_id().length;i++)
		{
			retailDesignBeanDtl=new RetailDesignBeanDtl();
			retailDesignBeanDtl.setTr_id(desg.getTr_ids()[i]);
			retailDesignBeanDtl.setCo_id(desg.getCo_id()[i]);
			retailDesignBeanDtl.setRt_type(desg.getRt_type()[i]);
			retailDesignBeanDtl.setRate(desg.getRate()[i]);
			retailDesignBeanDtl.setRemarks(desg.getRemarks()[i]);
			retailDesignBeanDtl.setDefault_rate(desg.getDefault_rate()[i]);
			retailDesignBeanDtl.setOrg_id(util.findOrgIdByCoId(desg.getCo_id()[i]));
			retailDesignBeanDtl.setrCode(desg.getrCode()[i]);
			retailDesignBeanDtl.setSale_type(desg.getSale_type()[i]);
			retailDesignBeanDtl.setActive("Y");
			retailDesignBeanDtl.setCreated_by(desg.getCreated_by());
			retailDesignBeanDtl.setCreated_on(desg.getCreated_on());
			retailDesignBeanDtl.setRetaildesignbean(desg);
			session.saveOrUpdate(retailDesignBeanDtl);
		}
		return "success";
	}

}
