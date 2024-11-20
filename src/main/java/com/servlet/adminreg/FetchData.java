package com.servlet.adminreg;

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


@WebServlet("/FetchData")
public class FetchData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		try {
			
			response.setContentType("text/html");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdb","root","Shubham123");
			PreparedStatement ps = con.prepareStatement("select * from user");
			ResultSet rs=ps.executeQuery();
			PrintWriter out=response.getWriter();
			
			out.println("<html><body><table border='1' align='center'><tr><td>Id</td><td>Username</td><td>Password</td></tr>");
			
			while(rs.next()) {
				
				out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td></tr>");
			}
			
			out.println("</table></body></html>");
			
		}catch (Exception e) {
			//to do auto generated catch box
			
			e.printStackTrace();
		}
	}
}
