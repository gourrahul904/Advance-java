package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mchange.v2.sql.filter.SynchronizedFilterDataSource;

import in.co.rays.been.UserBean;
import in.co.rays.model.UserModel;

//@WebServlet("/LoginCtl")
public class LoginCtl extends BaseCtl {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("operation");
		if (op != null) {

			HttpSession ses = req.getSession();
			ses.invalidate();
			// ses.setMaxInactiveInterval(30);
			// resp.sendRedirect("LoginView.jsp");
			req.setAttribute("success", "Logout successfully");

		}
		RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String login = req.getParameter("login");
		String pass = req.getParameter("pass");

		String op = req.getParameter("operation");

		UserModel model = new UserModel();
		if (op.equals("SignIn")) {
			if (login.equals("") || pass.equals("")) {
				if (login.equals("")) {
					req.setAttribute("log", "login id required");
				}
				if (pass.equals("")) {
					req.setAttribute("pass", "password id required");

				}
				RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
				rd.forward(req, resp);

			} else {

				try {

					UserBean been = model.Authenticate(login, pass);
					if (been != null) {

						HttpSession session = req.getSession();
						System.out.println("user is valid");

						// RequestDispatcher rd = req.getRequestDispatcher("WelcomeLogin.jsp");
						// req.setAttribute("fname", been.getFirstName());
						session.setAttribute("fname", been.getFirstName());
						// rd.forward(req, resp);
						session.setMaxInactiveInterval(20);

						String uri = req.getParameter("uri");
						// resp.sendRedirect("WelcomeLogin.jsp");
						if (uri.equalsIgnoreCase("null")) {

							resp.sendRedirect("WelcomeLogin.jsp");

						} else {
							resp.sendRedirect(uri);

						}

					} else {
						System.out.println("user is not valid");
						RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
						req.setAttribute("name", "wrong user name password");

						rd.forward(req, resp);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}

		if (op.equals("SignUp")) {

			resp.sendRedirect("UserCtl");
		}
	}

}