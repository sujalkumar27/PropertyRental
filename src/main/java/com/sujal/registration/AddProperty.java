package com.sujal.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddProperty
 */
@WebServlet("/AddProperty")
public class AddProperty extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int bedrooms = Integer.parseInt(request.getParameter("bedrooms"));
        int bathrooms = Integer.parseInt(request.getParameter("bathrooms"));
        String description = request.getParameter("description");
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/real_estate","root","Incapp@12");
			PreparedStatement stmt = c.prepareStatement("INSERT INTO Properties (name, price, bedrooms, bathrooms, description) VALUES (?, ?, ?, ?, ?)");
			
			stmt.setString(1, name);
            stmt.setDouble(2, price);
            stmt.setInt(3, bedrooms);
            stmt.setInt(4, bathrooms);
            stmt.setString(5, description);
           int rowCount = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
        response.sendRedirect("Admin");
	}

}
