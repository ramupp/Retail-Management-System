package com.crunchify.model.view;

import java.io.Serializable;
import java.util.Date;
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

import com.fasterxml.jackson.annotation.JsonFormat;



public class DocumentRequestBodyBean implements Serializable{
//itm_typ_id, itm_typ_nm, created_by, created_on, modified_by, modified_on, active
	private static final long serialVersionUID = 1L;
	
				private int co_id[];
				private HashMap<Integer,List<String>> doc_id;
				private HashMap<Integer,List<String>> type;
				private HashMap<Integer,List<String>> flags;
				private HashMap<Integer,List<String>> doc_nm1;
				private HashMap<Integer,List<String>> doc_nm;
				private HashMap<Integer,List<String>> prefix;
				private HashMap<Integer,List<String>> sufix;
				private HashMap<Integer,List<Integer>> digits;
				private HashMap<Integer,List<String>> sln_pattern;
				
				
				public HashMap<Integer, List<String>> getType() {
					return type;
				}
				public void setType(HashMap<Integer, List<String>> type) {
					this.type = type;
				}
				public HashMap<Integer, List<String>> getDoc_nm() {
					return doc_nm;
				}
				public void setDoc_nm(HashMap<Integer, List<String>> doc_nm) {
					this.doc_nm = doc_nm;
				}
				public int[] getCo_id() {
					return co_id;
				}
				public void setCo_id(int[] co_id) {
					this.co_id = co_id;
				}
				public HashMap<Integer, List<String>> getDoc_id() {
					return doc_id;
				}
				public void setDoc_id(HashMap<Integer, List<String>> doc_id) {
					this.doc_id = doc_id;
				}
				
				public HashMap<Integer, List<String>> getFlags() {
					return flags;
				}
				public void setFlags(HashMap<Integer, List<String>> flags) {
					this.flags = flags;
				}
				public HashMap<Integer, List<String>> getDoc_nm1() {
					return doc_nm1;
				}
				public void setDoc_nm1(HashMap<Integer, List<String>> doc_nm1) {
					this.doc_nm1 = doc_nm1;
				}
				public HashMap<Integer, List<String>> getPrefix() {
					return prefix;
				}
				public void setPrefix(HashMap<Integer, List<String>> prefix) {
					this.prefix = prefix;
				}
				public HashMap<Integer, List<String>> getSufix() {
					return sufix;
				}
				public void setSufix(HashMap<Integer, List<String>> sufix) {
					this.sufix = sufix;
				}
				public HashMap<Integer, List<Integer>> getDigits() {
					return digits;
				}
				public void setDigits(HashMap<Integer, List<Integer>> digits) {
					this.digits = digits;
				}
				public HashMap<Integer, List<String>> getSln_pattern() {
					return sln_pattern;
				}
				public void setSln_pattern(HashMap<Integer, List<String>> sln_pattern) {
					this.sln_pattern = sln_pattern;
				}
				
				
				
				
								
				
				
}
	            
	   
		                                                                                   