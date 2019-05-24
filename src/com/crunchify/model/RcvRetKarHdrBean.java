package com.crunchify.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "trn_kar_issue_hd")
public class RcvRetKarHdrBean implements Serializable {

	private static final long serialVersionUID = 2316854742593895137L;
	// itm_typ_id, itm_typ_nm, created_by, created_on, modified_by, modified_on,
	// active
	@Id
	@GeneratedValue
	private int hid ;
	private String doc_no;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date doc_dt;
	private int kar_cd;
	
	private String narration;
	private int co_id;
	private int org_id;
	private String active;
	private String created_by;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date created_on;
	private String modified_by;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date modified_on;
	private String ref_no;
	private String type;
	private String status;
	private int isu_id;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date ref_dt;
	@Transient
	private int nuom_id[];
	public String[] getRate1() {
		return rate1;
	}

	public void setRate1(String[] rate1) {
		this.rate1 = rate1;
	}

	@Transient
	private String barcode1[];
	@Transient
	private String desg_id1[];
	@Transient
	private String rate1[];
	@Transient
	private String amt1[];
	@Transient
	private String tot_amt1[];
	@Transient
	private String net_amt1[];
	@Transient
	private String party_nm;
	
	
	
	
	
	
	public String[] getAmt1() {
		return amt1;
	}

	public void setAmt1(String[] amt1) {
		this.amt1 = amt1;
	}

	public String[] getTot_amt1() {
		return tot_amt1;
	}

	public void setTot_amt1(String[] tot_amt1) {
		this.tot_amt1 = tot_amt1;
	}

	public String[] getNet_amt1() {
		return net_amt1;
	}

	public void setNet_amt1(String[] net_amt1) {
		this.net_amt1 = net_amt1;
	}

	@Transient
	private int[] item_typ_id;
	@Transient
	private int[] item_id;
	@Transient
	private String[] desg_no;
	// private String hsn_cd;
	@Transient
	private int[] qty;
	@Transient
	private String[] uom_id;
	
	@Transient
	private int nuom_id1[];
	@Transient
	private int[] item_typ_id1;
	@Transient
	private int[] item_id1;
	@Transient
	private String[] desg_no1;
	// private String hsn_cd;
	@Transient
	private int[] qty1;
	@Transient
	private String[] uom_id1;

	@OneToMany(targetEntity = RcvRetKarDtlBean.class, mappedBy = "issuekarhdrBean", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<RcvRetKarDtlBean> issueKarDtlBean;

	@OneToMany(targetEntity = RcvRetKarProdBean.class, mappedBy = "issuekarhdrBean", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<RcvRetKarProdBean> issueKarProdBean;

	public RcvRetKarHdrBean() {

	}

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public int[] getNuom_id() {
		return nuom_id;
	}

	public void setNuom_id(int[] nuom_id) {
		this.nuom_id = nuom_id;
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

	public String[] getDesg_no() {
		return desg_no;
	}

	public void setDesg_no(String[] desg_no) {
		this.desg_no = desg_no;
	}

	public int[] getQty() {
		return qty;
	}

	public void setQty(int[] qty) {
		this.qty = qty;
	}

	public String[] getUom_id() {
		return uom_id;
	}

	public void setUom_id(String[] uom_id) {
		this.uom_id = uom_id;
	}

	public List<RcvRetKarDtlBean> getissueKarDtlBean() {
		return issueKarDtlBean;
	}

	public void setIssueKarDtlBean(List<RcvRetKarDtlBean> issueKarDtlBean) {
		this.issueKarDtlBean = issueKarDtlBean;
	}

	// public int getHid() {
	// return hid;
	// }
	//
	// public void setHid(int hid) {
	// this.hid = hid;
	// }

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

	public int getKar_cd() {
		return kar_cd;
	}

	public void setKar_cd(int kar_cd) {
		this.kar_cd = kar_cd;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
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

	public String getRef_no() {
		return ref_no;
	}

	public void setRef_no(String ref_no) {
		this.ref_no = ref_no;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getIsu_id() {
		return isu_id;
	}

	public void setIsu_id(int isu_id) {
		this.isu_id = isu_id;
	}

	public Date getRef_dt() {
		return ref_dt;
	}

	public void setRef_dt(Date ref_dt) {
		this.ref_dt = ref_dt;
	}

	public int[] getNuom_id1() {
		return nuom_id1;
	}

	public void setNuom_id1(int[] nuom_id1) {
		this.nuom_id1 = nuom_id1;
	}

	public int[] getItem_typ_id1() {
		return item_typ_id1;
	}

	public void setItem_typ_id1(int[] item_typ_id1) {
		this.item_typ_id1 = item_typ_id1;
	}

	public int[] getItem_id1() {
		return item_id1;
	}

	public void setItem_id1(int[] item_id1) {
		this.item_id1 = item_id1;
	}

	public String[] getDesg_no1() {
		return desg_no1;
	}

	public void setDesg_no1(String[] desg_no1) {
		this.desg_no1 = desg_no1;
	}

	public int[] getQty1() {
		return qty1;
	}

	public void setQty1(int[] qty1) {
		this.qty1 = qty1;
	}

	public String[] getUom_id1() {
		return uom_id1;
	}

	public void setUom_id1(String[] uom_id1) {
		this.uom_id1 = uom_id1;
	}

	public List<RcvRetKarProdBean> getIssueKarProdBean() {
		return issueKarProdBean;
	}

	public void setIssueKarProdBean(List<RcvRetKarProdBean> issueKarProdBean) {
		this.issueKarProdBean = issueKarProdBean;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String[] getBarcode1() {
		return barcode1;
	}

	public void setBarcode1(String[] barcode1) {
		this.barcode1 = barcode1;
	}

	public String[] getDesg_id1() {
		return desg_id1;
	}

	public void setDesg_id1(String[] desg_id1) {
		this.desg_id1 = desg_id1;
	}

	public String getParty_nm() {
		return party_nm;
	}

	public void setParty_nm(String party_nm) {
		this.party_nm = party_nm;
	}

	
	

	
}
