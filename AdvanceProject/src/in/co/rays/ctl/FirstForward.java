package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstForward")
public class FirstForward extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("In firstforward  doget ");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		System.out.println("msg " + fname + "  " + lname);
		req.setAttribute("name", "Hrithik");
		RequestDispatcher rd = req.getRequestDispatcher("SecondForward");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("In firstForward  dopost ");

		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		System.out.println("msg " + fname + "  " + lname);
		req.setAttribute("name", "Hrithik");

		RequestDispatcher rd = req.getRequestDispatcher("SecondForward");
		rd.forward(req, resp);

	}

}
