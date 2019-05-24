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


@Entity
@Table(name= "cr_sale_hd")
public class CrSaleViewBean implements Serializable{

	private static final long serialVersionUID = 1L;
				@Id
				 private int tr_hid;		
				 private String pck_sl_no;		
				 private Date pck_sl_dt;		
				 private int co_id		;
				 private String co_nm;
				 private int org_id		;	
				 private int yr_cd_id	;		
				 private int consg_id	;		
				 private int transp_id	;
				// private String transport;
				 private int no_of_pck	;		
				 private String notes		;		
				 private int tot_qty	;
				 private double finBasic;
				 private String bill_no;
				 private Date bill_dt;
				 private String gst_no;
				 private String amt_in_word;
				  private double fin_dis_amt;
				  private double fin_cgst_amt 	;
				  private double fin_sgst_amt 	;
				  private double fin_igst_amt 	;		
				  private double net_amt	;		
				 private String active		;	
				 private int party_id	;		
				 private String created_by	;	
				 private Date created_on	;	
				 private String modified_by;		
				 private Date modified_on;
				 private String lr_no;
				 private Date lr_dt;
				 private String pkwt;
				 private String salesman;
				 private String helper;
				 private String vr_type;
				 private String accepted;
				 
				public String getVr_type() {
					return vr_type;
				}
				public void setVr_type(String vr_type) {
					this.vr_type = vr_type;
				}
				public String getAccepted() {
					return accepted;
				}
				public void setAccepted(String accepted) {
					this.accepted = accepted;
				}
				public int getTr_hid() {
					return tr_hid;
				}
				public void setTr_hid(int tr_hid) {
					this.tr_hid = tr_hid;
				}
				public String getPck_sl_no() {
					return pck_sl_no;
				}
				public void setPck_sl_no(String pck_sl_no) {
					this.pck_sl_no = pck_sl_no;
				}
				public Date getPck_sl_dt() {
					return pck_sl_dt;
				}
				public void setPck_sl_dt(Date pck_sl_dt) {
					this.pck_sl_dt = pck_sl_dt;
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
				public int getYr_cd_id() {
					return yr_cd_id;
				}
				public void setYr_cd_id(int yr_cd_id) {
					this.yr_cd_id = yr_cd_id;
				}
				public int getConsg_id() {
					return consg_id;
				}
				public void setConsg_id(int consg_id) {
					this.consg_id = consg_id;
				}
				public int getTransp_id() {
					return transp_id;
				}
				public void setTransp_id(int transp_id) {
					this.transp_id = transp_id;
				}
				public int getNo_of_pck() {
					return no_of_pck;
				}
				public void setNo_of_pck(int no_of_pck) {
					this.no_of_pck = no_of_pck;
				}
				public String getNotes() {
					return notes;
				}
				public void setNotes(String notes) {
					this.notes = notes;
				}
				public int getTot_qty() {
					return tot_qty;
				}
				public void setTot_qty(int tot_qty) {
					this.tot_qty = tot_qty;
				}
				public double getFinBasic() {
					return finBasic;
				}
				public void setFinBasic(double finBasic) {
					this.finBasic = finBasic;
				}
				public String getBill_no() {
					return bill_no;
				}
				public void setBill_no(String bill_no) {
					this.bill_no = bill_no;
				}
				public Date getBill_dt() {
					return bill_dt;
				}
				public void setBill_dt(Date bill_dt) {
					this.bill_dt = bill_dt;
				}
				public String getGst_no() {
					return gst_no;
				}
				public void setGst_no(String gst_no) {
					this.gst_no = gst_no;
				}
				public String getAmt_in_word() {
					return amt_in_word;
				}
				public void setAmt_in_word(String amt_in_word) {
					this.amt_in_word = amt_in_word;
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
				public double getFin_igst_amt() {
					return fin_igst_amt;
				}
				public void setFin_igst_amt(double fin_igst_amt) {
					this.fin_igst_amt = fin_igst_amt;
				}
				public double getNet_amt() {
					return net_amt;
				}
				public void setNet_amt(double net_amt) {
					this.net_amt = net_amt;
				}
				public String getActive() {
					return active;
				}
				public void setActive(String active) {
					this.active = active;
				}
				public int getParty_id() {
					return party_id;
				}
				public void setParty_id(int party_id) {
					this.party_id = party_id;
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
				public String getLr_no() {
					return lr_no;
				}
				public void setLr_no(String lr_no) {
					this.lr_no = lr_no;
				}
				public Date getLr_dt() {
					return lr_dt;
				}
				public void setLr_dt(Date lr_dt) {
					this.lr_dt = lr_dt;
				}
				public String getPkwt() {
					return pkwt;
				}
				public void setPkwt(String pkwt) {
					this.pkwt = pkwt;
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
				public String getCo_nm() {
					return co_nm;
				}
				public void setCo_nm(String co_nm) {
					this.co_nm = co_nm;
				}
				
				
				
}
	            
	   
		                                                                                   