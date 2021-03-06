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
@Table(name= "mst_consg")
public class ConsgMasterBean implements Serializable{
//itm_typ_id, itm_typ_nm, created_by, created_on, modified_by, modified_on, active
	private static final long serialVersionUID = 1L;
				@Id
				@GeneratedValue
				//private int party_typ_id;
	/*     */   private int consg_id;
				private int party_id;
				
				//private String consg_typ;
			
				
	/*     */   private String consg_nm;
				 
				private String consg_add1;
				 
				private String consg_add2;	
				 
				private String consg_add3;
				
				private int city;
				
				private int state;
				
				private String pin;	
				
				private String gst_no;
				
				private String phone;
				
				private String email;
				 
				private String web_site;	
				
				private String fax;	
				@Transient
				private String state_nm;
				@Transient
				private String city_nm;
	
	             
	/*     */   private String created_by;
	  			private Date created_on;	
	/*     */   private String modified_by;
	/*     */   private Date modified_on;
				private String active;
				
				
			
				
				 	@Transient
					private int sl_no;
		            
		            @Transient
					private String cont_per;
		            
		            @Transient
					private String cont_mob;
		            @Transient
					private String cont_email;
		            
//		            @Transient
//					private String desig;
//		            
		          
		            @OneToMany(targetEntity=ContactConsgBean.class, mappedBy="consgmasterbean",cascade = CascadeType.ALL, fetch=FetchType.EAGER)
		            private List<ContactConsgBean> contactDtlList;

					public int getConsg_id() {
						return consg_id;
					}

					public void setConsg_id(int consg_id) {
						this.consg_id = consg_id;
					}

				

					public String getConsg_nm() {
						return consg_nm;
					}

					public void setConsg_nm(String consg_nm) {
						this.consg_nm = consg_nm;
					}

					public String getConsg_add1() {
						return consg_add1;
					}

					public void setConsg_add1(String consg_add1) {
						this.consg_add1 = consg_add1;
					}

					public String getConsg_add2() {
						return consg_add2;
					}

					public void setConsg_add2(String consg_add2) {
						this.consg_add2 = consg_add2;
					}

					public String getConsg_add3() {
						return consg_add3;
					}

					public void setConsg_add3(String consg_add3) {
						this.consg_add3 = consg_add3;
					}

					public int getCity() {
						return city;
					}

					public void setCity(int city) {
						this.city = city;
					}

					public int getState() {
						return state;
					}

					public void setState(int state) {
						this.state = state;
					}

					public String getPin() {
						return pin;
					}

					public void setPin(String pin) {
						this.pin = pin;
					}

					public String getGst_no() {
						return gst_no;
					}

					public void setGst_no(String gst_no) {
						this.gst_no = gst_no;
					}

					public String getPhone() {
						return phone;
					}

					public void setPhone(String phone) {
						this.phone = phone;
					}

					public String getEmail() {
						return email;
					}

					public void setEmail(String email) {
						this.email = email;
					}

					public String getWeb_site() {
						return web_site;
					}

					public void setWeb_site(String web_site) {
						this.web_site = web_site;
					}

					public String getFax() {
						return fax;
					}

					public void setFax(String fax) {
						this.fax = fax;
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

					public List<ContactConsgBean> getContactDtlList() {
						return contactDtlList;
					}

					public void setContactDtlList(List<ContactConsgBean> contactDtlList) {
						this.contactDtlList = contactDtlList;
					}

					public int getParty_id() {
						return party_id;
					}

					public void setParty_id(int party_id) {
						this.party_id = party_id;
					}

					public String getState_nm() {
						return state_nm;
					}

					public void setState_nm(String state_nm) {
						this.state_nm = state_nm;
					}

					public String getCity_nm() {
						return city_nm;
					}

					public void setCity_nm(String city_nm) {
						this.city_nm = city_nm;
					}
					
					

				
				
}
	            
	   
		                                                                                   