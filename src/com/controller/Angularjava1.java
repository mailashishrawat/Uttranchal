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
 * Servlet implementation class Angularjava1
 */
@WebServlet("/Angularjava1")
public class Angularjava1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Angularjava1() {
        super();
        
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws IOException{
    	response.getWriter().append("Served at: ").append(request.getContextPath());
    		}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("hello123");
		System.out.println();
		String json = null ;
	 // JDBC driver name and database URL
	    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	    final String DB_URL = "jdbc:mysql://localhost:1433/Angular";
	    PreparedStatement ps = null;
        InputStream is = null;

	//Database credentials
	    final String USER = "Shewani";
	    final String PASS = "June54321";
	    String hostname="localhost";
	    String port="1433";
	    
	    Connection conn = null;
	    Statement stmt = null;
	    try{
	       //STEP 2: Register JDBC driver
	     
	       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
			
	       //STEP 3: Open a connection
	       System.out.println("Connecting to database...");

	       String jdbcString = "jdbc:sqlserver://" + hostname + ":" + port + ";databaseName=Angular";
	       conn = DriverManager.getConnection(jdbcString,"Shewani","June54321");
	       System.out.println("Creating statement...");
	       stmt = conn.createStatement();
	       System.out.println(stmt);
	       StringBuilder sb = new StringBuilder();
	       
		   BufferedReader br = request.getReader();
		   
		   String str = null;
		   while ((str = br.readLine()) != null) {
			   
				sb.append(str);
			}
			
			 String str1 = sb.toString();
			
			 JSONObject json1 = new JSONObject(str1);
             String name = json1.getString("name");	
             String email = json1.getString("email");	
             String msg = json1.getString("msg");	
             ps = conn.prepareCall("insert into Comment values (?,?,?)");
	         ps.setString(1,name);
             ps.setString(2, email);
             ps.setString(3,msg);
             int count = ps.executeUpdate();
             System.out.println("Count: "+count);

          /*  String sql1 = "Select * from Comment";
	       ResultSet rs=stmt.executeQuery(sql1);  
	   List<String> Comment=new ArrayList() ;
		while(rs.next()){//now on 1st row  
	              
			Comment.add(rs.getString(1));
			Comment.add(rs.getString(2));
			Comment.add(rs.getString(3));
	            
	       }
	     
	       json = new Gson().toJson(Comment);
		    System.out.println("json---" + json);
		    response.setContentType("application/json");
	       System.out.println("Database created successfully...");
	      
	       //shewani--start
	       JSONArray jArry=new JSONArray();
	       while(rs.next()){//now on 1st row  
	              
	    	   JSONObject jObjd=new JSONObject();
		        jObjd.put("name", rs.getString(1));
		        jObjd.put("msg", rs.getString(3));
		        jArry.put(jObjd);
		       }
	      /* for (int i=0;i<3;i++)
	       {
	        JSONObject jObjd=new JSONObject();
	        jObjd.put("key", value);
	        jObjd.put("key", value);
	        jArry.put(jObjd);
	       }*/
	       //shewani --end
	       response.setContentType("application/json");

	       System.out.println("Database created successfully...");
		
	}catch (SQLException error){
		System.out.println(error.getMessage());
	}catch(Exception e){
		System.out.println(e);
	}
	   
	
		//response.getWriter().write(json);

	   // response.getWriter().write("hello from java. you entered : "+stmt);
	}
	 

}
