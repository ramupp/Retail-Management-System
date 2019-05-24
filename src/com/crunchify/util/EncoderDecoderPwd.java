package com.crunchify.util;

import java.nio.charset.StandardCharsets;

import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Component;

/* Class including encode-decode methods */
@Component
public class EncoderDecoderPwd {
	 public String getEncodedValue(String decryptData) {
		    final String s = decryptData;
		    final byte[] authBytes = s.getBytes(StandardCharsets.UTF_8);
		    final String encoded =DatatypeConverter.printBase64Binary(authBytes);
		    return encoded;

		  }

		  public String getDecodedValue(String encryptData) {

		    final String s = encryptData;
		    final byte[] authBytes = DatatypeConverter.parseBase64Binary(s);
		    final String decoded = new String(authBytes);
		    return decoded;
		  }

}
