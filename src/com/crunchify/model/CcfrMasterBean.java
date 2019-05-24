package com.crunchify.model;

import java.io.Serializable;
import java.sql.Date;

public class CcfrMasterBean implements Serializable{
	
	
	/*     */   private int dbId;
	/*     */   private String customer_name;
	/*     */   private String location_name;
	/*     */   private String serial_number;
	/*     */   private String failure_type;
	/*     */   private String model;
	/*     */   private String call_type;
	/*     */   private String unit_failed;
	/*     */   private String service_type;
	/*     */   private String call_number;
	/*     */   private String ccfr_number;
	/*     */   private String system_status;
	/*     */   private String ntg;
	/*     */   private String system_down;
	/*     */   private String ptn;
	/*     */   private String problem_nature;
	/*     */   private String start_date;
	/*     */   private String start_time;
	/*     */   private String call_date;
	/*     */   private String call_time;
	/*     */   private String end_date;
	/*     */   private String end_time;
	/*     */   private String arrival_date;
	/*     */   private String arrival_time;
	/*     */   private String remarks;
	/*     */   private String active;
	/*     */   private String oem_call_id;
	/*     */   private String old_serial;
	/*     */   private String new_serial;
	/*     */   private String created_by;
	/*     */   private Date created_on;
	/*     */   private String modified_by;
	/*     */   private Date modified_on;
	            private String verify;
	            private String warranty_status;
	            private String flag;
	            
	            
				public String getWarranty_status() {
					return warranty_status;
				}
				public void setWarranty_status(String warranty_status) {
					this.warranty_status = warranty_status;
				}
				public String getFlag() {
					return flag;
				}
				public void setFlag(String flag) {
					this.flag = flag;
				}
				public int getDbId() {
					return dbId;
				}
				public void setDbId(int dbId) {
					this.dbId = dbId;
				}
				public String getCustomer_name() {
					return customer_name;
				}
				public void setCustomer_name(String customer_name) {
					this.customer_name = customer_name;
				}
				public String getLocation_name() {
					return location_name;
				}
				public void setLocation_name(String location_name) {
					this.location_name = location_name;
				}
				public String getSerial_number() {
					return serial_number;
				}
				public void setSerial_number(String serial_number) {
					this.serial_number = serial_number;
				}
				public String getFailure_type() {
					return failure_type;
				}
				public void setFailure_type(String failure_type) {
					this.failure_type = failure_type;
				}
				public String getModel() {
					return model;
				}
				public void setModel(String model) {
					this.model = model;
				}
				public String getCall_type() {
					return call_type;
				}
				public void setCall_type(String call_type) {
					this.call_type = call_type;
				}
				public String getUnit_failed() {
					return unit_failed;
				}
				public void setUnit_failed(String unit_failed) {
					this.unit_failed = unit_failed;
				}
				public String getService_type() {
					return service_type;
				}
				public void setService_type(String service_type) {
					this.service_type = service_type;
				}
				public String getCall_number() {
					return call_number;
				}
				public void setCall_number(String call_number) {
					this.call_number = call_number;
				}
				public String getCcfr_number() {
					return ccfr_number;
				}
				public void setCcfr_number(String ccfr_number) {
					this.ccfr_number = ccfr_number;
				}
				public String getSystem_status() {
					return system_status;
				}
				public void setSystem_status(String system_status) {
					this.system_status = system_status;
				}
				public String getNtg() {
					return ntg;
				}
				public void setNtg(String ntg) {
					this.ntg = ntg;
				}
				public String getSystem_down() {
					return system_down;
				}
				public void setSystem_down(String system_down) {
					this.system_down = system_down;
				}
				public String getPtn() {
					return ptn;
				}
				public void setPtn(String ptn) {
					this.ptn = ptn;
				}
				public String getProblem_nature() {
					return problem_nature;
				}
				public void setProblem_nature(String problem_nature) {
					this.problem_nature = problem_nature;
				}
				public String getStart_date() {
					return start_date;
				}
				public void setStart_date(String start_date) {
					this.start_date = start_date;
				}
				public String getStart_time() {
					return start_time;
				}
				public void setStart_time(String start_time) {
					this.start_time = start_time;
				}
				public String getCall_date() {
					return call_date;
				}
				public void setCall_date(String call_date) {
					this.call_date = call_date;
				}
				public String getCall_time() {
					return call_time;
				}
				public void setCall_time(String call_time) {
					this.call_time = call_time;
				}
				public String getEnd_date() {
					return end_date;
				}
				public void setEnd_date(String end_date) {
					this.end_date = end_date;
				}
				public String getEnd_time() {
					return end_time;
				}
				public void setEnd_time(String end_time) {
					this.end_time = end_time;
				}
				public String getArrival_date() {
					return arrival_date;
				}
				public void setArrival_date(String arrival_date) {
					this.arrival_date = arrival_date;
				}
				public String getArrival_time() {
					return arrival_time;
				}
				public void setArrival_time(String arrival_time) {
					this.arrival_time = arrival_time;
				}
				public String getRemarks() {
					return remarks;
				}
				public void setRemarks(String remarks) {
					this.remarks = remarks;
				}
				public String getActive() {
					return active;
				}
				public void setActive(String active) {
					this.active = active;
				}
				public String getOem_call_id() {
					return oem_call_id;
				}
				public void setOem_call_id(String oem_call_id) {
					this.oem_call_id = oem_call_id;
				}
				public String getOld_serial() {
					return old_serial;
				}
				public void setOld_serial(String old_serial) {
					this.old_serial = old_serial;
				}
				public String getNew_serial() {
					return new_serial;
				}
				public void setNew_serial(String new_serial) {
					this.new_serial = new_serial;
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
				public String getVerify() {
					return verify;
				}
				public void setVerify(String verify) {
					this.verify = verify;
				}
	            
	            

	}

