package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Registration;

public class RegisterDAO {

	public int registration(Registration registration) throws ClassNotFoundException{
		String INSERT_USER_SQL = "INSERT INTO registration" + "(userName, password, confirmPassword, phoneNumber, email) VALUES" 
		        + "(?, ?, ?, ?, ?);";  
		
		int result = 0;
		//connect database to mysql 
		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cpan368_yuewang",
				"cpan368_yuewang", "Class123!")){                                  
		PreparedStatement ps = connection.prepareStatement(INSERT_USER_SQL);
			ps.setString(1, registration.getUserName());
			ps.setString(2, registration.getPassword());
			ps.setString(3, registration.getConfirmPassword());
			ps.setString(4, registration.getPhoneNumber());
			ps.setString(5, registration.getEmail());

				System.out.println(ps);
				result = ps.executeUpdate();
			} catch (SQLException e) {
				printSQLException(e);
				
			}
			return result;
		}

		private void printSQLException(SQLException ex) {
			for (Throwable e : ex) {
				if (e instanceof SQLException) {

					e.printStackTrace(System.err);
					System.err.println("SQLState: " + ((SQLException) e).getSQLState());
					System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
					System.err.println("Message: " + e.getMessage());
					Throwable t = ex.getCause();
					while (t != null) {
						System.out.println("Cause: " + t);
						t = t.getCause();

					}
				}

			}
	} 
	
}
