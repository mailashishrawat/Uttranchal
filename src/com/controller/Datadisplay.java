package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

/**
 * Servlet implementation class Datadisplay
 */
@WebServlet("/Datadisplay")
public class Datadisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Datadisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hello123");
		  JSONArray jArry=new JSONArray();
		  JSONObject json1     = new JSONObject();
		System.out.println();
		String json = null ;
	 // JDBC driver name and database URL
	    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	    final String DB_URL = "jdbc:mysql://localhost:1433/Angular";
	    PreparedStatement ps = null;
        InputStream is = null;

	//Database credentials
	    final String USER = "Shewani";
	   // final String PASS = "June54321";
	    final String PASS="Aryan@2015";
	    String hostname="localhost";
	    String port="1433";
	    
	    Connection conn = null;
	    Statement stmt = null;
	    try{
	       //STEP 2: Register JDBC driver
	     
	       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
			
	       //STEP 3: Open a connection
	       System.out.println("Connecting to database...");

	      // String jdbcString = "jdbc:sqlserver://" + hostname + ":" + port + ";databaseName=Angular";
	       String jdbcString = "jdbc:sqlserver://" + hostname + ":" + port + ";databaseName=Uttarachal";
	       conn = DriverManager.getConnection(jdbcString,"Shewani","June54321");
	       System.out.println("Creating statement...");
	       stmt = conn.createStatement();
	       System.out.println(stmt);
	      

          String sql1 = "Select * from Comment";
	       ResultSet rs=stmt.executeQuery(sql1);  
	       /*  List<String> Comment=new ArrayList() ;
		while(rs.next()){//now on 1st row  
	              
			Comment.add(rs.getString(1));
			Comment.add(rs.getString(2));
			Comment.add(rs.getString(3));
	            
	       }
	     
	       json = new Gson().toJson(Comment);
		    System.out.println("json---" + json);
		    
		    response.setContentType("application/json");
	       System.out.println("Database created successfully...");*/
	      
	       //shewani--start
	     
	      while(rs.next()){//now on 1st row  
	              
	    	   JSONObject jObjd=new JSONObject();
		        jObjd.put("name", rs.getString(1));
		        jObjd.put("msg", rs.getString(3));
		        jArry.put(jObjd);
		       }
	  
	       //shewani --end
	      System.out.println(jArry);
	       response.setContentType("application/json");
	       //response.getWriter().write(json);

	       System.out.println("Database created successfully...");
		
	}catch (SQLException error){
		System.out.println(error.getMessage());
	}catch(Exception e){
		System.out.println(e);
	}
	   
	
	    response.getWriter().write(jArry.toString());
	    System.out.println("testing"+jArry.toString());
	   // response.getWriter().write("hello from java. you entered : "+stmt);
	
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
