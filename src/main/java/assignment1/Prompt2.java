package assignment1;

//Prompt 2:
//Registration for a course

//This file is utilized by registration.html which asks for username, gender, name, class ID, and known languages.
//This file then takes that information and prints it out in a formatted way.

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Reg")
public class Prompt2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String userName = req.getParameter("username");
		String gender = req.getParameter("gender");
		String name = req.getParameter("name");
		String classID = req.getParameter("classID");
		String[] languages = req.getParameterValues("language");
		
		String langList = "";
		for (String langs : languages) {
			langList = langList + langs + " ";
		}
		
		PrintWriter out = res.getWriter();
		out.println(userName);
		out.println("Name: " + name);
		out.println("Gender: " + gender);
		out.println("Class ID: " + classID);
		out.println("Known Languages: " + langList);
	}

}
