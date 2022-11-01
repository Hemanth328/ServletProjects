package com.hem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// get PrintWriter
		PrintWriter pw = res.getWriter();
		
		//set response ContentType
		res.setContentType("text/html");
		
		//read the "p1" request param value
		String p1val = req.getParameter("p1");
		
		// differentiate the logics for hyperlinks
		Locale locales[] = Locale.getAvailableLocales();
		if(p1val.equalsIgnoreCase("link1")) {
			pw.println("<h2>All Countries</h2><br>");
			for(Locale l: locales) {
				pw.println(l.getDisplayCountry()+",");
			}
		}
		else if(p1val.equalsIgnoreCase("link2")) {
			pw.println("<h2> All Languages</h2><br>");
			for(Locale l: locales) {
				pw.println(l.getDisplayLanguage());
			}
		}
		else {
			pw.println("<h2> System Properties</h2><br>");
			pw.println(System.getProperties());
		}
		
		
		pw.println("<br><a href='links.html'> Home </a>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
