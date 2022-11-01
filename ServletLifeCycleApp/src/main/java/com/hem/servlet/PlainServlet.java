package com.hem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

public class PlainServlet extends HttpServlet {
	
	static {
		System.out.println("PlainServlet : static block");
	}
	
	public PlainServlet() {
		System.out.println("PlainServlet:0-Param Constructor");
	}
	
	
	@Override
	public void init(ServletConfig cfg) throws ServletException {
		System.out.println("PlainServlet.init(-)");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("PlainServclet.service(-,-)");
		
		//get PrintWriter
		PrintWriter pw = res.getWriter();
		
		//set Response Content type
		res.setContentType("text/html");
		
		//Write output to response object
		pw.println("<h1>Date and Time :: "+new java.util.Date()+"</h1>");
		
		//Close Stream
		pw.close();
	}

}
