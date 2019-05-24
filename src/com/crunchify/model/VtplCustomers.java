package com.crunchify.model;

import java.io.Serializable;
import java.util.List;

public class VtplCustomers implements Serializable{
	
	/**
   * 
   */
  private static final long serialVersionUID = 1L;
  private String custName;	
	private int id;
	private int flag;
	private String status;
	private String engName;
	private int totCall;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getEngName() {
		return engName;
	}
	public void setEngName(String engName) {
		this.engName = engName;
	}
	public int getTotCall() {
		return totCall;
	}
	public void setTotCall(int totCall) {
		this.totCall = totCall;
	}
		
	
}
