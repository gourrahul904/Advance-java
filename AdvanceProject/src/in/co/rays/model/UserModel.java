package in.co.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mchange.v2.codegen.bean.BeangenUtils;

import in.co.rays.been.AddDateBean;
import in.co.rays.been.UserBean;
import in.co.rays.util.JDBCDataSource;

public class UserModel {

	public void add(UserBean bean) throws Exception {

		Connection con = JDBCDataSource.getConnection();
		// Class.forName("com.mysql.cj.jdbc.Driver");
		// Connection con =
		// DriverManager.getConnection("jdbc:mysql://localhost:3306/final", "root",
		// "root");

		PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?,?,?)");

		// ps.setInt(1, bean.getId());
		ps.setInt(1, nextPK());
		ps.setString(2, bean.getFirstName());
		ps.setString(3, bean.getLastName());
		ps.setString(4, bean.getLoginId());
		ps.setString(5, bean.getPassword());
		ps.setString(6, bean.getMobileNumber());

		int i = ps.executeUpdate();

		System.out.println("insert  " + i);
	}

	public List<UserBean> search() throws Exception {

		Connection con = JDBCDataSource.getConnection();

		PreparedStatement pt = con.prepareStatement("select * from student");
		ResultSet rs = pt.executeQuery();

		
		ArrayList<UserBean> list = new ArrayList<UserBean>();

		while (rs.next()) {

			UserBean m = new UserBean();
			m.setId(rs.getInt(1));
			m.setFirstName(rs.getString(2));
			m.setLastName(rs.getString(3));
			m.setLoginId(rs.getString(4));
			m.setPassword(rs.getString(5));
			m.setMobileNumber(rs.getString(6));
			list.add(m);

		}
		return list;
	}

	public UserBean FindById(int id) throws Exception {
		Connection con = JDBCDataSource.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from student where id=?");

		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		UserBean been = null;
		while (rs.next()) {
			been = new UserBean();
			been.setId(rs.getInt(1));
			been.setFirstName(rs.getString(2));
			been.setLastName(rs.getString(3));
			been.setLoginId(rs.getString(4));
			been.setPassword(rs.getString(5));
			been.setMobileNumber(rs.getString(6));

		}
		return been;

	}

	public List<UserBean> searchf(UserBean bean) throws Exception {
		Connection con = JDBCDataSource.getConnection();
		StringBuffer sql = new StringBuffer("select * from Student where 1=1");
		if (bean != null) {
			if (bean.getFirstName() != null) {

				sql.append(" and firstName like '" + bean.getFirstName() + "%'");
			}

		}

		// System.out.println(sql);
		PreparedStatement ps = con.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();

		ArrayList<UserBean> list = new ArrayList<UserBean>();

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setMobileNumber(rs.getString(6));
			list.add(bean);

		}
		return list;

	}

	public Integer nextPK() throws Exception {

		int Pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/final", "root", "root");

		PreparedStatement ps = con.prepareStatement("select max(id) from student");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			Pk = rs.getInt(1);

		}

		return Pk + 1;

	}

	public UserBean Authenticate(String loginID, String password) throws Exception {
		Connection con = JDBCDataSource.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from Student where loginID=? and password=?");
		ps.setString(1, loginID);
		ps.setString(2, password);

		ResultSet rs = ps.executeQuery();

		UserBean been = null;
		while (rs.next()) {
			been = new UserBean();
			// been.setId(rs.getInt(1));
			been.setFirstName(rs.getString(2));
			been.setLastName(rs.getString(3));
			been.setLoginId(rs.getString(4));
			been.setPassword(rs.getString(5));
			been.setMobileNumber(rs.getString(6));

		}
		return been;

	}

	public void update(UserBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement(
				"update student set firstName=?,lastName=?,loginId=?,password=?,mobileNumber=? where id=?");

		// System.out.println(bean.getFirstName());

		ps.setString(1, bean.getFirstName());
		ps.setString(2, bean.getLastName());
		ps.setString(3, bean.getLoginId());
		ps.setString(4, bean.getPassword());
		ps.setString(5, bean.getMobileNumber());
		ps.setInt(6, bean.getId());
		int i = ps.executeUpdate();
		System.out.println("insert  " + i);

	}

	public void addDate(AddDateBean bean) throws SQLException {
		Connection con = JDBCDataSource.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into rahul values(?)");
		ps.setDate(1, new java.sql.Date(bean.getDob().getTime()));
		int i = ps.executeUpdate();
		// JDBCDataSource.closeConnection(con);
		System.out.println("Date insert: " + i);

	}

}
