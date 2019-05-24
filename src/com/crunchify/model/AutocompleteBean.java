package com.crunchify.model;

import java.io.Serializable;
import java.sql.Date;

public class AutocompleteBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*     */   private int id;
	/*     */   private String label;
	/*     */   private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	}

