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
@Table(name= "mst_yr_code")
public class YearCodeBean implements Serializable{
//itm_typ_id, itm_typ_nm, created_by, created_on, modified_by, modified_on, active
	private static final long serialVersionUID = 1L;
				@Id
				@GeneratedValue
	/*     */   private int yr_cd_id;
	/*     */   private String yr_cd;
				private String st_date;
				private String end_date;
	             
	/*     */   private String created_by;
				@JsonFormat(pattern="dd-MM-yyyy")
	  			private Date created_on;	
	/*     */   private String modified_by;
				@JsonFormat(pattern="dd-MM-yyyy")
	/*     */   private Date modified_on;
				private String active;
				
				
				public int getYr_cd_id() {
					return yr_cd_id;
				}
				public void setYr_cd_id(int yr_cd_id) {
					this.yr_cd_id = yr_cd_id;
				}
				public String getYr_cd() {
					return yr_cd;
				}
				public void setYr_cd(String yr_cd) {
					this.yr_cd = yr_cd;
				}
				public String getSt_date() {
					return st_date;
				}
				public void setSt_date(String st_date) {
					this.st_date = st_date;
				}
				public String getEnd_date() {
					return end_date;
				}
				public void setEnd_date(String end_date) {
					this.end_date = end_date;
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
	            
	   
		                                                                                   