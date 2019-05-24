package com.crunchify.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "trn_pur_dtl")
public class PurDataDtl implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
				@Id @GeneratedValue
	/*     */   private int pur_dtl_id;		
				private int org_id;
				private int co_id;
				private int desg_id;
				private String desg_no;
				private int itm_typ_id;
				private int itm_id;
				private String uom_id;
				private double qty;
				private double rate;
				private double amt;
				private double dis_per;		
			    private double dis_amt;	
				private double gst_per;	
				private double gst_amt;	
				private String hsn_cd;
				private String bar_code;
				private double cgst_amt;
				private double sgst_amt;
				private double igst_amt;
				private double basic_amt;
				private String active;
				private double ret_qty;
				
	/*     */   private String created_by;
	/*     */   private String modified_by;
	/*     */   private Date created_on;				
	/*     */   private Date modified_on;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pur_id", nullable = false)
				private PurDataHdr purdatahdr;

	public int getPur_dtl_id() {
		return pur_dtl_id;
	}

	public void setPur_dtl_id(int pur_dtl_id) {
		this.pur_dtl_id = pur_dtl_id;
	}
	public int getOrg_id() {
		return org_id;
	}

	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}

	public int getCo_id() {
		return co_id;
	}

	public void setCo_id(int co_id) {
		this.co_id = co_id;
	}

	

	public int getDesg_id() {
		return desg_id;
	}

	public void setDesg_id(int desg_id) {
		this.desg_id = desg_id;
	}

	public int getItm_typ_id() {
		return itm_typ_id;
	}

	public void setItm_typ_id(int itm_typ_id) {
		this.itm_typ_id = itm_typ_id;
	}

	public int getItm_id() {
		return itm_id;
	}

	public void setItm_id(int itm_id) {
		this.itm_id = itm_id;
	}

	public String getUom_id() {
		return uom_id;
	}

	public void setUom_id(String uom_id) {
		this.uom_id = uom_id;
	}

	public String getHsn_cd() {
		return hsn_cd;
	}

	public void setHsn_cd(String hsn_cd) {
		this.hsn_cd = hsn_cd;
	}

	public String getBar_code() {
		return bar_code;
	}

	public void setBar_code(String bar_code) {
		this.bar_code = bar_code;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getModified_by() {
		return modified_by;
	}

	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}

	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	public Date getModified_on() {
		return modified_on;
	}

	public void setModified_on(Date modified_on) {
		this.modified_on = modified_on;
	}

	

	public PurDataHdr getPurdatahdr() {
		return purdatahdr;
	}

	public void setPurdatahdr(PurDataHdr purdatahdr) {
		this.purdatahdr = purdatahdr;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public double getQty() {
		return qty;
	}

	public void setQty(double qty) {
		this.qty = qty;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getAmt() {
		return amt;
	}

	public void setAmt(double amt) {
		this.amt = amt;
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

	public double getGst_per() {
		return gst_per;
	}

	public void setGst_per(double gst_per) {
		this.gst_per = gst_per;
	}

	public double getGst_amt() {
		return gst_amt;
	}

	public void setGst_amt(double gst_amt) {
		this.gst_amt = gst_amt;
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

	public double getBasic_amt() {
		return basic_amt;
	}

	public void setBasic_amt(double basic_amt) {
		this.basic_amt = basic_amt;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public double getRet_qty() {
		return ret_qty;
	}

	public void setRet_qty(double ret_qty) {
		this.ret_qty = ret_qty;
	}

	public String getDesg_no() {
		return desg_no;
	}

	public void setDesg_no(String desg_no) {
		this.desg_no = desg_no;
	}
	
	
	}

