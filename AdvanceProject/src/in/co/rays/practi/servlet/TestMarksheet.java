package in.co.rays.practi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.been.UserBean2;
import in.co.rays.model.UserModel2;

@WebServlet("/testmark")
public class TestMarksheet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fname = req.getParameter("fname");
		String sname = req.getParameter("sname");
		String mo = req.getParameter("mo");
		String add = req.getParameter("add");

		UserBean2 ub = new UserBean2();
		ub.setName(fname);
		ub.setSurname(sname);
		ub.setMobile(mo);
		ub.setAddress(add);
		UserModel2 uu= new UserModel2();
		try {
			uu.add(ub);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
