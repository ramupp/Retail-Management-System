package com.crunchify.model;

import java.io.Serializable;
import java.util.HashMap;

public class DropDownBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String beanName;
	private String valColumn[];	
	
	private String valValue[];	
	private String valSelect;
	private String joinBean;
	
	
	
	public String getJoinBean() {
		return joinBean;
	}

	public void setJoinBean(String joinBean) {
		this.joinBean = joinBean;
	}

	public String getBeanName() {
		return beanName;
	}
	
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String[] getValColumn() {
		return valColumn;
	}

	public void setValColumn(String[] valColumn) {
		this.valColumn = valColumn;
	}

	public String[] getValValue() {
		return valValue;
	}

	public void setValValue(String[] valValue) {
		this.valValue = valValue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getValSelect() {
		return valSelect;
	}

	public void setValSelect(String valSelect) {
		this.valSelect = valSelect;
	}
}
				
	           		                                                                                   