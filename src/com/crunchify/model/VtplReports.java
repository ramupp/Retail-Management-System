package com.crunchify.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class VtplReports implements Serializable{
	/**
   * 
   */
  private static final long serialVersionUID = 1L;
  private Date fromDt;
	private Date toDt;
	private String item;
	private String make;
	private String model;
	private int totOrder;
	private String engName;
	private String emp;
	private int totCall;
	private int openCall;
	private int closedCall;
	private String custName;
	private int maxNumber;
	private int srlNo;
	private String srlnumber;
	private String callNumber;	
	private String location;
	private String probdesc;	
	private int brkDownDay;
	private String ordCode;
	public String order_number;
	public String order_date;
	private int prevPenIssue;
	private int currPenIssue;
	private int totInstall;
	private double percentageCall;
	private String username;
	private int id;
	private int flag;
	private String status;
	private  List<VtplCustomers> list1;
	private String finyear;
	private int no_of_ord;
	private int tot_amt;
	private double totamount;
	
	public double getTotamount() {
		return totamount;
	}
	public void setTotamount(double totamount) {
		this.totamount = totamount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
		
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public Date getFromDt() {
		return fromDt;
	}
	
	
	public void setFromDt(Date fromDt) {
		this.fromDt = fromDt;
	}
	
		
	
	public String getFinyear() {
		return finyear;
	}
	public void setFinyear(String finyear) {
		this.finyear = finyear;
	}
	public int getNo_of_ord() {
		return no_of_ord;
	}
	public void setNo_of_ord(int no_of_ord) {
		this.no_of_ord = no_of_ord;
	}
	public int getTot_amt() {
		return tot_amt;
	}
	public void setTot_amt(int tot_amt) {
		this.tot_amt = tot_amt;
	}
	public Date getToDt() {
		return toDt;
	}
	public void setToDt(Date toDt) {
		this.toDt = toDt;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
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
	public int getTotOrder() {
		return totOrder;
	}
	public void setTotOrder(int totOrder) {
		this.totOrder = totOrder;
	}
	public String getEngName() {
		return engName;
	}
	public void setEngName(String engName) {
		this.engName = engName;
	}
	public String getEmp() {
		return emp;
	}
	public void setEmp(String emp) {
		this.emp = emp;
	}
	public int getTotCall() {
		return totCall;
	}
	public void setTotCall(int totCall) {
		this.totCall = totCall;
	}
	public int getOpenCall() {
		return openCall;
	}
	public void setOpenCall(int openCall) {
		this.openCall = openCall;
	}
	public int getClosedCall() {
		return closedCall;
	}
	public void setClosedCall(int closedCall) {
		this.closedCall = closedCall;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public int getMaxNumber() {
		return maxNumber;
	}
	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}
	public int getSrlNo() {
		return srlNo;
	}
	public void setSrlNo(int srlNo) {
		this.srlNo = srlNo;
	}
	public String getCallNumber() {
		return callNumber;
	}
	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getProbdesc() {
		return probdesc;
	}
	public void setProbdesc(String probdesc) {
		this.probdesc = probdesc;
	}
	public int getBrkDownDay() {
		return brkDownDay;
	}
	public void setBrkDownDay(int brkDownDay) {
		this.brkDownDay = brkDownDay;
	}
	public String getOrdCode() {
		return ordCode;
	}
	public void setOrdCode(String ordCode) {
		this.ordCode = ordCode;
	}
	public int getPrevPenIssue() {
		return prevPenIssue;
	}
	public void setPrevPenIssue(int prevPenIssue) {
		this.prevPenIssue = prevPenIssue;
	}
	public int getCurrPenIssue() {
		return currPenIssue;
	}
	public void setCurrPenIssue(int currPenIssue) {
		this.currPenIssue = currPenIssue;
	}
	public int getTotInstall() {
		return totInstall;
	}
	public void setTotInstall(int totInstall) {
		this.totInstall = totInstall;
	}
	public double getPercentageCall() {
		return percentageCall;
	}
	public void setPercentageCall(double percentageCall) {
		this.percentageCall = percentageCall;
	}
	
	public String getSrlnumber() {
		return srlnumber;
	}
	public void setSrlnumber(String srlnumber) {
		this.srlnumber = srlnumber;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getOrder_number() {
		return order_number;
	}
	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public List<VtplCustomers> getList1() {
		return list1;
	}
	public void setList1(List<VtplCustomers> detaillist) {
		this.list1 = detaillist;
	}
	
	
	
	
	
}
