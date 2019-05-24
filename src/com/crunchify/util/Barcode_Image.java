package com.crunchify.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.Random;

//import javax.naming.ConfigurationException;
//import javax.security.auth.login.Configuration;
//
//import org.krysalis.barcode4j.BarcodeException;
//import org.krysalis.barcode4j.BarcodeGenerator;
//import org.krysalis.barcode4j.BarcodeUtil;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import java.util.Random;

//import com.itextpdf.text.pdf.codec.Base64.OutputStream;


public class Barcode_Image {
	
	public String generate() {
		Random r = new Random();
		int number;
//		for(int counter=1; counter<=1;counter++){
			
			number= 1+r.nextInt(1203456789);
			String s = String.valueOf(number);
//			System.out.println(number +"");
                       //String p=s.concat("<br>arnab");
			//Barcode_Image.createImage( s +".png",s);
//		}
                        return s;
		
		
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
			
			FileOutputStream fos = new FileOutputStream("E:\\OLD_DRIVE_BACKUP\\VTPL\\Project\\generate_barcode\\build\\web\\barcode\\"+image_name);
			fos.write(baos.toByteArray());
			fos.flush();
			fos.close();
		}catch (Exception e){
		System.out.println("error is:-"+e);
		}
	}
	
}
