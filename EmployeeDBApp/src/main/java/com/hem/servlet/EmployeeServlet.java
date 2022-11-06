package com.hem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmployeeServlet extends HttpServlet {
	
	private static final String GET_EMP_DETAILS_BY_NO = "SELECT EMPNO, ENAME, JOB, SAL, DEPTNO FROM EMP WHERE EMPNO=?";
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//Get Print Writer
		PrintWriter pw = res.getWriter();
		
		// set browser content type
		res.setContentType("text/html");
		
		// get req Param
		int empno = Integer.parseInt(req.getParameter("eno"));
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//Load JDBC Driver Class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Establish the Connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system" , "Hemanth11");
			//Create Prepared Statement
			ps=con.prepareStatement(GET_EMP_DETAILS_BY_NO);
			//set Query param value
			ps.setInt(1, empno);
			// execute the Query
			rs = ps.executeQuery();
			// process the resultSet
			if(rs.next()) {
				pw.println("<h1 style='color:blue'>Employee No : "+rs.getInt(1)+"</h>");
				pw.println("<h1 style='color:blue'>Employee Name : "+rs.getString(2)+"</h>");
				pw.println("<h1 style='color:blue'>Employee Desg : "+rs.getString(3)+"</h>");
				pw.println("<h1 style='color:blue'>Employee Salary : "+rs.getFloat(4)+"</h>");
				pw.println("<h1 style='color:blue'>Employee DeptNo : "+rs.getInt(5)+"</h>");
			}
			else {
				pw.println("<h1 style='color:red'>OOP's ! Employee Details Not Found. ");
			}
			
			//Home Hyperlink
			pw.println("<h1 style='color:green'><a href='form.html'>Home</a></h1>");
		}
		catch(SQLException se) {
			se.printStackTrace();
			pw.println("<h4 style='color:red'>DB Problem</h4>");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			
			try {
				if(rs != null)
					rs.close();
			} catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				if(ps != null)
					ps.close();
			} catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				if(con != null)
					con.close();
			} catch(SQLException se) {
				se.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
