package com.crunchify.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
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
@Table(name = "ADM_ROLE_HD")
public class RoleDataHdr implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
				@Id @GeneratedValue(strategy = GenerationType.AUTO)
				@Column(name = "role_id")				
	/*     */   private int roleId;
				
	            @Column(name="role_nm")
	/*     */   private String roleNm;	
	            
	/*     */   private String created_by;
	/*     */   private String modified_by;
	/*     */   private Date created_on;	
	/*     */   private Date modified_on;
				private String active;
				
				@Transient
				private int role_dtl_id[];				
				
	            @Transient
				private String menuId[];
	            
	            @Transient
				private String addId[];
	            
	            @Transient
				private String editId[];
	            
	            @Transient
				private String deleteId[];
	            
	            @Transient
				private String viewId[];
	            
	            private String app_id;
	/*     */   
	            //@OneToMany(targetEntity=Student.class, mappedBy="college", fetch=FetchType.EAGER)
	            @OneToMany(targetEntity=RoleDataDtl.class, mappedBy="roledatahdr",cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	            private List<RoleDataDtl> roleDtlList;
	           


	public String getActive() {
					return active;
				}

				public void setActive(String active) {
					this.active = active;
				}

	public String[] getMenuId() {
		return menuId;
	}

	public void setMenuId(String[] menuId) {
		this.menuId = menuId;
	}
	
	public String[] getAddId() {
		return addId;
	}

	public void setAddId(String[] addId) {
		this.addId = addId;
	}

	public String[] getEditId() {
		return editId;
	}

	public void setEditId(String[] editId) {
		this.editId = editId;
	}

	public String[] getDeleteId() {
		return deleteId;
	}

	public void setDeleteId(String[] deleteId) {
		this.deleteId = deleteId;
	}

	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) { 
		this.roleId = roleId;
	}
	public String getRoleNm() {
		return roleNm;
	}
	public void setRoleNm(String roleNm) {
		this.roleNm = roleNm;
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
	 
	public List<RoleDataDtl> getRoleDtlList() {
		return roleDtlList;
	}

	public void setRoleDtlList(List<RoleDataDtl> roleDtlList) {
		this.roleDtlList = roleDtlList;
	}

	public String[] getViewId() {
		return viewId;
	}

	public void setViewId(String[] viewId) {
		this.viewId = viewId;
	}

	public String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}

	public int[] getRole_dtl_id() {
		return role_dtl_id;
	}

	public void setRole_dtl_id(int[] role_dtl_id) {
		this.role_dtl_id = role_dtl_id;
	}
	
	
	
	}

