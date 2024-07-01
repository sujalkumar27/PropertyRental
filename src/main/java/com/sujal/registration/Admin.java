package com.sujal.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        HttpSession session=request.getSession(false);
		if(session==null) {
			response.sendRedirect("login.jsp");
		}
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/real_estate","root","Incapp@12");
			PreparedStatement stmt = c.prepareStatement("SELECT * FROM Properties");
			
			 ResultSet rs = stmt.executeQuery();
	             
		            out.println("<html><head><title>Admin Page</title></head><body>");
		            out.println("<h1>Properties List</h1>");
		            out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Price</th><th>Bedrooms</th><th>Bathrooms</th><th>Description</th></tr>");
		            
		            while (rs.next()) {
		                out.println("<tr><td>" + rs.getInt("id") + "</td><td>" + rs.getString("name") + "</td><td>" +
		                            rs.getDouble("price") + "</td><td>" + rs.getInt("bedrooms") + "</td><td>" +
		                            rs.getInt("bathrooms") + "</td><td>" + rs.getString("description") + "</td></tr>");
		            }
		            out.println("</table>");
		            out.println("</body></html>");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
}
}
