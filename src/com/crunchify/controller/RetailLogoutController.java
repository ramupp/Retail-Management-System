package com.crunchify.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.crunchify.exception.SpringCrunchifyException;
import com.crunchify.model.RetailRegistrationBean;
import com.google.gson.Gson;

@RestController
public class RetailLogoutController {
	
	@RequestMapping(value = "/logoutFromAll", method = RequestMethod.GET,produces = "application/json")
	public ModelAndView logOutFromAll( HttpServletRequest request, HttpServletResponse response) throws Exception
    {
	  System.out.println("hello world");
 
 try {
 	
 	//String x=gson.toJson(list);
 	//data.put("current", String.valueOf(request.getParameter("current")));
 	//data.put("rowCount", String.valueOf(request.getParameter("rowCount")));
 	//data.put("rows", list);
 	//data.put("total",String.valueOf(list.size()));
	
	System.out.println("logginh out....");
	//response.sendRedirect("/login.jsp");
	
	 ModelAndView modelAndView = new ModelAndView("login");
	    modelAndView.addObject("message", "logout");
	    request.getSession().invalidate();
	    return modelAndView;
 } catch (Exception e) {
 		
   return null;
 }
 finally
 {
 
 }

}
}
