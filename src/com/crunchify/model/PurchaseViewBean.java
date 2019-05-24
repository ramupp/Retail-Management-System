package com.crunchify.model;
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

@Entity
@Table(name = "trn_pur_hdr")
public class PurchaseViewBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pur_id;
	private int org_id;
	private int co_id;
	private String pur_no;
	public int getPur_id() {
		return pur_id;
	}
	public void setPur_id(int pur_id) {
		this.pur_id = pur_id;
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
	public String getPur_no() {
		return pur_no;
	}
	public void setPur_no(String pur_no) {
		this.pur_no = pur_no;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
