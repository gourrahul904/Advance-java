package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SecondForward")
public class SecondForward  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("In SecondForward  doget ");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		System.out.println("msg "+ fname+"  "+ lname);
		
		String name = (String) req.getAttribute("name");
		System.out.println(name);
		
		

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("In SecondForward  dopost ");
	
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		System.out.println("msg "+ fname+"  "+ lname);
		String name = (String) req.getAttribute("name");
		System.out.println(name);
		
		

		
	}


}
