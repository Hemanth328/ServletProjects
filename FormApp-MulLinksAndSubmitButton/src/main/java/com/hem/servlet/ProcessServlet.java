package com.hem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.TimeZone;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// Get Print Writer
		PrintWriter pw = res.getWriter();
		
		//set Content Type
		res.setContentType("text/html");
		
		//Read s1 Param Values
		String s1val = req.getParameter("s1");
		
		//read form data only when submit buttons are clicked
		int val1=0, val2=0;
		if(!s1val.equalsIgnoreCase("link1") && !s1val.equalsIgnoreCase("link2")) {
			val1 = Integer.parseInt(req.getParameter("t1"));
			val2 = Integer.parseInt(req.getParameter("t2"));
		}
		
		//differentiate logics for submit buttons and hyperlinks
		if(s1val.equalsIgnoreCase("add")) {
			pw.println("<h1> Add : "+(val1+val2)+"</h1>");
		}
		else if(s1val.equalsIgnoreCase("sub")) {
			pw.println("<h1> Sub : "+(val1-val2)+"</h1>");
		}
		else if(s1val.equalsIgnoreCase("mul")) {
			pw.println("<h1> Mul : "+(val1*val2)+"</h1>");
		}
		else if(s1val.equalsIgnoreCase("link1")) {
			// System Date
			LocalDate ldt = LocalDate.now();
			
			//current Month
			int month = ldt.getMonthValue();
			if(month>=3 && month<=6) {
				pw.println("<h1>Summer Season </h1>");
			}
			else if(month>=7 && month<=10) {
				pw.println("<h1>Rainy Season </h1>");
			}
			else {
				pw.println("<h1>Winter Season </h1>");
			}
		} 
		else {
			//Get System Date and time
			TimeZone tz = TimeZone.getDefault();
			pw.println("<h1> Current Time Zone :: "+tz.getDisplayName()+"</h1>");
			
		}
		
		//add Home Hyperlink
		pw.println("<br><br><h1 style='color:red; text-align:center'> <a href='form.html'>Home</a></h1>");
		
		//Close Stream
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
