package com.crunchify.util;

//import com.itextpdf.*;

//import com.mysql.jdbc.PreparedStatement;

import java.io.FileOutputStream;
//import com.mysql.jdbc.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.sql.*;

import org.json.JSONObject;

import com.crunchify.model.RetailRegistrationBean;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;





public class UtilityHelper {

    private String add_permission;
    private String edit_permission;
    private String delete_permission;
    private String report_permission;
    ConnectionFactory conf = null;
    Connection conn = null;

    CallableStatement cs = null;

//    @SessionTarget
//    Session session;
//
//    @TransactionTarget
//    Transaction transaction;
    public String getDropdownString(String table_name,String val,String view,String match)
    {
    	MyConnection mc=new MyConnection();
    	ResultSet rs=null;
    	String generated_val="";
    	try{
    	conn=mc.getConnection("adm_retail");
    	Statement stmt=conn.createStatement();
    	String sql="select "+val+","+view+" from "+table_name+" where active='Y'";
    	System.out.println(sql+"-match is-"+match);
    	rs=stmt.executeQuery(sql);
    	while(rs.next())
    	{
    		if(rs.getString(1).equals(match))
    		{
    			generated_val=generated_val+"<option value="+rs.getString(1)+" selected>"+rs.getString(2)+"</option> ";
    		}
    		else{
    			generated_val=generated_val+"<option value="+rs.getString(1)+">"+rs.getString(2)+"</option> ";
    		}
    	}
    	conn.close();
    	}catch (Exception ex) {
            ex.printStackTrace();
        }
    	System.out.println(generated_val);
    	return generated_val;
    	
    	
    }
    
    public String getDropdownStringForRMItemType(String table_name,String val,String view,String match )
    {
    	MyConnection mc=new MyConnection();
    	ResultSet rs=null;
    	String generated_val="";
    	try{
    	conn=mc.getConnection("adm_retail");
    	Statement stmt=conn.createStatement();
    	String sql="select "+val+","+view+" from "+table_name+" where active='Y' and prod_typ='RM'";
    	System.out.println(sql+"-match is-"+match);
    	rs=stmt.executeQuery(sql);
    	while(rs.next())
    	{
    		if(rs.getString(1).equals(match))
    		{
    			generated_val=generated_val+"<option value="+rs.getString(1)+" selected>"+rs.getString(2)+"</option> ";
    		}
    		else{
    			generated_val=generated_val+"<option value="+rs.getString(1)+">"+rs.getString(2)+"</option> ";
    		}
    	}
    	conn.close();
    	}catch (Exception ex) {
            ex.printStackTrace();
        }
    	System.out.println(generated_val);
    	return generated_val;
    	
    	
    }
    public String getDropdownStringForPckSlip(String table_name,String val,String view)
    {
    	MyConnection mc=new MyConnection();
    	ResultSet rs=null;
    	String generated_val="";
    	try{
    	conn=mc.getConnection("adm_retail");
    	Statement stmt=conn.createStatement();
    	String sql="select "+val+","+view+" from "+table_name+" where active='Y' and co_id<>0 and sd_tag is null";
    	System.out.println(sql);
    	rs=stmt.executeQuery(sql);
    	generated_val="<option value='0' selected>--Select--</option> ";
    	while(rs.next())
    	{
    		
    			generated_val=generated_val+"<option value="+rs.getString(1)+">"+rs.getString(2)+"</option> ";
    		
    	}
    	conn.close();
    	}catch (Exception ex) {
            ex.printStackTrace();
        }
    	System.out.println(generated_val);
    	return generated_val;
    	
    	
    }
    public String getDropdownStringForPckSlipWithSDtype(String table_name,String val,String view)
    {
    	MyConnection mc=new MyConnection();
    	ResultSet rs=null;
    	String generated_val="";
    	try{
    	conn=mc.getConnection("adm_retail");
    	Statement stmt=conn.createStatement();
    	String sql="select "+val+","+view+" from "+table_name+" where active='Y' and party_typ='SD' and co_id=0 "+"union select "+val+","+view+" from "+table_name+" where active='Y' and party_typ='SD' and  sd_tag='Y' order by 2 ";
    	System.out.println(sql);
    	rs=stmt.executeQuery(sql);
    	generated_val="<option value='0' selected>--Select--</option> ";
    	while(rs.next())
    	{
    		
    			generated_val=generated_val+"<option value="+rs.getString(1)+">"+rs.getString(2)+"</option> ";
    		
    	}
    	conn.close();
    	}catch (Exception ex) {
            ex.printStackTrace();
        }
    	System.out.println(generated_val);
    	return generated_val;
    	
    	
    }
    public String findUOMIdByUOM(String val)
    {
    	MyConnection mc=new MyConnection();
    	ResultSet rs=null;
    	String uom_id="";
    	try{
    	conn=mc.getConnection("adm_retail");
    	Statement stmt=conn.createStatement();
    	String sql="SELECT uom_id,uom_nm FROM mst_uom where uom_nm='"+val+"' and active='Y'";
    	rs=stmt.executeQuery(sql);
    	rs.next();
    	uom_id=rs.getString("uom_id");
    	conn.close();
    	}catch (Exception ex) {
            ex.printStackTrace();
        }
    	return uom_id;
    	
    	
    }
    
    public String getDropdownStringForParty(String table_name,String val,String view,String match,String cond)
    {
    	MyConnection mc=new MyConnection();
    	ResultSet rs=null;
    	String generated_val="";
    	try{
    	conn=mc.getConnection("adm_retail");
    	Statement stmt=conn.createStatement();
    	String sql="select "+val+","+view+" from "+table_name+" where active='Y' and party_typ='"+cond+"' order by 2";
    	System.out.println(sql+"-match is-"+match);
    	rs=stmt.executeQuery(sql);
    	while(rs.next())
    	{
    		if(rs.getString(1).equals(match))
    		{
    			generated_val=generated_val+"<option value="+rs.getString(1)+" selected>"+rs.getString(2)+"</option> ";
    		}
    		else{
    			generated_val=generated_val+"<option value="+rs.getString(1)+">"+rs.getString(2)+"</option> ";
    		}
    	}
    	conn.close();
    	}catch (Exception ex) {
            ex.printStackTrace();
        }
    	System.out.println(generated_val);
    	return generated_val;
    	
    	
    }
    
    public String barcode_generate(String barcode,String purno,String co_id,String pdt)
    {
    	 	Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 6, Font.BOLD);
    	    Font dogFont = new Font(Font.FontFamily.TIMES_ROMAN, 4, Font.BOLD);
    	    Font ratFont = new Font(Font.FontFamily.TIMES_ROMAN, 5, Font.BOLD);
    	    Barcode128 code128;
         try {
        	 MyConnection mc=new MyConnection();
    		 String fin_path=mc.getBarcodePath();
    		 Connection conn=mc.getConnection("adm_retail");
    		 
             Statement st= null;
            String cid = "", cnm = "";
            st = conn.createStatement();
            String sql="select i.itm_id,i.itm_nm,t.itm_typ_id,t.itm_typ_nm,i.gst_per,d.desg_no,d.bar_code,rt.rCode,rt.rate,rt.co_id from mst_design d join mst_fp_itm i on(i.itm_id=d.item_id) join mst_itm_typ t on(t.itm_typ_id=i.itm_typ_id) join mst_design_rt rt on(d.tr_id=rt.desg_id)  where sale_type='C' and rt.co_id='"+co_id+"' and d.bar_code='"+barcode+"'";
        	System.out.println(sql);
        	
			ResultSet rs = st.executeQuery(sql);	
			ResultSetMetaData rsmd = rs.getMetaData();
			JSONObject obj = new JSONObject();
			while(rs.next()) {
			  int numColumns = rsmd.getColumnCount();
			  
			  
			  
			  for (int i=1; i<=numColumns; i++) {
			    String column_name = rsmd.getColumnName(i);
			    obj.put(column_name, rs.getObject(column_name));
			  }
			}
			String co_nm=findCoNameExceptOutletFromId(Integer.parseInt(obj.get("co_id").toString()));
			String itm_nm=String.valueOf(obj.get("itm_nm"));
			String itm_typ_nm=String.valueOf(obj.get("itm_typ_nm"));
			String desg_no=String.valueOf(obj.get("desg_no"));
			String rate_code=String.valueOf(obj.get("rCode"));
			String rate=String.valueOf(obj.get("rate"));
			
    		 String workingDir = System.getProperty( "catalina.base" )+fin_path;
    		 System.out.println("work is:-"+workingDir);
    		 String finpath=workingDir+"/"+barcode+".pdf";
             Document document = new Document();
             Rectangle one = new Rectangle(170,100);
             document.setPageSize(one);
             PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(finpath));
             document.setMargins(28, 50, 5, 1);
             document.setMarginMirroring(true);
             //Font f=new Font(FontFamily.TIMES_ROMAN,50.0f,Font.UNDERLINE,BaseColor.RED); "E:/OLD_DRIVE_BACKUP/VTPL/BARCODE/barcode.pdf"
             document.open();
             String tot_itm=itm_typ_nm+" "+itm_nm;
             Paragraph p1 = new Paragraph(co_nm, catFont);
             Paragraph p2 = new Paragraph(tot_itm, dogFont);
            
             p1.setAlignment(Element.ALIGN_LEFT);
             p2.setAlignment(Element.ALIGN_LEFT);

             document.add(p1);
             
             document.add(p2);
             code128 = new Barcode128();
             code128.setGenerateChecksum(true);
             //code128.setAltText(barcode);
             code128.setCode(barcode);

            document.add(code128.createImageWithBarcode(writer.getDirectContent(), null, null));
             
           // Paragraph p3 = new Paragraph("0001012223",ratFont);
            Paragraph p4 = new Paragraph("Design", ratFont);
            Paragraph p5 = new Paragraph(desg_no, ratFont);
            Paragraph p6 = new Paragraph(rate_code, ratFont);
           // Paragraph p7 = new Paragraph(pdt, ratFont);
            
