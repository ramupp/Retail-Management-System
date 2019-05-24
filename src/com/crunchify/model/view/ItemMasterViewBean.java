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


@Entity
@Table(name= "mst_fp_itm")
public class ItemMasterViewBean implements Serializable{
//itm_typ_id, itm_typ_nm, created_by, created_on, modified_by, modified_on, active
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int itm_id;
/*     */   private int itm_typ_id;
	private String itm_typ_nm;
	
/*     */   private String itm_nm;
	private String hsn_cd;
	private Double gst_per;
	private Double gst_per1;
	private int amount;
	private String log_cond;
     
/*     */   private String created_by;

	@JsonFormat(pattern="dd-MM-yyyy")
		private Date created_on;	
/*     */   private String modified_by;
	@JsonFormat(pattern="dd-MM-yyyy")
/*     */   private Date modified_on;
	private String active;
	public int getItm_id() {
		return itm_id;
	}
	public void setItm_id(int itm_id) {
		this.itm_id = itm_id;
	}
	public int getItm_typ_id() {
		return itm_typ_id;
	}
	public void setItm_typ_id(int itm_typ_id) {
		this.itm_typ_id = itm_typ_id;
	}
	public String getItm_nm() {
		return itm_nm;
	}
	public void setItm_nm(String itm_nm) {
		this.itm_nm = itm_nm;
	}
	public String getHsn_cd() {
		return hsn_cd;
	}
	public void setHsn_cd(String hsn_cd) {
		this.hsn_cd = hsn_cd;
	}
	public Double getGst_per() {
		return gst_per;
	}
	public void setGst_per(Double gst_per) {
		this.gst_per = gst_per;
	}
	public Double getGst_per1() {
		return gst_per1;
	}
	public void setGst_per1(Double gst_per1) {
		this.gst_per1 = gst_per1;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getLog_cond() {
		return log_cond;
	}
	public void setLog_cond(String log_cond) {
		this.log_cond = log_cond;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public String getItm_typ_nm() {
		return itm_typ_nm;
	}
	public void setItm_typ_nm(String itm_typ_nm) {
		this.itm_typ_nm = itm_typ_nm;
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
	
	
	
	
	
				
}
	            
	   
		        