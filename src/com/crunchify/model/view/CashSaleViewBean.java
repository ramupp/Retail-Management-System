package com.crunchify.model.view;

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

import com.fasterxml.jackson.annotation.JsonFormat;



public class CashSaleViewBean implements Serializable{
//itm_typ_id, itm_typ_nm, created_by, created_on, modified_by, modified_on, active
	private static final long serialVersionUID = 1L;
				@Id
				@GeneratedValue
				private int tr_hid; 		
				  private int co_id; 
				  private String co_nm;
				  private int org_id; 
				  private String memo_no; 	
				  @JsonFormat(pattern="dd-MM-yyyy")
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
				 // private double tot_amt 		;
				
				  private double tot_bas_amt;
			
				  private double tot_dis_amt;
			
				  private double tot_cgst_amt;
			
				  private double tot_sgst_amt;
//				  @Transient
//				  private double tot_igst_amt;
			
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
				  private String remarks 		;
				  private String created_by 	;
				  @JsonFormat(pattern="dd-MM-yyyy")
				  private Date created_on 	;
				  private String modified_by 	;
				  private Date modified_on 	;
				  private String active	;
				  
				
				public String getCo_nm() {
					return co_nm;
				}
				public void setCo_nm(String co_nm) {
					this.co_nm = co_nm;
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
	
//				public double[] getIgst_amt() {
//					return igst_amt;
//				}
//				public void setIgst_amt(double[] igst_amt) {
//					this.igst_amt = igst_amt;
//				}
			
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
				
								
				
				
}
	            
	   
		                                                                                   