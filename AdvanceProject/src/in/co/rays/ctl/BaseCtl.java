package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseCtl extends HttpServlet {
	
	public boolean validate() {
		return true;
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service method");
	if (validate()) {
		System.out.println("true");
		
	}
	else {
		System.out.println("false");
	}
		
		super.service(req, resp);
	}
	
}
