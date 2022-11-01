package com.hem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SeasonDeciderServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// set response content type
		res.setContentType("text/html");
		
		// get Print writer	
		PrintWriter pw = res.getWriter();
		
		// Get System Date and time
		LocalDateTime ldt = LocalDateTime.now();
		
		// get the current month
		int month = ldt.getMonthValue();
		
		// Decide the season
		if(month > 2 && month <= 6)
			pw.println("<h1 style='color:red; text-align:center'>Season Name : Summer Season</h1>");
		else if (month >6 && month <=10)
			pw.println("<h1 style='color:green; text-align:center'>Season Name : Rainy Season</h1>");
		else
			pw.println("<h1 style='color:red; text-align:center'>Season Name : Winter Season</h1>");
		
		
		// Home Hyperlink
		pw.println("<br><br><a href='http://localhost:3030/SeasonApp/page.html'>Home</a>");
		
		// Close the stream to commit the response
		pw.close();
	}

}
