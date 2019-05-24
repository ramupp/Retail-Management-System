package com.crunchify.model.view;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
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

import org.hibernate.annotations.Tuplizers;

import com.fasterxml.jackson.annotation.JsonFormat;


public class PurDataViewBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private int pur_id;
	private int org_id;
	private int co_id;
	private String co_nm;
	private String pur_no;
	@JsonFormat( pattern="dd/MM/yyyy")
	private Date pur_dt;
	private String inv_no;
	@JsonFormat( pattern="dd/MM/yyyy")
	private Date inv_dt;
	private int party_cd;
	private String pur_typ;

	private double tot_amt;
	private double tot_disc;
	private double tot_gst;
	private double net_amt;
	private double round_off;
	private String active;

	private String created_by;
	private String modified_by;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date created_on;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date modified_on;
	private int pay_terms;
	
	
	private double tot_bas_amt;
	
	
	private double tot_dis_amt;
	
	
	private double tot_cgst_amt;
	
	
	private double tot_sgst_amt;
	
	private double tot_igst_amt;      

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

	public String getCo_nm() {
		return co_nm;
	}

	public void setCo_nm(String co_nm) {
		this.co_nm = co_nm;
	}

	public String getPur_no() {
		return pur_no;
	}

	public void setPur_no(String pur_no) {
		this.pur_no = pur_no;
	}

	

	public String getInv_no() {
		return inv_no;
	}

	public void setInv_no(String inv_no) {
		this.inv_no = inv_no;
	}

	
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy", timezone="GST")
	public Date getPur_dt() {
		return pur_dt;
	}
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy", timezone="GST")
	public void setPur_dt(Date pur_dt) {
		this.pur_dt = pur_dt;
	}
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy", timezone="GST")
	public Date getInv_dt() {
		return inv_dt;
	}
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy", timezone="GST")
	public void setInv_dt(Date inv_dt) {
		this.inv_dt = inv_dt;
	}

	public int getParty_cd() {
		return party_cd;
	}

	public void setParty_cd(int party_cd) {
		this.party_cd = party_cd;
	}

	public String getPur_typ() {
		return pur_typ;
	}

	public void setPur_typ(String pur_typ) {
		this.pur_typ = pur_typ;
	}

	public double getTot_amt() {
		return tot_amt;
	}

	public void setTot_amt(double tot_amt) {
		this.tot_amt = tot_amt;
	}

	public double getTot_disc() {
		return tot_disc;
	}

	public void setTot_disc(double tot_disc) {
		this.tot_disc = tot_disc;
	}

	public double getTot_gst() {
		return tot_gst;
	}

	public void setTot_gst(double tot_gst) {
		this.tot_gst = tot_gst;
	}

	public double getNet_amt() {
		return net_amt;
	}

	public void setNet_amt(double net_amt) {
		this.net_amt = net_amt;
	}

	public double getRound_off() {
		return round_off;
	}

	public void setRound_off(double round_off) {
		this.round_off = round_off;
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

	public int getPay_terms() {
		return pay_terms;
	}

	public void setPay_terms(int pay_terms) {
		this.pay_terms = pay_terms;
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

}
