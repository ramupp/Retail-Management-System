


<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>


 <%
          
		//String pur_no=request.getParameter("pur_no");
 String kar_cd=request.getParameter("kar_cd");
 System.out.println("Karigarh code  is-----="+kar_cd);
		//System.out.println("pur_no is:-"+pur_no);
		String co_id=request.getParameter("co_id");
        MyConnection mc=new MyConnection();
    	Connection conn=mc.getConnection("adm_retail");
                     Statement st= null;
                     Statement st1=null;
                     Statement st2=null;
                    String cid = "", cnm = "";
                    st = conn.createStatement();
                    st1=conn.createStatement();
                    st2=conn.createStatement();
                    String sql3="select hid, doc_no, doc_dt, narration  from trn_kar_issue_hd  where type='I' and kar_cd="+kar_cd+"";
                    String sql4="select hid, doc_no,doc_dt, kar_cd, ref_no, ref_dt from trn_kar_issue_hd";
                    String sql5="select id, itm_typ_id, itm_id, desg_no, qty, uom_id, co_id from trn_kar_isu_dt";
                   // String sql="SELECT h.pur_id, h.pur_no, date_format(h.pur_dt,'%Y-%m-%d') pur_dt, h.inv_no, h.inv_dt,h.tot_bas_amt, h.tot_dis_amt, h.tot_cgst_amt, h.tot_sgst_amt, h.tot_igst_amt, h.party_cd,p.party_nm,h.tot_amt,h.tot_disc,h.tot_gst,h.net_amt FROM trn_pur_hdr h left join mst_party p on(p.party_id=h.party_cd) where h.pur_no='"+pur_no+"' and h.co_id='"+co_id+"'";
                    //String sql1="select d.*,(d.qty - ret_qty) as av_qty,md.desg_no,it.itm_typ_nm,i.itm_nm,d.basic_amt,d.cgst_amt, d.sgst_amt, d.igst_amt, d.basic_amt,d.qty from trn_pur_hdr h join trn_pur_dtl d on(h.pur_id=d.pur_id) join mst_party p on(p.party_id=h.party_cd) join mst_design md on(md.tr_id=d.desg_id) join mst_fp_itm i on(d.itm_id=i.itm_id) join mst_itm_typ it on(d.itm_typ_id=it.itm_typ_id) where h.co_id='"+co_id+"' and h.pur_no='"+pur_no+"' and h.vr_type='PURC'";
                	//String sql2="SELECT o.*,oh.* FROM trn_pur_hdr h join pur_other_dtl o on(h.pur_id=o.pur_id) inner join mst_other_head oh on(oh.oh_id=o.oh_hid) where pur_no='"+pur_no+"'  and h.vr_type='PURC' and h.co_id='"+co_id+"'";
                    System.out.println(sql3);
                	ResultSet rs = st.executeQuery(sql3);	
                	ResultSet rs4 = st1.executeQuery(sql4);	
                	ResultSet rs5 = st2.executeQuery(sql5);	
                	//while(rs.next()){

                	
					//int hid=rs.getInt("hid");
                	//String doc_no = rs.getString("doc_no");
                	//String doc_dt = rs.getString("doc_dt");
                	//String narration = rs.getString("narration");
                	
                	
                	
    %>
    
    
    
   <head>
    
   
   
<!--  <style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 10px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>-->


</head>
  
    <div>
   <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
  <thead>
    <tr>
      <th class="th-sm">Issue No
        <i class="fa fa-sort float-right" aria-hidden="true"></i>
      </th>
      <th class="th-sm">Issue Date
        <i class="fa fa-sort float-right" aria-hidden="true"></i>
      </th>
      <th class="th-sm">Narration
        <i class="fa fa-sort float-right" aria-hidden="true"></i>
      </th>
      <th class="th-sm">Select
        <i class="fa fa-sort float-right" aria-hidden="true"></i>
      </th>
      
    </tr>
  </thead>
  <tbody>


                     <% while (rs.next())  {
                    	 int hid=rs.getInt("hid");
                     	String doc_no = rs.getString("doc_no");
                     	String doc_dt = rs.getString("doc_dt");
                     	String narration = rs.getString("narration");
                     
                     %> 
                      

                        <tr id="normal_tr">

                            <td style="display: none;"><%=hid%>
                            <td><%=doc_no%>
                            <td><%=doc_dt%>
                             <td><%=narration%>
                              <td><input type="button" name="edit" value="Select" onClick="EditThis(<%=rs.getString(1)%>)" style="background-color:#4253f4;font-weight:bold;color:#ffffff;" onchange="EditThis(this.value);">
                             
                           
                          
                          
                           
                        </tr> 
                        <% }  %> 
                              

                    </tbody>
  <!-- <tfoot>
    <tr>
      <th>ID
      </th>
      <th>Issue Date
      </th>
      <th>Narration
      </th>
      <th>Edit
      </th>
     
    </tr>
  </tfoot> -->
