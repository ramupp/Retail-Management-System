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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "mst_party_cont")
public class ContactDetailsBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
				public PartyMasterBean getPartymasterbean() {
		return partymasterbean;
	}

	public void setPartymasterbean(PartyMasterBean partymasterbean) {
		this.partymasterbean = partymasterbean;
	}

				@Id @GeneratedValue
	/*     */   private int con_id;	
				private int consg_id;	
				private int sl_no;
				
	/*     */   private String cont_per;	
				
				private String cont_mob;
				private String cont_email;
				
	/*     */   private String created_by;
	/*     */   private String modified_by;
				@JsonFormat(pattern="dd-MM-yyyy")
	/*     */   private Date created_on;	
				@JsonFormat(pattern="dd-MM-yyyy")
	/*     */   private Date modified_on;
	private String active;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "party_id", nullable = false)
	private PartyMasterBean partymasterbean;

	public int getCon_id() {
		return con_id;
	}

	public void setCon_id(int con_id) {
		this.con_id = con_id;
	}

	public int getConsg_id() {
		return consg_id;
	}

	public void setConsg_id(int consg_id) {
		this.consg_id = consg_id;
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

