package com.crunchify.model;

import java.io.Serializable;
import java.sql.Date;

public class CallData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*     */   private int dbId;
	/*     */   private String call_register;
	/*     */   private String hid1;
	/*     */   private String serial;
	/*     */   private String customer;
	/*     */   private String order_code;
	/*     */   private String warranty_temp;
	/*     */   private Date warranty;
	/*     */   private String item;
	/*     */   private Date order_date;
	/*     */   private String order_date_temp;
	/*     */   private String amc_temp;
	/*     */   private Date amc;
	/*     */   private String user;
	/*     */   private String location;
	/*     */   private String contact;
	/*     */   private String choice;
	/*     */   private String complain_details;
	/*     */   private String remarks;
	/*     */   private String user_other;
	/*     */   private String location_other;
	/*     */   private String contact_other;
	/*     */   private String caller_name;
	/*     */   private String caller_phone;
	/*     */   private Date call_date;
	/*     */   private String call_date_temp;
	/*     */   private String authorize;
	/*     */   private String end_date_oem_warranty;
	/*     */   private String end_date_oem_amc;
	/*     */   private String item_make;
	/*     */   private String item_model;
	/*     */   private String created_by;
	/*     */   private String modified_by;
	/*     */   private Date created_on;
				private String assigned_oem;
	/*     */   private Date modified_on;
	/*     */   private String assigned_to;
	/*     */   private String call_status;
	/*     */   private String mgr_instr;
	/*     */   private String ccfr_number;
	/*     */   private String address;
	/*     */   private String address_other;
	/*     */   private String user_type;
	/*     */   private String user_name;
				private String make;
				private String model;
				private int count;
				
				
	            
				public int getCount() {
					return count;
				}
				public void setCount(int count) {
					this.count = count;
				}
				public int getDbId() {
					return dbId;
				}
				public void setDbId(int dbId) {
					this.dbId = dbId;
				}	
				
				public String getAssigned_oem() {
					return assigned_oem;
				}
				public void setAssigned_oem(String assigned_oem) {
					this.assigned_oem = assigned_oem;
				}
				public String getUser_name() {
					return user_name;
				}
				public void setUser_name(String user_name) {
					this.user_name = user_name;
				}
				public String getUser_type() {
					return user_type;
				}
				public void setUser_type(String user_type) {
					this.user_type = user_type;
				}
				public String getCall_register() {
					return call_register;
				}
				public void setCall_register(String call_register) {
					this.call_register = call_register;
				}
				public String getHid1() {
					return hid1;
				}
				public void setHid1(String hid1) {
					this.hid1 = hid1;
				}
				public String getSerial() {
					return serial;
				}
				public void setSerial(String serial) {
					this.serial = serial;
				}
				public String getCustomer() {
					return customer;
				}
				public void setCustomer(String customer) {
					this.customer = customer;
				}
				public String getOrder_code() {
					return order_code;
				}
				public void setOrder_code(String order_code) {
					this.order_code = order_code;
				}
				public String getWarranty_temp() {
					return warranty_temp;
				}
				public void setWarranty_temp(String warranty_temp) {
					this.warranty_temp = warranty_temp;
				}
				public Date getWarranty() {
					return warranty;
				}
				public void setWarranty(Date warranty) {
					this.warranty = warranty;
				}
				public String getItem() {
					return item;
				}
				public void setItem(String item) {
					this.item = item;
				}
				public Date getOrder_date() {
					return order_date;
				}
				public void setOrder_date(Date order_date) {
					this.order_date = order_date;
				}
				public String getOrder_date_temp() {
					return order_date_temp;
				}
				public void setOrder_date_temp(String order_date_temp) {
					this.order_date_temp = order_date_temp;
				}
				public String getAmc_temp() {
					return amc_temp;
				}
				public void setAmc_temp(String amc_temp) {
					this.amc_temp = amc_temp;
				}
				public Date getAmc() {
					return amc;
				}
				public void setAmc(Date amc) {
					this.amc = amc;
				}
				public String getUser() {
					return user;
				}
				public void setUser(String user) {
					this.user = user;
				}
				public String getLocation() {
					return location;
				}
				public void setLocation(String location) {
					this.location = location;
				}
				public String getContact() {
					return contact;
				}
				public void setContact(String contact) {
					this.contact = contact;
				}
				public String getChoice() {
					return choice;
				}
				public void setChoice(String choice) {
					this.choice = choice;
				}
				public String getComplain_details() {
					return complain_details;
				}
				public void setComplain_details(String complain_details) {
					this.complain_details = complain_details;
				}
				public String getRemarks() {
					return remarks;
				}
				public void setRemarks(String remarks) {
					this.remarks = remarks;
				}
				public String getUser_other() {
					return user_other;
				}
				public void setUser_other(String user_other) {
					this.user_other = user_other;
				}
				public String getLocation_other() {
					return location_other;
				}
				public void setLocation_other(String location_other) {
					this.location_other = location_other;
				}
				public String getContact_other() {
					return contact_other;
				}
				public void setContact_other(String contact_other) {
					this.contact_other = contact_other;
				}
				public String getCaller_name() {
					return caller_name;
				}
				public void setCaller_name(String caller_name) {
					this.caller_name = caller_name;
				}
				public String getCaller_phone() {
					return caller_phone;
				}
				public void setCaller_phone(String caller_phone) {
					this.caller_phone = caller_phone;
				}
				public Date getCall_date() {
					return call_date;
				}
				public void setCall_date(Date call_date) {
					this.call_date = call_date;
				}
				public String getCall_date_temp() {
					return call_date_temp;
				}
				public void setCall_date_temp(String call_date_temp) {
					this.call_date_temp = call_date_temp;
				}
				public String getAuthorize() {
					return authorize;
				}
				public void setAuthorize(String authorize) {
					this.authorize = authorize;
				}
				public String getEnd_date_oem_warranty() {
					return end_date_oem_warranty;
				}
				public void setEnd_date_oem_warranty(String end_date_oem_warranty) {
					this.end_date_oem_warranty = end_date_oem_warranty;
				}
				public String getEnd_date_oem_amc() {
					return end_date_oem_amc;
				}
				public void setEnd_date_oem_amc(String end_date_oem_amc) {
					this.end_date_oem_amc = end_date_oem_amc;
				}
				public String getItem_make() {
					return item_make;
				}
				public void setItem_make(String item_make) {
					this.item_make = item_make;
				}
				public String getItem_model() {
					return item_model;
				}
				public void setItem_model(String item_model) {
					this.item_model = item_model;
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
				public String getAssigned_to() {
					return assigned_to;
				}
				public void setAssigned_to(String assigned_to) {
					this.assigned_to = assigned_to;
				}
				public String getCall_status() {
					return call_status;
				}
				public void setCall_status(String call_status) {
					this.call_status = call_status;
				}
				public String getMgr_instr() {
					return mgr_instr;
				}
				public void setMgr_instr(String mgr_instr) {
					this.mgr_instr = mgr_instr;
				}
				public String getCcfr_number() {
					return ccfr_number;
				}
				public void setCcfr_number(String ccfr_number) {
					this.ccfr_number = ccfr_number;
				}
				public String getAddress() {
					return address;
				}
				public void setAddress(String address) {
					this.address = address;
				}
				public String getAddress_other() {
					return address_other;
				}
				public void setAddress_other(String address_other) {
					this.address_other = address_other;
				}
				public String getMake() {
					return make;
				}
				public void setMake(String make) {
					this.make = make;
				}
				public String getModel() {
					return model;
				}
				public void setModel(String model) {
					this.model = model;
				}

	}

