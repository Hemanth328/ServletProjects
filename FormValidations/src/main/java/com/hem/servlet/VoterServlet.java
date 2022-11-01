package com.hem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class VoterServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost Method(-,-)");
		// get print writer
		PrintWriter pw = resp.getWriter();
		
		// set response content type
		resp.setContentType("text/html");
		
		//read form data (req param values from request obj)
		String name = req.getParameter("pname");
		String tage = req.getParameter("page");
		
		
		int age = 0;
		
			
			// read the hidden value as req param value indicating wheather client side form validation is done or not
			String vstatus = req.getParameter("vstatus");
			
			if(vstatus.equalsIgnoreCase("no")) {
				  //Server Side form validation logics
				  
				  List<String> errorsList = new ArrayList();
				  
				  if(name == null || name.equals("") || name.length() == 0) // required 
					  errorsList.add("Person name is required");  
				  else if(name.length() < 5 || name.length() >10) // min length, max length rule
					  errorsList.add("Person name must contain minimum of 5 chars max of 10 chars");
				  
				  
				  
				  if(tage == null || tage.equals("") || tage.length() == 0) // required rule on age 
					  errorsList.add("Person age is required"); 
				  else { 
					  try { // converting age into 
						  age = Integer.parseInt(tage);
						   if(age <0 || age >120) { // age range rule 
							   errorsList.add("Person age must be ther̥e in the range between 1 through(1 & 120) 120");
						    } 
					  } 
					  catch (NumberFormatException nfe) {
						  errorsList.add("Person age must be numeric value"); // Age must be numeric value 
					   }
				  }
				  
				  
				  
				  // display form validation error messages 
				  if(errorsList.size()>0) {
					  for(String msg:errorsList) {
						  pw.println("<li style='color:red'><b> "+msg+" </b></li>");
					  }
		
					  return;  // If form validation errors are raised this return <without value> return the control back to caller
					              // without executing the further logics(indirectly stops the execution in servlet components
				  }
			}
			else {
				age = Integer.parseInt(tage);  // Convert String int value to real int values
			}
			  
			 
		
//		int age = Integer.parseInt(tage);
		  
		// business logic
		if(age >= 18 ) {
			pw.println("<h1 style='color:green;text-align:center'>Mr/Miss/Mrs."+name+" you are eligible for voting</h1>");
		} else {
			pw.println("<h1 style='color:green;text-align:center'>Mr/Miss/Mrs."+name+" you are not eligible for voting</h1>");
		}
		
		// graphical hyperlink (image as the hyperlink)
		pw.println("<a href='details_form.html'> <img src='images/home.png' width='100' height='100'></a>");
		
		
		// Headers Info	
		String browser = req.getHeader("user-agent");
		String language = req.getHeader("accept-language");
		pw.println("<br>Browser name :: "+browser);
		pw.println("<br>Language name :: "+language);
		
		pw.println("<br><b>Request Obj class name :: "+req.getClass()+"</b>");
		pw.println("<br><b>Response Obj class name :: "+resp.getClass()+"</b>");
		
		pw.close();
		 
		
	}
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("VoterServlet.doGet()");
		doPost(req, resp);
	}

}
