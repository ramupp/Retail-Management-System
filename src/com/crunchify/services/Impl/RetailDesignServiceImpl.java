package com.crunchify.services.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.crunchify.dao.RetailDesignDao;
import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.RetailDesignBean;
import com.crunchify.model.view.DesignViewBean;
import com.crunchify.model.view.RetailDesignViewBean;
import com.crunchify.services.RetailDesignService;

@Service
@Transactional 
public class RetailDesignServiceImpl implements RetailDesignService {
	@Autowired
	RetailDesignDao retailDesignDao;
	
	
	@Override
	public String fetchAllDesign(String code)
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		 List<RetailDesignBean> list=new ArrayList<RetailDesignBean>();
		 int flag=0;
		list= retailDesignDao.fetchAllDesign();
		for (RetailDesignBean retailDesignBean : list) {
			if(retailDesignBean.getBar_code().equals(code))
			{
				flag=1;
				break;
			}
		}
		if(flag==0)
		{
		return "again";	
		}
		else{
			return code;
		}
	}
	@Override
	public String addDesign(RetailDesignBean desg)
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return retailDesignDao.addDesign(desg);
	}
	@Override
	public List<RetailDesignBean> fetchDesignDetails()
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		 List<RetailDesignBean> list=new ArrayList<RetailDesignBean>();
		 List<RetailDesignViewBean> view=new ArrayList<RetailDesignViewBean>();
		 RetailDesignViewBean retailDesignViewBean=null;
		 list= retailDesignDao.fetchAllDesign();
		 for (RetailDesignBean retailDesignBean : list) {
			 retailDesignViewBean=new RetailDesignViewBean();
			 retailDesignViewBean.setDesg_no(retailDesignBean.getDesg_no());
			 retailDesignViewBean.setTr_id(retailDesignBean.getTr_id());
			 retailDesignViewBean.setV_desg_no(retailDesignBean.getV_desg_no());
			 retailDesignViewBean.setDesg_on(retailDesignBean.getDesg_on());
			 retailDesignViewBean.setDesign_by(retailDesignBean.getDesign_by());
			 
			 
			//rtlView.set
		}
		 return list; 
		 
	}
	
	@Override
	public List<DesignViewBean> fetchDesignDetails1()
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		 
		return  retailDesignDao.fetchAllDesign1();
		 
	
		 
	}
	@Override
	public String updateDesign(RetailDesignBean desg)
			throws SpringCrunchifyException {
		// TODO Auto-generated method stub
		return retailDesignDao.updateDesign(desg);
	}

}
