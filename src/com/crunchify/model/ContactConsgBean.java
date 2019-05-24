package com.crunchify.model;

import java.io.Serializable;
import java.sql.Date;

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
//party_id, consg_id, sl_no, cont_per, cont_mob, cont_email, created_by, created_on, modified_by, modified_on, active

@Entity
@Table(name = "mst_consg_cont")
public class ContactConsgBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
				public ConsgMasterBean getConsgmasterbean() {
		return consgmasterbean;
	}

	public void setConsgmasterbean(ConsgMasterBean consgmasterbean) {
		this.consgmasterbean = consgmasterbean;
	}

				@Id @GeneratedValue
	/*     */   private int con_id;	
				private int party_id;	
				private int sl_no;
				
	/*     */   private String cont_per;	
				
				private String cont_mob;
				private String cont_email;
				
	/*     */   private String created_by;
	/*     */   private String modified_by;
	/*     */   private Date created_on;				
	/*     */   private Date modified_on;
	private String active;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "consg_id", nullable = false)
	private ConsgMasterBean consgmasterbean;



	

	

	

	public int getCon_id() {
		return con_id;
	}

	public void setCon_id(int con_id) {
		this.con_id = con_id;
	}

	public int getParty_id() {
		return party_id;
	}

	public void setParty_id(int party_id) {
		this.party_id = party_id;
	}

	public int getSl_no() {
		return sl_no;
	}

	public void setSl_no(int sl_no) {
		this.sl_no = sl_no;
	}

	public String getCont_per() {
		return cont_per;
	}

	public void setCont_per(String cont_per) {
		this.cont_per = cont_per;
	}

	


	public String getCont_mob() {
		return cont_mob;
	}

	public void setCont_mob(String cont_mob) {
		this.cont_mob = cont_mob;
	}

	public String getCont_email() {
		return cont_email;
	}

	public void setCont_email(String cont_email) {
		this.cont_email = cont_email;
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

	
	
	}

