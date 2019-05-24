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
@Table(name = "mst_design")
public class RetailTempBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id	
	@GeneratedValue
	private int tr_id;
	private String desg_no;
	private String v_desg_no;
	private Date desg_on;
	private String desg_desc;
	private String active;
	private int item_typ;
	private int item_id;
	
	
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	
	
	
}
