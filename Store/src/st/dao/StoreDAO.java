package st.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class StoreDAO {

	DataSource ds = null;

	public StoreDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MemberDB");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String ADD_STORE = "insert into stores values(?,?,?,?,?)";

	public int insert(StoreBean stB) throws SQLException {
		int n = 0;
		try (
				Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(ADD_STORE);
				ResultSet rs = stmt.executeQuery();) {
			stmt.setString(1, stB.getTown());
			stmt.setString(2, stB.getStore());
			stmt.setString(3, stB.getTelephone());
			stmt.setString(4, stB.getAddr());
			stmt.setString(5, stB.getProduct());
			n = stmt.executeUpdate();
		}
		return n;
	}

	private static final String UPDATE_STORE = "update stores set town=?,telephone=?,addr=?,product=? where store=?";

	public int update(StoreBean stB) throws SQLException {
		int n = 0;
		try (
			 Connection conn = ds.getConnection(); 
			 PreparedStatement stmt = conn.prepareStatement(UPDATE_STORE);) {
			stmt.setString(1, stB.getTown());
			stmt.setString(2, stB.getTelephone());
			stmt.setString(3, stB.getAddr());
			stmt.setString(4, stB.getProduct());
			stmt.setString(5, stB.getStore());
			n = stmt.executeUpdate();
		}
		return n;
	}

	private static final String DELETE_STORE = "delete from stores where store=?";

	public int delete(String storename) throws SQLException {
		int deleteCount = 0;
		try (
			 Connection conn = ds.getConnection(); 
			 PreparedStatement stmt = conn.prepareStatement(DELETE_STORE);) {

			stmt.setString(1, storename);
			deleteCount = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deleteCount;
	}

	private static final String GET_STORE = "select * from stores where store=?";

	public StoreBean findByStore(String storename) {
		StoreBean result = null;
		try (
			 Connection conn = ds.getConnection(); 
			 PreparedStatement stmt = conn.prepareStatement(GET_STORE);) {
			stmt.setString(1, storename);
			try (
				 ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					result = new StoreBean();
					result.setTown(rs.getString("town"));
					result.setStore(rs.getString("store"));
					result.setTelephone(rs.getString("telephone"));
					result.setAddr(rs.getString("addr"));
					result.setProduct(rs.getString("product"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String GETALL_STORE = "select * from stores order by town";

	public List<StoreBean> getAll() {

		StoreBean st = null;
		List<StoreBean> lst = new ArrayList<>();
		try (
				Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(GETALL_STORE);
				ResultSet rs = stmt.executeQuery();) {
			while (rs.next()) {
				st = new StoreBean();
				st.setTown(rs.getString("town"));
				st.setStore(rs.getString("store"));
				st.setTelephone(rs.getString("telephone"));
				st.setAddr(rs.getString("addr"));
				st.setProduct(rs.getString("product"));
				lst.add(st);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}
}

