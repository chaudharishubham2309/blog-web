package com.servlet.create;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	
	private static final String INSERT_QUERY="INSERT INTO firstdb.create(TITLE,AUTHOR) VALUES(?,?)";
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	
			PrintWriter pw =response.getWriter();
			//set content type
			response.setContentType("text/html");
			//read form value
			String title =request.getParameter("title");
			String author =request.getParameter("author");
			
			//load jdbc drivers
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
			}catch (ClassNotFoundException e) {
				//to do auto generated catch box
				
				e.printStackTrace();
			}
			
			//create a connection
			
			try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdb","root","Shubham123");
					
					PreparedStatement ps = con.prepareStatement(INSERT_QUERY);
					
		){
				
				//set value
				ps.setString(1,title);
				ps.setString(2,author);
				
				//execute query
				
				int count =ps.executeUpdate();
				if(count==0) {
					pw.println("Record is not stored in database");
					
				}else {
					pw.println("record stored into database");
				}
				
			}catch(SQLException se) {
				pw.println(se.getMessage());
				se.printStackTrace();
				
			}catch(Exception e){
				pw.println(e.getMessage());
				e.printStackTrace();
				
				
			}
			
			// close the stream
			pw.close();
			
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
