package com.crunchify.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "mst_company")
public class RetailCompanyMasterBean {
	private static final long serialVersionUID = 1L;
	@Id
	private int co_id;
	private String co_nm;
	private String org_id;
	private String add1;
	private String add2;
	private String add3;
	private String loc_nm;
	private String pin;
	private String phone;
	private String fax;
	private String web_site;
	private String co_email;
	private String parent_co;
	private String valid_fr;
	private String valid_to;
	private String gst_no;
	private String bank_nm;
	private String bank_br;
	private String bank_acc;
	private String ifsc_cd;
	private String co_key;
	private String co_type; 
	private String war_amc_flag;
	private String active;
	private String created_by;
	private String created_on;
	private String modified_by;
	private String modified_on;
	private String city_nm;
	private String state_nm;
	private String country_nm;
	private String con_name;
	private String desig;
	private String mobile;
	private String con_email;
	private String outlet;
	
	
	public String getOutlet() {
		return outlet;
	}
	public void setOutlet(String outlet) {
		this.outlet = outlet;
	}
	public int getCo_id() {
		return co_id;
	}
	public void setCo_id(int co_id) {
		this.co_id = co_id;
	}
	public String getCo_nm() {
		return co_nm;
	}
	public void setCo_nm(String co_nm) {
		this.co_nm = co_nm;
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
	public String getAdd3() {
		return add3;
	}
	public void setAdd3(String add3) {
		this.add3 = add3;
	}
	public String getLoc_nm() {
		return loc_nm;
	}
	public void setLoc_nm(String loc_nm) {
		this.loc_nm = loc_nm;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getWeb_site() {
		return web_site;
	}
	public void setWeb_site(String web_site) {
		this.web_site = web_site;
	}
	public String getCo_email() {
		return co_email;
	}
	public void setCo_email(String co_email) {
		this.co_email = co_email;
	}
	
	
	public String getValid_fr() {
		return valid_fr;
	}
	public void setValid_fr(String valid_fr) {
		this.valid_fr = valid_fr;
	}
	public String getValid_to() {
		return valid_to;
	}
	public void setValid_to(String valid_to) {
		this.valid_to = valid_to;
	}
	public String getGst_no() {
		return gst_no;
	}
	public void setGst_no(String gst_no) {
		this.gst_no = gst_no;
	}
	public String getBank_nm() {
		return bank_nm;
	}
	public void setBank_nm(String bank_nm) {
		this.bank_nm = bank_nm;
	}
	public String getBank_br() {
		return bank_br;
	}
	public void setBank_br(String bank_br) {
		this.bank_br = bank_br;
	}
	public String getBank_acc() {
		return bank_acc;
	}
	public void setBank_acc(String bank_acc) {
		this.bank_acc = bank_acc;
	}
	public String getIfsc_cd() {
		return ifsc_cd;
	}
	public void setIfsc_cd(String ifsc_cd) {
		this.ifsc_cd = ifsc_cd;
	}
	public String getCo_key() {
		return co_key;
	}
	public void setCo_key(String co_key) {
		this.co_key = co_key;
	}
	public String getCo_type() {
		return co_type;
	}
	public void setCo_type(String co_type) {
		this.co_type = co_type;
	}
	public String getWar_amc_flag() {
		return war_amc_flag;
	}
	public void setWar_amc_flag(String war_amc_flag) {
		this.war_amc_flag = war_amc_flag;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public String getCreated_on() {
		return created_on;
	}
	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}
	public String getModified_by() {
		return modified_by;
	}
	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}
	public String getModified_on() {
		return modified_on;
	}
	public void setModified_on(String modified_on) {
		this.modified_on = modified_on;
	}
	public String getCity_nm() {
		return city_nm;
	}
	public void setCity_nm(String city_nm) {
		this.city_nm = city_nm;
	}
	public String getState_nm() {
		return state_nm;
	}
	public void setState_nm(String state_nm) {
		this.state_nm = state_nm;
	}
	public String getCountry_nm() {
		return country_nm;
	}
	public void setCountry_nm(String country_nm) {
		this.country_nm = country_nm;
	}
	public String getCon_name() {
		return con_name;
	}
	public void setCon_name(String con_name) {
		this.con_name = con_name;
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCon_email() {
		return con_email;
	}
	public void setCon_email(String con_email) {
		this.con_email = con_email;
	}
	public String getOrg_id() {
		return org_id;
	}
	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}
	public String getParent_co() {
		return parent_co;
	}
	public void setParent_co(String parent_co) {
		this.parent_co = parent_co;
	}
	
	

}
