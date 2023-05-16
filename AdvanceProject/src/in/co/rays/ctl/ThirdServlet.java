package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("In third servlet doget ");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		System.out.println("msg " + fname + "  " + lname);
		resp.sendRedirect("FourthServlet");


	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("In third servlet dopost ");

		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		System.out.println("msg " + fname + "  " + lname);
		resp.sendRedirect("FourthServlet");

	}

}
