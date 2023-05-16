package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.co.rays.been.UserBean2;
import in.co.rays.util.JDBCDataSource;

public class UserModel2 {
	public void add(UserBean2 bean) throws Exception {

		Connection con = JDBCDataSource.getConnection();

		PreparedStatement ps = con.prepareStatement("insert into prof values(?,?,?,?)");

		ps.setString(1, bean.getName());
		ps.setString(2, bean.getSurname());
		ps.setString(3, bean.getMobile());
		ps.setString(4, bean.getAddress());

		int i = ps.executeUpdate();

		System.out.println("insert  " + i);
	}

}
