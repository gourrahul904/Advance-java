package in.co.rays.ctl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.been.AddDateBean;
import in.co.rays.model.UserModel;

@WebServlet("/DateCtl")
public class DateCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dob = req.getParameter("dob");
		System.out.println(dob);

		AddDateBean bean = new AddDateBean();
		try {
			bean.setDob(sdf.parse(dob));

			System.out.println(bean.getDob());
			UserModel mo = new UserModel();
			mo.addDate(bean);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
