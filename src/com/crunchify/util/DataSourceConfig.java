/*     */ package com.crunchify.util;
/*     */ 
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.sql.DataSource;
/*     */ 
/*     */ public abstract class DataSourceConfig 
/*     */   implements ConnectionFactory
/*     */ {
/*  17 */   protected HttpServletRequest request = null;
/*  18 */   protected Connection conn = null;
/*  19 */   protected PreparedStatement psmt = null;
/*  20 */   protected ResultSet res = null;
/*  21 */   protected DataSource dataSource = null;
/*  22 */   protected String sql = null;
/*     */ 
/*     */   public static ConnectionFactory getConnection() throws Exception {
/*  25 */     return new ConnectDB();
/*     */   }
/*     */ 
/*     */   public static ConnectionFactory getBatchConnection() throws Exception {
/*  29 */     return new ConnectDBBatch();
/*     */   }
/*     */ 
/*     */   public void setSql(String sql) throws Exception {
/*  33 */     this.sql = sql;
/*     */   }
/*     */ 
/*     */   public String getSql() throws Exception {
/*  37 */     return this.sql;
/*     */   }
/*     */ 
/*     */   public void setResultSet(int type) throws Exception {
/*  41 */     if (type == 0)
/*     */     {
/*  43 */       this.psmt = this.conn.prepareStatement(this.sql);
/*     */     }
/*  45 */     else this.psmt = this.conn.prepareStatement(this.sql, 1005, 1007);
/*     */   }
/*     */ 
/*     */   public void setSPara(int position, String value)
/*     */     throws Exception
/*     */   {
/*  51 */     this.psmt.setString(position, value);
/*     */   }
/*     */ 
/*     */   public void setIPara(int position, int value) throws Exception
/*     */   {
/*  56 */     this.psmt.setInt(position, value);
/*     */   }
/*     */ 
/*     */   public void setDPara(int position, double value) throws Exception {
/*  60 */     this.psmt.setDouble(position, value);
/*     */   }
/*     */ 
/*     */   public void setLPara(int position, long value) throws Exception {
/*  64 */     this.psmt.setLong(position, value);
/*     */   }
/*     */ 
/*     */   public void setDTPara(int position, Date value) throws Exception {
/*  68 */     this.psmt.setDate(position, value);
/*     */   }
/*     */ 
/*     */   public void setBINPara(int position, InputStream value, int size) throws Exception {
/*  72 */     this.psmt.setBinaryStream(position, value, size);
/*     */   }
/*     */ 
/*     */   public void clearPara() throws Exception {
/*  76 */     this.psmt.clearParameters();
/*     */   }
/*     */ 
/*     */   public int insertData() throws Exception {
/*  80 */     int roweffected = this.psmt.executeUpdate();
/*  81 */     return roweffected;
/*     */   }
/*     */ 
/*     */   public ResultSet fetchData() throws Exception {
/*  85 */     this.res = this.psmt.executeQuery();
/*  86 */     return this.res;
/*     */   }
/*     */ 
/*     */   public void rollBack()
/*     */   {
/*     */   }
/*     */ 
/*     */   public void commit()
/*     */     throws Exception
/*     */   {
/*     */   }
/*     */ 
/*     */   public void closeConnection()
/*     */   {
/* 100 */     if (this.res != null) {
/*     */       try {
/* 102 */         this.res.close();
/*     */       } catch (SQLException sqle) {
/* 104 */         this.res = null;
/* 105 */         sqle.printStackTrace();
/*     */       }
/*     */     }
/* 108 */     if (this.psmt != null) {
/*     */       try {
/* 110 */         this.psmt.close();
/*     */       } catch (SQLException sqle) {
/* 112 */         this.psmt = null;
/* 113 */         sqle.printStackTrace();
/*     */       }
/*     */     }
/* 116 */     if (this.conn != null)
/*     */       try {
/* 118 */         this.conn.close();
/*     */       } catch (SQLException sqle) {
/* 120 */         this.conn = null;
/* 121 */         sqle.printStackTrace();
/*     */       }
/*     */   }
/*     */ 
/*     */   public static Connection getDataSource(String db)
/*     */     throws Exception
/*     */   {
/* 128 */     Class.forName("com.mysql.jdbc.Driver");
/* 129 */     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, "root", "root");
/*     */ 
/* 131 */     return con;
/*     */   }
/*     */ }

/* Location:           C:\Users\VTPL\Desktop\
 * Qualified Name:     com.vareli.services.dao.DataSourceConfig
 * JD-Core Version:    0.6.0
 */