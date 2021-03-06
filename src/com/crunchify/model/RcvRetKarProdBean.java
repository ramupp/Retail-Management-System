package com.crunchify.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "trn_kar_isu_prod")
public class RcvRetKarProdBean implements Serializable {

	private static final long serialVersionUID = 9051115703034908898L;

	@Id
	@GeneratedValue
	private int id;
	// private int hid;
	private int itm_typ_id;
	private int itm_id;
	private String desg_no;
	// private String hsn_cd;
	private int qty;
	private String uom_id;
	private int co_id;
	private int org_id;
	//private String net_amt;
	private String active;
	private String created_by;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date created_on;
	private String modified_by;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date modified_on;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "hid", nullable = false)
	private RcvRetKarHdrBean issuekarhdrBean;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// public int getHid() {
	// return hid;
	// }
	//
	// public void setHid(int hid) {
	// this.hid = hid;
	// }

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

	public String getDesg_no() {
		return desg_no;
	}

	public void setDesg_no(String desg_no) {
		this.desg_no = desg_no;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getUom_id() {
		return uom_id;
	}

	public void setUom_id(String uom_id) {
		this.uom_id = uom_id;
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

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
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

	public RcvRetKarHdrBean getIssuekarhdrBean() {
		return issuekarhdrBean;
	}

	public void setIssuekarhdrBean(RcvRetKarHdrBean issuekarhdrBean) {
		this.issuekarhdrBean = issuekarhdrBean;
	}

	
	

}
