package com.crunchify.model;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name= "cash_sale_hd")
public class CashSaleHdrBean implements Serializable{
//itm_typ_id, itm_typ_nm, created_by, created_on, modified_by, modified_on, active
	private static final long serialVersionUID = 1L;
				@Id
				@GeneratedValue
				private int tr_hid; 		
				  private int co_id; 		
				  private int org_id; 
				 
				  private String memo_no; 		
				  private Date tr_dt	;	
				  private String cust_name ;	
				  private String cust_add1 ;	
				  private String cust_add2 ;	
				  private String cust_mob 	;
				  private String cust_email 	;
				  private String user_id	;
				  private double finBasic;
				  private String salesman;
				  private String helper;
				  private String vr_type;
				  private String uid;
				  private String r_memo_no;
				  private double adj_amt;
				  
				  @Transient
				  private int updateId;
				 // private double tot_amt 		;
				  @Transient
				  private double tot_bas_amt;
				  @Transient
				  private double tot_dis_amt;
				  @Transient
				  private double tot_cgst_amt;
				  @Transient
				  private double tot_sgst_amt;
//				  @Transient
//				  private double tot_igst_amt;
				  @Transient
				  private double tot_amt;
				  
				  private String amt_in_word;
				  
				  private double fin_dis_amt 	;
				  private double fin_cgst_amt 	;
				  private double fin_sgst_amt 	;
//				  private double fin_igst_amt 	;
				  private double net_amt	;
				  private String pay_type 	;
				  private double pay_amt 		;
				  private double bal_amt 		;
				  private String doc_no 		;
				  private Date doc_dt 		;
				  private String drawn_on 	;
				  
				  private String pay_type1 	;
				  private double pay_amt1		;
				 
				  private String doc_no1 		;
				  private Date doc_dt1 		;
				  private String drawn_on1 	;
				  private String remarks 		;
				  private String created_by 	;
				  private Date created_on 	;
				  private String modified_by 	;
				  private Date modified_on 	;
				  private String active	;
				  @Transient
				  private int item_typ_id[];
				  @Transient
				  private String hsn_cd[];
				  @Transient
				  private int item_id[] ;
				  @Transient
				  private String desg_id[] ;
				  @Transient
				  private String barcode[];
				  @Transient
				  private String stk[];
				  @Transient
				  private int qty[] ;
				  @Transient
				  private int qty1[] ;
				  @Transient
				  private int nuom_id[];
				  @Transient
				  private String uom_id[];
				  @Transient
				  private double rate[]; 
				  @Transient
				  private double basic[];
				  @Transient
				  private double dis_per[]; 
				  @Transient
				  private double dis_amt[];
				  @Transient
				  private double cgst_amt[] ;
				  @Transient
				  private double sgst_amt[] ;
//				  @Transient
//				  private double igst_amt[] ;
				  @Transient
				  private double amt[] ;
				  @Transient
				  private double gst_per[];
//				  @Transient
//				  private int miscH[];
//				  @Transient
//				  private double miscHamt[];
//				  @Transient
//				  private double o_gst_per[];
//				  @Transient
//				  private double o_cgst_amt[];
//				  @Transient
//				  private double o_sgst_amt[];
//				  @Transient
//				  private double o_igst_amt[];
//				  @Transient
//				  private double o_amt[];
//				  @Transient
//				  private String o_cal_typ[];
				  
