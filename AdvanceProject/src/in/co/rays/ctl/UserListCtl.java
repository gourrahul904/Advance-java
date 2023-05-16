package in.co.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.been.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/UserListCtl.do")
public class UserListCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserModel model = new UserModel();
		try {
			List<UserBean> list = model.searchf(null);
			req.setAttribute("list", list);
			RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String op = req.getParameter("operation");

		UserModel model = new UserModel();

		if (op.equals("search")) {

			System.out.println("search method");
			UserBean bean = new UserBean();
			bean.setFirstName(name);

		try {
				List<UserBean> list = model.searchf(bean);
				req.setAttribute("list", list);
				RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
				rd.forward(req, resp);

			} catch (Exception e) {
  
				e.printStackTrace();
			}

		}

	}
	}


