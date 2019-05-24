package com.crunchify.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
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
public class UserRegRoleCompany implements Serializable{

	private static final long serialVersionUID = 1L;
				@Id
				@Column(name = "user_id")				
	/*     */   private String user_id;
				
	            @Column(name="user_nm")
	/*     */   private String user_nm;	
	            
	            @Column(name="user_type")
	/*     */   private String usertype;	
	            
	            private String active;
	            
	            private String user_pw;
	            private String seq_ques;
	            private String seq_ans;
	            
	/*     */   private String created_by;
	/*     */   private String modified_by;
	/*     */   private Date created_on;	
	/*     */   private Date modified_on;
				private String ques;
				
				 @Column(name="ques_ans")
				private String quesAns;
				 
				 private String emp_id;
				
	            @Transient
				private HashMap<Integer,Integer> cId;
	            
	            @Transient
				private HashMap<Integer,List<Integer>> roleId;



				public String getUsertype() {
					return usertype;
				}

				public void setUsertype(String usertype) {
					this.usertype = usertype;
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

				public String getQues() {
					return ques;
				}

				public void setQues(String ques) {
					this.ques = ques;
				}

				public String getQuesAns() {
					return quesAns;
				}

				public void setQuesAns(String quesAns) {
					this.quesAns = quesAns;
				}

				public String getEmp_id() {
					return emp_id;
				}

				public void setEmp_id(String emp_id) {
					this.emp_id = emp_id;
				}

				

				

				public String getUser_id() {
					return user_id;
				}

				public void setUser_id(String user_id) {
					this.user_id = user_id;
				}

				public String getUser_nm() {
					return user_nm;
				}

				public void setUser_nm(String user_nm) {
					this.user_nm = user_nm;
				}

				public String getUser_pw() {
					return user_pw;
				}

				public void setUser_pw(String user_pw) {
					this.user_pw = user_pw;
				}

				public String getSeq_ques() {
					return seq_ques;
				}

				public void setSeq_ques(String seq_ques) {
					this.seq_ques = seq_ques;
				}

				public String getSeq_ans() {
					return seq_ans;
				}

				public void setSeq_ans(String seq_ans) {
					this.seq_ans = seq_ans;
				}

				public HashMap<Integer, Integer> getcId() {
					return cId;
				}

				public void setcId(HashMap<Integer, Integer> cId) {
					this.cId = cId;
				}

			

				
				public HashMap<Integer, List<Integer>> getRoleId() {
					return roleId;
				}

				public void setRoleId(HashMap<Integer, List<Integer>> roleId) {
					this.roleId = roleId;
				}

				public static long getSerialversionuid() {
					return serialVersionUID;
				}
				
}
	            
	   
		                                                                                   