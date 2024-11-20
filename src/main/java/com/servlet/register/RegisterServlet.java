package com.servlet.register;

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
import java.sql.*;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	//createthe query 
	
	private static final String INSERT_QUERY="INSERT INTO firstdb.user(USERNAME,PASSWORD) VALUES(?,?)";
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printWriter
		PrintWriter pw =res.getWriter();
		//set content type
		res.setContentType("text/html");
		//read form value
		String username =req.getParameter("username");
		String password =req.getParameter("password");
		
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
			ps.setString(1,username);
			ps.setString(2,password);
			
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

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		;
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	
}