				  @OneToMany(targetEntity=CashSaleDtlBean.class, mappedBy="cashsalehdrbean",cascade = CascadeType.ALL, fetch=FetchType.EAGER)
					 private List<CashSaleDtlBean> cashSaleDtlBean; 
				  
//				  @OneToMany(targetEntity=CashSaleOtherHeadDtlBean.class, mappedBy="cashsalehdrbean",cascade = CascadeType.ALL, fetch=FetchType.EAGER)
//					 private List<CashSaleOtherHeadDtlBean> cashSaleOtherHeadDtlBean; 
				
				  
				public String getR_memo_no() {
					return r_memo_no;
				}
				public void setR_memo_no(String r_memo_no) {
					this.r_memo_no = r_memo_no;
				}
				public double getAdj_amt() {
					return adj_amt;
				}
				public void setAdj_amt(double adj_amt) {
					this.adj_amt = adj_amt;
				}
				public String[] getHsn_cd() {
					return hsn_cd;
				}
				public void setHsn_cd(String[] hsn_cd) {
					this.hsn_cd = hsn_cd;
				}
				public String getUid() {
					return uid;
				}
				public void setUid(String uid) {
					this.uid = uid;
				}
				public String getVr_type() {
					return vr_type;
				}
				public void setVr_type(String vr_type) {
					this.vr_type = vr_type;
				}
				public int[] getNuom_id() {
					return nuom_id;
				}
				public void setNuom_id(int[] nuom_id) {
					this.nuom_id = nuom_id;
				}
				public int getUpdateId() {
					return updateId;
				}
				public void setUpdateId(int updateId) {
					this.updateId = updateId;
				}
//				public List<CashSaleOtherHeadDtlBean> getCashSaleOtherHeadDtlBean() {
//					return cashSaleOtherHeadDtlBean;
//				}
//				public void setCashSaleOtherHeadDtlBean(
//						List<CashSaleOtherHeadDtlBean> cashSaleOtherHeadDtlBean) {
//					this.cashSaleOtherHeadDtlBean = cashSaleOtherHeadDtlBean;
//				}
				public List<CashSaleDtlBean> getCashSaleDtlBean() {
					return cashSaleDtlBean;
				}
				public void setCashSaleDtlBean(List<CashSaleDtlBean> cashSaleDtlBean) {
					this.cashSaleDtlBean = cashSaleDtlBean;
				}
				
				
			
				public String[] getStk() {
					return stk;
				}
				public void setStk(String[] stk) {
					this.stk = stk;
				}
				public int[] getQty1() {
					return qty1;
				}
				public void setQty1(int[] qty1) {
					this.qty1 = qty1;
				}
				public String[] getBarcode() {
					return barcode;
				}
				public void setBarcode(String[] barcode) {
					this.barcode = barcode;
				}
				public String getSalesman() {
					return salesman;
				}
				public void setSalesman(String salesman) {
					this.salesman = salesman;
				}
				public String getHelper() {
					return helper;
				}
				public void setHelper(String helper) {
					this.helper = helper;
				}
				public int[] getItem_typ_id() {
					return item_typ_id;
				}
				public void setItem_typ_id(int[] item_typ_id) {
					this.item_typ_id = item_typ_id;
				}
				public int[] getItem_id() {
					return item_id;
				}
				public void setItem_id(int[] item_id) {
					this.item_id = item_id;
				}
				
				public String[] getDesg_id() {
					return desg_id;
				}
				public void setDesg_id(String[] desg_id) {
					this.desg_id = desg_id;
				}
				public int[] getQty() {
					return qty;
				}
				public void setQty(int[] qty) {
					this.qty = qty;
				}
				public double[] getRate() {
					return rate;
				}
				public void setRate(double[] rate) {
					this.rate = rate;
				}
				public double[] getDis_per() {
					return dis_per;
				}
				public void setDis_per(double[] dis_per) {
					this.dis_per = dis_per;
				}
				
				public double[] getBasic() {
					return basic;
				}
				public void setBasic(double[] basic) {
					this.basic = basic;
				}
				public double[] getCgst_amt() {
					return cgst_amt;
				}
				public void setCgst_amt(double[] cgst_amt) {
					this.cgst_amt = cgst_amt;
				}
				public double[] getSgst_amt() {
					return sgst_amt;
				}
				public void setSgst_amt(double[] sgst_amt) {
					this.sgst_amt = sgst_amt;
				}
//				public double[] getIgst_amt() {
//					return igst_amt;
//				}
//				public void setIgst_amt(double[] igst_amt) {
//					this.igst_amt = igst_amt;
//				}
				public double[] getAmt() {
					return amt;
				}
				public void setAmt(double[] amt) {
					this.amt = amt;
				}
				public double[] getGst_per() {
					return gst_per;
				}
				public void setGst_per(double[] gst_per) {
					this.gst_per = gst_per;
				}
				
