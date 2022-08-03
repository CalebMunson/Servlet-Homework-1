package assignment1;

//Prompt 1:
//Create login page with DB checking
//Create user table, insert some records
//Create a login page, take user name and pass, submit
//login servlet, check credentials

//This prompt is used by LoginPage.html which asks for a username and password.
//It takes the info from LoginPage.html and checks whether this data is in the database.

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Prompt1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init() {
		System.out.println("From LoginPage init");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		
		PrintWriter out = res.getWriter();
		
		res.setContentType("text/html");
		
		Connection con;
		PreparedStatement stmt;
		ResultSet set;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userAccounts", "root", "");
			stmt = con.prepareStatement("Select * from accounts where username = ? and password = ? ");
			
			stmt.setString(1, user);
			stmt.setString(2, pass);
			
			set = stmt.executeQuery();
			
			if (set.next()) {
				out.println("Welcome " + user);
			} else {
				out.println("Username or Password not found. Please try again.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
