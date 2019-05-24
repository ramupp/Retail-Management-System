/*    */ package com.crunchify.util;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ 
/*    */ public class ConnectDBBatch extends DataSourceConfig
/*    */ {
/*    */   public void makeConnection(String db)
/*    */     throws Exception
/*    */   {
/* 10 */     this.conn = getDataSource(db);
/* 11 */     this.conn.setAutoCommit(false);
/*    */   }
/*    */ 
/*    */   public void rollBack()
/*    */   {
/*    */     try
/*    */     {
/* 18 */       this.conn.rollback();
/*    */     }
/*    */     catch (Exception ex)
/*    */     {
/* 22 */       ex.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void commit() throws Exception
/*    */   {
/* 28 */     this.conn.commit();
/*    */   }
/*    */ }

/* Location:           C:\Users\VTPL\Desktop\
 * Qualified Name:     com.vareli.services.dao.ConnectDBBatch
 * JD-Core Version:    0.6.0
 */