				public int getTr_hid() {
					return tr_hid;
				}
				public void setTr_hid(int tr_hid) {
					this.tr_hid = tr_hid;
				}
				public int getCo_id() {
					return co_id;
				}
				public void setCo_id(int co_id) {
					this.co_id = co_id;
				}
				public int getOrg_id() {
					return org_id;
				}
				public void setOrg_id(int org_id) {
					this.org_id = org_id;
				}
				public String getMemo_no() {
					return memo_no;
				}
				public void setMemo_no(String memo_no) {
					this.memo_no = memo_no;
				}
				public Date getTr_dt() {
					return tr_dt;
				}
				public void setTr_dt(Date tr_dt) {
					this.tr_dt = tr_dt;
				}
				public String getCust_name() {
					return cust_name;
				}
				public void setCust_name(String cust_name) {
					this.cust_name = cust_name;
				}
				public String getCust_add1() {
					return cust_add1;
				}
				public void setCust_add1(String cust_add1) {
					this.cust_add1 = cust_add1;
				}
				public String getCust_add2() {
					return cust_add2;
				}
				public void setCust_add2(String cust_add2) {
					this.cust_add2 = cust_add2;
				}
				public String getCust_mob() {
					return cust_mob;
				}
				public void setCust_mob(String cust_mob) {
					this.cust_mob = cust_mob;
				}
				public String getCust_email() {
					return cust_email;
				}
				public void setCust_email(String cust_email) {
					this.cust_email = cust_email;
				}
				public String getUser_id() {
					return user_id;
				}
				public void setUser_id(String user_id) {
					this.user_id = user_id;
				}
			
				
				public double getFinBasic() {
					return finBasic;
				}
				public void setFinBasic(double finBasic) {
					this.finBasic = finBasic;
				}
				public double getFin_dis_amt() {
					return fin_dis_amt;
				}
				public void setFin_dis_amt(double fin_dis_amt) {
					this.fin_dis_amt = fin_dis_amt;
				}
				public double getFin_cgst_amt() {
					return fin_cgst_amt;
				}
				public void setFin_cgst_amt(double fin_cgst_amt) {
					this.fin_cgst_amt = fin_cgst_amt;
				}
				public double getFin_sgst_amt() {
					return fin_sgst_amt;
				}
				public void setFin_sgst_amt(double fin_sgst_amt) {
					this.fin_sgst_amt = fin_sgst_amt;
				}
//				public double getFin_igst_amt() {
//					return fin_igst_amt;
//				}
//				public void setFin_igst_amt(double fin_igst_amt) {
//					this.fin_igst_amt = fin_igst_amt;
//				}
				
