package com.crunchify.model.view;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class RetailDesignViewBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int tr_id;
	private String desg_no; 
	private String v_desg_no;
	private Date desg_on;
	private String desg_desc;
	private int item_typ;
	private String item_typ_nm;
	private int item_id;
	private String item_id_nm;
	private String bar_code;
	private String notes;
	private int design_by;
	private String design_by_nm;
	
	private String created_by;
	private String modified_by;
	
	//@Temporal(TemporalType.TIMESTAMP)
	private Date created_on;
	//@Temporal(TemporalType.TIMESTAMP)
	private Date modified_on;
	private String active;
	private String file_name;
	
	@Transient
	private int co_id[];
	@Transient
	private String rt_type[];
	@Transient
	private double rate[];
	@Transient
	private String remarks[];
	@Transient
	private int org_id[];
	
	
	 
	public int[] getCo_id() {
		return co_id;
	}
	public void setCo_id(int[] co_id) {
		this.co_id = co_id;
	}
	public String[] getRt_type() {
		return rt_type;
	}
	public void setRt_type(String[] rt_type) {
		this.rt_type = rt_type;
	}
	public double[] getRate() {
		return rate;
	}
	public void setRate(double[] rate) {
		this.rate = rate;
	}
	public String[] getRemarks() {
		return remarks;
	}
	public void setRemarks(String[] remarks) {
		this.remarks = remarks;
	}
	public int[] getOrg_id() {
		return org_id;
	}
	public void setOrg_id(int[] org_id) {
		this.org_id = org_id;
	}

	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public int getTr_id() {
		return tr_id;
	}
	public void setTr_id(int tr_id) {
		this.tr_id = tr_id;
	}
	public String getDesg_no() {
		return desg_no;
	}
	public void setDesg_no(String desg_no) {
		this.desg_no = desg_no;
	}
	public String getV_desg_no() {
		return v_desg_no;
	}
	public void setV_desg_no(String v_desg_no) {
		this.v_desg_no = v_desg_no;
	}
	public Date getDesg_on() {
		return desg_on;
	}
	public void setDesg_on(Date desg_on) {
		this.desg_on = desg_on;
	}
	public String getDesg_desc() {
		return desg_desc;
	}
	public void setDesg_desc(String desg_desc) {
		this.desg_desc = desg_desc;
	}

	
	public int getItem_typ() {
		return item_typ;
	}
	public void setItem_typ(int item_typ) {
		this.item_typ = item_typ;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getBar_code() {
		return bar_code;
	}
	public void setBar_code(String bar_code) {
		this.bar_code = bar_code;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public int getDesign_by() {
		return design_by;
	}
	public void setDesign_by(int design_by) {
		this.design_by = design_by;
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
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getItem_typ_nm() {
		return item_typ_nm;
	}
	public void setItem_typ_nm(String item_typ_nm) {
		this.item_typ_nm = item_typ_nm;
	}
	public String getItem_id_nm() {
		return item_id_nm;
	}
	public void setItem_id_nm(String item_id_nm) {
		this.item_id_nm = item_id_nm;
	}
	public String getDesign_by_nm() {
		return design_by_nm;
	}
	public void setDesign_by_nm(String design_by_nm) {
		this.design_by_nm = design_by_nm;
	}
	
		
	

}
