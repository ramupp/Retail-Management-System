package com.crunchify.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "trn_kar_isu_dt")
public class IssueKarDtlBean implements Serializable {
	// itm_typ_id, itm_typ_nm, created_by, created_on, modified_by, modified_on,
	// active
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;

	// private int hid ;
	private int itm_typ_id;
	private int itm_id;
	private String desg_no;
	// private String hsn_cd;
	private double qty;
	private String uom_id;
	private int co_id;
	private int org_id;
	private String active;
	private String created_by;
	private Date created_on;
	private String modified_by;
	private Date modified_on;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "hid", nullable = false)
	private IssueKarHdrBean issuekarhdrBean;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDesg_no() {
		return desg_no;
	}

	public void setDesg_no(String desg_no) {
		this.desg_no = desg_no;
	}

	public double getQty() {
		return qty;
	}

	public void setQty(double qty) {
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

	public IssueKarHdrBean getIssuekarhdrBean() {
		return issuekarhdrBean;
	}

	public void setIssuekarhdrBean(IssueKarHdrBean issuekarhdrBean) {
		this.issuekarhdrBean = issuekarhdrBean;
	}

}
