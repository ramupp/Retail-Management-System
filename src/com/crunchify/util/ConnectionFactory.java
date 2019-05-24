package com.crunchify.util;

import java.io.InputStream;
import java.sql.Date;
import java.sql.ResultSet;

public abstract interface ConnectionFactory
{
  public abstract void makeConnection(String paramString)
    throws Exception;

  public abstract void setSql(String paramString)
    throws Exception;

  public abstract String getSql()
    throws Exception;

  public abstract void setResultSet(int paramInt)
    throws Exception;

  public abstract void setSPara(int paramInt, String paramString)
    throws Exception;

  public abstract void setIPara(int paramInt1, int paramInt2)
    throws Exception;

  public abstract void setDPara(int paramInt, double paramDouble)
    throws Exception;

  public abstract void setLPara(int paramInt, long paramLong)
    throws Exception;

  public abstract void setDTPara(int paramInt, Date paramDate)
    throws Exception;

  public abstract void setBINPara(int paramInt1, InputStream paramInputStream, int paramInt2)
    throws Exception;

  public abstract void clearPara()
    throws Exception;

  public abstract int insertData()
    throws Exception;

  public abstract ResultSet fetchData()
    throws Exception;

  public abstract void rollBack();

  public abstract void commit()
    throws Exception;

  public abstract void closeConnection();
}
