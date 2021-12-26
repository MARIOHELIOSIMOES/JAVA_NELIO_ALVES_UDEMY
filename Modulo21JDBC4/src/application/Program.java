package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import db.DB;
import db.DBException;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"UPDATE seller "
					+ " SET BaseSalary = BaseSalary + ?"
					+ " WHERE "
					+ " (DepartmentId = ?)"
					);
			st.setDouble(1, 200.0);
			st.setInt(2, 2);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done! Rows Affected "+ rowsAffected);
			
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
		
	}

}
