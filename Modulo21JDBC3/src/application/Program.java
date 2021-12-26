package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
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
			/*st = conn.prepareStatement(
						"INSERT INTO seller "
						+"(Name, Email, BirthDate, BaseSalary, DepartmentId) "
						+" VALUES "
						+"(?, ?, ?, ?, ?)"
					);*/
			st = conn.prepareStatement(
					"INSERT INTO seller "
					+"(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+" VALUES "
					+"(?, ?, ?, ?, ?)"
				, Statement.RETURN_GENERATED_KEYS);//retornar chave gerada
			st.setString(1, "Carl Purple");
			st.setString(2, "carl@gmail.com");
			st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
			st.setDouble(4, 3000.0);
			st.setInt(5, 4);
			
			int rowsAffedted = st.executeUpdate();
			if(rowsAffedted>0) {
				ResultSet rs = st.getGeneratedKeys(); // Obtem o id dos objetos inseridos
				while(rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! Id = " + id);
				}
			}
			
			System.out.println("Done! Rows affedtec: "+rowsAffedted);
			
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
		
	}

}
