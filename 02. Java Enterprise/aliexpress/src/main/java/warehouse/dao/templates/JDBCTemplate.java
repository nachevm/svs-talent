package warehouse.dao.templates;

import java.sql.Connection;
import java.sql.SQLException;
import warehouse.connections.JDBCConnection;
import warehouse.exceptions.GenericDBException;

public class JDBCTemplate {

	public <T> T returnQuery(JDBCSetter jdbcSetter) {
		try {
			Connection connection = JDBCConnection.getLibraryConnection();
			T object = jdbcSetter.returnQuery(connection);
			connection.close();
			return object;
		} catch (SQLException e) {
			throw new GenericDBException();
		}
	}

}
