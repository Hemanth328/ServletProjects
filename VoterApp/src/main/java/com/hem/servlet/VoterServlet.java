package com.hem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class VoterServlet extends HttpServlet {
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Service Method(-,-)");
		// get print writer
		PrintWriter pw = resp.getWriter();
		
		// set response content type
		resp.setContentType("text/html");
		
		//read form data (req param values from request obj)
		String name = req.getParameter("pname");
		String tage = req.getParameter("page");
		
		// converting age into int
		
		int age = Integer.parseInt(tage);
		
		// business logic
		
		if(age >= 18 ) {
			pw.println("<h1 style='color:green;text-align:center'>Mr/Miss/Mrs."+name+" you are eligible for voting</h1>");
		} else {
			pw.println("<h1 style='color:green;text-align:center'>Mr/Miss/Mrs."+name+" you are not eligible for voting</h1>");
		}
		
		// graphical hyperlink (image as the hyperlink)
		pw.println("<a href='http://localhost:3030/VoterApp/details_form.html'> <img src='images/home.png' width='100' height='100'></a>");
		
		pw.close();
	}

}