           Chunk glue1 = new Chunk(new VerticalPositionMark());
           Chunk glue2 = new Chunk(new VerticalPositionMark());
           Chunk glue3 = new Chunk(new VerticalPositionMark());
           Chunk glue4 = new Chunk(new VerticalPositionMark());
          
           
           p4.add(new Chunk(glue1));
           p4.add(purno);
           
           p5.add(new Chunk(glue2));
           p5.add(pdt);
           
           p4.add(new Chunk(glue3));
           p4.add("MRP");
          
           p5.add(new Chunk(glue4));
           p5.add(rate);
           
          
           
          // p6.add(new Chunk(glue4));
          // p6.add(pdt);
           
           
           //document.add(p3);            
           document.add(p4);
           document.add(p5);
           document.add(p6);
           
           document.close();
           System.out.println("Document Generated...!!!!!!");
             document.close();

             System.out.println("Document Generated...!!!!!!");
         } catch (Exception e) {
             e.printStackTrace();
         }
         return barcode+".pdf";
    }
    
    public String getGSTamtInWord(String invNo,String colmn_nm,String co_id,String table_nm)
    {
    	MyConnection mc=new MyConnection();
    	ResultSet rs=null;
    	String generated_val="";
    	try{
    	conn=mc.getConnection("adm_retail");
    	Statement stmt=conn.createStatement();
    	String sql="select fin_igst_amt+fin_cgst_amt+fin_sgst_amt from "+table_nm+" where co_id="+co_id+" and "+colmn_nm+"='"+invNo+"'";
    	System.out.println(sql+"-match is-"+table_nm);
    	rs=stmt.executeQuery(sql);
    	rs.next();
    	double amt=rs.getDouble(1);
    	NumberToWordsConverter ctx= new NumberToWordsConverter(amt);
    	generated_val=ctx.returnText();
    	conn.close();
    	}catch (Exception ex) {
            ex.printStackTrace();
        }
    	System.out.println(generated_val);
    	return generated_val;
    	
    	
    }
    public String getMailIdFromUser(String user_id)
    {
    	MyConnection mc=new MyConnection();
    	ResultSet rs=null;
    	String generated_val="";
    	try{
    	conn=mc.getConnection("adm_retail");
    	Statement stmt=conn.createStatement();
    	String sql="select email from adm_reg where user_id ='"+user_id+"'";
    	//System.out.println(sql+"-match is-"+table_nm);
    	rs=stmt.executeQuery(sql);
    	rs.next();
    	
    	generated_val=rs.getString(1);
    	conn.close();
    	}catch (Exception ex) {
            ex.printStackTrace();
        }
    	System.out.println(generated_val);
    	return generated_val;
    	
    	
    }
    public void setPermission(String module_id, String user_id, String project_id) {
        try {
            this.conf = DataSourceConfig.getBatchConnection();
            this.conf.makeConnection("vareli_sms");
            this.conf.setSql("SELECT * FROM TBL_PROJECT_MODULE_USER_MAP WHERE MODULE_ID = ? AND USER_ID = ? AND PROJECT_ID = ?");
            this.conf.setResultSet(1);
            this.conf.setSPara(1, module_id);
            this.conf.setSPara(2, user_id);
            this.conf.setSPara(3, project_id);
            ResultSet rs = this.conf.fetchData();
            rs.next();
            setAdd_permission(nullOmit(rs.getString("ADD_PERMISSION")));
            setEdit_permission(nullOmit(rs.getString("EDIT_PERMISSION")));
            setDelete_permission(nullOmit(rs.getString("DELETE_PERMISSION")));
            setReport_permission(nullOmit(rs.getString("REPORT_PERMISSION")));
            this.conf.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
     
    public String nullOmit(String s) {
        if (s != null) {
            return s;
        }
        return "false";
    }

    public String findCategoryNameById(int category_id) {
        String category_name = "";
        String qry = "SELECT CATEGORY_NAME FROM TBL_MASTER_CATEGORY WHERE ID = " + category_id + " AND ACTIVE = 'Y' AND IS_DELETE = 0";
        System.out.println("qry: " + qry);
        try {
            this.conf = DataSourceConfig.getBatchConnection();
            this.conf.makeConnection("vareli_sms");
            this.conf.setSql(qry);
            this.conf.setResultSet(1);
            ResultSet rs = this.conf.fetchData();
            rs.next();
            category_name = rs.getString("CATEGORY_NAME");
            System.out.println("category_name: " + category_name);
            this.conf.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return category_name;
    }
    
    public int findOrgIdByCoId(int id)
    {
    	MyConnection mc=new MyConnection();
    	ResultSet rs=null;
    	int fin_id=0;
    	try{
    	conn=mc.getConnection("adm_retail");
    	Statement stmt=conn.createStatement();
    	String sql="SELECT org_id FROM mst_company where co_id='"+id+"' and active='Y'";
    	rs=stmt.executeQuery(sql);
    	rs.next();
    	fin_id=rs.getInt(1);
    	conn.close();
    	}catch (Exception ex) {
            ex.printStackTrace();
        }
    	return fin_id;
    	
    	
    }
    
    public int updateSerialNumber(String flag,int dbId)
    {
    	MyConnection mc=new MyConnection();
    	
    	int fin_id=0;
    	try{
    	conn=mc.getConnection("adm_retail");
    	Statement stmt=conn.createStatement();
    	String sql="update mst_yr_sl_map set slno=slno+1 where active='Y' and doc_id='"+flag+"' and id="+dbId;
    	 //update mst_yr_sl_map set slno=slno+1 where active='Y' and doc_id='CASR' ;
    	fin_id=stmt.executeUpdate(sql);
    	
    	conn.close();
    	}catch (Exception ex) {
            ex.printStackTrace();
        }
    	return fin_id;
    	
    	
    }
    
    public String findOrgNameByCoId(int id)
    {
    	MyConnection mc=new MyConnection();
    	ResultSet rs=null;
    	String org_nm=null;
    	try{
    	conn=mc.getConnection("adm_retail");
    	Statement stmt=conn.createStatement();
    	String sql="SELECT b.org_nm FROM mst_company a left join adm_org b on(a.org_id=b.org_id) where co_id='"+id+"' and b.active='Y'";
    	rs=stmt.executeQuery(sql);
    	rs.next();
    	org_nm=rs.getString(1);
    	conn.close();
    	}catch (Exception ex) {
            ex.printStackTrace();
        }
    	return org_nm;
    	
    	
    }
    
    public String findCoNameFromId(int id)
    {
    	MyConnection mc=new MyConnection();
    	ResultSet rs=null;
    	String fin_id=null;
    	try{
    	conn=mc.getConnection("adm_retail");
    	Statement stmt=conn.createStatement();
    	String sql="SELECT concat(co_nm,', ',outlet) co_nm FROM mst_company where co_id='"+id+"' and active='Y'";
    	rs=stmt.executeQuery(sql);
    	rs.next();
    	fin_id=rs.getString(1);
    	conn.close();
    	}catch (Exception ex) {
            ex.printStackTrace();
        }
    	return fin_id;
    	
    	
    }
    
    public String findCoNameExceptOutletFromId(int id)
    {
    	MyConnection mc=new MyConnection();
    	ResultSet rs=null;
    	String fin_id=null;
    	try{
    	conn=mc.getConnection("adm_retail");
    	Statement stmt=conn.createStatement();
    	String sql="SELECT co_nm FROM mst_company where co_id='"+id+"' and active='Y'";
    	rs=stmt.executeQuery(sql);
    	rs.next();
    	fin_id=rs.getString(1);
    	conn.close();
    	}catch (Exception ex) {
            ex.printStackTrace();
        }
    	return fin_id;
    	
    	
    }
    public String[] findFinalUpdatedId(String id,String coid,String p_type)
    {
    	MyConnection mc=new MyConnection();
    	ResultSet rs=null;
    	ResultSet rsp=null;
    	String doc_id=null;
    	String prefix=null;
    	String digits=null;
    	String sufix=null;
    	String dbId=null;
    	String fin_id[]={"0","1"};
    	int slno=0;
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	Date date = new Date();
    	String curdate=dateFormat.format(date);
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(date);
    	int year = cal.get(Calendar.YEAR);
    	int month = cal.get(Calendar.MONTH);
    	int day = cal.get(Calendar.DAY_OF_MONTH);
    	try{
    	conn=mc.getConnection("adm_retail");
    	Statement stmt=conn.createStatement();
    	String sql1="SELECT digits,sln_pattern FROM mst_document where co_id="+coid+" and type='"+p_type+"' and doc_id='"+id+"'";
    	System.out.println(sql1);
    	rsp=stmt.executeQuery(sql1);
    	rsp.next();
    	int digit=rsp.getInt(1);
    	String type=rsp.getString(2);
    	String sql=null;
    	if(type.equals("Y"))
    	{
    		sql="SELECT doc_id,prefix,ifnull(suffix,''),slno,id FROM mst_yr_sl_map where co_id="+coid+" and doc_id='"+id+"' and type='"+p_type+"'  and active='Y'";
    		System.out.println("sqls is:-"+sql);
    	}
    	else if(type.equals("M"))
    	{
    		sql="SELECT doc_id,prefix,ifnull(suffix,''),slno,id FROM mst_yr_sl_map where co_id="+coid+" and doc_id='"+id+"' and mnth="+month+" and type='"+p_type+"' and active='Y'";	
    		System.out.println("sqls is:-"+sql);
    	}
    	else
    	{
    		sql="SELECT doc_id,prefix,ifnull(suffix,''),slno,id FROM mst_yr_sl_map where co_id="+coid+" and doc_id='"+id+"' and mnth="+month+"  and type='"+p_type+"' and  days="+day+" and active='Y'";	
    		System.out.println("sqls is:-"+sql);
    	}
    	rs=stmt.executeQuery(sql);
    	rs.next();
    	doc_id=rs.getString(1);
    	prefix=rs.getString(2);
    	digits=String.valueOf(digit);
    	sufix=rs.getString(3);
    	slno=rs.getInt(4);
    	dbId=rs.getString(5);
    	slno=slno+1;
    	if(!sufix.equals("")  )
    	{
    		fin_id[0]=	prefix+"/"+org.apache.commons.lang.StringUtils.leftPad(String.valueOf(slno), Integer.parseInt(digits), "0")+"/"+sufix;
    		fin_id[1]=dbId;
    		
    	}else{
    		fin_id[0]=	prefix+"/"+org.apache.commons.lang.StringUtils.leftPad(String.valueOf(slno), Integer.parseInt(digits), "0");
    		fin_id[1]=dbId;
    	}
    	conn.close();
    	}catch (Exception ex) {
            ex.printStackTrace();
        }
    	return fin_id;
    	
    	
    }
    
    public String currentFinYear()
    {
    	MyConnection mc=new MyConnection();
    	ResultSet rs=null;
    	String fin_val="";
    	try{
    		conn=mc.getConnection("adm_retail");
        	Statement stmt=conn.createStatement();
        	String sql="SELECT yr_cd FROM mst_yr_code where active='Y'";
        	rs=stmt.executeQuery(sql);
        	while(rs.next())
        	{
        		fin_val=fin_val+rs.getString(1);
        	}
    		
    		
    	}catch (Exception ex) {
            ex.printStackTrace();
        }
    	
    	return fin_val;
    	
    }
    public String findDesignByDisgnId(int val)
    {
    	MyConnection mc=new MyConnection();
    	ResultSet rs=null;
    	String fin_id="";
    	try{
    	conn=mc.getConnection("adm_retail");
    	Statement stmt=conn.createStatement();
    	String sql="SELECT tr_id,desg_no FROM mst_design where tr_id="+val+" and active='Y'";
    	rs=stmt.executeQuery(sql);
    	rs.next();
    	fin_id=rs.getString("desg_no");
    	conn.close();
    	}catch (Exception ex) {
            ex.printStackTrace();
        }
    	return fin_id;
    	
    	
    }
    
    public int findNameById(int id)
    {
    	MyConnection mc=new MyConnection();
    	ResultSet rs=null;
    	int fin_id=0;
    	try{
    	conn=mc.getConnection("adm_retail");
    	Statement stmt=conn.createStatement();
    	String sql="SELECT org_id FROM mst_company where co_id='"+id+"' and active='Y'";
    	rs=stmt.executeQuery(sql);
    	rs.next();
    	fin_id=rs.getInt(1);
    	conn.close();
    	}catch (Exception ex) {
            ex.printStackTrace();
        }
    	return fin_id;
    	
    	
    }
    public String findStateNameById(int state_id)
    {
    	MyConnection mc=new MyConnection();
    	ResultSet rs=null;
    	String state_nm="";
    	try{
    	conn=mc.getConnection("adm_retail");
    	Statement stmt=conn.createStatement();
    	String sql="SELECT state_nm FROM mst_state where state_id='"+state_id+"' and active='Y'";
    	rs=stmt.executeQuery(sql);
    	rs.next();
    	state_nm=rs.getString(1);
    	conn.close();
    	}catch (Exception ex) {
            ex.printStackTrace();
        }
    	return state_nm;
    	
    	
    }
    public String findCityNameById(int city_id)
    {
    	MyConnection mc=new MyConnection();
    	ResultSet rs=null;
    	String city_nm="";
    	try{
    	conn=mc.getConnection("adm_retail");
    	Statement stmt=conn.createStatement();
    	String sql="SELECT city_nm FROM mst_city where city_id='"+city_id+"' and active='Y'";
    	rs=stmt.executeQuery(sql);
    	rs.next();
    	city_nm=rs.getString(1);
    	conn.close();
    	}catch (Exception ex) {
            ex.printStackTrace();
        }
    	return city_nm;
    	
    	
    }
    public String findItemTypeNameById(int item)
    {
    	MyConnection mc=new MyConnection();
    	ResultSet rs=null;
    	String itm_typ_nm="";
    	try{
    	conn=mc.getConnection("adm_retail");
    	Statement stmt=conn.createStatement();
    	String sql="SELECT itm_typ_nm FROM mst_itm_typ where itm_typ_id='"+item+"' and active='Y'";
    	rs=stmt.executeQuery(sql);
    	rs.next();
    	itm_typ_nm=rs.getString(1);
    	conn.close();
    	}catch (Exception ex) {
            ex.printStackTrace();
        }
    	return itm_typ_nm;
    	
    	
    }
    public String findItemNameById(int item)
    {
    	MyConnection mc=new MyConnection();
    	ResultSet rs=null;
    	String itm="";
    	try{
    	conn=mc.getConnection("adm_retail");
    	Statement stmt=conn.createStatement();
    	String sql="SELECT itm_nm FROM mst_fp_itm where itm_id='"+item+"' and active='Y'";
    	rs=stmt.executeQuery(sql);
    	rs.next();
    	itm=rs.getString(1);
    	conn.close();
    	}catch (Exception ex) {
            ex.printStackTrace();
        }
    	return itm;
    	
    	
    }

//
//    public String findSubCategoryNameById(int sub_category_id) {
//        String sub_category_name = "";
//        String qry = "SELECT SUB_CATEGORY_NAME FROM TBL_MASTER_SUBCATEGORY WHERE ID = " + sub_category_id + " AND ACTIVE = 'Y' " + "AND IS_DELETE = 1";
//
//        System.out.println("qry: " + qry);
//        try {
//            this.conf = DataSourceConfig.getBatchConnection();
//            this.conf.makeConnection("vareli_sms");
//            this.conf.setSql(qry);
//            this.conf.setResultSet(1);
//            ResultSet rs = this.conf.fetchData();
//            rs.next();
//            sub_category_name = rs.getString("SUB_CATEGORY_NAME");
//            System.out.println("sub_category_name: " + sub_category_name);
//            this.conf.closeConnection();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return sub_category_name;
//    }

//    public String findSpecificationNameById(int specification_id) {
//        String specification_name = "";
//        String qry = "SELECT NAME FROM TBL_MASTER_COMMON WHERE ID = " + specification_id + " AND TYPE = 2 AND ACTIVE = 'Y' AND IS_DELETE = 0";
//        System.out.println("qry: " + qry);
//        try {
//            this.conf = DataSourceConfig.getBatchConnection();
//            this.conf.makeConnection("vareli_sms");
//            this.conf.setSql(qry);
//            this.conf.setResultSet(1);
//            ResultSet rs = this.conf.fetchData();
//            rs.next();
//            specification_name = rs.getString("NAME");
//            System.out.println("specification_name: " + specification_name);
//            this.conf.closeConnection();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return specification_name;
//    }

    

    public Date stringToDate(String tempDate) {
        Date date = null;
        try {
            if (!tempDate.equals("")) {
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                date = formatter.parse(tempDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public Date stringToDate2(String tempDate) {
        Date date = null;
        try {
            if (!tempDate.equals("")) {
                DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                date = formatter.parse(tempDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public String dateToString(Date tempDate) {
        String date = "";
        if (tempDate != null) {
            date = new SimpleDateFormat("yyyy-MM-dd").format(tempDate);
        }
        return date;
    }

    public String dateToString2(Date tempDate) {
        String date = "";
        if (tempDate != null) {
            date = new SimpleDateFormat("ddMyy").format(tempDate);
        }
        return date;
    }

    public String dateToString3(Date tempDate) {
        String date = "";
        if (tempDate != null) {
            date = new SimpleDateFormat("dd-MM-yyyy").format(tempDate);
        }
        return date;
    }

    public Date DateToDate(Date tempDate) {
        Date date = null;
        try {
            if (tempDate != null) {
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                date = tempDate;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }




    public String getMonthCode() {
        Date date = new Date();
        String month = null;

        Format formatter = new SimpleDateFormat("MM");
        String s = formatter.format(date);
        if (s.equals("01")) {
            month = "A";
        } else if (s.equals("02")) {
            month = "B";
        } else if (s.equals("03")) {
            month = "C";
        } else if (s.equals("04")) {
            month = "D";
        } else if (s.equals("05")) {
            month = "E";
        } else if (s.equals("06")) {
            month = "F";
        } else if (s.equals("07")) {
            month = "G";
        } else if (s.equals("08")) {
            month = "H";
        } else if (s.equals("09")) {
            month = "I";
        } else if (s.equals("10")) {
            month = "J";
        } else if (s.equals("11")) {
            month = "K";
        } else if (s.equals("12")) {
            month = "L";
        }
        return month;
    }

    public String getMonthCode2(String m) {
        String s = m;
        String month = null;
        if (s.equals("01")) {
            month = "A";
        } else if (s.equals("02")) {
            month = "B";
        } else if (s.equals("03")) {
            month = "C";
        } else if (s.equals("04")) {
            month = "D";
        } else if (s.equals("05")) {
            month = "E";
        } else if (s.equals("06")) {
            month = "F";
        } else if (s.equals("07")) {
            month = "G";
        } else if (s.equals("08")) {
            month = "H";
        } else if (s.equals("09")) {
            month = "I";
        } else if (s.equals("10")) {
            month = "J";
        } else if (s.equals("11")) {
            month = "K";
        } else if (s.equals("12")) {
            month = "L";
        }
        return month;
    }

    public int findPurchaseSerialStatusByInstallation(String id) {
        int uom = 0;
         System.out.println("Serial no is : " + id);
        try {
            this.conf = DataSourceConfig.getBatchConnection();
            this.conf.makeConnection("vareli_sms");
            this.conf.setSql("select count(*) from trn_installation_serial where serial_number='" + id + "' and active='Y'");
            this.conf.setResultSet(1);
            ResultSet rs = this.conf.fetchData();
            rs.next();
            uom = rs.getInt(1);
            System.out.println("uom : " + uom);
            this.conf.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return uom;
    }

    public String getAreaById(int id) {
        String desc = "";
        try {
            this.conf = DataSourceConfig.getBatchConnection();
            this.conf.makeConnection("vareli_sms");
            this.conf.setSql("SELECT AREA_NAME FROM TBL_MASTER_AREA WHERE ID = '" + id + "' AND ACTIVE='Y'");
            this.conf.setResultSet(1);
            ResultSet rs = this.conf.fetchData();
            rs.next();
            desc = rs.getString("AREA_NAME");
            this.conf.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return desc;
    }

    public String findItemDescriptionByCode(int id) {
        String desc = "";
        try {
            this.conf = DataSourceConfig.getBatchConnection();
            this.conf.makeConnection("vareli_sms");
            this.conf.setSql("SELECT NAME from tbl_master_common where ID='" + id + "'");
            this.conf.setResultSet(1);
            ResultSet rs = this.conf.fetchData();
            rs.next();
            desc = rs.getString("NAME");
            this.conf.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return desc;
    }

    public String findMakeByCode(String id) {
        String make = "";
        String qry = "SELECT MAKE from tbl_master_item where ID='" + id + "'";
        System.out.println("qryMake: " + qry);
        try {
            this.conf = DataSourceConfig.getBatchConnection();
            this.conf.makeConnection("vareli_sms");
            this.conf.setSql(qry);
            this.conf.setResultSet(1);
            ResultSet rs = this.conf.fetchData();
            rs.next();
            make = rs.getString("MAKE");
            this.conf.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return make;
    }

    public String findItemDtlsById(int item_id) {
        String item_dtls = "";
        try {
            this.conf = DataSourceConfig.getBatchConnection();
            this.conf.makeConnection("vareli_sms");
            this.conf.setSql("SELECT concat(b.category_name,':',c.sub_category_name,':',a.make,':',a.model) FROM tbl_master_item a JOIN tbl_master_CATEGORY b ON a.category_id=b.id JOIN tbl_master_subcategory c ON a.sub_category_id=c.id WHERE a.id=" + item_id);

            this.conf.setResultSet(1);
            ResultSet rs = this.conf.fetchData();
            rs.next();
            item_dtls = rs.getString(1);
            this.conf.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return item_dtls;
    }

    public String getUserType(String userid) {
        String userType = "";
        try {
            this.conf = DataSourceConfig.getBatchConnection();
            this.conf.makeConnection("vareli_sms");
            this.conf.setSql("SELECT USER_TYPE FROM tbl_login_master where USER_ID='" + userid + "'");
            this.conf.setResultSet(1);
            ResultSet rs = this.conf.fetchData();
            rs = this.conf.fetchData();
            if (rs.next()) {
                userType = rs.getString("USER_TYPE");
            }
            this.conf.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userType;
    }
    public String CCFR_Complete(String userid,String call_no) {
    	PreparedStatement pst = null;
    	Connection con=null;
        String userType = "";
        try {
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            String connectionURL = "jdbc:mysql://localhost/vareli_sms";
            con = DriverManager.getConnection(connectionURL, "root", "root");
            
            String queryString = "update trn_call_register set call_status='P',modified_on=now(),modified_by=? where registration_number=?";

            pst = (PreparedStatement) con.prepareStatement(queryString);
            pst.setString(1, userid);
            pst.setString(2, call_no);
            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "success";
    }

    public String getUserAuthorize(String userid) {
        String authorise = "";
        try {
            this.conf = DataSourceConfig.getBatchConnection();
            this.conf.makeConnection("vareli_sms");
            this.conf.setSql("SELECT AUTHORIZE FROM tbl_master_authorization where USER_ID='" + userid + "'");
            this.conf.setResultSet(1);
            ResultSet rs = this.conf.fetchData();
            rs = this.conf.fetchData();
            if (rs.next()) {
                authorise = rs.getString("AUTHORIZE");
            }
            this.conf.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return authorise;
    }

    public String getAdd_permission() {
        return this.add_permission;
    }

    public void setAdd_permission(String add_permission) {
        this.add_permission = add_permission;
    }

    public String getDelete_permission() {
        return this.delete_permission;
    }

    public void setDelete_permission(String delete_permission) {
        this.delete_permission = delete_permission;
    }

    public String getEdit_permission() {
        return this.edit_permission;
    }

    public void setEdit_permission(String edit_permission) {
        this.edit_permission = edit_permission;
    }

    public String getReport_permission() {
        return this.report_permission;
    }

    public void setReport_permission(String report_permission) {
        this.report_permission = report_permission;
    }
}

///*     */ package com.vareli.services.util;
///*     */
///*     */ import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
///*     */ import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
///*     */ import com.mysql.jdbc.PreparedStatement;
///*     */ import com.mysql.jdbc.Statement;
///*     */ import com.vareli.services.dao.ConnectionFactory;
///*     */ import com.vareli.services.dao.DataSourceConfig;
///*     */ import java.sql.CallableStatement;
///*     */ import java.sql.Connection;
///*     */ import java.sql.DriverManager;
///*     */ import java.sql.ResultSet;
///*     */ import java.text.DateFormat;
///*     */ import java.text.Format;
///*     */ import java.text.SimpleDateFormat;
///*     */ import java.util.Date;
///*     */ import org.hibernate.Session;
///*     */ import org.hibernate.Transaction;
///*     */
///*     */ public class UtilityHelper /*     */ {
//    /*     */ private String add_permission;
//    /*     */    private String edit_permission;
//    /*     */    private String delete_permission;
//    /*     */    private String report_permission;
//    /*  33 */    ConnectionFactory conf = null;
//    /*  34 */    Connection conn = null;
//    /*     */
//    /*  36 */    CallableStatement cs = null;
//    /*     */
//    /*     */    @SessionTarget
//    /*     */ Session session;
//    /*     */
//    /*     */    @TransactionTarget
//    /*     */ Transaction transaction;
//    /*     */
//    /*     */ public void setPermission(String module_id, String user_id, String project_id) {
//        try {
//            this.conf = DataSourceConfig.getBatchConnection();
//            /*  46 */ this.conf.makeConnection("vareli_sms");
//            /*  47 */ this.conf.setSql("SELECT * FROM TBL_PROJECT_MODULE_USER_MAP WHERE MODULE_ID = ? AND USER_ID = ? AND PROJECT_ID = ?");
//            /*  48 */ this.conf.setResultSet(1);
//            /*  49 */ this.conf.setSPara(1, module_id);
//            /*  50 */ this.conf.setSPara(2, user_id);
//            /*  51 */ this.conf.setSPara(3, project_id);
//            /*  52 */ ResultSet rs = this.conf.fetchData();
//            /*  53 */ rs.next();
//            /*  54 */ setAdd_permission(nullOmit(rs.getString("ADD_PERMISSION")));
//            /*  55 */ setEdit_permission(nullOmit(rs.getString("EDIT_PERMISSION")));
//            /*  56 */ setDelete_permission(nullOmit(rs.getString("DELETE_PERMISSION")));
//            /*  57 */ setReport_permission(nullOmit(rs.getString("REPORT_PERMISSION")));
//            /*  58 */ this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /*  60 */ ex.printStackTrace();
//            /*     */        }
//    }
//    /*     */
//    /*     */ public String nullOmit(String s) /*     */ {
//        /*  65 */ if (s != null) {
//            /*  66 */ return s;
//            /*     */        }
//        /*  68 */ return "false";
//        /*     */    }
//    /*     */
//    /*     */ public String findCategoryNameById(int category_id) /*     */ {
//        /*  74 */ String category_name = "";
//        /*  75 */ String qry = "SELECT CATEGORY_NAME FROM TBL_MASTER_CATEGORY WHERE ID = " + category_id + " AND ACTIVE = 'Y' AND IS_DELETE = 0";
//        /*  76 */ System.out.println("qry: " + qry);
//        /*     */ try {
//            /*  78 */ this.conf = DataSourceConfig.getBatchConnection();
//            /*  79 */ this.conf.makeConnection("vareli_sms");
//            /*  80 */ this.conf.setSql(qry);
//            /*  81 */ this.conf.setResultSet(1);
//            /*  82 */ ResultSet rs = this.conf.fetchData();
//            /*  83 */ rs.next();
//            /*  84 */ category_name = rs.getString("CATEGORY_NAME");
//            /*  85 */ System.out.println("category_name: " + category_name);
//            /*  86 */ this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /*  88 */ ex.printStackTrace();
//            /*     */        }
//        /*  90 */ return category_name;
//        /*     */    }
//    /*     */
//    /*     */ public String findSubCategoryNameById(int sub_category_id) /*     */ {
//        /*  95 */ String sub_category_name = "";
//        /*  96 */ String qry = "SELECT SUB_CATEGORY_NAME FROM TBL_MASTER_SUBCATEGORY WHERE ID = " + sub_category_id + " AND ACTIVE = 'Y' " + "AND IS_DELETE = 0";
//        /*     */
//        /*  98 */ System.out.println("qry: " + qry);
//        /*     */ try {
//            /* 100 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 101 */ this.conf.makeConnection("vareli_sms");
//            /* 102 */ this.conf.setSql(qry);
//            /* 103 */ this.conf.setResultSet(1);
//            /* 104 */ ResultSet rs = this.conf.fetchData();
//            /* 105 */ rs.next();
//            /* 106 */ sub_category_name = rs.getString("SUB_CATEGORY_NAME");
//            /* 107 */ System.out.println("sub_category_name: " + sub_category_name);
//            /* 108 */ this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 110 */ ex.printStackTrace();
//            /*     */        }
//        /* 112 */ return sub_category_name;
//        /*     */    }
//    /*     */
//    /*     */ public String findSpecificationNameById(int specification_id) /*     */ {
//        /* 117 */ String specification_name = "";
//        /* 118 */ String qry = "SELECT NAME FROM TBL_MASTER_COMMON WHERE ID = " + specification_id + " AND TYPE = 2 AND ACTIVE = 'Y' AND IS_DELETE = 0";
//        /* 119 */ System.out.println("qry: " + qry);
//        /*     */ try {
//            /* 121 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 122 */ this.conf.makeConnection("vareli_sms");
//            /* 123 */ this.conf.setSql(qry);
//            /* 124 */ this.conf.setResultSet(1);
//            /* 125 */ ResultSet rs = this.conf.fetchData();
//            /* 126 */ rs.next();
//            /* 127 */ specification_name = rs.getString("NAME");
//            /* 128 */ System.out.println("specification_name: " + specification_name);
//            /* 129 */ this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 131 */ ex.printStackTrace();
//            /*     */        }
//        /* 133 */ return specification_name;
//        /*     */    }
//    /*     */
//    /*     */ public String getNameById(int id) /*     */ {
//        /* 147 */ String name = "";
//        /*     */ try {
//            /* 149 */ String sql = "SELECT CONCAT(EMPLOYEE_FIRST_NAME,' ',EMPLOYEE_MIDDLE_NAME,' ',EMPLOYEE_LAST_NAME) FROM TBL_MASTER_EMPLOYEE WHERE ID = '" + id + "'";
//            /*     */
//            /* 151 */ System.out.println(sql);
//            /* 152 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 153 */ this.conf.makeConnection("vareli_sms");
//            /* 154 */ this.conf.setSql(sql);
//            /* 155 */ this.conf.setResultSet(1);
//            /* 156 */ ResultSet rs = this.conf.fetchData();
//            /* 157 */ rs.next();
//            /* 158 */ name = rs.getString(1);
//            /* 159 */ this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 161 */ ex.printStackTrace();
//            /*     */        }
//        /* 163 */ return name;
//        /*     */    }
//    /*     */
//    /*     */ public Date stringToDate(String tempDate) {
//        /* 167 */ Date date = null;
//        /*     */ try {
//            /* 169 */ if (!tempDate.equals("")) /*     */ {
//                /* 171 */ DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//                /* 172 */ date = formatter.parse(tempDate);
//                /*     */            }
//            /*     */        } catch (Exception e) {
//            /* 175 */ e.printStackTrace();
//            /*     */        }
//        /* 177 */ return date;
//        /*     */    }
//    /*     */
//    /*     */ public Date stringToDate2(String tempDate) {
//        /* 181 */ Date date = null;
//        /*     */ try {
//            /* 183 */ if (!tempDate.equals("")) /*     */ {
//                /* 185 */ DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//                /* 186 */ date = formatter.parse(tempDate);
//                /*     */            }
//            /*     */        } catch (Exception e) {
//            /* 189 */ e.printStackTrace();
//            /*     */        }
//        /* 191 */ return date;
//        /*     */    }
//    /*     */
//    /*     */ public String dateToString(Date tempDate) {
//        /* 195 */ String date = "";
//        /* 196 */ if (tempDate != null) {
//            /* 197 */ date = new SimpleDateFormat("yyyy-MM-dd").format(tempDate);
//            /*     */        }
//        /* 199 */ return date;
//        /*     */    }
//    /*     */
//    /*     */ public String dateToString2(Date tempDate) {
//        /* 203 */ String date = "";
//        /* 204 */ if (tempDate != null) {
//            /* 205 */ date = new SimpleDateFormat("ddMyy").format(tempDate);
//            /*     */        }
//        /* 207 */ return date;
//        /*     */    }
//    /*     */
//    /*     */ public String dateToString3(Date tempDate) {
//        /* 211 */ String date = "";
//        /* 212 */ if (tempDate != null) {
//            /* 213 */ date = new SimpleDateFormat("dd-MM-yyyy").format(tempDate);
//            /*     */        }
//        /* 215 */ return date;
//        /*     */    }
//    /*     */
//    /*     */ public Date DateToDate(Date tempDate) {
//        /* 219 */ Date date = null;
//        /*     */ try {
//            /* 221 */ if (tempDate != null) /*     */ {
//                /* 223 */ DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//                /* 224 */ date = tempDate;
//                /*     */            }
//            /*     */        } catch (Exception e) {
//            /* 227 */ e.printStackTrace();
//            /*     */        }
//        /* 229 */ return date;
//        /*     */    }
//    /*     */
//    /*     */ public int tableRowCountMaster(String tableName) {
//        /* 233 */ int idPattern = 0;
//        /*     */ try {
//            /* 235 */ String sql = "SELECT MAX(ID) FROM " + tableName;
//            /* 236 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 237 */ this.conf.makeConnection("vareli_sms");
//            /* 238 */ this.conf.setSql(sql);
//            /* 239 */ this.conf.setResultSet(1);
//            /* 240 */ ResultSet rs = this.conf.fetchData();
//            /* 241 */ rs.next();
//            /* 242 */ idPattern = rs.getInt(1) + 1;
//            System.out.println("idPattern: " + idPattern);
//            /* 243 */ this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 245 */ ex.printStackTrace();
//            /*     */        }
//        /* 247 */ return idPattern;
//        /*     */    }
//    /*     */
//    /*     */ public String tableRowCount(String tableName) {
//        /* 251 */ String idPattern = null;
//        /*     */ try {
//            /* 253 */ String sql = "SELECT COUNT(*) FROM " + tableName;
//            /* 254 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 255 */ this.conf.makeConnection("vareli_sms");
//            /* 256 */ this.conf.setSql(sql);
//            /* 257 */ this.conf.setResultSet(1);
//            /* 258 */ ResultSet rs = this.conf.fetchData();
//            /* 259 */ rs.next();
//            /* 260 */ String count = "" + (rs.getInt(1) + 1);
//            /* 261 */ String str = "0000000000";
//            /* 262 */ idPattern = str.substring(0, str.length() - count.length()) + count;
//            /* 263 */ this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 265 */ ex.printStackTrace();
//            /*     */        }
//        /* 267 */ return idPattern;
//        /*     */    }
//    /*     */
//    /*     */ public String findLocationNameByCode(int location_id) {
//        /* 271 */ String location_name = "";
//        /*     */ try {
//            /* 273 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 274 */ this.conf.makeConnection("vareli_sms");
//            /* 275 */ this.conf.setSql("SELECT LOCATION_NAME FROM tbl_master_location where ID='" + location_id + "'");
//            /* 276 */ this.conf.setResultSet(1);
//            /* 277 */ ResultSet rs = this.conf.fetchData();
//            /* 278 */ rs.next();
//            /* 279 */ location_name = rs.getString("LOCATION_NAME");
//            /* 280 */ System.out.println("location_name: " + location_name);
//            /* 281 */ this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 283 */ ex.printStackTrace();
//            /*     */        }
//        /* 285 */ return location_name;
//        /*     */    }
//    /*     */
//    /*     */ public String findStateNameByCode(int state_id) {
//        /* 289 */ String state_name = "";
//        /*     */ try {
//            /* 291 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 292 */ this.conf.makeConnection("vareli_sms");
//            /* 293 */ this.conf.setSql("SELECT STATE_NAME FROM tbl_master_state where ID='" + state_id + "'");
//            /* 294 */ this.conf.setResultSet(1);
//            /* 295 */ ResultSet rs = this.conf.fetchData();
//            /* 296 */ rs.next();
//            /* 297 */ state_name = rs.getString("STATE_NAME");
//            /* 298 */ System.out.println("state_name: " + state_name);
//            /* 299 */ this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 301 */ ex.printStackTrace();
//            /*     */        }
//        /* 303 */ return state_name;
//        /*     */    }
//    /*     */
//    /*     */ public String findTypeNameByCode(int id) {
//        /* 307 */ String type_name = "";
//        /*     */ try {
//            /* 309 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 310 */ this.conf.makeConnection("vareli_sms");
//            /* 311 */ this.conf.setSql("SELECT TYPE_NAME FROM tbl_master_type where ID='" + id + "'");
//            /* 312 */ this.conf.setResultSet(1);
//            /* 313 */ ResultSet rs = this.conf.fetchData();
//            /* 314 */ rs.next();
//            /* 315 */ type_name = rs.getString("TYPE_NAME");
//            /* 316 */ this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 318 */ ex.printStackTrace();
//            /*     */        }
//        /* 320 */ return type_name;
//        /*     */    }
//    /*     */
//    /*     */ public String findCategoryNameByCode(int id) {
//        /* 324 */ String category_name = "";
//        /*     */ try {
//            /* 326 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 327 */ this.conf.makeConnection("vareli_sms");
//            /* 328 */ this.conf.setSql("SELECT CATEGORY_NAME FROM tbl_master_CATEGORY where ID='" + id + "'");
//            /* 329 */ this.conf.setResultSet(1);
//            /* 330 */ ResultSet rs = this.conf.fetchData();
//            /* 331 */ rs.next();
//            /* 332 */ category_name = rs.getString("CATEGORY_NAME");
//            /* 333 */ this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 335 */ ex.printStackTrace();
//            /*     */        }
//        /* 337 */ return category_name;
//        /*     */    }
//    /*     */
//    /*     */ public int findCategoryIdByName(String name) {
//        /* 341 */ int category_id = 0;
//        /*     */ try {
//            /* 343 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 344 */ this.conf.makeConnection("vareli_sms");
//            /* 345 */ this.conf.setSql("SELECT ID FROM tbl_master_CATEGORY where CATEGORY_NAME='" + name + "'");
//            /* 346 */ this.conf.setResultSet(1);
//            /* 347 */ ResultSet rs = this.conf.fetchData();
//            /* 348 */ rs.next();
//            /* 349 */ category_id = rs.getInt("ID");
//            /* 350 */ this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 352 */ ex.printStackTrace();
//            /*     */        }
//        /* 354 */ return category_id;
//        /*     */    }
//    /*     */
//    /*     */ public int findCategoryCodeByid(int id) {
//        /* 358 */ int category_id = 0;
//        /*     */ try {
//            /* 360 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 361 */ this.conf.makeConnection("vareli_sms");
//            /* 362 */ this.conf.setSql("SELECT CATEGORY_ID FROM tbl_master_subcategory where ID='" + id + "'");
//            /* 363 */ this.conf.setResultSet(1);
//            /* 364 */ ResultSet rs = this.conf.fetchData();
//            /* 365 */ rs.next();
//            /* 366 */ category_id = rs.getInt("CATEGORY_ID");
//            /* 367 */ this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 369 */ ex.printStackTrace();
//            /*     */        }
//        /* 371 */ return category_id;
//        /*     */    }
//    /*     */
//    /*     */ public String findSubCategoryNameByCode(int id) {
//        /* 375 */ String subcategory_name = "";
//        /*     */ try {
//            /* 377 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 378 */ this.conf.makeConnection("vareli_sms");
//            /* 379 */ this.conf.setSql("SELECT SUB_CATEGORY_NAME FROM tbl_master_subcategory where ID='" + id + "'");
//            /* 380 */ this.conf.setResultSet(1);
//            /* 381 */ ResultSet rs = this.conf.fetchData();
//            /* 382 */ rs.next();
//            /* 383 */ subcategory_name = rs.getString("SUB_CATEGORY_NAME");
//            /* 384 */ System.out.println("subcategory_name: " + subcategory_name);
//            this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 386 */ ex.printStackTrace();
//            /*     */        }
//        /* 388 */ return subcategory_name;
//        /*     */    }
//    /*     */
//    /*     */ public String findCustomerNameByCode(int id) {
//        /* 392 */ String customer_name = "";
//        /*     */ try {
//            /* 394 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 395 */ this.conf.makeConnection("vareli_sms");
//            /* 396 */ this.conf.setSql("SELECT CUSTOMER_NAME FROM tbl_master_customer where ID='" + id + "'");
//            /* 397 */ this.conf.setResultSet(1);
//            /* 398 */ ResultSet rs = this.conf.fetchData();
//            /* 399 */ rs.next();
//            /* 400 */ customer_name = rs.getString("CUSTOMER_NAME");
//            this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 402 */ ex.printStackTrace();
//            /*     */        }
//        /* 404 */ return customer_name;
//        /*     */    }
//    /*     */
//    /*     */ public String findOEMCodeById(int id) {
//        /* 408 */ String customer_name = "";
//        /*     */ try {
//            /* 410 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 411 */ this.conf.makeConnection("vareli_sms");
//            /* 412 */ this.conf.setSql("SELECT OEM_CODE FROM tbl_master_customer where ID='" + id + "'");
//            /* 413 */ this.conf.setResultSet(1);
//            /* 414 */ ResultSet rs = this.conf.fetchData();
//            /* 415 */ rs.next();
//            /* 416 */ customer_name = rs.getString("OEM_CODE");
//            /* 417 */ System.out.println("customer_name: " + customer_name);
//            this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 419 */ ex.printStackTrace();
//            /*     */        }
//        /* 421 */ return customer_name;
//        /*     */    }
//    /*     */
//    /*     */ public String findConsigneeNameByCode(int id) {
//        /* 425 */ String consignee_name = "";
//        /*     */ try {
//            /* 427 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 428 */ this.conf.makeConnection("vareli_sms");
//            /* 429 */ this.conf.setSql("SELECT CONCAT(ADDRESS1,' ',ADDRESS2) from tbl_master_consignee where ID='" + id + "'");
//            /* 430 */ this.conf.setResultSet(1);
//            /* 431 */ ResultSet rs = this.conf.fetchData();
//            /* 432 */ rs.next();
//            /* 433 */ consignee_name = rs.getString("CONCAT(ADDRESS1,' ',ADDRESS2)");
//            this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 435 */ ex.printStackTrace();
//            /*     */        }
//        /* 437 */ return consignee_name;
//        /*     */    }
//    /*     */
//    /*     */ public String getCatName(int CatId) {
//        /* 441 */ String cat_name = "";
//        /* 442 */ String qry = "SELECT CATEGORY_NAME FROM TBL_MASTER_CATEGORY WHERE ID = " + CatId;
//        /* 443 */ System.out.println("qry: " + qry);
//        /*     */ try {
//            /* 445 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 446 */ this.conf.makeConnection("vareli_sms");
//            /* 447 */ this.conf.setSql(qry);
//            /* 448 */ this.conf.setResultSet(1);
//            /* 449 */ ResultSet rs = this.conf.fetchData();
//            /* 450 */ rs.next();
//            /* 451 */ cat_name = rs.getString("CATEGORY_NAME");
//            /* 452 */ System.out.println("cat_name: " + cat_name);
//            this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 454 */ ex.printStackTrace();
//            /*     */        }
//        /* 456 */ return cat_name;
//        /*     */    }
//    /*     */
//    /*     */ public int getCatIdFromItem(int ItemId) {
//        /* 460 */ int cat_id = 0;
//        /* 461 */ String qry = "SELECT CATEGORY_ID FROM TBL_MASTER_ITEM WHERE ID = " + ItemId;
//        /* 462 */ System.out.println("cat_id: " + cat_id);
//        /*     */ try {
//            /* 464 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 465 */ this.conf.makeConnection("vareli_sms");
//            /* 466 */ this.conf.setSql(qry);
//            /* 467 */ this.conf.setResultSet(1);
//            /* 468 */ ResultSet rs = this.conf.fetchData();
//            /* 469 */ rs.next();
//            /* 470 */ cat_id = Integer.parseInt(rs.getString("CATEGORY_ID"));
//            this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 472 */ ex.printStackTrace();
//            /*     */        }
//        /* 474 */ return cat_id;
//        /*     */    }
//    /*     */
//    /*     */ public String findItemNameByCode(int id, String order_code) {
//        /* 478 */ String item_name = "";
//        /* 479 */ String qry = "SELECT CATEGORY_NAME from tbl_master_CATEGORY where ID=(SELECT CAT_ID FROM trn_order_detail WHERE ITEM_ID='" + id + "'" + " and order_code_header='" + order_code + "'" + " and is_delete = 1)";
//        /*     */
//        /* 483 */ System.out.println("qryItem: " + qry);
//        /*     */ try {
//            /* 485 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 486 */ this.conf.makeConnection("vareli_sms");
//            /* 487 */ this.conf.setSql(qry);
//            /* 488 */ this.conf.setResultSet(1);
//            /* 489 */ ResultSet rs = this.conf.fetchData();
//            /* 490 */ rs.next();
//            /* 491 */ item_name = rs.getString("CATEGORY_NAME");
//            this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 493 */ ex.printStackTrace();
//            /*     */        }
//        /* 495 */ return item_name;
//        /*     */    }
//    /*     */
//    /*     */ public String findItemNameByCode2(int id) {
//        /* 499 */ String item_name = "";
//        /* 500 */ String qry = "SELECT CATEGORY_NAME from tbl_master_CATEGORY where ID='" + id + "'";
//        /* 501 */ System.out.println("qryItem: " + qry);
//        /*     */ try {
//            /* 503 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 504 */ this.conf.makeConnection("vareli_sms");
//            /* 505 */ this.conf.setSql(qry);
//            /* 506 */ this.conf.setResultSet(1);
//            /* 507 */ ResultSet rs = this.conf.fetchData();
//            /* 508 */ rs.next();
//            /* 509 */ item_name = rs.getString("CATEGORY_NAME");
//            this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 511 */ ex.printStackTrace();
//            /*     */        }
//        /* 513 */ return item_name;
//        /*     */    }
//    /*     */
//    /*     */ public String findItemSubNameByCode(int id) {
//        /* 517 */ String sub_cat = "";
//        /*     */ try {
//            /* 519 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 520 */ this.conf.makeConnection("vareli_sms");
//            /* 521 */ this.conf.setSql("SELECT SUB_CATEGORY_NAME from tbl_master_subcategory where ID='" + id + "'");
//            /* 522 */ this.conf.setResultSet(1);
//            /* 523 */ ResultSet rs = this.conf.fetchData();
//            /* 524 */ rs.next();
//            /* 525 */ sub_cat = rs.getString("SUB_CATEGORY_NAME");
//            this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 527 */ ex.printStackTrace();
//            /*     */        }
//        /* 529 */ return sub_cat;
//        /*     */    }
//    /*     */
//    /*     */ public int findDuplicate(String table_name, String col_name, String value) {
//        /* 533 */ int count = 0;
//        /* 534 */ String qry = "SELECT COUNT(*) FROM " + table_name + " WHERE " + col_name + " = UPPER(TRIM('" + value + "'))";
//        /* 535 */ System.out.println("qry: " + qry);
//        /*     */ try {
//            /* 537 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 538 */ this.conf.makeConnection("vareli_sms");
//            /* 539 */ this.conf.setSql(qry);
//            /* 540 */ this.conf.setResultSet(1);
//            /* 541 */ ResultSet rs = this.conf.fetchData();
//            /* 542 */ rs.next();
//            /* 543 */ count = rs.getInt(1);
//            this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 545 */ ex.printStackTrace();
//            /*     */        }
//        /* 547 */ return count;
//        /*     */    }
//    /*     */
//    /*     */ public int findDuplicateDtls(String cat, String sct, String dsc, String dtl) {
//        /* 551 */ int count = 0;
//        /* 552 */ String qry = "SELECT COUNT(*) FROM TBL_MASTER_ITEM_DESCRIPTION_DTLS WHERE CATEGORY_ID = " + cat + " AND SUBCATEGORY_ID = " + sct + " AND DESCRIPTION_ID = " + dsc + " AND DETAILS = UPPER(TRIM('" + dtl + "'))";
//        /*     */
//        /* 557 */ System.out.println("qry: " + qry);
//        /*     */ try {
//            /* 559 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 560 */ this.conf.makeConnection("vareli_sms");
//            /* 561 */ this.conf.setSql(qry);
//            /* 562 */ this.conf.setResultSet(1);
//            /* 563 */ ResultSet rs = this.conf.fetchData();
//            /* 564 */ rs.next();
//            /* 565 */ count = rs.getInt(1);
//            this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 567 */ ex.printStackTrace();
//            /*     */        }
//        /* 569 */ return count;
//        /*     */    }
//    /*     */
//    /*     */ public int findDuplicateVal(String table_name, String col_name1, String value1, String col_name2, String value2) {
//        /* 573 */ int count = 0;
//        /* 574 */ String qry = "SELECT COUNT(*) FROM " + table_name + " " + "WHERE " + col_name1 + " = UPPER(TRIM('" + value1 + "')) " + "AND " + col_name2 + " = UPPER(TRIM('" + value2 + "')) ";
//        /*     */
//        /* 577 */ System.out.println("qry: " + qry);
//        /*     */ try {
//            /* 579 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 580 */ this.conf.makeConnection("vareli_sms");
//            /* 581 */ this.conf.setSql(qry);
//            /* 582 */ this.conf.setResultSet(1);
//            /* 583 */ ResultSet rs = this.conf.fetchData();
//            /* 584 */ rs.next();
//            /* 585 */ count = rs.getInt(1);
//            this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 587 */ ex.printStackTrace();
//            /*     */        }
//        /* 589 */ return count;
//        /*     */    }
//    /*     */
//    /*     */ public int findCallRegisterOccarence(String pt) {
//        /* 593 */ String reg = pt;
//        /* 594 */ int oc = 0;
//        /*     */ try {
//            /* 596 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 597 */ this.conf.makeConnection("vareli_sms");
//            /* 598 */ this.conf.setSql("SELECT COUNT(*) FROM trn_call_register WHERE CALL_DATE LIKE '" + reg + "'");
//            this.conf.getSql();
//            /* 599 */ this.conf.setResultSet(1);
//            /* 600 */ ResultSet rs = this.conf.fetchData();
//            /* 601 */ rs.next();
//            /* 602 */ oc = rs.getInt(1) + 1;
//            this.conf.closeConnection();
//            /*     */        } /*     */ catch (Exception ex) {
//            /* 605 */ ex.printStackTrace();
//            /*     */        }
//        /* 607 */ return oc;
//        /*     */    }
//    
//    public int findLastSerial(String pt) {
//        /* 593 */ String reg = pt;
//        /* 594 */ int oc = 0;
//        /*     */ try {
//            /* 596 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 597 */ this.conf.makeConnection("vareli_sms");
//            /* 598 */ this.conf.setSql("SELECT MAX(SUBSTR(REGISTRATION_NUMBER, -3)) FROM trn_call_register WHERE CALL_DATE = '" + reg + "'");
//            this.conf.getSql();
//            /* 599 */ this.conf.setResultSet(1);
//            /* 600 */ ResultSet rs = this.conf.fetchData();
//            /* 601 */ rs.next();
//            /* 602 */ oc = rs.getInt(1) + 1;
//            System.out.println("oc: " + oc);
//            this.conf.closeConnection();
//            /*     */        } /*     */ catch (Exception ex) {
//            /* 605 */ ex.printStackTrace();
//            /*     */        }
//        /* 607 */ return oc;
//        /*     */    }
//
//    /*     */
//    /*     */ public String findCallRegisterSerial() {
//        /* 611 */ String reg = "Registration";
//        /* 612 */ String reg2 = null;
//        /*     */ try {
//            /* 614 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 615 */ this.conf.makeConnection("vareli_sms");
//            /* 616 */ this.conf.setSql("SELECT SERIAL_NUMBER from tbl_serial_number where PROJ_DESCRIPTION='" + reg + "'");
//            /* 617 */ this.conf.setResultSet(1);
//            /* 618 */ ResultSet rs = this.conf.fetchData();
//            /* 619 */ rs.next();
//            /* 620 */ int sub_cat = rs.getInt("SERIAL_NUMBER");
//            /* 621 */ sub_cat++;
//            /* 622 */ reg2 = "" + sub_cat;
//            this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 624 */ ex.printStackTrace();
//            /*     */        }
//        /* 626 */ return reg2;
//        /*     */    }
//    /*     */
//    /*     */ public void updateSerialTablePre(int pattern) {
//        /* 630 */ System.out.println("1");
//        /* 631 */ Connection con = null;
//        /* 632 */ PreparedStatement pst = null;
//        /* 633 */ ResultSet rs = null;
//        /* 634 */ Statement statement = null;
//        /* 635 */ String reg = "Registration";
//        /* 636 */ int sr = pattern;
//        /*     */ try {
//            /* 638 */ Class.forName("com.mysql.jdbc.Driver").newInstance();
//            /* 639 */ String connectionURL = "jdbc:mysql://localhost/vareli_sms";
//            /* 640 */ con = DriverManager.getConnection(connectionURL, "root", "root");
//            /* 641 */ statement = (Statement) con.createStatement();
//            /* 642 */ String queryString = "update tbl_serial_number set SERIAL_NUMBER=? where PROJ_DESCRIPTION='" + reg + "'";
//            /*     */
//            /* 644 */ pst = (PreparedStatement) con.prepareStatement(queryString);
//            /* 645 */ pst.setInt(1, sr);
//            /* 646 */ pst.executeUpdate();
//            con.close();
//            /*     */        } catch (Exception ex) {
//            /* 648 */ ex.printStackTrace();
//            /*     */        }
//        /*     */    }
//    /*     */
//    /*     */ public void updateSerialTable() {
//        /* 653 */ System.out.println("2");
//        /* 654 */ Connection con = null;
//        /* 655 */ PreparedStatement pst = null;
//        /* 656 */ ResultSet rs = null;
//        /* 657 */ Statement statement = null;
//        /* 658 */ String reg = "Registration";
//        /*     */ try {
//            /* 660 */ Class.forName("com.mysql.jdbc.Driver").newInstance();
//            /* 661 */ String connectionURL = "jdbc:mysql://localhost/vareli_sms";
//            /* 662 */ con = DriverManager.getConnection(connectionURL, "root", "root");
//            /* 663 */ statement = (Statement) con.createStatement();
//            /* 664 */ int id = 0;
//            /* 665 */ String QueryString = "select SERIAL_NUMBER from tbl_serial_number where PROJ_DESCRIPTION='" + reg + "'";
//            /*     */
//            /* 667 */ System.out.println("QueryString: " + QueryString);
//            /* 668 */ rs = statement.executeQuery(QueryString);
//            /* 669 */ while (rs.next()) {
//                /* 670 */ id = Integer.parseInt(rs.getString("SERIAL_NUMBER"));
//                /*     */            }
//            /* 672 */ System.out.println("id: " + id);
//            /* 673 */ id++;
//            /* 674 */ System.out.println("id: " + id);
//            /* 675 */ String queryString = "update tbl_serial_number set SERIAL_NUMBER=? where PROJ_DESCRIPTION='" + reg + "'";
//            /*     */
//            /* 677 */ System.out.println("queryString: " + queryString);
//            /* 678 */ pst = (PreparedStatement) con.prepareStatement(queryString);
//            /* 679 */ pst.setInt(1, id);
//            /* 680 */ pst.executeUpdate();
//            con.close();
//            /*     */        } catch (Exception ex) {
//            /* 682 */ ex.printStackTrace();
//            /*     */        }
//        /*     */    }
//    /*     */
//    /*     */ public String getMonthCode() {
//        /* 687 */ Date date = new Date();
//        /* 688 */ String month = null;
//        /*     */
//        /* 690 */ Format formatter = new SimpleDateFormat("MM");
//        /* 691 */ String s = formatter.format(date);
//        /* 692 */ if (s.equals("01")) /* 693 */ {
//            month = "A";
//        } /* 694 */ else if (s.equals("02")) /* 695 */ {
//            month = "B";
//        } /* 696 */ else if (s.equals("03")) /* 697 */ {
//            month = "C";
//        } /* 698 */ else if (s.equals("04")) /* 699 */ {
//            month = "D";
//        } /* 700 */ else if (s.equals("05")) /* 701 */ {
//            month = "E";
//        } /* 702 */ else if (s.equals("06")) /* 703 */ {
//            month = "F";
//        } /* 704 */ else if (s.equals("07")) /* 705 */ {
//            month = "G";
//        } /* 706 */ else if (s.equals("08")) /* 707 */ {
//            month = "H";
//        } /* 708 */ else if (s.equals("09")) /* 709 */ {
//            month = "I";
//        } /* 710 */ else if (s.equals("10")) /* 711 */ {
//            month = "J";
//        } /* 712 */ else if (s.equals("11")) /* 713 */ {
//            month = "K";
//        } /* 714 */ else if (s.equals("12")) {
//            /* 715 */ month = "L";
//            /*     */        }
//        /* 717 */ return month;
//        /*     */    }
//    /*     */
//    /*     */ public String getMonthCode2(String m) {
//        /* 721 */ String s = m;
//        String month = null;
//        /* 722 */ if (s.equals("01")) /* 723 */ {
//            month = "A";
//        } /* 724 */ else if (s.equals("02")) /* 725 */ {
//            month = "B";
//        } /* 726 */ else if (s.equals("03")) /* 727 */ {
//            month = "C";
//        } /* 728 */ else if (s.equals("04")) /* 729 */ {
//            month = "D";
//        } /* 730 */ else if (s.equals("05")) /* 731 */ {
//            month = "E";
//        } /* 732 */ else if (s.equals("06")) /* 733 */ {
//            month = "F";
//        } /* 734 */ else if (s.equals("07")) /* 735 */ {
//            month = "G";
//        } /* 736 */ else if (s.equals("08")) /* 737 */ {
//            month = "H";
//        } /* 738 */ else if (s.equals("09")) /* 739 */ {
//            month = "I";
//        } /* 740 */ else if (s.equals("10")) /* 741 */ {
//            month = "J";
//        } /* 742 */ else if (s.equals("11")) /* 743 */ {
//            month = "K";
//        } /* 744 */ else if (s.equals("12")) {
//            /* 745 */ month = "L";
//            /*     */        }
//        /* 747 */ return month;
//        /*     */    }
//    /*     */
//    /*     */ public String findItemDescDtlsByCode(int id) {
//        /* 751 */ String dtls = "";
//        /*     */ try {
//            /* 753 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 754 */ this.conf.makeConnection("vareli_sms");
//            /* 755 */ this.conf.setSql("SELECT DETAILS from tbl_master_item_description_dtls where ID='" + id + "'");
//            /* 756 */ this.conf.setResultSet(1);
//            /* 757 */ ResultSet rs = this.conf.fetchData();
//            /* 758 */ rs.next();
//            /* 759 */ dtls = rs.getString("DETAILS");
//            this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 761 */ ex.printStackTrace();
//            /*     */        }
//        /* 763 */ return dtls;
//        /*     */    }
//    /*     */
//    /*     */ public int findItemSubCodeByName(String name) {
//        /* 767 */ int cat = 0;
//        /*     */ try {
//            /* 769 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 770 */ this.conf.makeConnection("vareli_sms");
//            /* 771 */ this.conf.setSql("SELECT ID from tbl_master_subcategory where SUB_CATEGORY_NAME='" + name + "'");
//            /* 772 */ this.conf.setResultSet(1);
//            /* 773 */ ResultSet rs = this.conf.fetchData();
//            /* 774 */ rs.next();
//            /* 775 */ cat = rs.getInt("ID");
//            this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 777 */ ex.printStackTrace();
//            /*     */        }
//        /* 779 */ return cat;
//        /*     */    }
//    /*     */
//    /*     */ public String findDesignationByCode(int id) {
//        /* 783 */ String designation = "";
//        /*     */ try {
//            /* 785 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 786 */ this.conf.makeConnection("vareli_sms");
//            /* 787 */ this.conf.setSql("SELECT NAME from tbl_master_common where ID='" + id + "'");
//            /* 788 */ this.conf.setResultSet(1);
//            /* 789 */ ResultSet rs = this.conf.fetchData();
//            /* 790 */ rs.next();
//            /* 791 */ designation = rs.getString("NAME");
//            this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 793 */ ex.printStackTrace();
//            /*     */        }
//        /* 795 */ return designation;
//        /*     */    }
//    /*     */
//    /*     */ public String findEmployeeById(int id) {
//        /* 799 */ String name = "";
//        /*     */ try {
//            /* 801 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 802 */ this.conf.makeConnection("vareli_sms");
//            /* 803 */ this.conf.setSql("SELECT concat(EMPLOYEE_FIRST_NAME,' ',EMPLOYEE_LAST_NAME) from tbl_master_employee where ID='" + id + "'");
//            /*     */
//            /* 805 */ this.conf.setResultSet(1);
//            /* 806 */ ResultSet rs = this.conf.fetchData();
//            /* 807 */ rs.next();
//            /* 808 */ name = rs.getString("concat(EMPLOYEE_FIRST_NAME,' ',EMPLOYEE_LAST_NAME)");
//            /* 809 */ System.out.println("Name : " + name);
//            this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 811 */ ex.printStackTrace();
//            /*     */        }
//        /* 813 */ return name;
//        /*     */    }
//    /*     */
//    /*     */ public String findOrderCodeById(int id) {
//        /* 817 */ String order_code = "";
//        /*     */ try {
//            /* 819 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 820 */ this.conf.makeConnection("vareli_sms");
//            /* 821 */ this.conf.setSql("SELECT PROJECT_ID from trn_order_code where ID='" + id + "'");
//            /* 822 */ this.conf.setResultSet(1);
//            /* 823 */ ResultSet rs = this.conf.fetchData();
//            /* 824 */ rs.next();
//            /* 825 */ order_code = rs.getString("PROJECT_ID");
//            this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 827 */ ex.printStackTrace();
//            /*     */        }
//        /* 829 */ return order_code;
//        /*     */    }
//    /*     */
//    /*     */ public String findQualificationByCode(int id) {
//        /* 833 */ String qualification = "";
//        /*     */ try {
//            /* 835 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 836 */ this.conf.makeConnection("vareli_sms");
//            /* 837 */ this.conf.setSql("SELECT NAME from tbl_master_common where ID='" + id + "'");
//            /* 838 */ this.conf.setResultSet(1);
//            /* 839 */ ResultSet rs = this.conf.fetchData();
//            /* 840 */ rs.next();
//            /* 841 */ qualification = rs.getString("NAME");
//            this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 843 */ ex.printStackTrace();
//            /*     */        }
//        /* 845 */ return qualification;
//        /*     */    }
//    /*     */
//    /*     */ public String findUOMByCode(int id) {
//        /* 849 */ String uom = "";
//        /*     */ try {
//            /* 851 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 852 */ this.conf.makeConnection("vareli_sms");
//            /* 853 */ this.conf.setSql("SELECT NAME from tbl_master_common where ID='" + id + "'");
//            /* 854 */ this.conf.setResultSet(1);
//            /* 855 */ ResultSet rs = this.conf.fetchData();
//            /* 856 */ rs.next();
//            /* 857 */ uom = rs.getString("NAME");
//            /* 858 */ System.out.println("uom : " + uom);
//            this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 860 */ ex.printStackTrace();
//            /*     */        }
//        /* 862 */ return uom;
//        /*     */    }
//    /*     */
//    /*     */ public String getAreaById(int id) {
//        /* 866 */ String desc = "";
//        /*     */ try {
//            /* 868 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 869 */ this.conf.makeConnection("vareli_sms");
//            /* 870 */ this.conf.setSql("SELECT AREA_NAME FROM TBL_MASTER_AREA WHERE ID = '" + id + "' AND ACTIVE='Y'");
//            /* 871 */ this.conf.setResultSet(1);
//            /* 872 */ ResultSet rs = this.conf.fetchData();
//            /* 873 */ rs.next();
//            /* 874 */ desc = rs.getString("AREA_NAME");
//            this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 876 */ ex.printStackTrace();
//            /*     */        }
//        /* 878 */ return desc;
//        /*     */    }
//    /*     */
//    /*     */ public String findItemDescriptionByCode(int id) {
//        /* 882 */ String desc = "";
//        /*     */ try {
//            /* 884 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 885 */ this.conf.makeConnection("vareli_sms");
//            /* 886 */ this.conf.setSql("SELECT NAME from tbl_master_common where ID='" + id + "'");
//            /* 887 */ this.conf.setResultSet(1);
//            /* 888 */ ResultSet rs = this.conf.fetchData();
//            /* 889 */ rs.next();
//            /* 890 */ desc = rs.getString("NAME");
//            this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 892 */ ex.printStackTrace();
//            /*     */        }
//        /* 894 */ return desc;
//        /*     */    }
//    /*     */
//    /*     */ public String findMakeByCode(String id) {
//        /* 898 */ String make = "";
//        /* 899 */ String qry = "SELECT MAKE from tbl_master_item where ID='" + id + "'";
//        /* 900 */ System.out.println("qryMake: " + qry);
//        /*     */ try {
//            /* 902 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 903 */ this.conf.makeConnection("vareli_sms");
//            /* 904 */ this.conf.setSql(qry);
//            /* 905 */ this.conf.setResultSet(1);
//            /* 906 */ ResultSet rs = this.conf.fetchData();
//            /* 907 */ rs.next();
//            /* 908 */ make = rs.getString("MAKE");
//            this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 910 */ ex.printStackTrace();
//            /*     */        }
//        /* 912 */ return make;
//        /*     */    }
//    /*     */
//    /*     */ public String findItemDtlsById(int item_id) {
//        /* 916 */ String item_dtls = "";
//        /*     */ try {
//            /* 918 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 919 */ this.conf.makeConnection("vareli_sms");
//            /* 920 */ this.conf.setSql("SELECT concat(b.category_name,':',c.sub_category_name,':',a.make,':',a.model) FROM tbl_master_item a JOIN tbl_master_CATEGORY b ON a.category_id=b.id JOIN tbl_master_subcategory c ON a.sub_category_id=c.id WHERE a.id=" + item_id);
//            /*     */
//            /* 923 */ this.conf.setResultSet(1);
//            /* 924 */ ResultSet rs = this.conf.fetchData();
//            /* 925 */ rs.next();
//            /* 926 */ item_dtls = rs.getString(1);
//            this.conf.closeConnection();
//            /*     */        } catch (Exception ex) {
//            /* 928 */ ex.printStackTrace();
//            /*     */        }
//        /* 930 */ return item_dtls;
//        /*     */    }
//    /*     */
//    /*     */ public String getUserType(String userid) {
//        /* 934 */ String userType = "";
//        /*     */ try {
//            /* 936 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 937 */ this.conf.makeConnection("vareli_sms");
//            /* 938 */ this.conf.setSql("SELECT USER_TYPE FROM tbl_login_master where USER_ID='" + userid + "'");
//            /* 939 */ this.conf.setResultSet(1);
//            /* 940 */ ResultSet rs = this.conf.fetchData();
//            /* 941 */ rs = this.conf.fetchData();
//            /* 942 */ if (rs.next()) /* 943 */ {
//                userType = rs.getString("USER_TYPE");
//            }
//            this.conf.closeConnection();
//            /*     */        } /*     */ catch (Exception ex) {
//            /* 946 */ ex.printStackTrace();
//            /*     */        }
//        /* 948 */ return userType;
//        /*     */    }
//    /*     */
//    /*     */ public String getUserAuthorize(String userid) {
//        /* 952 */ String authorise = "";
//        /*     */ try {
//            /* 954 */ this.conf = DataSourceConfig.getBatchConnection();
//            /* 955 */ this.conf.makeConnection("vareli_sms");
//            /* 956 */ this.conf.setSql("SELECT AUTHORIZE FROM tbl_master_authorization where USER_ID='" + userid + "'");
//            /* 957 */ this.conf.setResultSet(1);
//            /* 958 */ ResultSet rs = this.conf.fetchData();
//            /* 959 */ rs = this.conf.fetchData();
//            /* 960 */ if (rs.next()) /* 961 */ {
//                authorise = rs.getString("AUTHORIZE");
//            }
//            this.conf.closeConnection();
//            /*     */        } /*     */ catch (Exception ex) {
//            /* 964 */ ex.printStackTrace();
//            /*     */        }
//        /* 966 */ return authorise;
//        /*     */    }
//    /*     */
//    /*     */ public String getAdd_permission() {
//        /* 970 */ return this.add_permission;
//        /*     */    }
//    /*     */
//    /*     */ public void setAdd_permission(String add_permission) {
//        /* 974 */ this.add_permission = add_permission;
//        /*     */    }
//    /*     */
//    /*     */ public String getDelete_permission() {
//        /* 978 */ return this.delete_permission;
//        /*     */    }
//    /*     */
//    /*     */ public void setDelete_permission(String delete_permission) {
//        /* 982 */ this.delete_permission = delete_permission;
//        /*     */    }
//    /*     */
//    /*     */ public String getEdit_permission() {
//        /* 986 */ return this.edit_permission;
//        /*     */    }
//    /*     */
//    /*     */ public void setEdit_permission(String edit_permission) {
//        /* 990 */ this.edit_permission = edit_permission;
//        /*     */    }
//    /*     */
//    /*     */ public String getReport_permission() {
//        /* 994 */ return this.report_permission;
//        /*     */    }
//    /*     */
//    /*     */ public void setReport_permission(String report_permission) {
//        /* 998 */ this.report_permission = report_permission;
//        /*     */    }
//    /*     */ }
//
///* Location:           C:\Users\VTPL\Desktop\
// * Qualified Name:     com.vareli.services.util.UtilityHelper
// * JD-Core Version:    0.6.0
// */
