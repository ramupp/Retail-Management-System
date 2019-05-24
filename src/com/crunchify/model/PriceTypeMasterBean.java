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
@Table(name= "mst_price_typ")
public class PriceTypeMasterBean implements Serializable{
//itm_typ_id, itm_typ_nm, created_by, created_on, modified_by, modified_on, active
	private static final long serialVersionUID = 1L;
				@Id
				
	/*     */   private String price_typ;
	/*     */   private String typ_nm;	
	             
	/*     */   private String created_by;
				@JsonFormat(pattern="dd-MM-yyyy")
	  			private Date created_on;	
	/*     */   private String modified_by;
				@JsonFormat(pattern="dd-MM-yyyy")
	/*     */   private Date modified_on;
				private String active;
				
				
				
				
				public String getPrice_typ() {
					return price_typ;
				}
				public void setPrice_typ(String price_typ) {
					this.price_typ = price_typ;
				}
				public String getTyp_nm() {
					return typ_nm;
				}
				public void setTyp_nm(String typ_nm) {
					this.typ_nm = typ_nm;
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
	            
	   
		                                                                                   