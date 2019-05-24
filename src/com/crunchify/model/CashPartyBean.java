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


@Entity
@Table(name= "mst_cash_party")
public class CashPartyBean implements Serializable{
//itm_typ_id, itm_typ_nm, created_by, created_on, modified_by, modified_on, active
	private static final long serialVersionUID = 1L;
				@Id
				@GeneratedValue
				 private int id 	;
				private String name;
				private String add1;
				private String add2;
				private String mobile;
				private String email;
				private String active;
				private String uid;
				private int co_id;
				
				public int getCo_id() {
					return co_id;
				}
				public void setCo_id(int co_id) {
					this.co_id = co_id;
				}
				public int getId() {
					return id;
				}
				public void setId(int id) {
					this.id = id;
				}
				public String getName() {
					return name;
				}
				public void setName(String name) {
					this.name = name;
				}
				public String getAdd1() {
					return add1;
				}
				public void setAdd1(String add1) {
					this.add1 = add1;
				}
				public String getAdd2() {
					return add2;
				}
				public void setAdd2(String add2) {
					this.add2 = add2;
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
				public String getActive() {
					return active;
				}
				public void setActive(String active) {
					this.active = active;
				}
				public String getUid() {
					return uid;
				}
				public void setUid(String uid) {
					this.uid = uid;
				}
				
				
				 
				
				
}
	            
	   
		                                                                                   