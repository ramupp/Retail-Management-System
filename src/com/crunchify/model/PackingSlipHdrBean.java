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
@Table(name= "pck_slp_hdr")
public class PackingSlipHdrBean implements Serializable{
//itm_typ_id, itm_typ_nm, created_by, created_on, modified_by, modified_on, active
	private static final long serialVersionUID = 1L;
				@Id
				@GeneratedValue
				 private int tr_hid 	;		
				 private String pck_sl_no	;		
				 private Date pck_sl_dt	;		
				 private int co_id		;		
				 private int org_id		;	
				 private int yr_cd_id	;		
				 private int consg_id	;		
				 private int transp_id	;		
				 private int no_of_pck	;		
				 private String notes		;		
				 private int tot_qty	;
				 private double finBasic;
				 private String lr_no;
				 private Date lr_dt;
				 private String pkwt;
				 private String slp_type;
//				 private String salesman;
//				 private String helper;
				 private String amt_in_word;
				 
				  @Transient
				  private int updateId;
				  @Transient
				  private double tot_bas_amt;
				  @Transient
				  private double tot_dis_amt;
				  @Transient
				  private double tot_cgst_amt;
				  @Transient
				  private double tot_sgst_amt;
				  @Transient
				  private double tot_igst_amt;
				  @Transient
				  private double tot_amt;
						
				  private double fin_dis_amt 	;
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
				 @Transient
				 private String barcode[];
				 @Transient
				  private int item_typ_id[];
				  @Transient
				  private int item_id[] ;
				  @Transient
				  private String desg_id[] ;
				  @Transient
				  private String hsn_cd[];
				  @Transient
				  private int nuom_id[];
				  @Transient
				  private String uom_id[];
				  @Transient
				  private double stk[] ;
				  @Transient
				  private int qty[] ;
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
				  @Transient
				  private double igst_amt[] ;
				  @Transient
				  private double amt[] ;
				  @Transient
				  private double gst_per[];
				  @Transient
				  private int miscH[];
				  @Transient
				  private double miscHamt[];
				  @Transient
				  private double o_gst_per[];
				  @Transient
				  private double o_cgst_amt[];
				  @Transient
				  private double o_sgst_amt[];
				  @Transient
				  private double o_igst_amt[];
				  @Transient
				  private double o_amt[];
				  @Transient
				  private String o_cal_typ[];
				  
				  @OneToMany(targetEntity=PackingSlipDtlBean.class, mappedBy="packingsliphdrbean",cascade = CascadeType.ALL, fetch=FetchType.EAGER)
					 private List<PackingSlipDtlBean> packingSlipDtlBean; 
				  
				  @OneToMany(targetEntity=PackingSlipOtherHeadDtlBean.class, mappedBy="packingsliphdrbean",cascade = CascadeType.ALL, fetch=FetchType.EAGER)
					 private List<PackingSlipOtherHeadDtlBean> packingSlipOtherHeadDtlBean;
				  
				  
				public int[] getNuom_id() {
					return nuom_id;
				}
				public void setNuom_id(int[] nuom_id) {
					this.nuom_id = nuom_id;
				}
				public String[] getUom_id() {
					return uom_id;
				}
				public void setUom_id(String[] uom_id) {
					this.uom_id = uom_id;
				}
				public double[] getStk() {
					return stk;
				}
				public void setStk(double[] stk) {
					this.stk = stk;
				}
				public int getUpdateId() {
					return updateId;
				}
				public void setUpdateId(int updateId) {
					this.updateId = updateId;
				}
				public String getSlp_type() {
					return slp_type;
				}
				public void setSlp_type(String slp_type) {
					this.slp_type = slp_type;
				}
				public String getAmt_in_word() {
					return amt_in_word;
				}
				public void setAmt_in_word(String amt_in_word) {
					this.amt_in_word = amt_in_word;
				}
				public List<PackingSlipOtherHeadDtlBean> getPackingSlipOtherHeadDtlBean() {
					return packingSlipOtherHeadDtlBean;
				}
				public void setPackingSlipOtherHeadDtlBean(
						List<PackingSlipOtherHeadDtlBean> packingSlipOtherHeadDtlBean) {
					this.packingSlipOtherHeadDtlBean = packingSlipOtherHeadDtlBean;
				}
				public List<PackingSlipDtlBean> getPackingSlipDtlBean() {
					return packingSlipDtlBean;
				}
				public void setPackingSlipDtlBean(List<PackingSlipDtlBean> packingSlipDtlBean) {
					this.packingSlipDtlBean = packingSlipDtlBean;
				}
				
				public String[] getBarcode() {
					return barcode;
				}
				public void setBarcode(String[] barcode) {
					this.barcode = barcode;
				}
				public String[] getHsn_cd() {
					return hsn_cd;
				}
				public void setHsn_cd(String[] hsn_cd) {
					this.hsn_cd = hsn_cd;
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
//				public String getSalesman() {
//					return salesman;
//				}
//				public void setSalesman(String salesman) {
//					this.salesman = salesman;
//				}
//				public String getHelper() {
//					return helper;
//				}
//				public void setHelper(String helper) {
//					this.helper = helper;
//				}
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
				public double getFinBasic() {
					return finBasic;
				}
				public void setFinBasic(double finBasic) {
					this.finBasic = finBasic;
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
				public double getTot_amt() {
					return tot_amt;
				}
				public void setTot_amt(double tot_amt) {
					this.tot_amt = tot_amt;
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
				public double[] getDis_amt() {
					return dis_amt;
				}
				public void setDis_amt(double[] dis_amt) {
					this.dis_amt = dis_amt;
				}
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
				public double getTot_igst_amt() {
					return tot_igst_amt;
				}
				public void setTot_igst_amt(double tot_igst_amt) {
					this.tot_igst_amt = tot_igst_amt;
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
				public double[] getIgst_amt() {
					return igst_amt;
				}
				public void setIgst_amt(double[] igst_amt) {
					this.igst_amt = igst_amt;
				}
				public int[] getMiscH() {
					return miscH;
				}
				public void setMiscH(int[] miscH) {
					this.miscH = miscH;
				}
				public double[] getMiscHamt() {
					return miscHamt;
				}
				public void setMiscHamt(double[] miscHamt) {
					this.miscHamt = miscHamt;
				}
				public double[] getO_gst_per() {
					return o_gst_per;
				}
				public void setO_gst_per(double[] o_gst_per) {
					this.o_gst_per = o_gst_per;
				}
				public double[] getO_cgst_amt() {
					return o_cgst_amt;
				}
				public void setO_cgst_amt(double[] o_cgst_amt) {
					this.o_cgst_amt = o_cgst_amt;
				}
				public double[] getO_sgst_amt() {
					return o_sgst_amt;
				}
				public void setO_sgst_amt(double[] o_sgst_amt) {
					this.o_sgst_amt = o_sgst_amt;
				}
				public double[] getO_igst_amt() {
					return o_igst_amt;
				}
				public void setO_igst_amt(double[] o_igst_amt) {
					this.o_igst_amt = o_igst_amt;
				}
				public double[] getO_amt() {
					return o_amt;
				}
				public void setO_amt(double[] o_amt) {
					this.o_amt = o_amt;
				}
				public String[] getO_cal_typ() {
					return o_cal_typ;
				}
				public void setO_cal_typ(String[] o_cal_typ) {
					this.o_cal_typ = o_cal_typ;
				}
								
				
				
}
	            
	   
		                                                                                   