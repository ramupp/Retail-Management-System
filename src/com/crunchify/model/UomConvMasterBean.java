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
@Table(name= "mst_uom_cnv")
public class UomConvMasterBean implements Serializable{
//itm_typ_id, itm_typ_nm, created_by, created_on, modified_by, modified_on, active
	private static final long serialVersionUID = 1L;
				@Id
				
	/*     */   private String con_fr;
	/*     */   private String con_to;	
	 			private String unit_tag;
		/*     */private String unit_amt;	
	             
	/*     */   private String created_by;
				@JsonFormat(pattern="dd-MM-yyyy")
	  			private Date created_on;	
	/*     */   private String modified_by;
				@JsonFormat(pattern="dd-MM-yyyy")
	/*     */   private Date modified_on;
				private String active;
				public String getCon_fr() {
					return con_fr;
				}
				public void setCon_fr(String con_fr) {
					this.con_fr = con_fr;
				}
				public String getCon_to() {
					return con_to;
				}
				public void setCon_to(String con_to) {
					this.con_to = con_to;
				}
				public String getUnit_tag() {
					return unit_tag;
				}
				public void setUnit_tag(String unit_tag) {
					this.unit_tag = unit_tag;
				}
				public String getUnit_amt() {
					return unit_amt;
				}
				public void setUnit_amt(String unit_amt) {
					this.unit_amt = unit_amt;
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
				public static long getSerialversionuid() {
					return serialVersionUID;
				}
				
				
				
				
				
				
}