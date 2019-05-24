package com.crunchify.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
@Table(name = "trn_stock")
public class StockData implements Serializable{

	private static final long serialVersionUID = 1L;
				@Id	 @GeneratedValue(strategy = GenerationType.AUTO)
				private int id;
	/*     */   private String desg_no;					
	/*     */   private int item_id;	
	            private int item_type_id;
	            private String uom_id;
	            private double op_bal;					
	 			private int co_id;
	 			private int org_id;
	 			private String yr_cd;		
	 			private String rem;	
	/*     */   private String created_by;
	/*     */   private String modified_by;
	/*     */   private Date created_on;	
	/*     */   private Date modified_on;
	 			private double purch;
	 			private double pur_ret;
	 			private double cash_sal;
	 			private double sale_ret;	
	 			private double cl_bal;
	 			private Date stk_dt;
	 			private double cr_sal;
	 			private double op_stk;
	 			private String active;
	 			 @Transient
					private String itm_nm;
	 			 @Transient
					private String itm_typ_nm;
	 			 
	 			@Transient
				private String comp_nm;
	 			
	
	public double getOp_stk() {
					return op_stk;
				}
				public void setOp_stk(double op_stk) {
					this.op_stk = op_stk;
				}
	public String getActive() {
					return active;
				}
				public void setActive(String active) {
					this.active = active;
				}
	public String getItm_nm() {
					return itm_nm;
				}
				public void setItm_nm(String itm_nm) {
					this.itm_nm = itm_nm;
				}
				public String getItm_typ_nm() {
					return itm_typ_nm;
				}
				public void setItm_typ_nm(String itm_typ_nm) {
					this.itm_typ_nm = itm_typ_nm;
				}
				public String getComp_nm() {
					return comp_nm;
				}
				public void setComp_nm(String comp_nm) {
					this.comp_nm = comp_nm;
				}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesg_no() {
		return desg_no;
	}
	public void setDesg_no(String desg_no) {
		this.desg_no = desg_no;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getItem_type_id() {
		return item_type_id;
	}
	public void setItem_type_id(int item_type_id) {
		this.item_type_id = item_type_id;
	}
	public String getUom_id() {
		return uom_id;
	}
	public void setUom_id(String uom_id) {
		this.uom_id = uom_id;
	}
	public double getOp_bal() {
		return op_bal;
	}
	public void setOp_bal(double op_bal) {
		this.op_bal = op_bal;
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
	public String getYr_cd() {
		return yr_cd;
	}
	public void setYr_cd(String yr_cd) {
		this.yr_cd = yr_cd;
	}
	
	public String getRem() {
		return rem;
	}
	public void setRem(String rem) {
		this.rem = rem;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public double getPurch() {
		return purch;
	}
	public void setPurch(double purch) {
		this.purch = purch;
	}
	public double getPur_ret() {
		return pur_ret;
	}
	public void setPur_ret(double pur_ret) {
		this.pur_ret = pur_ret;
	}
	public double getCash_sal() {
		return cash_sal;
	}
	public void setCash_sal(double cash_sal) {
		this.cash_sal = cash_sal;
	}
	public double getSale_ret() {
		return sale_ret;
	}
	public void setSale_ret(double sale_ret) {
		this.sale_ret = sale_ret;
	}
	public double getCl_bal() {
		return cl_bal;
	}
	public void setCl_bal(double cl_bal) {
		this.cl_bal = cl_bal;
	}
	public Date getStk_dt() {
		return stk_dt;
	}
	public void setStk_dt(Date stk_dt) {
		this.stk_dt = stk_dt;
	}
	public double getCr_sal() {
		return cr_sal;
	}
	public void setCr_sal(double cr_sal) {
		this.cr_sal = cr_sal;
	}
}
				
	           		                                                                                   