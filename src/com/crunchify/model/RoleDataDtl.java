package com.crunchify.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "adm_role_dt")
public class RoleDataDtl implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
				@Id @GeneratedValue
				@Column(name = "role_dtl_id")
	/*     */   private int roleDtlId;	
				@Column(name = "menu_id")
	/*     */   private String menuId;	
				@Column(name = "add_per")
				private String addId;					
				@Column(name = "edit_per")
			    private String editId;	
				@Column(name = "delete_per")
				private String deleteId;	
				@Column(name = "view_per")
				private String viewId;	
				
	/*     */   private String created_by;
	/*     */   private String modified_by;
	/*     */   private Date created_on;				
	/*     */   private Date modified_on;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id", nullable = false)
				private RoleDataHdr roledatahdr;
	
	public int getRoleDtlId() {
		return roleDtlId;
	}
	public void setRoleDtlId(int roleDtlId) {
		this.roleDtlId = roleDtlId;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
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
	
	
	public RoleDataHdr getRoledatahdr() {
		//return roledatahdr;
		return null;
	}
	public void setRoledatahdr(RoleDataHdr roledatahdr) {
		this.roledatahdr = roledatahdr;
	}
	public String getAddId() {
		return addId;
	}
	public void setAddId(String addId) {
		this.addId = addId;
	}
	public String getEditId() {
		return editId;
	}
	public void setEditId(String editId) {
		this.editId = editId;
	}
	public String getDeleteId() {
		return deleteId;
	}
	public void setDeleteId(String deleteId) {
		this.deleteId = deleteId;
	}
	public String getViewId() {
		return viewId;
	}
	public void setViewId(String viewId) {
		this.viewId = viewId;
	}
	
	}

