package com.crunchify.model;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
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

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name= "mst_sales_man")
public class SalesManBean implements Serializable{
//itm_typ_id, itm_typ_nm, created_by, created_on, modified_by, modified_on, active
	private static final long serialVersionUID = 1L;
				@Id
				
	/*     */   private String sm_id;
	/*     */   private String sm_nm;
				private int co_id;
				private int org_id;
				private String sl_type;
	             
	/*     */   private String created_by;
				@JsonFormat(pattern="dd-MM-yyyy")
	  			private Date created_on;	
	/*     */   private String modified_by;
				@JsonFormat(pattern="dd-MM-yyyy")
	/*     */   private Date modified_on;
				private String active;
				public String getSm_id() {
					return sm_id;
				}
				public void setSm_id(String sm_id) {
					this.sm_id = sm_id;
				}
				public String getSm_nm() {
					return sm_nm;
				}
				public void setSm_nm(String sm_nm) {
					this.sm_nm = sm_nm;
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
				public String getSl_type() {
					return sl_type;
				}
				public void setSl_type(String sl_type) {
					this.sl_type = sl_type;
				}
				
				
}
	            
	   
		                                                                                   