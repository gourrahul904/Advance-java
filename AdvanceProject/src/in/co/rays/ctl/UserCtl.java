package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.been.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/UserCtl")
public class UserCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		
		System.out.println(id);

		UserModel mode = new UserModel();
		if (id != null) {
			try {
				UserBean bean = mode.FindById(Integer.parseInt(id));
				req.setAttribute("bean", bean);

			} catch (Exception e) {

				e.printStackTrace();
			}

		}
		RequestDispatcher rd = req.getRequestDispatcher("UserRegistration.jsp");
		rd.forward(req, resp);
		// resp.sendRedirect("UserRegistration.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String login = req.getParameter("login");
		String pass = req.getParameter("pass");
		String no = req.getParameter("no");
		//System.out.println("id  " + id);

		String op = req.getParameter("operation");

		UserBean bean = new UserBean();
		bean.setFirstName(fname);
		bean.setLastName(lname);
		bean.setLoginId(login);
		bean.setPassword(pass);
		bean.setMobileNumber(no);

		if (op.equals("Add")) {
			UserModel model = new UserModel();

			System.out.println("add method");
			try {
				model.add(bean);
			} catch (Exception e) {

				e.printStackTrace();
			}

		}
		if (op.equals("Update")) {
			System.out.println("update");

			bean.setId(Integer.parseInt(id));

			UserModel model = new UserModel();

			try {
				model.update(bean);
			} catch (Exception e) {

				e.printStackTrace();
			}

		}

	}

}
