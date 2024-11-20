package com.servlet.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		// database connecting
				try {
					
					
					PrintWriter out=response.getWriter();
				    response.setContentType("text/html");
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdb","root","Shubham123");
					String n=request.getParameter("username");
					String p=request.getParameter("password");
					
					PreparedStatement ps =con.prepareStatement("select username from user where username=? and password=?");
					ps.setString(1,n);
					ps.setString(2,p);
					ResultSet rs = ps.executeQuery();
					
					if(rs.next())
					{
						RequestDispatcher rd=request.getRequestDispatcher("user.html");
						rd.forward(request, response);
					}
					
					else {
						
						out.println("<font color=red size=18>Login Failed!!<br>");
						out.println("<a href=home.html>Try Again!!</a>");
						
						
					}
					
				}catch (ClassNotFoundException e) {
					//to do auto generated catch box
					
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
				
				//create a connection
				
				
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
