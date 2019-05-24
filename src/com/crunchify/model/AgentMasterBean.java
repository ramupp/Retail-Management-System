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
@Table(name= "mst_agent_master")
public class AgentMasterBean implements Serializable{
//itm_typ_id, itm_typ_nm, created_by, created_on, modified_by, modified_on, active
	private static final long serialVersionUID = 1L;
				@Id
				@GeneratedValue
	/*     */   private int agent_cd;
	/*     */   private String name;	
				private String address;
				private String phone;
				private String mobile;
				private String email;
				private String created_by;
				@JsonFormat(pattern="dd-MM-yyyy")
	  			private Date created_on;	
	/*     */   private String modified_by;
				@JsonFormat(pattern="dd-MM-yyyy")
	/*     */   private Date modified_on;
				private String active;
				
				public String getActive() {
					return active;
				}
				public void setActive(String active) {
					this.active = active;
				}
				public int getAgent_cd() {
					return agent_cd;
				}
				public void setAgent_cd(int agent_cd) {
					this.agent_cd = agent_cd;
				}
				public String getName() {
					return name;
				}
				public void setName(String name) {
					this.name = name;
				}
				public String getAddress() {
					return address;
				}
				public void setAddress(String address) {
					this.address = address;
				}
				public String getPhone() {
					return phone;
				}
				public void setPhone(String phone) {
					this.phone = phone;
				}
				public String getMobile() {
					return mobile;
				}
				public void setMobile(String mobile) {
					this.mobile = mobile;
				}
				public String getEmail() {
					return email;
				}
				public void setEmail(String email) {
					this.email = email;
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
				
		
			
}
	            
	   
		        