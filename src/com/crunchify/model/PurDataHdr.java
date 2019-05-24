package com.crunchify.model;

import java.io.Serializable;
import java.util.Date;
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

import org.hibernate.annotations.Tuplizers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

/**
 * @author SUNANDA
 *
 */
@Entity
@Table(name = "trn_pur_hdr")
public class PurDataHdr implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pur_id;
	private int org_id;
	private int co_id;
	@Transient
	private int from_co_id;
	private String pur_no;
	private String vr_type;
	//@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd/MM/yyyy",timezone="EST")
	private Date pur_dt;
	private String inv_no;
	private Date inv_dt;
	private int party_cd;
	private String pur_typ;
	@Transient
	private String party_nm;
	private double tot_amt;
	private double tot_disc;
	private double tot_gst;
	private double net_amt;
	private double round_off;
	private String active;

	private String created_by;
	private String modified_by;
	private Date created_on;
	private Date modified_on;
	private int pay_terms;
	private String ref_pur_no;
	 @Transient
	private int updateId;
	@Transient
	private int desg_id[];
	
	@Transient
	private String desg_id1[];
	
	@Transient
	private String msg[];
	
	@Transient
	private int item_typ_id[];
	
	@Transient
	private int item_id[];
	
	@Transient
	private String item_nm[];
	
	@Transient
	private String item_typ_nm[];
	
	@Transient
	private double qty[];
	
	@Transient
	private double qty1[];
	
	@Transient
	private double rate[];
	
	@Transient
	private double rate1[];
	
	@Transient
	private String uom_id[];
	
	@Transient
	private String nuom_id[];
	
	@Transient
	private double basic[];
	
	@Transient
	private double dis_per[];
	
	@Transient
	private double dis_amt[];
	
	@Transient
	private double gst_per[];
	
	
	@Transient
	private double cgst_amt[];
	
	@Transient
	private double sgst_amt[];
	
	@Transient
	private double igst_amt[];
	
	@Transient
	private double amt[];
	
	@Transient
	private int miscH[];
	
	@Transient
	private double miscHamt[];
	
	@Transient
	private double miscHamt1[];
	
	@Transient
	private String description[];
	
	
	@Transient
	private double o_gst_per[];
	
	
	@Transient
	private double o_cgst_amt[];
	
	
	@Transient
	private double o_sgst_amt[];
	
	@Transient
	private double o_igst_amt[];
	
	@Transient
	private double o_amt[];
	
	@Transient
	private double diffqty[];
	
	@Transient
	private String o_cal_typ[];
	
	@Transient
	private String bar_code[];
	
	@Column(name="tot_bas_amt")
	private double finBasic;
	
	
	
	@Column(name="tot_dis_amt")
	private double fin_dis_amt;
	
	
	@Column(name="tot_cgst_amt")
	private double fin_cgst_amt;
	
	
	@Column(name="tot_sgst_amt")
	private double fin_sgst_amt;
	
	@Column(name="tot_igst_amt")
	private double fin_igst_amt;
	
	
	
	@Transient
	private double tot_bas_amt;
	
	@Transient
	private double hqty;
	
	@Transient
	private double tot_dis_amt;
	
	@Transient
	private double tot_cgst_amt;
	
	@Transient
	private double tot_sgst_amt;
	
	@Transient
	private double tot_igst_amt;
	
	@Transient
	private String co_nm;
	
	
	@Transient
	private String val;
	
	
	@Transient
	private String desg_no[];
	

	@OneToMany(targetEntity = PurDataDtl.class, mappedBy = "purdatahdr", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<PurDataDtl> purDtlList;

	
	public String getRef_pur_no() {
		return ref_pur_no;
	}

	public void setRef_pur_no(String ref_pur_no) {
		this.ref_pur_no = ref_pur_no;
	}

	public String getParty_nm() {
		return party_nm;
	}

	public void setParty_nm(String party_nm) {
		this.party_nm = party_nm;
	}

	public int getFrom_co_id() {
		return from_co_id;
	}

	public void setFrom_co_id(int from_co_id) {
		this.from_co_id = from_co_id;
	}

	public int getUpdateId() {
		return updateId;
	}

	public void setUpdateId(int updateId) {
		this.updateId = updateId;
	}

	public int getPur_id() {
		return pur_id;
	}

	public void setPur_id(int pur_id) {
		this.pur_id = pur_id;
	}
	
	public double[] getMiscHamt1() {
		return miscHamt1;
	}

	public void setMiscHamt1(double[] miscHamt1) {
		this.miscHamt1 = miscHamt1;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public int getOrg_id() {
		return org_id;
	}

	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}
	
	public String[] getUom_id() {
		return uom_id;
	}

	public void setUom_id(String[] uom_id) {
		this.uom_id = uom_id;
	}

	public int getCo_id() {
		return co_id;
	}

	public void setCo_id(int co_id) {
		this.co_id = co_id;
	}

	public String getPur_no() {
		return pur_no;
	}

	public void setPur_no(String pur_no) {
		this.pur_no = pur_no;
	}
	//@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd/MM/yyyy",timezone="EST")
	public Date getPur_dt() {
		return pur_dt;
	}

	public void setPur_dt(Date pur_dt) {
		this.pur_dt = pur_dt;
	}

	public String getInv_no() {
		return inv_no;
	}

	public void setInv_no(String inv_no) {
		this.inv_no = inv_no;
	}

	public Date getInv_dt() {
		return inv_dt;
	}

	public void setInv_dt(Date inv_dt) {
		this.inv_dt = inv_dt;
	}

	public int getParty_cd() {
		return party_cd;
	}

	public void setParty_cd(int party_cd) {
		this.party_cd = party_cd;
	}

	public String getPur_typ() {
		return pur_typ;
	}

	public void setPur_typ(String pur_typ) {
		this.pur_typ = pur_typ;
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

	public List<PurDataDtl> getPurDtlList() {
		return purDtlList;
	}

	public void setPurDtlList(List<PurDataDtl> purDtlList) {
		this.purDtlList = purDtlList;
	}

	public int[] getDesg_id() {
		return desg_id;
	}

	public void setDesg_id(int[] desg_id) {
		this.desg_id = desg_id;
	}

	public int[] getItem_typ_id() {
		return item_typ_id;
	}

	public void setItem_typ_id(int[] item_typ_id) {
		this.item_typ_id = item_typ_id;
	}

	public int[] getItem_id() {
		return item_id;
	}

	public void setItem_id(int[] item_id) {
		this.item_id = item_id;
	}

	public double[] getQty() {
		return qty;
	}

	public void setQty(double[] qty) {
		this.qty = qty;
	}

	public double[] getRate() {
		return rate;
	}

	public void setRate(double[] rate) {
		this.rate = rate;
	}

	public double[] getDis_per() {
		return dis_per;
	}

	public void setDis_per(double[] dis_per) {
		this.dis_per = dis_per;
	}

	public double[] getDis_amt() {
		return dis_amt;
	}

	public void setDis_amt(double[] dis_amt) {
		this.dis_amt = dis_amt;
	}

	public double[] getGst_per() {
		return gst_per;
	}

	public void setGst_per(double[] gst_per) {
		this.gst_per = gst_per;
	}

	

	public double[] getCgst_amt() {
		return cgst_amt;
	}

	public void setCgst_amt(double[] cgst_amt) {
		this.cgst_amt = cgst_amt;
	}

	public double[] getSgst_amt() {
		return sgst_amt;
	}

	public void setSgst_amt(double[] sgst_amt) {
		this.sgst_amt = sgst_amt;
	}

	public double[] getIgst_amt() {
		return igst_amt;
	}

	public void setIgst_amt(double[] igst_amt) {
		this.igst_amt = igst_amt;
	}

	public double[] getAmt() {
		return amt;
	}

	public void setAmt(double[] amt) {
		this.amt = amt;
	}

	public double getTot_amt() {
		return tot_amt;
	}

	public void setTot_amt(double tot_amt) {
		this.tot_amt = tot_amt;
	}

	public double getTot_disc() {
		return tot_disc;
	}

	public void setTot_disc(double tot_disc) {
		this.tot_disc = tot_disc;
	}
	
	public double[] getQty1() {
		return qty1;
	}

	public void setQty1(double[] qty1) {
		this.qty1 = qty1;
	}

	public double getTot_gst() {
		return tot_gst;
	}

	public void setTot_gst(double tot_gst) {
		this.tot_gst = tot_gst;
	}

	public double getNet_amt() {
		return net_amt;
	}

	public void setNet_amt(double net_amt) {
		this.net_amt = net_amt;
	}

	public double getRound_off() {
		return round_off;
	}

	public void setRound_off(double round_off) {
		this.round_off = round_off;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public double[] getBasic() {
		return basic;
	}

	public void setBasic(double[] basic) {
		this.basic = basic;
	}

	public int[] getMiscH() {
		return miscH;
	}

	public void setMiscH(int[] miscH) {
		this.miscH = miscH;
	}

	public double[] getMiscHamt() {
		return miscHamt;
	}

	public void setMiscHamt(double[] miscHamt) {
		this.miscHamt = miscHamt;
	}

	public double[] getO_gst_per() {
		return o_gst_per;
	}

	public void setO_gst_per(double[] o_gst_per) {
		this.o_gst_per = o_gst_per;
	}

	public double[] getO_cgst_amt() {
		return o_cgst_amt;
	}

	public void setO_cgst_amt(double[] o_cgst_amt) {
		this.o_cgst_amt = o_cgst_amt;
	}

	public double[] getO_sgst_amt() {
		return o_sgst_amt;
	}

	public void setO_sgst_amt(double[] o_sgst_amt) {
		this.o_sgst_amt = o_sgst_amt;
	}

	public double[] getO_igst_amt() {
		return o_igst_amt;
	}

	public void setO_igst_amt(double[] o_igst_amt) {
		this.o_igst_amt = o_igst_amt;
	}

	public double[] getO_amt() {
		return o_amt;
	}

	public void setO_amt(double[] o_amt) {
		this.o_amt = o_amt;
	}

	public String[] getO_cal_typ() {
		return o_cal_typ;
	}

	public void setO_cal_typ(String[] o_cal_typ) {
		this.o_cal_typ = o_cal_typ;
	}
	
	public double getFinBasic() {
		return finBasic;
	}

	public void setFinBasic(double finBasic) {
		this.finBasic = finBasic;
	}

	public double getFin_dis_amt() {
		return fin_dis_amt;
	}

	public void setFin_dis_amt(double fin_dis_amt) {
		this.fin_dis_amt = fin_dis_amt;
	}

	public double getFin_cgst_amt() {
		return fin_cgst_amt;
	}

	public void setFin_cgst_amt(double fin_cgst_amt) {
		this.fin_cgst_amt = fin_cgst_amt;
	}

	public double getFin_sgst_amt() {
		return fin_sgst_amt;
	}

	public void setFin_sgst_amt(double fin_sgst_amt) {
		this.fin_sgst_amt = fin_sgst_amt;
	}

	public double getFin_igst_amt() {
		return fin_igst_amt;
	}

	public void setFin_igst_amt(double fin_igst_amt) {
		this.fin_igst_amt = fin_igst_amt;
	}

	public double getTot_bas_amt() {
		return tot_bas_amt;
	}

	public void setTot_bas_amt(double tot_bas_amt) {
		this.tot_bas_amt = tot_bas_amt;
	}

	public double getTot_dis_amt() {
		return tot_dis_amt;
	}

	public void setTot_dis_amt(double tot_dis_amt) {
		this.tot_dis_amt = tot_dis_amt;
	}

	public double getTot_cgst_amt() {
		return tot_cgst_amt;
	}

	public void setTot_cgst_amt(double tot_cgst_amt) {
		this.tot_cgst_amt = tot_cgst_amt;
	}

	public double getTot_sgst_amt() {
		return tot_sgst_amt;
	}

	public void setTot_sgst_amt(double tot_sgst_amt) {
		this.tot_sgst_amt = tot_sgst_amt;
	}

	public double getTot_igst_amt() {
		return tot_igst_amt;
	}

	public void setTot_igst_amt(double tot_igst_amt) {
		this.tot_igst_amt = tot_igst_amt;
	}

	public double[] getDiffqty() {
		return diffqty;
	}

	public void setDiffqty(double[] diffqty) {
		this.diffqty = diffqty;
	}

	public int getPay_terms() {
		return pay_terms;
	}

	public void setPay_terms(int pay_terms) {
		this.pay_terms = pay_terms;
	}

	public String[] getNuom_id() {
		return nuom_id;
	}

	public void setNuom_id(String[] nuom_id) {
		this.nuom_id = nuom_id;
	}

	public String[] getBar_code() {
		return bar_code;
	}

	public void setBar_code(String[] bar_code) {
		this.bar_code = bar_code;
	}

	public double[] getRate1() {
		return rate1;
	}

	public void setRate1(double[] rate1) {
		this.rate1 = rate1;
	}

	public double getHqty() {
		return hqty;
	}

	public void setHqty(double hqty) {
		this.hqty = hqty;
	}

	public String[] getItem_nm() {
		return item_nm;
	}

	public void setItem_nm(String[] item_nm) {
		this.item_nm = item_nm;
	}

	public String[] getItem_typ_nm() {
		return item_typ_nm;
	}

	public void setItem_typ_nm(String[] item_typ_nm) {
		this.item_typ_nm = item_typ_nm;
	}

	public String getCo_nm() {
		return co_nm;
	}

	public void setCo_nm(String co_nm) {
		this.co_nm = co_nm;
	}

	public String[] getDesg_no() {
		return desg_no;
	}

	public void setDesg_no(String[] desg_no) {
		this.desg_no = desg_no;
	}

	public String[] getDescription() {
		return description;
	}

	public void setDescription(String[] description) {
		this.description = description;
	}

	public String getVr_type() {
		return vr_type;
	}

	public void setVr_type(String vr_type) {
		this.vr_type = vr_type;
	}

	public String[] getMsg() {
		return msg;
	}

	public void setMsg(String[] msg) {
		this.msg = msg;
	}

	public String[] getDesg_id1() {
		return desg_id1;
	}

	public void setDesg_id1(String[] desg_id1) {
		this.desg_id1 = desg_id1;
	}
	
}
