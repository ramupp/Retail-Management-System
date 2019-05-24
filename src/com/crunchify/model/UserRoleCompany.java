package com.crunchify.model;

import java.io.Serializable;
import java.sql.Date;
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


@Entity
@Table(name = "user_role")
public class UserRoleCompany implements Serializable{

	private static final long serialVersionUID = 1L;
				@Id	 @GeneratedValue(strategy = GenerationType.AUTO)
				private int id;
	/*     */   private String user_id;
					
	/*     */   private String role_id;	
					
	 			private String co_id;
	           
	/*     */   private String created_by;
	/*     */   private String modified_by;
	/*     */   private Date created_on;	
	/*     */   private Date modified_on;
				
	            @Transient
				private HashMap<Integer,Integer> cId;
	            
	            @Transient
				private HashMap<Integer,List<Integer>> roleId;

				public String getUser_id() {
					return user_id;
				}

				public void setUser_id(String user_id) {
					this.user_id = user_id;
				}

				public String getRole_id() {
					return role_id;
				}

				public void setRole_id(String role_id) {
					this.role_id = role_id;
				}

				public String getCo_id() {
					return co_id;
				}

				public void setCo_id(String co_id) {
					this.co_id = co_id;
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

				public HashMap<Integer, Integer> getcId() {
					return cId;
				}

				public void setcId(HashMap<Integer, Integer> cId) {
					this.cId = cId;
				}

				public HashMap<Integer, List<Integer>> getRoleId() {
					return roleId;
				}

				public void setRoleId(HashMap<Integer, List<Integer>> roleId) {
					this.roleId = roleId;
				}

				public static long getSerialversionuid() {
					return serialVersionUID;
				}

}
	            
	   
		                                                                                   