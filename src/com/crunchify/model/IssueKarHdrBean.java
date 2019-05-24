package com.crunchify.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
public class IssueKarHdrBean implements Serializable {

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
	private Date created_on;
	private String modified_by;
	private Date modified_on;
	private String ref_no;
	private String type;
	private String status;
	private int isu_id;
	private Date ref_dt;
	@Transient
	private String did[];
	@Transient
	private String pid[];
	
	@Transient
	private int nuom_id[];
	@Transient
	private int[] itm_typ_id;
	@Transient
	private int[] itm_id;
	
	@Transient
	private String[] desg_no;
	@Transient
	private String party_nm;
	// private String hsn_cd;
	@Transient
	private double[] qty;
	@Transient
	private String[] uom_id;

	@Transient
	private int nuom_id1[];
	@Transient
	private int[] itm_typ_id1;
	@Transient
	private int[] itm_id1;
	@Transient
	private String[] desg_no1;
	// private String hsn_cd;
	@Transient
	private double[] qty1;
	@Transient
	private String[] uom_id1;

	@OneToMany(targetEntity = IssueKarDtlBean.class, mappedBy = "issuekarhdrBean", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<IssueKarDtlBean> issueKarDtlBean;

	@OneToMany(targetEntity = IssueKarProdBean.class, mappedBy = "issuekarhdrBean", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<IssueKarProdBean> issueKarProdBean;


	public String[] getDid() {
		return did;
	}

	public void setDid(String[] did) {
		this.did = did;
	}

	public String[] getPid() {
		return pid;
	}

	public void setPid(String[] pid) {
		this.pid = pid;
	}

//	public List<IssueKarDtlBean> getIssueKarDtlBean() {
//		return issueKarDtlBean;
//	}

	
	
	
	public String getParty_nm() {
		return party_nm;
	}

	public void setParty_nm(String party_nm) {
		this.party_nm = party_nm;
	}

	
	public IssueKarHdrBean() {

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

	public int[] getItm_typ_id() {
		return itm_typ_id;
	}

	public void setItm_typ_id(int[] itm_typ_id) {
		this.itm_typ_id = itm_typ_id;
	}

	public int[] getItm_id() {
		return itm_id;
	}

	public void setItm_id(int[] itm_id) {
		this.itm_id = itm_id;
	}

	public String[] getDesg_no() {
		return desg_no;
	}

	public void setDesg_no(String[] desg_no) {
		this.desg_no = desg_no;
	}

	public double[] getQty() {
		return qty;
	}

	public void setQty(double[] qty) {
		this.qty = qty;
	}

	public String[] getUom_id() {
		return uom_id;
	}

	public void setUom_id(String[] uom_id) {
		this.uom_id = uom_id;
	}

	public List<IssueKarDtlBean> getissueKarDtlBean() {
		return issueKarDtlBean;
	}

	public void setIssueKarDtlBean(List<IssueKarDtlBean> issueKarDtlBean) {
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

	public int[] getItm_typ_id1() {
		return itm_typ_id1;
	}

	public void setItm_typ_id1(int[] itm_typ_id1) {
		this.itm_typ_id1 = itm_typ_id1;
	}

	public int[] getItm_id1() {
		return itm_id1;
	}

	public void setItm_id1(int[] itm_id1) {
		this.itm_id1 = itm_id1;
	}

	public String[] getDesg_no1() {
		return desg_no1;
	}

	public void setDesg_no1(String[] desg_no1) {
		this.desg_no1 = desg_no1;
	}

	public double[] getQty1() {
		return qty1;
	}

	public void setQty1(double[] qty1) {
		this.qty1 = qty1;
	}

	public String[] getUom_id1() {
		return uom_id1;
	}

	public void setUom_id1(String[] uom_id1) {
		this.uom_id1 = uom_id1;
	}

	public List<IssueKarProdBean> getIssueKarProdBean() {
		return issueKarProdBean;
	}

	public void setIssueKarProdBean(List<IssueKarProdBean> issueKarProdBean) {
		this.issueKarProdBean = issueKarProdBean;
	}

}
