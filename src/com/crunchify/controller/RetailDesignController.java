package com.crunchify.controller;


import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.*;
import com.crunchify.model.view.DesignViewBean;
import com.crunchify.services.RetailDesignService;
import com.crunchify.util.Barcode_Image;
import com.crunchify.util.MyConnection;


@RestController
public class RetailDesignController {

	private static final Logger logger = Logger.getLogger(RetailDesignController.class);
	
  @Autowired
  private RetailDesignService designService;

  @Autowired
  ServletContext context;
  
  
  
  
  @RequestMapping(value = "/fetchBarcode", method = RequestMethod.GET,produces = "application/json")
  @ResponseBody
  public String barcodeCreate() throws Exception
       {	 
     logger.debug("roleCreate() method invoked in VtplReportController:");
    
    try {
    	String code=null,final_barcode=null;
    	Barcode_Image barcode_class=new Barcode_Image();
    	 code=barcode_class.generate(); 
    	 System.out.println("the code is:-"+code);
    	final_barcode=designService.fetchAllDesign(code);
    	outer: if(final_barcode.equals("again"))
    	{
    		final_barcode=barcode_class.generate();
    	break outer ;	
    	}
    	else
    	{
    		final_barcode= code;
    	}
    createImage( final_barcode +".png",final_barcode);
      return final_barcode;
    } catch (Exception e) {
    	logger.error("Error in  roleCreate " + this.getClass(), e);    	
      return null;
    }
    finally
    {
    	logger.debug("rolecreation() mehtod executes Successfully:");
    }

  }
  
  public static void createImage(String image_name,String myString) {
		
		try{
			
			Code128Bean code128= new Code128Bean();
			code128.setHeight(15f);
			code128.setModuleWidth(0.3);
			code128.setQuietZone(10);
			code128.doQuietZone(true);
                      
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			BitmapCanvasProvider canvas = new BitmapCanvasProvider(baos, "image/x-png", 300, BufferedImage.TYPE_BYTE_BINARY, false,0 );
		    code128.generateBarcode(canvas, myString);
			canvas.finish();
			 MyConnection mc=new MyConnection();
			 String fin_path=mc.getBarcodePath();
			 System.out.println("fin path is:-"+fin_path);
			FileOutputStream fos = new FileOutputStream(new File(fin_path, image_name));
			fos.write(baos.toByteArray());
			fos.flush();
			fos.close();
		}catch (Exception e){
		System.out.println("error is:-"+e);
		}
	}
  @RequestMapping(value = "/addDesign", method = RequestMethod.POST)
  @ResponseBody
	public String addDesign(@RequestBody RetailDesignBean desg,HttpServletRequest request) {
	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
	desg.setActive("Y");
	desg.setCreated_by(rb.getUser_id());
	Date dt=new Date();
	desg.setCreated_on(dt);
	String pageName=desg.getFile_name();
	if(pageName==null || pageName.equals("")){System.out.println("with out image");}else{
	System.out.println("page name is:--"+pageName);
	String[] x=pageName.split("\\.");
	String finData=desg.getBar_code()+"."+x[1];
	desg.setFile_name(finData);
	}
				try {
					return designService.addDesign(desg);
				} catch (SpringCrunchifyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
			
	}
  
  
  @RequestMapping(value = "/uploadDesignPic", method = RequestMethod.POST)
	 public ResponseEntity<String> Upload(@RequestParam("file") MultipartFile multipartFile,@RequestParam("barcode") String barcode,HttpServletRequest request) { 
		 System.out.println("Inside File Upload "+multipartFile.getName());
		// masterDataLoader.loadMasterData();
		 //String uploadPat = masterDataLoader.getPropVal(AppConstraint.ATTACH_REGISTRATION_COPY);
		// Map configMap = (Map) appContext.getAttribute("appConfigMap");
		 MyConnection mc=new MyConnection();
		 String fin_path=mc.getPath();
		 String[] fileNameSplits = multipartFile.getOriginalFilename().split("\\.");
		// String test=request.getSession().getServletContext().getRealPath("/");
//		 System.out.println("the test is:-"+test);
		 //String absolutePath = context.getRealPath("/webapps");
		 String workingDir = System.getProperty( "catalina.base" )+fin_path;
		// System.out.println("abs path:-"+absolutePath+"-test-"+test+"=testtt="+workingDir );
//	     String uploadPat = request.getContextPath()+"/resources/upload";//(String) configMap.get(AppConstraint.ATTACH_REGISTRATION_COPY);
//		 System.out.println("Upload File Path="+uploadPat);
		 BufferedOutputStream outputStream = null; 
		// Save file on system
	      if (!multipartFile.getOriginalFilename().isEmpty()) {
	        
			try {
				String new_file_name=barcode+"."+fileNameSplits[1];
				System.out.println("new file is:-"+new_file_name);
				outputStream = new BufferedOutputStream(
				       new FileOutputStream(new File(workingDir, new_file_name)));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         try {
				outputStream.write(multipartFile.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         try {
				outputStream.flush();
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
	      }else{
	         return new ResponseEntity<String>("Invalid file.",HttpStatus.BAD_REQUEST);
	      }
	      
	      return new ResponseEntity<String>("File Uploaded Successfully.",HttpStatus.OK);
	  // }
	   //  return "Uploaded: " + multipartFile.getSize() + " bytes";
	 }
  
  
  @RequestMapping(value = "/fetchDesignDetails", method = RequestMethod.GET,produces = "application/json")
  public ResponseEntity<List<RetailDesignBean>> fetchDesignDetails() throws Exception
       {
	  System.out.println("i am in controller");
     logger.debug("roleCreate() method invoked in VtplReportController:");
     List<RetailDesignBean> list=new ArrayList<RetailDesignBean>();
    try {
    
    	list=designService.fetchDesignDetails();
    	 return new ResponseEntity<List<RetailDesignBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  roleCreate " + this.getClass(), e);    	
    	 return new ResponseEntity<List<RetailDesignBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("rolecreation() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/fetchDesignDetails1", method = RequestMethod.GET,produces = "application/json")
  public ResponseEntity<List<DesignViewBean>> fetchDesignDetails1() throws Exception
       {	 
     logger.debug("roleCreate() method invoked in VtplReportController:");
     List<DesignViewBean> list=new ArrayList<DesignViewBean>();
    try {
    	System.out.println("i am in controller");
    	list=designService.fetchDesignDetails1();
    	 return new ResponseEntity<List<DesignViewBean>>(list, HttpStatus.OK);
    } catch (Exception e) {
    	logger.error("Error in  roleCreate " + this.getClass(), e);    	
    	 return new ResponseEntity<List<DesignViewBean>>(list, HttpStatus.OK);
    }
    finally
    {
    	logger.debug("rolecreation() mehtod executes Successfully:");
    }

  }
  
  @RequestMapping(value = "/updateDesign", method = RequestMethod.POST)
  @ResponseBody
	public String updateDesign(@RequestBody RetailDesignBean desg,HttpServletRequest request) {
	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
	desg.setActive("Y");
	desg.setCreated_by(rb.getUser_id());
	Date dt=new Date();
	desg.setCreated_on(dt);
	String pageName=desg.getFile_name();
	System.out.println("page name is:--"+pageName);
	if(pageName==null || pageName.equals("")){
		
	}
	else
	{
		System.out.println("hellooo sexy");
		String[] x=pageName.split("\\.");
		String finData=desg.getBar_code()+"."+x[1];
		desg.setFile_name(finData);
	}
				try {
					return designService.updateDesign(desg);
				} catch (SpringCrunchifyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
			
	}
  

}
