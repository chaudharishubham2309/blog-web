package com.servlet.contact;

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
 * Servlet implementation class ContactServlet
 */
@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final String INSERT_QUERY="INSERT INTO firstdb.contact(FIRSTNAME,LASTNAME,EMAIL,SUBJECT) VALUES(?,?,?,?)";
	
	
		
		
		
		
		@Override
		protected void doGet(HttpServletRequest request1, HttpServletResponse response1) throws ServletException, IOException {
		
	    
			

			
			
				//get printWriter
						PrintWriter pw =response1.getWriter();
						//set content type
						response1.setContentType("text/html");
						//read form value
						String firstname =request1.getParameter("firstname");
						String lastname=request1.getParameter("lastname");
						String email =request1.getParameter("email");
						String subject =request1.getParameter("subject");
						
						
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
							ps.setString(1,firstname);
							ps.setString(2,lastname);
							ps.setString(3,email);
							ps.setString(4,subject);
							
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
