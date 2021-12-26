package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DBException;
import db.DBIntegrityException;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = DB.getConnection();
			
			conn.setAutoCommit(false); // confirmação da transação feita pelo programador!
			
			st = conn.createStatement();
			int rowsAffected = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1 ");
			
			int x = 1;
			
			if(x<2) {
				//throw new SQLException("Fake Error");
			}
			
			int rowsAffected2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2 ");
			
			conn.commit(); // Confirma a transação caso não tenha ocorrido erro no try
			
			System.out.println("Rows affected 1: "+ rowsAffected);
			System.out.println("Rows affected 2: "+ rowsAffected2);
			
		} catch (SQLException e) {
			try {
				conn.rollback(); // Desfaz as alterações do banco de dados
				throw new DBIntegrityException("Transaction Rollback! Caused By: "+ e.getMessage());
			} catch (SQLException e1) {
				throw new DBException("ERROR trying rollback: "+ e1.getMessage());
			}
			
		}finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
		
	}

}
