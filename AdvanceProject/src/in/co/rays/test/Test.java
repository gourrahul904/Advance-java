package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import in.co.rays.been.UserBean;
import in.co.rays.model.UserModel;
import in.co.rays.util.JDBCDataSource;

public class Test {
	public static void main(String[] args) throws Exception {

		// testUpdate();
		// testadd();
		// testUpdatePrst(16,"shubhman","gil","gil",12345,"9976347765");
		// testUpdatePrst2();
		// addPrep();
		// testCreateStatementQueery();
		// testSearch();
		// testId();
		testSearchf();

	}

	private static void testSearchf() throws Exception {
		UserBean um = new UserBean();
		um.setFirstName("H");
		UserModel mm = new UserModel(); 
		List<UserBean> list = mm.searchf(um);

		Iterator<UserBean> it = list.iterator();
		while (it.hasNext()) {

			UserBean cj = it.next();

			System.out.print("\t"+cj.getId());
			System.out.print("\t"+cj.getFirstName());
			System.out.print("\t"+cj.getLastName());
			System.out.print("\t"+cj.getLoginId());
			System.out.print("\t"+cj.getPassword());
			System.out.println("\t"+cj.getMobileNumber());

		}

	}

	
	

	private static void testSearch() throws Exception {
		UserModel us = new UserModel();
		List<UserBean> list = us.search();
		Iterator<UserBean> it = list.iterator();
		while (it.hasNext()) {
			UserBean usb = it.next();

			// UserBean usb= new UserBean();
			System.out.print("\t" + usb.getId());
			System.out.print("\t" + usb.getFirstName());
			System.out.print("\t" + usb.getLastName());
			System.out.print("\t" + usb.getLoginId());
			System.out.print("\t" + usb.getPassword());
			System.out.println("\t" + usb.getMobileNumber());

		}

	}

	private static void addPrep() throws Exception {
		UserBean ub = new UserBean();
		ub.setId(17);
		ub.setFirstName("Manish");
		ub.setLastName("tirole");
		ub.setLoginId("tirole");
		ub.setPassword("12345");
		ub.setMobileNumber("99967436743");

		UserModel u = new UserModel();
		u.add(ub);

	}

	private static void testCreateStatementQueery() throws SQLException {
		Connection con = JDBCDataSource.getConnection();
		Statement ps = con.createStatement();
		ResultSet rs = ps.executeQuery("select * from student");

		while (rs.next()) {
			System.out.print("\t" + rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getString(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getString(6));

		}

	}

	private static void testUpdatePrst2() throws SQLException {
		Connection con = JDBCDataSource.getConnection();

		PreparedStatement ps = con.prepareStatement("update student set firstname=? where id=?");
		ps.setString(1, "suresh");
		ps.setInt(2, 14);
		int i = ps.executeUpdate();
		System.out.println("insert  " + i);

	}

	private static void testUpdatePrst(int id, String fname, String lname, String loginid, int pass, String mobile)
			throws Exception {
		Connection con = JDBCDataSource.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into  student values(?,?,?,?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, fname);
		ps.setString(3, lname);
		ps.setString(4, loginid);
		ps.setInt(5, pass);
		ps.setString(6, mobile);
		int i = ps.executeUpdate();
		System.out.println("insert " + i);

	}

	private static void testUpdate() throws Exception {
		Connection con = JDBCDataSource.getConnection();

		Statement st = con.createStatement();

		int i = st.executeUpdate("update student set firstname='raj' where id=10");

		System.out.println("insert  " + i);

	}

	private static void testadd() throws Exception {

		Connection con = JDBCDataSource.getConnection();
		// Class.forName("com.mysql.cj.jdbc.Driver");
		// Connection con =
		// DriverManager.getConnection("jdbc:mysql://localhost:3306/final", "root",
		// "root");

		Statement st = con.createStatement();

		int i = st.executeUpdate("insert into student values(14,'Sandeep','patel','patel',12345,998877665544)");

		System.out.println("insert  " + i);

	}

}
