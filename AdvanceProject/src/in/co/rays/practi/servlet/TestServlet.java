package in.co.rays.practi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testservlet")
public class TestServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fname = req.getParameter("fname");
		String sname = req.getParameter("sname");
		String mo = req.getParameter("mo");
		String add = req.getParameter("add");
		
		

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.write("our first servlet");
		
		out.write(fname+" "+sname+" "+mo+"  "+add);
		
		out.close();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
