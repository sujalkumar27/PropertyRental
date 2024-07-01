package com.sujal.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/Login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String uemail = request.getParameter("username");
		String upwd = request.getParameter ("password");
		 PreparedStatement stmt = null;
		 ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/real_estate","root","Incapp@12");
//			Statement st=c.createStatement();
//			
//			ResultSet rs=st.executeQuery("select * from users where uemail = "+uemail+"' and password = '"+upwd+"'");
//			
//			if(rs!=null) {
//				System.out.println("Done");
//			}
//			if(rs.next()) {
//				String name=rs.getString("name");
//				HttpSession session=request.getSession();
//				session.setAttribute("name",name);
//				response.sendRedirect("property.jsp");
//			}else {
//				response.sendRedirect("login.jsp");
//			}
			String sql = "SELECT * FROM users WHERE uemail = ? AND upwd = ?";
            stmt = c.prepareStatement(sql);
            stmt.setString(1, uemail);
            stmt.setString(2, upwd);

            // Execute query
            rs = stmt.executeQuery();

            // Check if user exists and password is correct
            if (rs.next()) {String name=rs.getString("uname");
				HttpSession session=request.getSession();
				session.setAttribute("name",name);
                // For example, in a Servlet environment:
                response.sendRedirect("property.jsp");
            } else {
            	response.sendRedirect("Error.html");
            }
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