</table>

<%-- <script type="text/javascript">
 jQuery.noConflict();
 jQuery(document).ready(function($){
$("#jsGrid").jsGrid({
    width: "100%",
    inserting: true,
    filtering: true,
    editing: true,
    sorting: true,
    paging: true,
    autoload: true,
    searching:true,
    pageSize: 5,
    deleteConfirm: "Do you really want to delete the client?",


    controller: {
        loadData: function(filter) {
            var d = $.Deferred();

            $.ajax({
            	   type: 'GET',
            	    url: "../../../fetchAllItemMaster",
            	    async: false,
            	    contentType: "application/json",
            	    dataType: 'json',
            	    success: function(response) {
            	    	//alert(reponse);
            	    	//alert(JSON.stringify(response));
            	    	d.resolve(JSON.parse(JSON.stringify(response)));
            	     
            	    },
            	    error: function(e) {
            	       console.log(e.message);
            	    }
            	});

            return d.promise();
        },
        updateItem: function(item) {
          	 var d = $.Deferred();
          	 //alert(JSON.stringify(item));
          var p=JSON.parse(JSON.stringify(item));      
              return $.ajax({
                  type: "POST",
                  async: false,
                  url: "../../../fetchheader",
                  contentType: "application/json",
                  dataType: 'json',
                  //var x = $('#form1').serializeJSON();
      			//var val = JSON.stringify(item.itm_nm),
      			
                  data: JSON.stringify(item),
                  success: function (data) {
               	  // d.resolve(JSON.parse(JSON.stringify(data)));
                	  location.reload();
                  }
              });
          },
          DeleteItem: function(item_master) {
           	 var d = $.Deferred();
           	 //alert(JSON.stringify(item));
           var p=JSON.parse(JSON.stringify(item_master));      
               return $.ajax({
                   type: "POST",
                   async: false,
                   url: "../../../itmDelete",
                   contentType: "application/json",
                   dataType: 'json',
                   //var x = $('#form1').serializeJSON();
       			//var val = JSON.stringify(item.itm_nm),
       			
                   data: JSON.stringify(item_master),
                   success: function (data) {
                	  // d.resolve(JSON.parse(JSON.stringify(data)));
                 	  location.reload();
                   }
               });
           }
        
    },

    fields: [
        { name: "itm_id",  width: 50, css: "hide"},
        { name: "itm_nm", type: "text", width: 50 ,title : "Item"  },
        { name: "itm_typ_nm", type: "text", width: 50 ,title : "Item Type"  },
        { name: "hsn_cd", type: "text", width: 50 ,title : "HSN"  },
        { name: "amount", type: "text", width: 50 ,title : "Amount"  },
        { name: "log_cond", type: "text", width: 50 ,title : "Condition"  },
        { name: "gst_per", type: "text", width: 50 ,title : "GST"  },
        { name: "gst_per1", type: "text", width: 50 ,title : "GST1"  },
        { name: "created_by", type: "text", width: 50, title: "Created By" ,type: "disabled"},
        { name: "modified_by", type: "text", width: 50 , title: "Modified By" ,type: "disabled"},
        { name: "created_on", type: "text", width: 50, title: "Created On" ,type: "disabled"},
        { name: "modified_on", type: "text", width: 50, title: "Modified On" ,type: "disabled"},
        { type: "control" }
    ]
});
});
</script>--%>

                

                	 </div>
                	
                	  