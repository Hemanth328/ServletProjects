package com.hem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FindCapitalServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get PrintWriter
		PrintWriter pw = resp.getWriter();
		// get response content type
		resp.setContentType("Text/html");
		// read from data
		int countryCode = Integer.parseInt(req.getParameter("country"));
		// prepare capitals
		String countries[] = new String[] {"INDIA", "USA", "FRANCE", "CANADA"};
		String capitals[] = new String[] {"New Delhi", "WashingtonDC",  "Franc", "Ottawa"};
		
		// display capital
		pw.println("<h1 style='color:red; text-alignment:center'>The Capital City Name Of "+countries[countryCode]+" is :: "+capitals[countryCode]+"</h1>");
		
		//  add home hyperlink
		pw.println("<a href='input.html'><h2 style='text-align:center'>Home</h2></a>");
		
		// Close Stream
		pw.close();
		
	}
}
