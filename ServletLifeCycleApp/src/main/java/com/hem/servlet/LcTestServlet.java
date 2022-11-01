package com.hem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

public class LcTestServlet extends HttpServlet {
	
	static {
		System.out.println("LcTestServlet : static block");
	}
	
	public LcTestServlet() {
		System.out.println("LcTestServlet:0-Param Constructor");
	}
	
	/*
	@Override
	public void init(ServletConfig cfg) throws ServletException {
		System.out.println("LcTestServlet.init(-)");
		System.out.println("Driver Class Name : "+cfg.getInitParameter("driverclass"));
		System.out.println("DB User Name : "+cfg.getInitParameter("dbuser"));
		System.out.println("DB Password : "+cfg.getInitParameter("dbpassword"));
	}*/
	
	public void init() throws ServletException {
		ServletConfig cg = getServletConfig();
		System.out.println("LcTestServlet.init()");
		System.out.println("Driver Class Name : "+cg.getInitParameter("driverclass"));
		System.out.println("DB User Name : "+cg.getInitParameter("dbuser"));
		System.out.println("DB Password : "+cg.getInitParameter("dbpassword"));
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("LcTestServlet.service(-,-)");
		
		//get PrintWriter
		PrintWriter pw = res.getWriter();
		
		//set Response Content type
		res.setContentType("text/html");
		
		//Write output to response object
		pw.println("<h1>Date and Time :: "+new java.util.Date()+"</h1>");
		
		ServletConfig cg = getServletConfig();
		System.out.println("Accessing ServletConfig Object in service class");
		System.out.println("Driver Class Name : "+cg.getInitParameter("driverclass"));
		System.out.println("DB User Name : "+cg.getInitParameter("dbuser"));
		System.out.println("DB Password : "+cg.getInitParameter("dbpassword"));
		System.out.println("CLass Name of ServletConfig Object : "+cg.getClass());
		
		//Close Stream
		pw.close();
	}
	
	public void destroy() {
		System.out.println("LcTestServlet:destroy()");
	}

}