				public double getNet_amt() {
					return net_amt;
				}
				public String[] getUom_id() {
					return uom_id;
				}
				public void setUom_id(String[] uom_id) {
					this.uom_id = uom_id;
				}
				public void setNet_amt(double net_amt) {
					this.net_amt = net_amt;
				}
				public String getPay_type() {
					return pay_type;
				}
				public void setPay_type(String pay_type) {
					this.pay_type = pay_type;
				}
				public double getPay_amt() {
					return pay_amt;
				}
				public void setPay_amt(double pay_amt) {
					this.pay_amt = pay_amt;
				}
				public double getBal_amt() {
					return bal_amt;
				}
				public void setBal_amt(double bal_amt) {
					this.bal_amt = bal_amt;
				}
				public String getDoc_no() {
					return doc_no;
				}
				public void setDoc_no(String doc_no) {
					this.doc_no = doc_no;
				}
				public Date getDoc_dt() {
					return doc_dt;
				}
				public void setDoc_dt(Date doc_dt) {
					this.doc_dt = doc_dt;
				}
				public String getDrawn_on() {
					return drawn_on;
				}
				public void setDrawn_on(String drawn_on) {
					this.drawn_on = drawn_on;
				}
				public String getRemarks() {
					return remarks;
				}
				public void setRemarks(String remarks) {
					this.remarks = remarks;
				}
				public String getCreated_by() {
					return created_by;
				}
				public void setCreated_by(String created_by) {
					this.created_by = created_by;
				}
				public Date getCreated_on() {
					return created_on;
				}
				public void setCreated_on(Date created_on) {
					this.created_on = created_on;
				}
				public String getModified_by() {
					return modified_by;
				}
				public void setModified_by(String modified_by) {
					this.modified_by = modified_by;
				}
				public Date getModified_on() {
					return modified_on;
				}
				public void setModified_on(Date modified_on) {
					this.modified_on = modified_on;
				}
				public String getActive() {
					return active;
				}
				public void setActive(String active) {
					this.active = active;
				}
//				public int[] getMiscH() {
//					return miscH;
//				}
//				public void setMiscH(int[] miscH) {
//					this.miscH = miscH;
//				}
//				public double[] getMiscHamt() {
//					return miscHamt;
//				}
//				public void setMiscHamt(double[] miscHamt) {
//					this.miscHamt = miscHamt;
//				}
//				public double[] getO_gst_per() {
//					return o_gst_per;
//				}
//				public void setO_gst_per(double[] o_gst_per) {
//					this.o_gst_per = o_gst_per;
//				}
//				public double[] getO_cgst_amt() {
//					return o_cgst_amt;
//				}
//				public void setO_cgst_amt(double[] o_cgst_amt) {
//					this.o_cgst_amt = o_cgst_amt;
//				}
//				public double[] getO_sgst_amt() {
//					return o_sgst_amt;
//				}
//				public void setO_sgst_amt(double[] o_sgst_amt) {
//					this.o_sgst_amt = o_sgst_amt;
//				}
//				public double[] getO_igst_amt() {
//					return o_igst_amt;
//				}
//				public void setO_igst_amt(double[] o_igst_amt) {
//					this.o_igst_amt = o_igst_amt;
//				}
//				public double[] getO_amt() {
//					return o_amt;
//				}
//				public void setO_amt(double[] o_amt) {
//					this.o_amt = o_amt;
//				}
//				public String[] getO_cal_typ() {
//					return o_cal_typ;
//				}
//				public void setO_cal_typ(String[] o_cal_typ) {
//					this.o_cal_typ = o_cal_typ;
//				}
				public double[] getDis_amt() {
					return dis_amt;
				}
				public void setDis_amt(double[] dis_amt) {
					this.dis_amt = dis_amt;
				}
				public double getTot_bas_amt() {
					return tot_bas_amt;
				}
				public void setTot_bas_amt(double tot_bas_amt) {
					this.tot_bas_amt = tot_bas_amt;
				}
				public double getTot_dis_amt() {
					return tot_dis_amt;
				}
				public void setTot_dis_amt(double tot_dis_amt) {
					this.tot_dis_amt = tot_dis_amt;
				}
				public double getTot_cgst_amt() {
					return tot_cgst_amt;
				}
				public void setTot_cgst_amt(double tot_cgst_amt) {
					this.tot_cgst_amt = tot_cgst_amt;
				}
				public double getTot_sgst_amt() {
					return tot_sgst_amt;
				}
				public void setTot_sgst_amt(double tot_sgst_amt) {
					this.tot_sgst_amt = tot_sgst_amt;
				}
//				public double getTot_igst_amt() {
//					return tot_igst_amt;
//				}
//				public void setTot_igst_amt(double tot_igst_amt) {
//					this.tot_igst_amt = tot_igst_amt;
//				}
				public double getTot_amt() {
					return tot_amt;
				}
				public void setTot_amt(double tot_amt) {
					this.tot_amt = tot_amt;
				}
				public String getAmt_in_word() {
					return amt_in_word;
				}
				public void setAmt_in_word(String amt_in_word) {
					this.amt_in_word = amt_in_word;
				}
				public String getPay_type1() {
					return pay_type1;
				}
				public void setPay_type1(String pay_type1) {
					this.pay_type1 = pay_type1;
				}
				public double getPay_amt1() {
					return pay_amt1;
				}
				public void setPay_amt1(double pay_amt1) {
					this.pay_amt1 = pay_amt1;
				}
				public String getDoc_no1() {
					return doc_no1;
				}
				public void setDoc_no1(String doc_no1) {
					this.doc_no1 = doc_no1;
				}
				public Date getDoc_dt1() {
					return doc_dt1;
				}
				public void setDoc_dt1(Date doc_dt1) {
					this.doc_dt1 = doc_dt1;
				}
				public String getDrawn_on1() {
					return drawn_on1;
				}
				public void setDrawn_on1(String drawn_on1) {
					this.drawn_on1 = drawn_on1;
				}
				
								
				
				
}
	            
	   
		                                                                                   