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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name= "pck_slp_dtl")
public class PackingSlipDtlBean implements Serializable{
//itm_typ_id, itm_typ_nm, created_by, created_on, modified_by, modified_on, active
	private static final long serialVersionUID = 1L;
				@Id
				@GeneratedValue
				 private int tr_did ;
				  
				  private int sl_no ;
				  private int item_typ_id;
				  private int item_id ;
				  private String desg_id ;
				  private String hsn_cd;
				  private int qty ;
				  private double rate; 
				  private double dis_per; 
				  private double dis_amt ;
				  private double amt ;
				  private String uom_id;
				  private double gst_per;
				  private double cgst_amt ;
				  private double sgst_amt;
				  private double igst_amt;
				  private double basic;
				  private int co_id ;
				  private String created_by 	;
				  private Date created_on 	;
				  private String modified_by 	;
				  private Date modified_on 	;
				  private String active	;
				  private String barcode;
				  
				  @ManyToOne(cascade = CascadeType.ALL)
					@JoinColumn(name = "tr_hid", nullable = false)
								private PackingSlipHdrBean packingsliphdrbean;
				  
				  
				public String getUom_id() {
					return uom_id;
				}
				public void setUom_id(String uom_id) {
					this.uom_id = uom_id;
				}
				public String getBarcode() {
					return barcode;
				}
				public void setBarcode(String barcode) {
					this.barcode = barcode;
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
				
				
				public String getHsn_cd() {
					return hsn_cd;
				}
				public void setHsn_cd(String hsn_cd) {
					this.hsn_cd = hsn_cd;
				}
				public PackingSlipHdrBean getPackingsliphdrbean() {
					return packingsliphdrbean;
				}
				public void setPackingsliphdrbean(PackingSlipHdrBean packingsliphdrbean) {
					this.packingsliphdrbean = packingsliphdrbean;
				}
				public int getTr_did() {
					return tr_did;
				}
				public void setTr_did(int tr_did) {
					this.tr_did = tr_did;
				}
				
				public int getSl_no() {
					return sl_no;
				}
				public void setSl_no(int sl_no) {
					this.sl_no = sl_no;
				}
				public int getItem_typ_id() {
					return item_typ_id;
				}
				public void setItem_typ_id(int item_typ_id) {
					this.item_typ_id = item_typ_id;
				}
				public int getItem_id() {
					return item_id;
				}
				public void setItem_id(int item_id) {
					this.item_id = item_id;
				}
				
				public String getDesg_id() {
					return desg_id;
				}
				public void setDesg_id(String desg_id) {
					this.desg_id = desg_id;
				}
				public int getQty() {
					return qty;
				}
				public void setQty(int qty) {
					this.qty = qty;
				}
				public double getRate() {
					return rate;
				}
				public void setRate(double rate) {
					this.rate = rate;
				}
				public double getDis_per() {
					return dis_per;
				}
				public void setDis_per(double dis_per) {
					this.dis_per = dis_per;
				}
				public double getDis_amt() {
					return dis_amt;
				}
				public void setDis_amt(double dis_amt) {
					this.dis_amt = dis_amt;
				}
				public double getAmt() {
					return amt;
				}
				public void setAmt(double amt) {
					this.amt = amt;
				}
				public double getGst_per() {
					return gst_per;
				}
				public void setGst_per(double gst_per) {
					this.gst_per = gst_per;
				}
				
				public double getCgst_amt() {
					return cgst_amt;
				}
				public void setCgst_amt(double cgst_amt) {
					this.cgst_amt = cgst_amt;
				}
				public double getSgst_amt() {
					return sgst_amt;
				}
				public void setSgst_amt(double sgst_amt) {
					this.sgst_amt = sgst_amt;
				}
				public double getIgst_amt() {
					return igst_amt;
				}
				public void setIgst_amt(double igst_amt) {
					this.igst_amt = igst_amt;
				}
				public double getBasic() {
					return basic;
				}
				public void setBasic(double basic) {
					this.basic = basic;
				}
				public int getCo_id() {
					return co_id;
				}
				public void setCo_id(int co_id) {
					this.co_id = co_id;
				}
				  
				  

								
				
				
}
	            
	   
		                                                                                   