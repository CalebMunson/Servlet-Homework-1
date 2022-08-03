package assignment1;

//Prompt 3:
//Get all registered users

//This file is used by GetAccounts.html which asks for a username and password before progressing to the next page.
//The next page simply prints out the data of all users inside of the database table.

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/data")
public class Prompt3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		Connection con;
		Statement stmt;
		ResultSet set;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userAccounts", "root", "");
			stmt = con.createStatement();
			
			set = stmt.executeQuery("select * from accounts");
			
			PrintWriter out = res.getWriter();
			
			out.println("User data: ");
			
			while(set.next()) {
				out.println(set.getString(1) + " " + set.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
