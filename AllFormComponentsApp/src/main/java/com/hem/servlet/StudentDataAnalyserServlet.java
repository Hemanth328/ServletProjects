package com.hem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StudentDataAnalyserServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    // getting the writer stream
		PrintWriter pw = resp.getWriter();
		
		// setting the content type
		resp.setContentType("text/html");
		
		// Getting the values
		String name = req.getParameter("sname");
		String address = req.getParameter("sadd");
		String gender = req.getParameter("gender");
		String email = req.getParameter("email");
		String qualification =req.getParameter("qlfy");
		System.out.println(req.getParameter("contactNo"));
		long contactNumber = Long.parseLong(req.getParameter("contactNo"));
		String ms = req.getParameter("ms");
		
		String hobbies[] = req.getParameterValues("hb");
		if(hobbies == null)
			hobbies = new String[] {"No Hobbies are Selected"};
		
		String favcolor[] = req.getParameterValues("favColors");
		if(favcolor == null)
			favcolor = new String[] {"No Favourite Colors are Selected"};
		
		String dob = req.getParameter("dob");
		String nickname = req.getParameter("petname");
		String mob = req.getParameter("mob");
		String wob = req.getParameter("wob");
		String tob = req.getParameter("tob");
		float salary = Float.parseFloat(req.getParameter("sal"));
		String ss = req.getParameter("ss");
		
		
		// Calculate the age of a person
		java.util.Date udob = java.sql.Date.valueOf(dob); // Converts String date of yyyy-mm-dd pattern to java.sql.Date class obj
		java.util.Date sysDate = new java.util.Date(); // system date and time
		double age = (sysDate.getTime()-udob.getTime())/(1000.0*60.0*60.0*24.0*365.25);
		
		// WRirte Analysation of data
		if(gender.equalsIgnoreCase("M")) {
			if(age<5)
				pw.println("<h1>Mister."+name+"you are baby boy</h1>");
			else if(age<13)
				pw.println("<h>1Mister."+name+"you are a small boy</h1>");
			else if(age<20)
				pw.println("<h1>Mister."+name+"you are a teenage boy</h1>");
			else if(age<35)
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1>Mister."+name+"you are a married young man</h1>");
				else
					pw.println("<h1>Mister."+name+"you are a young man</h1>");
			else if(age<50)
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1>Mister."+name+"you are a married middle-aged man</h1>");
				else
					pw.println("<h1>Mister."+name+"you are a middle-aged man</h1>");
			else
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1>Mister."+name+"you are a married aged man</h1>");
				else
					pw.println("<h1>Mister."+name+"you are a aged man</h1>");
		} 
		else {
			if(age<5)
				pw.println("<h1>Miss."+name+"you are baby girl</h1>");
			else if(age<13)
				pw.println("<h1>Miss."+name+"you are a small girl</h1>");
			else if(age<20)
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1>Mrs."+name+"you are a married teenage gal</h1>");
				else
					pw.println("<h1>Miss."+name+"you are a teenage gal</h1>");
			else if(age<35)
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1>Mrs."+name+"you are a married young women</h1>");
				else
					pw.println("<h1>Miss."+name+"you are a young women</h1>");
			else if(age<50)
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1>Mrs."+name+"you are a married middle-aged women</h1>");
				else
					pw.println("<h1>Miss."+name+"you are a middle-aged women</h1>");
			else
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1>Mrs."+name+"you are a married old women</h1>");
				else
					pw.println("<h1>Miss."+name+"you are a old women</h1>");
		}
		
		//Display the received data
		pw.println("<h1 style='color:blue'> The Form data is </h1>");
		pw.println("<br><b> Name : "+name+"</b>");
		pw.println("<br><b> Address : "+address+"</b>");
		pw.println("<br><b> Contact Number : "+contactNumber+"</b>");
		pw.println("<br><b> Gender : "+gender+"</b>");
		pw.println("<br><b> Maritual Status : "+ms+"</b>");
		pw.println("<br><b> Email : "+email+"</b>");
		pw.println("<br><b> DOB : "+dob+"</b>");
		pw.println("<br><b> TOB(TIme Of Birth) : "+tob+"</b>");
		pw.println("<br><b> MOB(Month Of Birth) : "+mob+"</b>");
		pw.println("<br><b> WOB(Week Of Birth) : "+wob+"</b>");
		pw.println("<br><b> Qulalification : "+qualification+"</b>");
		pw.println("<br><b> Favourite Colour : "+Arrays.toString(favcolor)+"</b>");
		pw.println("<br><b> Hobbies : "+Arrays.toString(hobbies)+"</b>");
		pw.println("<br><b> Nickname : "+nickname+"</b>");
		pw.println("<br><b> Expected Salary : "+salary+"</b>");
		pw.println("<br><b> Google Search String : "+ss+"</b>");
		
		// Add home hyperlink
		pw.println("<br><br> <a href='student_registration.html'>HOME</a></b>");
		
		// Close the Stream
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
