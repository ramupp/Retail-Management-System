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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name= "pur_other_dtl")
public class PurchaseOtherHeadDtlBean implements Serializable{
	private static final long serialVersionUID = 1L;
				@Id
				@GeneratedValue
				 private int tr_id ;
				@Column(name="oh_hid")
				private int miscH;
				@Column(name="basic")
				private double miscHamt;
				
				@Column(name="cal_type")
				  private String o_cal_typ ;
				  @Column(name="gst_per")
				  private double o_gst_per;
				  @Column(name="cgst_amt")
				  private double o_cgst_amt ;
				  @Column(name="sgst_amt")
				  private double o_sgst_amt;
				  @Column(name="igst_amt")
				  private double o_igst_amt;
				  @Column(name="amt")
				  private double o_amt;
				  private String created_by 	;
				  private Date created_on 	;
				  private String modified_by 	;
				  private Date modified_on 	;
				  private String active	;
				  
				  @ManyToOne(cascade = CascadeType.ALL)
					@JoinColumn(name = "pur_id", nullable = false)
				  private PurDataHdr purdatahdr;
				  
				  
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
				
				
				
				public PurDataHdr getPurdatahdr() {
					return purdatahdr;
				}
				public void setPurdatahdr(PurDataHdr purdatahdr) {
					this.purdatahdr = purdatahdr;
				}
				public int getTr_id() {
					return tr_id;
				}
				public String getO_cal_typ() {
					return o_cal_typ;
				}
				public void setO_cal_typ(String o_cal_typ) {
					this.o_cal_typ = o_cal_typ;
				}
				public void setTr_id(int tr_id) {
					this.tr_id = tr_id;
				}
				public int getMiscH() {
					return miscH;
				}
				public void setMiscH(int miscH) {
					this.miscH = miscH;
				}
				public double getMiscHamt() {
					return miscHamt;
				}
				public void setMiscHamt(double miscHamt) {
					this.miscHamt = miscHamt;
				}
				public double getO_gst_per() {
					return o_gst_per;
				}
				public void setO_gst_per(double o_gst_per) {
					this.o_gst_per = o_gst_per;
				}
				public double getO_cgst_amt() {
					return o_cgst_amt;
				}
				public void setO_cgst_amt(double o_cgst_amt) {
					this.o_cgst_amt = o_cgst_amt;
				}
				public double getO_sgst_amt() {
					return o_sgst_amt;
				}
				public void setO_sgst_amt(double o_sgst_amt) {
					this.o_sgst_amt = o_sgst_amt;
				}
				public double getO_igst_amt() {
					return o_igst_amt;
				}
				public void setO_igst_amt(double o_igst_amt) {
					this.o_igst_amt = o_igst_amt;
				}
				public double getO_amt() {
					return o_amt;
				}
				public void setO_amt(double o_amt) {
					this.o_amt = o_amt;
				}
				public static long getSerialversionuid() {
					return serialVersionUID;
				}
				  
				  

								
				
				
}
	            
	   
		                                                                                   